package com.PathfinderBBDD.Servlets;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.PathfinderBBDD.ClasesBasicas.Personaje;
import com.PathfinderBBDD.Funciones.GestorBBDDPersonajes;


import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;




@WebServlet("/ServletGestorDatos")
public class ServletGestorDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	@Resource(name = "a")
	private DataSource ConfiguracionConexion;

	// "ModeloProductos" Sera la clase encargada de gestionar la base de datos.
	// Creada a parte.
	private GestorBBDDPersonajes GestorPersonajes;

	@Override
	public void init() throws ServletException {
		// super.init();
		System.out.println("Comenzando");
		// MANERA 2 DE PASAR MI POOL
		// Aqui lo hacemos mediante try catch para recoger el error si no lo logra
		try {
			GestorPersonajes = new GestorBBDDPersonajes(ConfiguracionConexion);
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

	}
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String UsuarioConectado = (String)request.getAttribute("USUARIOCONECTADO");
		System.out.println("¡Bienvenido al SERVLET GESTOR DATOS " + UsuarioConectado);
		
		String elComando = request.getParameter("Instruccion");
		
		System.out.println("elComando: " + elComando);
		
		if (elComando == null)
			elComando = "Listar";
		
		try {
			switch (elComando) {
			case "Listar":
				ListarPersonajesRegistrados (request, response);
			break;
			
			default:
				ListarPersonajesRegistrados (request, response);
			break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void ListarPersonajesRegistrados (HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		List<Personaje> PersonajesRegistrados = GestorPersonajes.ObtenPersonajesRegistrados();
		
		System.out.println("La lista devuelta es: ");
		System.out.println(PersonajesRegistrados);
		System.out.println("El tamaño de la lista es: " + PersonajesRegistrados.size());
		request.setAttribute("LISTAPERSONAJES", PersonajesRegistrados);
		request.setAttribute("TamanoLista", PersonajesRegistrados.size());
		
		request.setAttribute("MensajeDePrueba", "EstoEsElMensajeDePrueba");
		request.setAttribute("excepcion", null);
		RequestDispatcher miDispatcher = request.getRequestDispatcher("/ListarHeroes.jsp");

		miDispatcher.forward(request, response);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
