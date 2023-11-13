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

import com.dmb.entities.Facultad;
import com.dmb.services.FacultadService;

@RestController
@RequestMapping("api/v1")
public class FacultadController {

	@Autowired
	private FacultadService serv;
	
	@GetMapping("/facultades")
	public ResponseEntity<List<Facultad>> getAllFacultad() {
		return ResponseEntity.ok(serv.getAllFacultad());
	}
	
	@GetMapping("/facultad/{id}")
	public ResponseEntity<Facultad> getOneFacultad(@PathVariable(name = "id") Long id) { 
		Optional<Facultad> entity = serv.getOneFacultad(id);
		if (entity.isPresent()) {
			return ResponseEntity.ok(entity.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/facultad")
	public ResponseEntity<Facultad> saveFacultad(@RequestBody Facultad entity) {
		return ResponseEntity.ok(serv.createFacultad(entity));
	}
	
	
	@PutMapping("/facultad/{id}")
	public ResponseEntity<Facultad> updateFacultad(@PathVariable(name = "id") Long id, @RequestBody Facultad entity) {
		Optional<Facultad> entityOld = serv.getOneFacultad(id);
		if (entityOld.isPresent()) {
			return ResponseEntity.ok(entity);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/facultad/{id}")
	public ResponseEntity<Void> deleteFacultad(@PathVariable(name = "id") Long id) { 
		Optional<Facultad> entity = serv.getOneFacultad(id);
		if (entity.isPresent()) {
			serv.deleteFacultad(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
