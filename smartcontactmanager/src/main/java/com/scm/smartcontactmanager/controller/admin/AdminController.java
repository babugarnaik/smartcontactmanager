package com.scm.smartcontactmanager.controller.admin;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scm.smartcontactmanager.controller.contact.request.ContactRequestDto;
import com.scm.smartcontactmanager.controller.contact.response.ContactResponseDto;
import com.scm.smartcontactmanager.service.contact.ContactService;

import jakarta.validation.Valid;

@RestController
public class AdminController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping(value= "/v1/contacts/admin",consumes="application/json", produces="application/json")
	public ResponseEntity<?> createContactByAdmin( @Valid @RequestBody ContactRequestDto conDto, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			List<String> errors = bindingResult.getFieldErrors().stream()
			.map(error -> error.getField()+":"+error.getDefaultMessage()).collect(Collectors.toList());
			return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
		}
		contactService.createContactByAdmin(conDto);
		return new ResponseEntity<>("Contact craeted Successfully",HttpStatus.CREATED);
	}
	
	@GetMapping(value="/v1/contacts/admin/users/{userId}",produces="application/jason")
	public ResponseEntity<List<ContactResponseDto>> getDetailsOfUserContact(@RequestParam (name = "contactIds") String contactIds , @PathVariable ("userId") int userId){
		contactService.getDetailsOfUserContact(userId,contactIds);
		return null;
	}

}
