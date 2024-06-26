package com.tecmulti.bookmanagement.dto;

import com.tecmulti.bookmanagement.entities.Book;

public class BookDto {

	private Long id;
	private String title;
	private String author;
	private String ISBN;
	
	
	public BookDto(Long id, String title, String author, String ISBN) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
	}
	
	public BookDto(Book entity) {
		id = id;
		title = title;
		author = author;
		ISBN = ISBN;
	}
	
}
