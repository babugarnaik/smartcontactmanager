package com.scm.smartcontactmanager.exceptionhandle;

public class BadRequestException extends Exception {
	private static final long serialVersionUID = -6595096158000436115L;

	private String message;
	public BadRequestException( String reason) {
		super(reason);
		this.message =reason;
		
	}

}
