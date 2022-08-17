package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="investigadores")
public class Investigador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nom_apels")
	private String nomApels;
	
	@ManyToOne
	@JoinColumn(name = "facultad")
	Facultad facultad;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Reserva> reserva;

	public Investigador() {
		super();
	}

	public Investigador(int id, String nomApels, Facultad facultad, List<Reserva> reserva) {
		super();
		this.id = id;
		this.nomApels = nomApels;
		this.facultad = facultad;
		this.reserva = reserva;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomApels() {
		return nomApels;
	}

	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	@Override
	public String toString() {
		return "Investigador [id=" + id + ", nomApels=" + nomApels + ", facultad=" + facultad + ", reserva=" + reserva
				+ "]";
	}
	
	

}
