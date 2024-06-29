package com.scm.smartcontactmanager.dao.category;

import java.util.List;
import java.util.Optional;

import com.scm.smartcontactmanager.entity.category.Category;
import com.scm.smartcontactmanager.entity.contact.Contact;
import com.scm.smartcontactmanager.entity.contactcategoryrelation.ContactCategoryRelation;

public interface CategoryDao {

	public Category newCategory(Category category);

	public List<Category> getListOfCategory();

	Optional<Category> getCategoryById(int id);

	List<Contact> getContactdByIds(List<Integer> contactIds);

	List<ContactCategoryRelation> addContactsToCategory(List<ContactCategoryRelation> relations);

	List<ContactCategoryRelation> getContactCategoryRelation(int id);

	void deleteCategoryById(int id);

	void deleteContactCategoryRelationById(List<Integer> collectId);

	Category findCategory(String name, String type);

}
