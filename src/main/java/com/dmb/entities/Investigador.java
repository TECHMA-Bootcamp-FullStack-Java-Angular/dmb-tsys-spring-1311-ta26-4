package com.dmb.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "investigadores")
public class Investigador {

	@Id
	@Column(name = "dni")
	private String DNI;

	private String fullname;

	@ManyToOne
	@JoinColumn(name = "facultad")
	@JsonIgnore
	private Facultad facultad;

	@OneToMany(mappedBy = "investigador")
	@JsonIgnore
	private List<Reserva> reservas;

	public Investigador() {
	}

	public Investigador(String DNI, String nomApels, Facultad facultad) {
		this.DNI = DNI;
		this.fullname = nomApels;
		this.facultad = facultad;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNomApels() {
		return fullname;
	}

	public void setNomApels(String nomApels) {
		this.fullname = nomApels;
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
