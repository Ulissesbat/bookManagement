package com.tecmulti.bookmanagement.dto;

import java.time.LocalDate;

import com.tecmulti.bookmanagement.entities.Reserve;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class ReserveDto {

	private Long id;
	
	@NotNull(message = "A data de início é obrigatória.")
    @PastOrPresent(message = "A data de início deve estar no passado ou presente.")
	private LocalDate startDate;
	
	@NotNull(message = "A data de fim é obrigatória.")
    @FutureOrPresent(message = "A data de início deve estar no passado ou presente.")
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

	@AssertTrue(message = "A data de fim deve ser posterior à data de início.")
	public boolean isEndDateAfterStartDate() {
	    if (startDate == null || endDate == null) {
	        return true; // Se uma das datas for nula, a validação não falha aqui.
	    }
	    return endDate.isAfter(startDate);
	}

}
