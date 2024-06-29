package com.tecmulti.bookmanagement.controller.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tecmulti.bookmanagement.dto.CustomError;
import com.tecmulti.bookmanagement.service.exeption.ResourceNotFountExeption;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFountExeption.class)
	public ResponseEntity<CustomError> resourceNotFount(ResourceNotFountExeption e, HttpServletRequest request) {
	HttpStatus status = HttpStatus.NOT_FOUND;
	CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
	return ResponseEntity.status(status).body(err);
}
}