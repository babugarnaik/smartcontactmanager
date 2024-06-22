package com.scm.smartcontactmanager.entity.contact;

import java.util.Date;

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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="contact")
public class Contact {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_SEQ")
	@SequenceGenerator(name = "contact_SEQ", sequenceName = "contact_SEQ", allocationSize = 1)
	
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="contact_number")
	private String contactNumber;
	
	@Column(name="personal_email")
	private String personalEmail;
	
	@Column(name="work_email")
	private String workEmail;
	
	@Column(name="home_address")
	private String homeAddress;
	
	@Column(name="work_address")
	private String workAddress;
	
	@Column(name="department")
	private String department;
	
	@Column(name="website")
	private String website;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="by_admin")
	private boolean byAdmin;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="updated_on")
	private Date updatedOn;
}
