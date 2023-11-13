package com.dmb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Reserva;
import com.dmb.repository.ReservaDAO;

@Service
public class ReservaService implements IServiceReserva{
	
	@Autowired
	private ReservaDAO dao;

	@Override
	public List<Reserva> getAllReserva() {
		return dao.findAll();
	}

	@Override
	public Optional<Reserva> getOneReserva(String id) {
		return dao.findById(id);
	}

	@Override
	public Reserva createReserva(Reserva entity) {
		return dao.save(entity);
	}

	@Override
	public Reserva updateReserva(Reserva entity) {
		return dao.save(entity);
	}

	@Override
	public void deleteReserva(String id) {
		dao.deleteById(id);
	}

}
