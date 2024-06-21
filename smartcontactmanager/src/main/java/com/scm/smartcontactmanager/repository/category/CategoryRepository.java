package com.scm.smartcontactmanager.repository.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scm.smartcontactmanager.entity.category.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	@Query("select c from Category c where lower(name)=lower(:name) and type = :type ")
	Category findByNameAndTypeIgnoreCase(@Param ("name") String name,@Param ("type")String type);

}
