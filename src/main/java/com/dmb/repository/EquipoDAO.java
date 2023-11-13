package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmb.entities.Equipo;

@Repository
public interface EquipoDAO extends JpaRepository<Equipo , String>{

}
