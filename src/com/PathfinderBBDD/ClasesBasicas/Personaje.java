package com.PathfinderBBDD.ClasesBasicas;

public class Personaje {
	private int id;
	private String Nombre;
	private String Clase;
	private String Especializacion;
	private int Nivel;
	private String Propietario;
	
	/*****************************************************************************************/
	
	// CONSTRUCTOR
	
	/*****************************************************************************************/
	
	public Personaje(int id, String nombre, String clase, String especializacion, int nivel, String propietario) {
		super();
		this.id = id;
		Nombre = nombre;
		Clase = clase;
		Especializacion = especializacion;
		Nivel = nivel;
		Propietario = propietario;
	}

	/*********************************************************************************/
	
	// GETTERS Y SETTER
	
	/***************************************************************************************/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getEspecializacion() {
		return Especializacion;
	}

	public void setEspecializacion(String especializacion) {
		Especializacion = especializacion;
	}

	public int getNivel() {
		return Nivel;
	}

	public void setNivel(int nivel) {
		Nivel = nivel;
	}

	public String getPropietario() {
		return Propietario;
	}

	public void setPropietario(String propietario) {
		Propietario = propietario;
	}
	
	

}
