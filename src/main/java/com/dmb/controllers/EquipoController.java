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

import com.dmb.entities.Equipo;
import com.dmb.services.EquipoService;

@RestController
@RequestMapping("api/v1")
public class EquipoController {

	@Autowired
	private EquipoService serv;

	@GetMapping("/equipos")
	public ResponseEntity<List<Equipo>> getAllEquipo() {
		return ResponseEntity.ok(serv.getAllEquipo());
	}

	@GetMapping("/equipo/{numSerie}")
	public ResponseEntity<Equipo> getOneEquipo(@PathVariable(name = "numSerie") String numSerie) {
		Optional<Equipo> entity = serv.getOneEquipo(numSerie);
		if (entity.isPresent()) {
			return ResponseEntity.ok(entity.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/equipo")
	public ResponseEntity<Equipo> saveEquipo(@RequestBody Equipo entity) {
		return ResponseEntity.ok(serv.createEquipo(entity));
	}

	@PutMapping("/equipo/{numSerie}")
	public ResponseEntity<Equipo> updateEquipo(@PathVariable(name = "numSerie")String numSerie, @RequestBody Equipo entity) {
		Optional<Equipo> entityOld = serv.getOneEquipo(numSerie);
		if (entityOld.isPresent()) {
			return ResponseEntity.ok(entity);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/equipo/{id}")
	public ResponseEntity<Void> deleteEquipo(@PathVariable(name = "numSerie") String numSerie) {
		Optional<Equipo> entity = serv.getOneEquipo(numSerie);
		if (entity.isPresent()) {
			serv.deleteEquipo(numSerie);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
