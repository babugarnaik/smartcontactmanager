package com.scm.smartcontactmanager.service.contact;

import java.util.List;

import com.scm.smartcontactmanager.controller.contact.request.ContactRequestDto;
import com.scm.smartcontactmanager.controller.contact.response.ContactResponseDto;

import jakarta.validation.Valid;

public interface ContactService {

	ContactResponseDto createContactByAdmin(@Valid ContactRequestDto conDto);

	List<ContactResponseDto> getDetailsOfUserContact(int userId, String contactIds);

}
