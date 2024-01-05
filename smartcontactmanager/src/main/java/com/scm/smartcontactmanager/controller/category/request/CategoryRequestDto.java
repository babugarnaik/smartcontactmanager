package com.scm.smartcontactmanager.controller.category.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequestDto {

	@Size(min = 2, message = "Name should be atleast 2 letters")
	private String name;

	@Size(min = 2, message = "Name should be atleast 2 letters")
	private String type;
	private int contactId;
	private int userId;
	private boolean byAdmin;
}
