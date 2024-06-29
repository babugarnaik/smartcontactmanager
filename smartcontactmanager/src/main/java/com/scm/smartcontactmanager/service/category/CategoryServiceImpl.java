package com.scm.smartcontactmanager.service.category;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import com.scm.smartcontactmanager.controller.category.request.CategoryRequestDto;
import com.scm.smartcontactmanager.controller.category.request.ContactIds;
import com.scm.smartcontactmanager.controller.category.response.CategoryResponseDto;
import com.scm.smartcontactmanager.dao.category.CategoryDao;
import com.scm.smartcontactmanager.entity.category.Category;
import com.scm.smartcontactmanager.entity.contact.Contact;
import com.scm.smartcontactmanager.entity.contactcategoryrelation.ContactCategoryRelation;
import com.scm.smartcontactmanager.exceptionhandle.BadRequestException;
import com.scm.smartcontactmanager.exceptionhandle.ServiceException;
import com.scm.smartcontactmanager.repository.contact.ContactRespository;
import com.scm.smartcontactmanager.repository.contactcategoryrelation.ContactCategoryRelationRepository;

import jakarta.validation.Valid;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public CategoryResponseDto createCategory(@Valid CategoryRequestDto categoryRequestDto) {
		Category category = mapToEntity(categoryRequestDto);
		Category existingCategory = categoryDao.findCategory(categoryRequestDto.getName(),
				categoryRequestDto.getType());
		if (existingCategory != null) {
			throw new ServiceException(HttpStatus.valueOf(409), "Category already exsists");
		} else {
			Category newCategory = categoryDao.newCategory(category);

			CategoryResponseDto savedResponse = mapToResponseDto(newCategory);
			return savedResponse;
		}

	}

	Category mapToEntity(CategoryRequestDto categoryRequestDto) {
		Category category = new Category();
		category.setName(categoryRequestDto.getName());
		category.setType(categoryRequestDto.getType());
		category.setUserId(categoryRequestDto.getUserId());
		category.setByAdmin(false);
		category.setCreatedOn(new Date());
		category.setUpdatedOn(new Date());
		return category;
	}

	CategoryResponseDto mapToResponseDto(Category category) {
		CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
		categoryResponseDto.setName(categoryResponseDto.getName());
		categoryResponseDto.setType(categoryResponseDto.getType());
		categoryResponseDto.setUserId(categoryResponseDto.getUserId());
		categoryResponseDto.setByAdmin(false);
		return categoryResponseDto;
	}

	@Override
	public List<Category> getListOfCategory() {
		List<Category> categoryList = categoryDao.getListOfCategory();
		if (categoryList == null) {
			throw new ServiceException(HttpStatusCode.valueOf(404), "Category not found");
		}
		return categoryList;
	}

	@Override
	public void addContactsToCategory(int id, ContactIds contactIds) {
		Category category = categoryDao.getCategoryById(id).get();
		List<Contact> contactList = categoryDao.getContactdByIds(contactIds.getContactId());
		if (category != null && contactList.size() == contactIds.getContactId().size()) {
			List<ContactCategoryRelation> relations = new ArrayList<>();
			for (int cId : contactIds.getContactId()) {
				ContactCategoryRelation relation = ContactCategoryRelation.builder().categoryId(id).contactId(cId)
						.build();

				relations.add(relation);
			}
			List<ContactCategoryRelation> concatrelation = categoryDao.addContactsToCategory(relations);
		} else {
			throw new BadRequestException(HttpStatusCode.valueOf(400), "Bad Request");
		}

	}

	@Override
	public List<Contact> getContactsByCategoryId(int id) {

		Optional<Category> categoryById = categoryDao.getCategoryById(id);
		if (categoryById.isEmpty()) {
			throw new ServiceException(HttpStatusCode.valueOf(404), "Category not found with id: " + id);
		} else {
			List<ContactCategoryRelation> relations = categoryDao.getContactCategoryRelation(id);
			List<Integer> contactIds = relations.stream().map(rl -> rl.getContactId()).collect(Collectors.toList());
			List<Contact> contactList = categoryDao.getContactdByIds(contactIds);
			return contactList;
		}

	}

	@Override
	public void deleteCategoryById(int id) {
		Optional<Category> categoryById = categoryDao.getCategoryById(id);
		if (categoryById.isEmpty()) {
			throw new ServiceException(HttpStatusCode.valueOf(404), "Category with id" + "{" + id + "}" + "not found");
		}
		categoryDao.deleteCategoryById(id);
		List<ContactCategoryRelation> existingContactCategoryRelations = categoryDao.getContactCategoryRelation(id);
		List<Integer> idList = existingContactCategoryRelations.stream().map(f -> f.getId()).collect(Collectors.toList());
		categoryDao.deleteContactCategoryRelationById(idList);
	}

}
