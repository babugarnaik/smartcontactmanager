package com.scm.smartcontactmanager.controller.category.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDto {

	private String name;
	private String type;
	private int contactId;
	private int userId;
	private boolean byAdmin;
	
}
