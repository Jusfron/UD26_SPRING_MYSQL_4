package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="facultad")
public class Facultad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Equipo> equipo;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Investigador> investigador;

	public Facultad() {
		super();
	}

	public Facultad(int id, String nombre, List<Equipo> equipo, List<Investigador> investigador) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.equipo = equipo;
		this.investigador = investigador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Equipo")
	public List<Equipo> getEquipo() {
		return equipo;
	}

	public void setEquipo(List<Equipo> equipo) {
		this.equipo = equipo;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Investigador")
	public List<Investigador> getInvestigador() {
		return investigador;
	}

	public void setInvestigador(List<Investigador> investigador) {
		this.investigador = investigador;
	}

	@Override
	public String toString() {
		return "Facultad [id=" + id + ", nombre=" + nombre + ", equipo=" + equipo + ", investigador=" + investigador
				+ "]";
	}

	

}
