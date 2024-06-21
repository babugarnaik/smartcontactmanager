package com.scm.smartcontactmanager.service.contact;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.smartcontactmanager.controller.contact.request.ContactRequestDto;
import com.scm.smartcontactmanager.controller.contact.response.ContactResponseDto;
import com.scm.smartcontactmanager.dao.category.CategoryDao;
import com.scm.smartcontactmanager.dao.contact.ContactDao;
import com.scm.smartcontactmanager.dao.contactcategory.ContactCategoryDao;
import com.scm.smartcontactmanager.entity.category.Category;
import com.scm.smartcontactmanager.entity.contact.Contact;
import com.scm.smartcontactmanager.entity.contactcategory.ContactCategoryRelation;
import com.scm.smartcontactmanager.exception.ResourceNotFoundException;

import jakarta.validation.Valid;

@Service
public class ContactServiceImpl implements ContactService{
	@Autowired
	private ContactDao contactDao;
	
	@Autowired
	private ContactCategoryDao categoryRelation;
	
	@Autowired 
	private CategoryDao categoryDao;

	@Override
	public ContactResponseDto createContactByAdmin(@Valid ContactRequestDto conReqDto) {
		Contact contact = mapToEntity(conReqDto);
		Contact createContactByAdmin = contactDao.createContactByAdmin(contact);
		
		Category category = new Category();
		category.setId(conReqDto.getCategoryId());
		
		Category findCategoryById = categoryDao
				.findCategory(category.getId());
		
		if(findCategoryById==null) {
			throw new ResourceNotFoundException("Category not found with id: "+category.getId());
		}
		
//		ContactCategoryRelation contactCategoryRelation = new ContactCategoryRelation();
//		contactCategoryRelation.setCategoryId(conReqDto.getCategoryId());
//		contactCategoryRelation.setContactId(createContactByAdmin.getId());
		
		ContactCategoryRelation contactCategoryRelation = ContactCategoryRelation.builder().categoryId(conReqDto.getCategoryId()).contactId(createContactByAdmin.getId()).build();
		
		categoryRelation.createRelation(contactCategoryRelation);
		
		ContactResponseDto savedResponse = mapToResponseDto(createContactByAdmin);
		return savedResponse;
		
		
	}
	
	Contact mapToEntity (ContactRequestDto conReqDto) {
		Contact contact = new Contact();
		contact.setFirstName(conReqDto.getFirstName());
		contact.setMiddleName(conReqDto.getMiddleName());
		contact.setLastName(conReqDto.getLastName());
		contact.setContactNumber(conReqDto.getContactNumber());
		contact.setPersonalEmail(conReqDto.getPersonalEmail());
		contact.setWorkEmail(conReqDto.getWorkEmail());
		contact.setHomeAddress(conReqDto.getHomeAddress());
		contact.setWorkAddress(conReqDto.getWorkAddress());
		contact.setDepartment(conReqDto.getDepartment());
		contact.setWebsite(conReqDto.getWebsite());
		contact.setByAdmin(true);
		contact.setCreatedOn(new Date());
		return contact;
	}
	
	ContactResponseDto mapToResponseDto(Contact contact) {
		ContactResponseDto conResDto =new ContactResponseDto();
		conResDto.setFirstName(contact.getFirstName());
		conResDto.setMiddleName(contact.getMiddleName());
		conResDto.setLastName(contact.getLastName());
		conResDto.setContactNumber(contact .getContactNumber());
		conResDto.setPersonalEmail(contact.getPersonalEmail());
		conResDto.setWorkEmail(contact.getWorkEmail());
		conResDto.setHomeAddress(contact.getHomeAddress());
		conResDto.setWorkAddress(contact.getWorkAddress());
		conResDto.setDepartment(contact.getDepartment());
		conResDto.setWebsite(contact.getWebsite());
		
		return conResDto;
	}

	@Override
	public List<ContactResponseDto> getDetailsOfUserContact(int userId, String contactIds) {
		 String[] ids = contactIds.trim().split(",");
		  List<Integer> listOfcontactIds = Arrays.stream(ids).map(i -> Integer.valueOf(i)).collect(Collectors.toList());
		 
		 contactDao.getDegetDetailsOfUserContact(userId,listOfcontactIds);
		 
	
		return null;
		
	}
}
