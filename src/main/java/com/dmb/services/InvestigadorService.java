package com.dmb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Investigador;
import com.dmb.repository.InvestigadorDAO;

@Service
public class InvestigadorService  implements IServiceInvestigador{

	@Autowired
	private InvestigadorDAO dao;

	@Override
	public List<Investigador> getAllInvestigador() {
		return  dao.findAll();
	}

	@Override
	public Optional<Investigador> getOneInvestigador(String DNI) {
		return dao.findById(DNI);
	}

	@Override
	public Investigador createInvestigador(Investigador entity) {
		return dao.save(entity);
	}

	@Override
	public Investigador updateInvestigador(Investigador entity) {
		return dao.save(entity);
	}

	@Override
	public void deleteInvestigador(String DNI) {
		dao.deleteById(DNI);
	}
	
	
	
}
