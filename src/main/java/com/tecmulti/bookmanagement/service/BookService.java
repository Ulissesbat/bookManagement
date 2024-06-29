package com.tecmulti.bookmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tecmulti.bookmanagement.dto.BookDto;
import com.tecmulti.bookmanagement.entities.Book;
import com.tecmulti.bookmanagement.repositories.BookRepository;
import com.tecmulti.bookmanagement.service.exeption.ResourceNotFountExeption;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	@Transactional(readOnly = true)
	public Page<BookDto> findAll(Pageable pageable) {//listagem de livros paginada
		Page<Book> result = repository.findAll(pageable);
		return result.map(x -> new BookDto(x));
	}
	
	@Transactional(readOnly = true)
	public BookDto findById(Long id) {//Busca especifica por Id
		Book books = repository.findById(id).orElseThrow(
				()-> new ResourceNotFountExeption("Recurso não encontrado"));
		return new BookDto(books);
	}
	
	@Transactional
	public BookDto insert(BookDto dto) {//Criar novo livro
		Book books = new Book();
		books = dtoToEntity(books, dto);
		books = repository.save(books);
		return new BookDto(books);
	}
	@Transactional
	public BookDto update(Long id, BookDto dto) {//Atualizar um livro
		Book books = repository.getReferenceById(id);
		books = dtoToEntity(books, dto);
		books = repository.save(books);
		return new BookDto(books);
	}
	
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	private static Book dtoToEntity(Book book, BookDto dto) {//tirar repetição de update e insert
		book.setTitle(dto.getTitle());
		book.setAuthor(dto.getAuthor());
		book.setIsbn(dto.getIsbn());
		return book;
	}
	
}
