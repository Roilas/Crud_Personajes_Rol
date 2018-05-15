package com.PathfinderBBDD.Servlets;

import com.PathfinderBBDD.Funciones.Calculadora;


import com.PathfinderBBDD.Funciones.GestorBBDDUsuarios;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/ServletCorePrincipal")
public class ServletCorePrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "ConfiguracionConexionBBDD")
	private DataSource ConfiguracionConexion;

	// "ModeloProductos" Sera la clase encargada de gestionar la base de datos.
	// Creada a parte.
	private GestorBBDDUsuarios GestorUsuarios;

	@Override
	public void init() throws ServletException {
		// super.init();
		System.out.println("Comenzando");
		// MANERA 2 DE PASAR MI POOL
		// Aqui lo hacemos mediante try catch para recoger el error si no lo logra
		try {
			GestorUsuarios = new GestorBBDDUsuarios(ConfiguracionConexion);
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Calculadora MiCalculadora = new Calculadora();

		String elComando = request.getParameter("Instruccion");

		System.out.println("elComando: " + elComando);

		if (elComando == null)
			elComando = "Login";

		try {
			switch (elComando) {

			case "Login":
				System.out.println("Vamos a sumar 3 y 4");
				int Resultado = MiCalculadora.Suma(3, 4);
				System.out.println(Resultado);
				HaciaPantallaLogin(request, response);
				break;
			case "VerificarUsuario":
				System.out.println("Devuelto de login, ejecutando metodo en principal");
				VerificarUsuarioEnBBDD(request, response);

				break;
			default:
				HaciaPantallaLogin(request, response);
				break;
			}
		} catch (Exception e) {
			System.out.println("EXCEPCIÓN al introducir comando: " + e.getMessage());

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	private void HaciaPantallaLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Instruccion LOGEARUSUARIO");
		RequestDispatcher miDispatcher = request.getRequestDispatcher("/Login.jsp");
		miDispatcher.forward(request, response);
	}

	private void VerificarUsuarioEnBBDD(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String UsuarioIntroducido = request.getParameter("UsuarioIntroducidoLogin");
		System.out.println("El usuario introducido es: " + UsuarioIntroducido);
		String ContrasenaIntroducida = request.getParameter("ContraIntroducidaLogin");
		System.out.println("La contraseña introducida es: " + ContrasenaIntroducida);
		if (GestorUsuarios.VerificarUsuario(UsuarioIntroducido, ContrasenaIntroducida)) {
			System.out.println("Usuario correcto, bienvenido");
		} else {
			System.out.println("Usuario NOOOOOO autorizado");

		}
	}

}
