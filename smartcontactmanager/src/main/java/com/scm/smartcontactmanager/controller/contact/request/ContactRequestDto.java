package com.scm.smartcontactmanager.controller.contact.request;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequestDto {
	
	@Id
	private int categoryId;
	
	@Size(min=2, message ="First name should be atleast 2 letters")
	@Pattern(regexp ="[A-Za-z]",message="It should contain only alphabetic letter")
	private String firstName;
	
	@Pattern(regexp ="[A-Za-z]",message="It should contain only alphabetic letter")
	private String middleName;
	
	@Pattern(regexp ="[A-Za-z]",message="It should contain only alphabetic letter")
	private String lastName;
	
	@Pattern(regexp = "[0-9]{10}")
	private String contactNumber;
	
	@Email
	private String personalEmail;
	
	@Email
	private String workEmail;
	
	@Size(min=2, message ="Home address should be atleast 2 letters")
	private String homeAddress;
	
	@Size(min=2, message ="Work address should be atleast 2 letters")
	private String workAddress;
	
	@Size(min=2, message ="Department should be atleast 2 letters")
	@Pattern(regexp ="[A-Za-z]" ,message="It should contain only alphabetic letter")
	private String department;
	
	@Size(min=2, message ="Website should be atleast 2 letters")
	private String website;

}
	
