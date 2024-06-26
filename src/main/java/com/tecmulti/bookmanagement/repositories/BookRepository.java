package com.tecmulti.bookmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecmulti.bookmanagement.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
