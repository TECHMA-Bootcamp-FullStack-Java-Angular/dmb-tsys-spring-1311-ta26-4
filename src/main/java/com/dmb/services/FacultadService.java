package com.dmb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Facultad;
import com.dmb.repository.FacultadDAO;

@Service
public class FacultadService implements IServiceFacultad {

	@Autowired
	private FacultadDAO dao;

	@Override
	public List<Facultad> getAllFacultad() {
		return dao.findAll();
	}

	@Override
	public Optional<Facultad> getOneFacultad(Long id) {
		return dao.findById(id);
	}

	@Override
	public Facultad createFacultad(Facultad entity) {
		return dao.save(entity);
	}

	@Override
	public Facultad updateFacultad(Facultad entity) {
		return dao.save(entity);
	}

	@Override
	public void deleteFacultad(Long id) {
		dao.deleteById(id);
	}
	
	
}
