package com.tecmulti.bookmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecmulti.bookmanagement.entities.Book;

public interface ReserveRepository extends JpaRepository<Book, Long>{

}
