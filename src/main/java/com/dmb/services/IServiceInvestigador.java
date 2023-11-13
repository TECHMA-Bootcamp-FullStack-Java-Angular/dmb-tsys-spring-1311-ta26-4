package com.dmb.services;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Investigador;

public interface IServiceInvestigador {
	
	//CRUD 

	//Read All
	public List<Investigador> getAllInvestigador();

	//Read One
	public Optional<Investigador> getOneInvestigador(String DNI); 

	public Investigador createInvestigador(Investigador entity);

	//Update
	public Investigador updateInvestigador(Investigador entity);

	//Delete
	public void deleteInvestigador(String DNI); 

}
