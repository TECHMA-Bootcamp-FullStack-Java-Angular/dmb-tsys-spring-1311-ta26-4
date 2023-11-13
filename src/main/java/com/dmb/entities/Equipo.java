package com.dmb.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="equipos")
public class Equipo {
	
	@Id
	private String numSerie;

	@ManyToOne
	@JoinColumn(name = "facultades")
	@JsonIgnore
	private Facultad facultad;

	@OneToMany(mappedBy = "equipo")
	@JsonIgnore
	private List<Reserva> reservas;

	public Equipo() {
	}

	public Equipo(String numSerie, Facultad facultad) {

		this.numSerie = numSerie;
		this.facultad = facultad;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}


	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}



	
}