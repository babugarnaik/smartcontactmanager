package com.scm.smartcontactmanager.repository.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.smartcontactmanager.entity.category.Category;
import com.scm.smartcontactmanager.entity.contact.Contact;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	public Contact findByName(String firstName);
}
