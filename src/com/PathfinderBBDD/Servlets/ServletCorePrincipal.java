package com.PathfinderBBDD.Servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletCorePrincipal")
public class ServletCorePrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String elComando = request.getParameter("instruccion");
		
		System.out.println("elComando: " + elComando);

		if (elComando == null)
			elComando = "Login";
		
		try {
			switch(elComando) {
			case "Login":
				HaciaPantallaLogin(request,response);
			break;
			case "VerificarUsuario":
				
			break;
			default:
				HaciaPantallaLogin(request,response);
			break;
			}
		}catch (Exception e) {
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

}
