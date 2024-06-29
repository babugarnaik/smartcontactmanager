package com.scm.smartcontactmanager.entity.contactcategoryrelation;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "contact_category_relation")
@Data
@RequiredArgsConstructor
@SuperBuilder
public class ContactCategoryRelation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_category_relation_seq")
	@SequenceGenerator(name = "contact_category_relation_seq", sequenceName = "contact_category_relation_seq", allocationSize = 1)
	private int id;

	@Column(name = "contact_id")
	private int contactId;

	@Column(name = "category_id")
	private int categoryId;

}
