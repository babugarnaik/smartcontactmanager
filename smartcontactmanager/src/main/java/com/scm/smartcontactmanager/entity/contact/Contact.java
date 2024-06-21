package com.scm.smartcontactmanager.entity.contact;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="contact")
@Entity
public class Contact {
	
	@Id
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="contact_number")
	private long contactNumber;
	
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
}
