package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dmb.entities.Facultad;

@Repository
public interface FacultadDAO extends JpaRepository<Facultad, Long > {

}
