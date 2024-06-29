package com.scm.smartcontactmanager.dao.category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scm.smartcontactmanager.entity.category.Category;
import com.scm.smartcontactmanager.entity.contact.Contact;
import com.scm.smartcontactmanager.entity.contactcategoryrelation.ContactCategoryRelation;
import com.scm.smartcontactmanager.repository.category.CategoryRepository;
import com.scm.smartcontactmanager.repository.contact.ContactRespository;
import com.scm.smartcontactmanager.repository.contactcategoryrelation.ContactCategoryRelationRepository;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ContactRespository contactRespository;

	@Autowired
	private ContactCategoryRelationRepository contactCategoryRelationRepository;

	@Override
	public Category newCategory(Category category) {
		Category saveContact = categoryRepository.save(category);
		return saveContact;
	}

	@Override
	public List<Category> getListOfCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> getCategoryById(int id) {
		return categoryRepository.findById(id);
	}

	@Override
	public List<ContactCategoryRelation> addContactsToCategory(List<ContactCategoryRelation> relations) {
		return contactCategoryRelationRepository.saveAll(relations);
	}

	@Override
	public List<ContactCategoryRelation> getContactCategoryRelation(int categoryId) {
		return contactCategoryRelationRepository.findByCategoryId(categoryId);
	}

	@Override
	public List<Contact> getContactdByIds(List<Integer> contactIds) {
		return contactRespository.findByIdIn(contactIds);
	}

	@Override
	public void deleteCategoryById(int id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public Category findCategory(String name, String type) {
		return categoryRepository.findByNameAndTypeIgnoreCase(name, type);
	}

	@Override
	public void deleteContactCategoryRelationById(List<Integer> idList) {
		contactCategoryRelationRepository.deleteAllById(idList);
	}

}
