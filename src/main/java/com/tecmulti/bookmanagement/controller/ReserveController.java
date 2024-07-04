package com.tecmulti.bookmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tecmulti.bookmanagement.dto.ReserveDto;
import com.tecmulti.bookmanagement.service.ReserveService;

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
	
}
