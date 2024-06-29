package com.tecmulti.bookmanagement.service.exeption;

public class ResourceNotFountExeption extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	
	public ResourceNotFountExeption(String msg) {
		super(msg);
	}

}
