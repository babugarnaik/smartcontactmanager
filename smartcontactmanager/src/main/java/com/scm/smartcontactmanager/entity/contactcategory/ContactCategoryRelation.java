package com.scm.smartcontactmanager.entity.contactcategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="contact_category_relation")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactCategoryRelation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="contact_id")
	private int  contactId;
	
	@Column(name="category_id")
	private int categoryId;

	

}
