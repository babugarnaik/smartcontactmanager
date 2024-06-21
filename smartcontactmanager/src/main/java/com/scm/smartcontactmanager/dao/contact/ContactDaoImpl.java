package com.scm.smartcontactmanager.dao.contact;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scm.smartcontactmanager.controller.contact.response.ContactResponseDto;
import com.scm.smartcontactmanager.entity.category.Category;
import com.scm.smartcontactmanager.entity.contact.Contact;
import com.scm.smartcontactmanager.repository.category.CategoryRepository;
import com.scm.smartcontactmanager.repository.contact.ContactRespository;

@Repository
public class ContactDaoImpl implements ContactDao {
	
	@Autowired
	private ContactRespository contactRespository;
	
	

	@Override
	public Contact createContactByAdmin(Contact contact) {
		Contact saveContact = contactRespository.save(contact);
		return saveContact;
	}



	@Override
	public List<ContactResponseDto> getDegetDetailsOfUserContact(int userId, List<Integer> listOfcontactIds) {
		contactRespository.findAllById(listOfcontactIds);
		return null;
	}

	



	
}
