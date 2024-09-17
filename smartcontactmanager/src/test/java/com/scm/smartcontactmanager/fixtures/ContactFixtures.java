package com.scm.smartcontactmanager.fixtures;

import java.util.Optional;

import com.scm.smartcontactmanager.controller.contact.request.ContactRequestDto;
import com.scm.smartcontactmanager.entity.contact.Contact;

public class ContactFixtures {
	
	public Optional<Contact> contactInfo;
	
	public  ContactRequestDto contactRequestDto;
	
	public ContactFixtures() {
		Contact contact = Contact.builder().id(123).firstName("Navneet").middleName("").lastName("Kumar").contactNumber("7546930695")
				          .personalEmail("nk123@gmail.com").workEmail("nk123@gmail.com").homeAddress("Br").workAddress("Blr").department("Development")
				          .website("nkj").build();
		contactInfo = Optional.of(contact);   
		contactRequestDto = ContactRequestDto.builder().firstName("Navneet").middleName("").lastName("Kumar").contactNumber("7546930695")
        .personalEmail("nk123@gmail.com").workEmail("nk123@gmail.com").homeAddress("Br").workAddress("Blr").department("Development")
        .website("nkj").build();
	}

}
