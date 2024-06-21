package com.scm.smartcontactmanager.dao.contactcategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scm.smartcontactmanager.entity.contactcategory.ContactCategoryRelation;
import com.scm.smartcontactmanager.repository.contactcategory.ContactCategoryRelationRepository;

@Repository
public class ContactCategoryDaoImpl implements ContactCategoryDao {
	
	@Autowired
	private ContactCategoryRelationRepository categoryRelationRepository;

	@Override
	public ContactCategoryRelation createRelation(ContactCategoryRelation contactCategoryRelation) {
		categoryRelationRepository.save(contactCategoryRelation);
		return null;
	}

}
