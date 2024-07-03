package com.tecmulti.bookmanagement.dto;

import java.time.LocalDate;

import com.tecmulti.bookmanagement.entities.Book;
import com.tecmulti.bookmanagement.entities.Reserve;

public class ReserveDto {

	private Long id;
	private LocalDate startDate;
	private LocalDate endDate;
	private String userName;
	private Book book;
	
	public ReserveDto(Long id, LocalDate startDate, LocalDate endDate, String userName, Book book) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userName = userName;
		this.book = book;
	}
	
	public ReserveDto(Reserve entity) {
		
		id = entity.getId();
		startDate = entity.getStartDate();
		endDate = entity.getEndDate();
		userName = entity.getUserName();
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

	public String getUserName() {
		return userName;
	}

	public Book getBook() {
		return book;
	}
	
	
}
