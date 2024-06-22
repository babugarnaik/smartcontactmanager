package com.scm.smartcontactmanager.controller.contact;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.PageRequest;

import com.scm.smartcontactmanager.controller.contact.request.ContactRequestDto;
import com.scm.smartcontactmanager.entity.contact.Contact;
import com.scm.smartcontactmanager.service.contact.ContactService;


@RestController
public class ContactController {

	@Autowired
	ContactService contactService;

	@PostMapping(value = "/v1/contacts", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> createContact(@RequestBody ContactRequestDto contactRequestDto) {
		contactService.createContact(contactRequestDto);
		return new ResponseEntity<>("Succesfully created", HttpStatus.OK);
	}

	@DeleteMapping(value = "/v1/contacts", produces = "application/json")
	public ResponseEntity<String> deleteAllContact() {
		contactService.deleteAllContact();
		return new ResponseEntity<>("Succesfully Deleted", HttpStatus.OK);
	}

	@GetMapping(value = "/v1/contacts", produces = "application/json")
	public ResponseEntity<List<Contact>> getAllContact(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "limit",defaultValue = "10") int size,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name="email",  required = false) String email){
		PageRequest pageRequest = PageRequest.of(page, size);
		List<Contact> contactList = contactService.getAllContact(pageRequest, name,email);
		return new ResponseEntity<>(contactList, HttpStatus.OK);
	}

	@PatchMapping(value = "/v1/contacts/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> updateContact(@RequestBody Contact contactdto, @PathVariable("id") int id) {
		contactService.updateContactById(contactdto, id);
		return new ResponseEntity<>("Succesfully Updated", HttpStatus.OK);
	}

	@DeleteMapping(value = "/v1/contacts/{id}", produces = "application/json")
	public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		contactService.deleteById(id);
		return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
	}

	@GetMapping(value = "/v1/contacts/{id}", produces = "application/json")
	public ResponseEntity<Contact> getContactById(@PathVariable("id") int id) {
		Contact contact = contactService.getcontactById(id);
		return new ResponseEntity<>(contact, HttpStatus.OK);
	}
	

}
