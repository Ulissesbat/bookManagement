package com.tecmulti.bookmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecmulti.bookmanagement.entities.Reserve;

public interface ReserveRepository extends JpaRepository<Reserve, Long>{

}
