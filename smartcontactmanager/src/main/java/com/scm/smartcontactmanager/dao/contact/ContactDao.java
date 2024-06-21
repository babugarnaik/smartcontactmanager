package com.scm.smartcontactmanager.dao.contact;

import java.util.List;

import com.scm.smartcontactmanager.controller.contact.response.ContactResponseDto;
import com.scm.smartcontactmanager.entity.contact.Contact;

public interface ContactDao {

	Contact createContactByAdmin(Contact contact);

	List<ContactResponseDto> getDegetDetailsOfUserContact(int userId, List<Integer> listOfcontactIds);

}
