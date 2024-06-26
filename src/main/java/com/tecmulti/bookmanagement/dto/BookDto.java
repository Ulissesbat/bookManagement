package com.tecmulti.bookmanagement.dto;

import com.tecmulti.bookmanagement.entities.Book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BookDto {

	private Long id;
	
	@Size(min = 3, max = 150, message = "title must be between 3 and 150 characters")
	@NotBlank(message = "Required field" )
	private String title;
	
	@Size(min = 3, max = 80, message = "title must be between 3 and 80 characters")
	@NotBlank(message = "Required field" )
	private String author;
	
	@Size(max = 13, message = "ISBN must contain 13 numbers" )
	private String ISBN;
	
	
	public BookDto(Long id, String title, String author, String ISBN) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
	}
	
	public BookDto(Book entity) {
		id = entity.getId();
		title = entity.getTitle();
		author = entity.getAuthor();
		ISBN = entity.getISBN();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getISBN() {
		return ISBN;
	}
	
	
}
