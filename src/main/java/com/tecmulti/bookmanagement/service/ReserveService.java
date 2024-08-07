package com.tecmulti.bookmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tecmulti.bookmanagement.dto.ReserveDto;
import com.tecmulti.bookmanagement.entities.Book;
import com.tecmulti.bookmanagement.entities.Reserve;
import com.tecmulti.bookmanagement.repositories.ReserveRepository;
import com.tecmulti.bookmanagement.service.exeption.DataBaseExeption;
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
	
	@Transactional
	public ReserveDto update(Long id, ReserveDto dto) {//Atualizar um livro
		Reserve reserve = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFountExeption("Reserva não encontrada com o ID: " + id));
		reserve = dtoToEntity(reserve, dto);
		reserve = repository.save(reserve);
		return new ReserveDto(reserve);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if(! repository.existsById(id)){
			 throw new ResourceNotFountExeption("Recurso não encontrado");
		}
		try {
			repository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataBaseExeption("falha de integridade");
		}
	}
	
	private Reserve dtoToEntity(Reserve reserve, ReserveDto dto) {
		
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
