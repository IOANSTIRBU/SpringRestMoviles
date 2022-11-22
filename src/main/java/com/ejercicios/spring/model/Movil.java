package com.ejercicios.spring.model;

import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 
 * @author Ioan Stirbu
 * 
 * Clase movil con sus caracteristicas
 *
 */



@Schema(name = "Movil", description = "Movil Class")
public class Movil  {

	
	/**
	 * El Schema: Se encarga de crear un movil de prueba con sus caracteristicas
	 */
	
	@Schema(name = "id",
			description = "Identificador para el movil",
			example = "20",
			required = true)
	
	@Size(min = 0, max = 40)

	private Long id;
	private String nombre;
	private String modelo;
	private String color;
	
	
	public Movil() {
		super();
	}
	
	public Movil(String nombre, String modelo, String color) {
		super();
		this.nombre = nombre;
		this.modelo = modelo;
		this.color = color;
		
	}


	public Movil(Long id,String nombre, String modelo, String color) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.modelo = modelo;
		this.color = color;
		
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


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	@Override
	public String toString() {
		return "Movil [id=" + id + ", nombre=" + nombre + ", modelo=" + modelo + ", color=" + color + "]";
	}


	


	
	
	
	
	
	

}
