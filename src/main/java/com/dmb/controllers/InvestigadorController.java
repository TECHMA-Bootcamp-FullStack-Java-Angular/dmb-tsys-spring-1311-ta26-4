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

import com.dmb.entities.Investigador;
import com.dmb.services.InvestigadorService;

@RestController
@RequestMapping("api/v1")
public class InvestigadorController  {

	@Autowired
	private InvestigadorService serv;

	@GetMapping("/investigadores")
	public ResponseEntity<List<Investigador>> getAllInvestigador() {
		return ResponseEntity.ok(serv.getAllInvestigador());
	}
	
	@GetMapping("/investigador/{dni}")
	public ResponseEntity<Investigador> getOneInvestigador(@PathVariable(name = "dni") String DNI) { 
		Optional<Investigador> entity = serv.getOneInvestigador(DNI);
		if (entity.isPresent()) {
			return ResponseEntity.ok(entity.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/investigador")
	public ResponseEntity<Investigador> saveInvestigador(@RequestBody Investigador entity) {
		return ResponseEntity.ok(serv.createInvestigador(entity));
	}
	
	
	@PutMapping("/investigador/{dni}")
	public ResponseEntity<Investigador> updateInvestigador(@PathVariable(name = "dni") String DNI, @RequestBody Investigador entity) {
		Optional<Investigador> entityOld = serv.getOneInvestigador(DNI);
		if (entityOld.isPresent()) {
			return ResponseEntity.ok(entity);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/investigador/{dni}")
	public ResponseEntity<Void> deleteInvestigador(@PathVariable(name = "dni") String DNI) { 
		Optional<Investigador> entity = serv.getOneInvestigador(DNI);
		if (entity.isPresent()) {
			serv.deleteInvestigador(DNI);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
