package com.tecmulti.bookmanagement.dto;

public class FieldMessage {
	
	private String FildName;
	private String message;
	
	public FieldMessage(String fildName, String message) {
		super();
		FildName = fildName;
		this.message = message;
	}

	public String getFildName() {
		return FildName;
	}

	public String getMessage() {
		return message;
	}
	
	

}
