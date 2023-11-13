package com.dmb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Equipo;
import com.dmb.repository.EquipoDAO;

@Service
public class EquipoService implements IServiceEquipo {
	
	@Autowired
	private EquipoDAO dao;

	@Override
	public List<Equipo> getAllEquipo() {
		return dao.findAll();
	}

	@Override
	public Optional<Equipo> getOneEquipo(String numSerie) {
		return dao.findById(numSerie);
	}

	@Override
	public Equipo createEquipo(Equipo entity) {
		return dao.save(entity);
	}
	

	@Override
	public Equipo updateEquipo(Equipo entity) {
		return dao.save(entity);
	}

	@Override
	public void deleteEquipo(String numSerie) {
		dao.findById(numSerie);
	}
 
}
