package com.PathfinderBBDD.ClasesBasicas;

public class Personaje {
	
	// CANTIDAD DE VARIABLES: 16
	
	private int Id;
	private String Nombre;
	private String Raza;
	private String Clase;
	private String Especializacion;
	private String Propietario;
	private int Nivel;
	private String Campaña;
	private String visibilidad;
	
	// Estas variables SOLO SE VERAN en el menu de consulta.
	
	private int Fuerza;
	private int Destreza;
	private int Constitucion;
	private int Intelecto;
	private int Sabiduria;
	private int Carisma;
	private String Conjuros;
	
	
	
	public Personaje(int Id, String Nombre, String Raza, String Clase, String Especializacion, String Propietario,
			int Nivel, String Campaña, String Visibilidad, int Fuerza, int Destreza, int Constitucion, int Intelecto,
			int Sabiduria, int Carisma, String Conjuros) {
		super();
		this.Id = Id;
		this.Nombre = Nombre;
		this.Raza = Raza;
		this.Clase = Clase;
		this.Especializacion = Especializacion;
		this.Propietario = Propietario;
		this.Nivel = Nivel;
		this.Campaña = Campaña;
		this.visibilidad = Visibilidad;
		this.Fuerza = Fuerza;
		this.Destreza = Destreza;
		this.Constitucion = Constitucion;
		this.Intelecto = Intelecto;
		this.Sabiduria = Sabiduria;
		this.Carisma = Carisma;
		this.Conjuros = Conjuros;
	}
	
	public Personaje() {
		
	}
	
	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getRaza() {
		return Raza;
	}
	public void setRaza(String raza) {
		Raza = raza;
	}
	public String getClase() {
		return Clase;
	}
	public void setClase(String clase) {
		Clase = clase;
	}
	public String getEspecializacion() {
		return Especializacion;
	}
	public void setEspecializacion(String especializacion) {
		Especializacion = especializacion;
	}
	public String getPropietario() {
		return Propietario;
	}
	public void setPropietario(String propietario) {
		Propietario = propietario;
	}
	public int getNivel() {
		return Nivel;
	}
	public void setNivel(int nivel) {
		Nivel = nivel;
	}
	public String getCampaña() {
		return Campaña;
	}
	public void setCampaña(String campaña) {
		Campaña = campaña;
	}
	public String getVisibilidad() {
		return visibilidad;
	}
	public void setVisibilidad(String visibilidad) {
		this.visibilidad = visibilidad;
	}
	public int getFuerza() {
		return Fuerza;
	}
	public void setFuerza(int fuerza) {
		Fuerza = fuerza;
	}
	public int getDestreza() {
		return Destreza;
	}
	public void setDestreza(int destreza) {
		Destreza = destreza;
	}
	public int getConstitucion() {
		return Constitucion;
	}
	public void setConstitucion(int constitucion) {
		Constitucion = constitucion;
	}
	public int getIntelecto() {
		return Intelecto;
	}
	public void setIntelecto(int intelecto) {
		Intelecto = intelecto;
	}
	public int getSabiduria() {
		return Sabiduria;
	}
	public void setSabiduria(int sabiduria) {
		Sabiduria = sabiduria;
	}
	public int getCarisma() {
		return Carisma;
	}
	public void setCarisma(int carisma) {
		Carisma = carisma;
	}
	public String getConjuros() {
		return Conjuros;
	}
	public void setConjuros(String conjuros) {
		Conjuros = conjuros;
	}
	@Override
	public String toString() {
		return "Personaje [Id=" + Id + ", Nombre=" + Nombre + ", Raza=" + Raza + ", Clase=" + Clase
				+ ", Especializacion=" + Especializacion + ", Propietario=" + Propietario + ", Nivel=" + Nivel
				+ ", Campaña=" + Campaña + ", visibilidad=" + visibilidad + ", Fuerza=" + Fuerza + ", Destreza="
				+ Destreza + ", Constitucion=" + Constitucion + ", Intelecto=" + Intelecto + ", Sabiduria=" + Sabiduria
				+ ", Carisma=" + Carisma + ", Conjuros=" + Conjuros + "]";
	}
	
	
	
	
	
	
	
	
}
