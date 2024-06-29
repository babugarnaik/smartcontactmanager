package com.scm.smartcontactmanager.service.category;

import java.util.List;

import com.scm.smartcontactmanager.controller.category.request.CategoryRequestDto;
import com.scm.smartcontactmanager.controller.category.request.ContactIds;
import com.scm.smartcontactmanager.controller.category.response.CategoryResponseDto;
import com.scm.smartcontactmanager.entity.category.Category;
import com.scm.smartcontactmanager.entity.contact.Contact;

import jakarta.validation.Valid;

public interface CategoryService {

	public CategoryResponseDto createCategory(@Valid CategoryRequestDto categoryRequestDto);

	public List<Category> getListOfCategory();

	public void addContactsToCategory(int id, ContactIds contactIds) ;

	List<Contact> getContactsByCategoryId(int id);

	void deleteCategoryById(int id);

}
