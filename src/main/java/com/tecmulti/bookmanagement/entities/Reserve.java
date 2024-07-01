package com.tecmulti.bookmanagement.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Reserve {
	
	private Long id;
	private LocalDate startDate;
	private LocalDate endDate;
	private String user;
	private Book book;
	
	public Reserve(Long id, LocalDate startDate, LocalDate endDate, String user, Book book) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.user = user;
		this.book = book;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserve other = (Reserve) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
