package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmb.entities.Reserva;

@Repository
public interface ReservaDAO extends JpaRepository<Reserva, String>{

}
