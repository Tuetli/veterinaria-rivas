package com.projectrivas.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.projectrivas.util.Raza;

@Entity
@Table(name = "animal")
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Raza raza;
	
	@Column(name = "duenio", length = 30, nullable = false)
	private String duenio;
	
	@Column(name = "edad", length = 3, nullable = false)
	private Integer edad;
	
	@Column(name = "color", length = 20, nullable = false)
	private String color;
	
	@Column(name = "peso", nullable = false)
	private Double peso;
	
	public Animal() {
		
	}
	
	public Animal(String nombre) {
		this.nombre = nombre;
	}
	
	public Animal(String nombre, String color, String duenio) {
		this.nombre = nombre;
		this.color = color;
		this.duenio = duenio;
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public String getDuenio() {
		return duenio;
	}

	public void setDuenio(String duenio) {
		this.duenio = duenio;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
}
