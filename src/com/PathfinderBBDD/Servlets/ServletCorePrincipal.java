package com.PathfinderBBDD.Servlets;



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

	@Resource(name = "a")
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


		String elComando = request.getParameter("Instruccion");

		System.out.println("elComando: " + elComando);

		if (elComando == null)
			elComando = "Login";

		try {
			switch (elComando) {

			case "Login":
				System.out.println("Vamos a sumar 3 y 4");
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
		// En estos procesos conectamos con la base de datos para validar el Usuario y contraseña introducidos
		// Si el usuario es valido, se devuelve el nombre en la variable "UsuarioDevuelto".
		//Si no es valido UsuarioDevuelto valdra "null"
		String UsuarioDevuelto;
		String UsuarioIntroducido = request.getParameter("UsuarioIntroducidoLogin");
		System.out.println("El usuario introducido es: " + UsuarioIntroducido);
		String ContrasenaIntroducida = request.getParameter("ContraIntroducidaLogin");
		System.out.println("La contraseña introducida es: " + ContrasenaIntroducida);
		UsuarioDevuelto = GestorUsuarios.VerificarUsuario(UsuarioIntroducido, ContrasenaIntroducida);
		System.out.print("El usuario que te devuelvo es:" + UsuarioDevuelto);
		if (UsuarioDevuelto != null) {
			
			//Esto solo ocurre cuando el usuario es correcto. Se enviara el Usuario a "ServletGestorDatos"
			
			System.out.println("Usuario correcto, bienvenido");
			
			request.setAttribute("USUARIOCONECTADO", UsuarioDevuelto);
			RequestDispatcher miDispatcher = request.getRequestDispatcher("ServletGestorDatos");
			miDispatcher.forward(request, response);
			
			
		} else {
			System.out.println("Usuario NOOOOOO autorizado");

		}
	
	}

}
