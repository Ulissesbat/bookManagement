package com.tecmulti.bookmanagement.dto;

import java.time.LocalDate;

import com.tecmulti.bookmanagement.entities.Book;
import com.tecmulti.bookmanagement.entities.Reserve;

public class ReserveDto {

	private Long id;
	private LocalDate startDate;
	private LocalDate endDate;
	private String user;
	private Book book;
	
	public ReserveDto(Long id, LocalDate startDate, LocalDate endDate, String user, Book book) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.user = user;
		this.book = book;
	}
	
	public ReserveDto(Reserve entity) {
		
		id = entity.getId();
		startDate = entity.getStartDate();
		endDate = entity.getEndDate();
		user = entity.getUser();
		book = entity.getBook();
	}

	public Long getId() {
		return id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public String getUser() {
		return user;
	}

	public Book getBook() {
		return book;
	}
	
	
}
