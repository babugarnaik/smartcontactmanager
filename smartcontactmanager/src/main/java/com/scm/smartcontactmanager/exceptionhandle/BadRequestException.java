package com.scm.smartcontactmanager.exceptionhandle;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BadRequestException extends ResponseStatusException{
	private static final long serialVersionUID = 488369140743454927L;
	
	private String message;
	private HttpStatusCode httpStatusCode;
	
		public BadRequestException(HttpStatusCode status, String reason) {
		super(status, reason);
		this.httpStatusCode = status;
		this.message = reason;
		// TODO Auto-generated constructor stub
	}

		
		
	

}
