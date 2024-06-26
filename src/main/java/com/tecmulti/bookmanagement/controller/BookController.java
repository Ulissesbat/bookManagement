package com.tecmulti.bookmanagement.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tecmulti.bookmanagement.dto.BookDto;
import com.tecmulti.bookmanagement.service.BookService;

import jakarta.validation.Valid;

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
	@PostMapping
	public ResponseEntity<BookDto>insert(@Valid @RequestBody BookDto dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<BookDto>update(@PathVariable Long id,@Valid @RequestBody BookDto dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok(dto);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
