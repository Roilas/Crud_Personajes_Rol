package com.PathfinderBBDD.Funciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.PathfinderBBDD.ClasesBasicas.Personaje;


public class GestorBBDDPersonajes {

	private DataSource ConfiguracionConexion;

	public GestorBBDDPersonajes(DataSource ConfiguracionConexion) {
		this.ConfiguracionConexion = ConfiguracionConexion;
	}

	
	
	public List<Personaje> ObtenPersonajesRegistrados() throws Exception {
		
		System.out.println("PROCESO: Listado de todos los personajes");
		
		//Este proceso se usa para obtener TODOS los personajes registrados. Los devuelve en una lista de "Personaje"
		
		
		//Aqui creamos la lista vacia.
		
		List<Personaje> PersonajesRegistrados = new ArrayList<Personaje>();
		
		
		// Con esto nos conectamos a la tabla "personajes"
		
		Connection miConexion = ConfiguracionConexion.getConnection();
		String ComandoIntroducido = "SELECT * FROM PERSONAJES";
		Statement MiDeclaracion = miConexion.createStatement();
		ResultSet miResultSet = MiDeclaracion.executeQuery(ComandoIntroducido);
		
		System.out.println("Conexion establecida");
		
		// y mientras haya Personajes extra, se iran añadiendo a la lista;
		
		while (miResultSet.next()) {
		
		Personaje PersonajeTemporalDelBucle = new Personaje();
		
		
		//String IdObtenido = miResultSet.getString("ID");
		//PersonajeTemporalDelBucle.setId(Integer.parseInt(IdObtenido));
		// PersonajeTemporalDelBucle.setId(Integer.parseInt(miResultSet.getString("ID")));
		//System.out.println("El id obtenido es: " + IdObtenido);
		
		
		/**************************************/
		
		// VARIABLES VISIBLES DEL MENU
		
		/********************************************/
		
		int IdObtenida = Integer.parseInt(miResultSet.getString("ID"));
		String NombreObtenido = miResultSet.getString("NOMBRE");
		String RazaObenida = miResultSet.getString("RAZA");
		String ClaseObtenida = miResultSet.getString("CLASE");
		String EspecializacionObtenida = miResultSet.getString("ESPECIALIZACION");
		String PropietarioObtenido = miResultSet.getString("PROPIETARIO");
		int NivelObtenido = Integer.parseInt(miResultSet.getString("NIVEL"));
		String CampañaObtenida = miResultSet.getString("CAMPAÑA");
		String VisibilidadObtenida = miResultSet.getString("VISIBILIDAD");
		
		/********************************************/
		
		// VARIABLES NO VISIBLES EN MENU
		
		/*************************************/
		
		int FuerzaObtenida = Integer.parseInt(miResultSet.getString("FUERZA"));
		int DestrezaObtenida = Integer.parseInt(miResultSet.getString("DESTREZA"));
		int ConstitucionObtenida = Integer.parseInt(miResultSet.getString("CONSTITUCION"));
		int IntelectoObtenida = Integer.parseInt(miResultSet.getString("INTELECTO"));
		int SabiduriaObtenida = Integer.parseInt(miResultSet.getString("SABIDURIA"));
		int CarismaObtenida = Integer.parseInt(miResultSet.getString("CARISMA"));
		String ConjurosObtenidos = miResultSet.getString("CONJUROS");
		
		
		/*
		
		PersonajeTemporalDelBucle.setNombre(NombreObtenido);
		System.out.println("El id obtenido es: " + NombreObtenido);
		
		PersonajeTemporalDelBucle.setRaza(miResultSet.getString("RAZA"));
		PersonajeTemporalDelBucle.setClase(miResultSet.getString("CLASE"));
		PersonajeTemporalDelBucle.setEspecializacion(miResultSet.getString("ESPECIALIZACION"));
		PersonajeTemporalDelBucle.setPropietario(miResultSet.getString("PROPIETARIO"));
		PersonajeTemporalDelBucle.setNivel(Integer.parseInt(miResultSet.getString("NIVEL")));
		PersonajeTemporalDelBucle.setCampaña(miResultSet.getString("CAMPAÑA"));
		PersonajeTemporalDelBucle.setVisibilidad(miResultSet.getString("VISIBILIDAD"));
		
		System.out.println("Variables de interfaz traspasadas.");
		

		PersonajeTemporalDelBucle.setFuerza(Integer.parseInt(miResultSet.getString("FUERZA")));
		PersonajeTemporalDelBucle.setDestreza(Integer.parseInt(miResultSet.getString("DESTREZA")));
		PersonajeTemporalDelBucle.setConstitucion(Integer.parseInt(miResultSet.getString("CONSTITUCION")));
		PersonajeTemporalDelBucle.setIntelecto(Integer.parseInt(miResultSet.getString("INTELECTO")));
		PersonajeTemporalDelBucle.setSabiduria(Integer.parseInt(miResultSet.getString("SABIDURIA")));
		PersonajeTemporalDelBucle.setCarisma(Integer.parseInt(miResultSet.getString("CARISMA")));
		
		PersonajeTemporalDelBucle.setConjuros(miResultSet.getString("CONJUROS"));
		
		*/
		
		// System.out.println("TODAS las variables importadas. El resultado es: ");
		// System.out.println(PersonajeTemporalDelBucle);
		
		Personaje TemporalDeEsteBucle = new Personaje(IdObtenida, NombreObtenido, RazaObenida, ClaseObtenida , EspecializacionObtenida, PropietarioObtenido,
				NivelObtenido, CampañaObtenida, VisibilidadObtenida, FuerzaObtenida, DestrezaObtenida, ConstitucionObtenida, IntelectoObtenida, SabiduriaObtenida,  CarismaObtenida, ConjurosObtenidos);
		PersonajesRegistrados.add(TemporalDeEsteBucle);


		
		}
		
		
		return PersonajesRegistrados;
	}
}
