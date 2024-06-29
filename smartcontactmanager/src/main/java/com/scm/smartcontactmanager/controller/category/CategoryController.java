package com.scm.smartcontactmanager.controller.category;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scm.smartcontactmanager.controller.category.request.CategoryRequestDto;
import com.scm.smartcontactmanager.controller.category.request.ContactIds;
import com.scm.smartcontactmanager.entity.category.Category;
import com.scm.smartcontactmanager.entity.contact.Contact;
import com.scm.smartcontactmanager.service.category.CategoryService;

import jakarta.validation.Valid;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping(value = "/v1/category", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryRequestDto categoryRequestDto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<String> errors = bindingResult.getFieldErrors().stream()
					.map(error -> error.getField() + ":" + error.getDefaultMessage()).collect(Collectors.toList());
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		categoryService.createCategory(categoryRequestDto);
		return new ResponseEntity<>("Category created successfully", HttpStatus.CREATED);
	}

	@GetMapping(value = "/v1/category", produces = "application/json")
	public ResponseEntity<List<Category>> getListOfCategory() {
		List<Category> listOfCategory = categoryService.getListOfCategory();
		return new ResponseEntity<List<Category>>(listOfCategory, HttpStatus.OK);
	}

	@PutMapping(value = "/v1/categories/{categoryId}/contacts", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> addContactsToCategory(@PathVariable("categoryId") int id,@RequestBody ContactIds contactIds) {
		categoryService.addContactsToCategory(id, contactIds);

		return new ResponseEntity<String>("Contacts added to Category successfully", HttpStatus.CREATED);
	}

	@GetMapping(value = "/v1/categories/{categoryId}/contacts", produces = "application/json")
	public ResponseEntity<List<Contact>> getContactsByCategoryId(@PathVariable("categoryId") int id) {

		List<Contact> contactList = categoryService.getContactsByCategoryId(id);
		return new ResponseEntity<>(contactList, HttpStatus.OK);
	}

	@DeleteMapping(value = "/v1/categories/{categoryId}/contacts", produces = "application/json")
	public ResponseEntity<String> deleteCategoryById(@PathVariable("categoryId") int id) {
		categoryService.deleteCategoryById(id);
		return new ResponseEntity<String>("Category and ContactCategoryRelations deleted successfully", HttpStatus.OK);
	}

}
