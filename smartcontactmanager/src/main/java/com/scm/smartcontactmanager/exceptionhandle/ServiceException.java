package com.scm.smartcontactmanager.exceptionhandle;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class ServiceException  extends ResponseStatusException{


		@Getter
		@Setter
		private HttpStatusCode httpStatusCode;
		
		@Getter
		@Setter
		private String message;
		
		public ServiceException (HttpStatusCode httpStatusCode , String message) {
			super(httpStatusCode , message);
			this.httpStatusCode = httpStatusCode;
			this.message = message;
		
	}
	
	

}
