package com.scm.smartcontactmanager.dao.contact;


import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;

import com.scm.smartcontactmanager.entity.contact.Contact;

public interface ContactDao {

	public Contact createContact(Contact contact);
	
	public void deleteallContact();
	
	public List<Contact> getAllContact(PageRequest pageRequest);
	
	public void deleteById(int id);
		
	public Optional<Contact> getcontactById(int id);
	
	public List<Contact> getContactByName(PageRequest pageRequest, String name);
	
	public Contact getContactByEmail(String email);
	
	public Contact getContactByPhone(String number);

	public Contact getConatctByWorkEmail(String workemail);
	
	public Contact getContactByFullName(String firstName,String middleName,String lastName);

}

