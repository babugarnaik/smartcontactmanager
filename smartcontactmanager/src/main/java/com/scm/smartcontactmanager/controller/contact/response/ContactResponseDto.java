package com.scm.smartcontactmanager.controller.contact.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponseDto {

	private String firstName;
	private String middleName;
	private String lastName;
	private long contactNumber;
	private String personalEmail;
	private String workEmail;
	private String homeAddress;
	private String workAddress;
	private String department;
	private String website;

}
