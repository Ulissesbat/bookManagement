package com.tecmulti.bookmanagement.dto;

import java.time.LocalDate;

import com.tecmulti.bookmanagement.entities.Book;
import com.tecmulti.bookmanagement.entities.Reserve;

public class ReserveDto {

	private Long id;
	private LocalDate startDate;
	private LocalDate endDate;
	private String userName;
	private Long bookId;
	
	public ReserveDto(Long id, LocalDate startDate, LocalDate endDate, String userName, Long bookId) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userName = userName;
		this.bookId = bookId;
	}

	public ReserveDto(Reserve entity) {
		
		id = entity.getId();
		startDate = entity.getStartDate();
		endDate = entity.getEndDate();
		userName = entity.getUserName();
		bookId = entity.getBook().getId();
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

	public Long getBookId() {
		return bookId;
	}

	
	
	
}
