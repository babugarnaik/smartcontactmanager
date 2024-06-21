package com.scm.smartcontactmanager.dao.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scm.smartcontactmanager.entity.category.Category;
import com.scm.smartcontactmanager.repository.category.CategoryRepository;

@Repository
public class CategoryDaoImpl implements CategoryDao{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category findCategory(int id) {
		 Category category = categoryRepository.findById(id).get();
		return category;
	}

}
