package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmb.entities.Investigador;

@Repository
public interface InvestigadorDAO  extends JpaRepository<Investigador, String>{

}
