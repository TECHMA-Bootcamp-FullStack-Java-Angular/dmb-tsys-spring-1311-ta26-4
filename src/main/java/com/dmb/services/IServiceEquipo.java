package com.dmb.services;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Equipo;

public interface IServiceEquipo {
	
	//CRUD 

	//Read All
	public List<Equipo> getAllEquipo();

	//Read One
	public Optional<Equipo> getOneEquipo( String numSerie);
	//Create

	public Equipo createEquipo(Equipo entity);

	//Update
	public Equipo updateEquipo(Equipo entity);

	//Delete
	public void deleteEquipo( String numSerie); 
}
