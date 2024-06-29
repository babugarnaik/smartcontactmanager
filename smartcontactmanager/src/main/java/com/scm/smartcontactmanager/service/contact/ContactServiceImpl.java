package com.scm.smartcontactmanager.service.contact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.scm.smartcontactmanager.controller.contact.request.ContactRequestDto;
import com.scm.smartcontactmanager.dao.contact.ContactDao;
import com.scm.smartcontactmanager.entity.contact.Contact;
import com.scm.smartcontactmanager.exceptionhandle.ServiceException;


@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactDao contactDao;

	@Override
	public Contact createContact(ContactRequestDto contactRequestDto) {
		Contact contactByEmail = contactDao.getContactByEmail(contactRequestDto.getPersonalEmail());
		if (contactByEmail != null) {
			throw new ServiceException(HttpStatusCode.valueOf(409), "Personal Email already exist");
		}
		Contact contactByPhone = contactDao.getContactByPhone(contactRequestDto.getContactNumber());
		if (contactByPhone != null) {
			throw new ServiceException(HttpStatusCode.valueOf(409), "Mobile Number already exit");
		}
		Contact contactByWorkEmail = contactDao.getConatctByWorkEmail(contactRequestDto.getWorkEmail());
		if (contactByWorkEmail != null) {
			throw new ServiceException(HttpStatusCode.valueOf(409), "Work Email already exit");
		}
		Contact contactByFullName = contactDao.getContactByFullName(contactRequestDto.getFirstName(),
				contactRequestDto.getMiddleName(), contactRequestDto.getLastName());
		if (contactByFullName != null) {
			throw new ServiceException(HttpStatusCode.valueOf(409), "Contact with this name already existing");
		}
		Contact contact = new Contact();
		contact.setFirstName(contactRequestDto.getFirstName());
		contact.setMiddleName(contactRequestDto.getMiddleName());
		contact.setLastName(contactRequestDto.getLastName());
		contact.setContactNumber(contactRequestDto.getContactNumber());
		contact.setPersonalEmail(contactRequestDto.getPersonalEmail());
		contact.setWorkEmail(contactRequestDto.getWorkEmail());
		contact.setHomeAddress(contactRequestDto.getHomeAddress());
		contact.setWorkAddress(contactRequestDto.getWorkAddress());
		contact.setDepartment(contactRequestDto.getDepartment());
		contact.setWebsite(contactRequestDto.getWebsite());
		contact.setUpdatedBy("USER");
		return contactDao.createContact(contact);
	}

	@Override
	public void deleteAllContact() {
		contactDao.deleteallContact();
	}
	
	@Override
	public void updateContactById(Contact contactDto, int id) {
		Optional<Contact> updateContactinfo = contactDao.getcontactById(id);
		if(!updateContactinfo.isPresent()) {
			throw new ServiceException(HttpStatusCode.valueOf(404), "Id Didn't Found:" + id);
		}
		Contact contact = new Contact();
		contact.setId(id);
		contact.setFirstName(contactDto.getFirstName());
		contact.setMiddleName(contactDto.getMiddleName());
		contact.setLastName(contactDto.getLastName());
		contact.setContactNumber(contactDto.getContactNumber());
		contact.setPersonalEmail(contactDto.getPersonalEmail());
		contact.setWorkEmail(contactDto.getWorkEmail());
		contact.setHomeAddress(contactDto.getHomeAddress());
		contact.setWorkAddress(contactDto.getWorkAddress());
		contact.setDepartment(contactDto.getDepartment());
		contact.setWebsite(contactDto.getWebsite());
		contact.setUpdatedBy("enum");
		
		 contactDao.createContact(contact);
	}

	@Override
	public void deleteById(int id) {
		Optional<Contact>deleteByid=contactDao.getcontactById(id);
		if(!deleteByid.isPresent()) {
			throw new ServiceException(HttpStatusCode.valueOf(409), "Id Didn't Found:"+id);
		}
		contactDao.deleteById(id);
	}

	@Override
	public Contact getcontactById(int id) {
		Optional<Contact> contactInfo = contactDao.getcontactById(id);
		if (!contactInfo.isPresent()) {
			throw new ServiceException(HttpStatusCode.valueOf(404), "Not found Id: " + id);
		}
		return contactInfo.get();
	}

	@Override
	public List<Contact> getAllContact(PageRequest pageRequest, String name, String email) {
		List<Contact> contactList = new ArrayList<>();
		if (StringUtils.hasLength(email)) {
			contactList = contactDao.getContactByName(pageRequest, name);
		} else if (email != null && email.isEmpty()) {
			contactList = Arrays.asList(contactDao.getContactByEmail(email));
		} else {
			contactList = contactDao.getAllContact(pageRequest);
		}
		return contactList;
	}
}
