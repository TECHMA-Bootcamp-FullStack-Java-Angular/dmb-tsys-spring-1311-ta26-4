package com.dmb.services;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Reserva;

public interface IServiceReserva {
	
	//CRUD 

	//Read All
	public List<Reserva> getAllReserva();

	//Read One
	public Optional<Reserva> getOneReserva(String id); 
	//Create

	public Reserva createReserva(Reserva entity);

	//Update
	public Reserva updateReserva(Reserva entity);

	//Delete
	public void deleteReserva(String id);
}
