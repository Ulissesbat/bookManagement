package com.tecmulti.bookmanagement.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tecmulti.bookmanagement.dto.BookDto;
import com.tecmulti.bookmanagement.dto.ReserveDto;
import com.tecmulti.bookmanagement.service.ReserveService;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/reservations")
public class ReserveController {

	@Autowired
	private ReserveService service;
	
	@GetMapping
	public ResponseEntity<Page<ReserveDto>> findAll(Pageable pageable){
		Page<ReserveDto> dto = service.findAll(pageable);
		return ResponseEntity.ok(dto);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<ReserveDto> findById(@PathVariable Long id){
		ReserveDto dto = service.findById(id);	
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<ReserveDto>insert(@Valid @RequestBody ReserveDto dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ReserveDto>update(@PathVariable Long id,@Valid @RequestBody ReserveDto dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok(dto);
	}
	
}
