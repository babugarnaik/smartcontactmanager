package com.scm.smartcontactmanager.service.contact;



import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.scm.smartcontactmanager.controller.contact.request.ContactRequestDto;
import com.scm.smartcontactmanager.entity.contact.Contact;

public interface ContactService {

	public Contact createContact(ContactRequestDto contactRequestDto);
	public void deleteAllContact();
	public List<Contact> getAllContact(PageRequest pageRequest,String name,String email);
	public void updateContactById(Contact contact,int id);
	public void deleteById(int id);
	public Contact getcontactById(int id);
}
