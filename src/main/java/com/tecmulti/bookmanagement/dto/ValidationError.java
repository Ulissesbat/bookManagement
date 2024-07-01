package com.tecmulti.bookmanagement.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {
	
	private List <FieldMessage> erros = new ArrayList<>();

	public ValidationError(Instant timestamp, Integer status, String error, String path) {
		super(timestamp, status, error, path);
		// TODO Auto-generated constructor stub
	}
	
	public List<FieldMessage> getErros() {
		return erros;
	}

	public void addError(String fildName, String message) {
		erros.add(new FieldMessage(fildName, message));
	}
}
