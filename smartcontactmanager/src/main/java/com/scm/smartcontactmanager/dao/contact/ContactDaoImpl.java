package com.scm.smartcontactmanager.dao.contact;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scm.smartcontactmanager.entity.contact.Contact;
import com.scm.smartcontactmanager.repository.contact.ContactRepository;

@Repository
public class ContactDaoImpl implements ContactDao {

	@Autowired
	ContactRepository contactRepo;

	@Override
	public Contact createContact(Contact contact) {
		return contactRepo.save(contact);
	}

	@Override
	public void deleteallContact() {
		contactRepo.deleteAll();
	}

	@Override
	public List<Contact> getAllContact(PageRequest pageRequest) {
		Pageable page = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), Sort.by("firstName"));
		return contactRepo.findAll(page).getContent();
	}

	@Override
	public void deleteById(int id) {
		contactRepo.deleteById(id);
	}

	@Override
	public Optional<Contact> getcontactById(int id) {
		return contactRepo.findById(id);
	}

	@Override
	public List<Contact> getContactByName(PageRequest pageRequest, String firstName) {
		Pageable page = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), Sort.by("firstName"));
		return contactRepo.searchByName(firstName, page);
	}

	@Override
	public Contact getContactByEmail(String email) {
		return contactRepo.findByPersonalEmail(email);

	}

	@Override
	public Contact getContactByPhone(String number) {
		return contactRepo.findByContactNumber(number);
	}
	
	@Override
	public Contact getConatctByWorkEmail(String workemail) {
		return contactRepo.findByWorkEmail(workemail);
	}
	
	@Override
	public Contact getContactByFullName(String firstName,String middleName,String lastName ) {
		return contactRepo.findByFirstNameAndMiddleNameAndLastName(firstName, middleName, lastName);
	}

}
