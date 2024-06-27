package com.tecmulti.bookmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tecmulti.bookmanagement.dto.BookDto;
import com.tecmulti.bookmanagement.entities.Book;
import com.tecmulti.bookmanagement.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	@Transactional(readOnly = true)
	public Page<BookDto> findAll(Pageable pageable) {
		Page<Book> result = repository.findAll(pageable);
		return result.map(x -> new BookDto(x));
	}
	
	@Transactional(readOnly = true)
	public BookDto findById(Long id) {
		Book books = repository.findById(id).get();
		return new BookDto(books);
	}
	
}
