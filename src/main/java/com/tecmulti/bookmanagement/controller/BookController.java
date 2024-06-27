package com.tecmulti.bookmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tecmulti.bookmanagement.dto.BookDto;
import com.tecmulti.bookmanagement.service.BookService;

@Controller
@RequestMapping(value = "/books")
public class BookController {

	@Autowired
	private BookService service;
	
	@GetMapping
	public ResponseEntity<Page<BookDto>> findAll(Pageable pageable){
		Page<BookDto> dto = service.findAll(pageable);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BookDto> findById(@PathVariable Long id){
		BookDto dto = service.findById(id);	
		return ResponseEntity.ok(dto);
	}
	
}
