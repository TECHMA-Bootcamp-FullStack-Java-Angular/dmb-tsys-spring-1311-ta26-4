package com.dmb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmb.entities.Reserva;
import com.dmb.services.ReservaService;

@RestController
@RequestMapping("api/v1")
public class ReservaController {
	
	@Autowired
	private ReservaService serv;
	
	@GetMapping("/reservas")
	public ResponseEntity<List<Reserva>> getAllReserva() {
		return ResponseEntity.ok(serv.getAllReserva());
	}
	
	@GetMapping("/reserva/{id}")
	public ResponseEntity<Reserva> getOneReserva(@PathVariable(name = "id") String id) { 
		Optional<Reserva> entity = serv.getOneReserva(id);
		if (entity.isPresent()) {
			return ResponseEntity.ok(entity.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/reserva")
	public ResponseEntity<Reserva> saveReserva(@RequestBody Reserva entity) {
		return ResponseEntity.ok(serv.createReserva(entity));
	}
	
	
	@PutMapping("/reserva/{id}")
	public ResponseEntity<Reserva> updateReserva(@PathVariable(name = "id") String id, @RequestBody Reserva entity) {
		Optional<Reserva> entityOld = serv.getOneReserva(id);
		if (entityOld.isPresent()) {
			return ResponseEntity.ok(entity);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/reserva/{id}")
	public ResponseEntity<Void> deleteReserva(@PathVariable(name = "id") String id) { 
		Optional<Reserva> entity = serv.getOneReserva(id);
		if (entity.isPresent()) {
			serv.deleteReserva(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
