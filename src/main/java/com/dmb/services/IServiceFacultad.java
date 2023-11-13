package com.dmb.services;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Facultad;

public interface IServiceFacultad {

	//CRUD 

	//Read All
	public List<Facultad> getAllFacultad();

	//Read One
	public Optional<Facultad> getOneFacultad(Long id);
	//Create

	public Facultad createFacultad(Facultad entity);

	//Update
	public Facultad updateFacultad(Facultad entity);

	//Delete
	public void deleteFacultad(Long id);
}
