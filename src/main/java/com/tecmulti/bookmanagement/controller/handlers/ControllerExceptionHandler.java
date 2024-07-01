package com.tecmulti.bookmanagement.controller.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tecmulti.bookmanagement.dto.CustomError;
import com.tecmulti.bookmanagement.dto.ValidationError;
import com.tecmulti.bookmanagement.service.exeption.DataBaseExeption;
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

	@ExceptionHandler(DataBaseExeption.class)
	public ResponseEntity<CustomError> dataBaseExeption(DataBaseExeption e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> methodArgumentNotValid(MethodArgumentNotValidException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ValidationError err = new ValidationError(Instant.now(), status.value(), "Validation error",
				request.getRequestURI());
		for (FieldError f : e.getBindingResult().getFieldErrors()) {
			err.addError(f.getField(), f.getDefaultMessage());
		}
		return ResponseEntity.status(status).body(err);
	}
}