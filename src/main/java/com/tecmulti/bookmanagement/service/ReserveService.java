package com.tecmulti.bookmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tecmulti.bookmanagement.dto.BookDto;
import com.tecmulti.bookmanagement.dto.ReserveDto;
import com.tecmulti.bookmanagement.entities.Book;
import com.tecmulti.bookmanagement.entities.Reserve;
import com.tecmulti.bookmanagement.repositories.ReserveRepository;
import com.tecmulti.bookmanagement.service.exeption.ResourceNotFountExeption;

@Service
public class ReserveService {
	
	@Autowired
	private ReserveRepository repository;
	
	 @Autowired
	 private BookService bookService;
	
	@Transactional(readOnly = true)
	public Page<ReserveDto> findAll(Pageable pageable) {//listagem de reserva paginada
		Page<Reserve> result = repository.findAll(pageable);
		return result.map(x -> new ReserveDto(x));
	}
	
	@Transactional(readOnly = true)
	public ReserveDto findById(Long id) {//Busca especifica por Id
		Reserve reserve = repository.findById(id).orElseThrow(
				()-> new ResourceNotFountExeption("Recurso não encontrado"));
		return new ReserveDto(reserve);
	}
	@Transactional
	public ReserveDto insert(ReserveDto dto) {//Criar novo livro
		Reserve reserve = new Reserve();
		reserve = dtoToEntity(reserve, dto);
		reserve = repository.save(reserve);
		return new ReserveDto(reserve);
	}
	
	private Reserve dtoToEntity(Reserve reserve, ReserveDto dto) {
        reserve.setId(dto.getId());
        reserve.setStartDate(dto.getStartDate());
        reserve.setEndDate(dto.getEndDate());
        reserve.setUserName(dto.getUserName());

         // Recuperar o livro pelo ID e associar à reserva
        Book book = bookService.findEntityById(dto.getBookId());
        reserve.setBook(book);
     
        if (book == null) { // Verificar se o livro foi encontrado
            throw new ResourceNotFountExeption("Livro não encontrado com o ID: " + dto.getBookId());
        }
        reserve.setBook(book);
        return reserve;
    }

}
