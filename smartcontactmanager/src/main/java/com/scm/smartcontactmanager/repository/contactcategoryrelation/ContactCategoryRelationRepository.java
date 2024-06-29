package com.scm.smartcontactmanager.repository.contactcategoryrelation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.scm.smartcontactmanager.entity.contactcategoryrelation.ContactCategoryRelation;

public interface ContactCategoryRelationRepository extends JpaRepository<ContactCategoryRelation, Integer> {

	public List<ContactCategoryRelation> findByCategoryId(int id);

	@Modifying
	@Query("delete from ContactCategoryRelation c where c.categoryId = ?1")
	void deleteByCategoryId(int categoryId);
}
