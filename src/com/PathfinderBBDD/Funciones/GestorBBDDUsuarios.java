package com.PathfinderBBDD.Funciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.sql.DataSource;

public abstract class GestorBBDDUsuarios {

	@Resource(name = "BasesDeDatos/InfoConexion")
	private DataSource ConfiguracionConexion;
	

	public GestorBBDDUsuarios(DataSource ConfiguracionConexion) {
		this.ConfiguracionConexion = ConfiguracionConexion;
	}
	
	public Boolean VerificarUsuario(String UsuarioIntroducido, String ContraIntroducida) {
		Boolean UsuarioCorrecto = false;
		try{
			Connection miConexion = ConfiguracionConexion.getConnection();
			
			String Comando = "SELECT * FROM USUARIOS WHERE USUARIO = ? AND CONTRASENA = ?";
			PreparedStatement miStatement = miConexion.prepareStatement(Comando);
			miStatement.setString(1, UsuarioIntroducido);
			miStatement.setString(2, ContraIntroducida);
			
			ResultSet Resultado = miStatement.executeQuery();
			
			System.out.println("Resultado: " + Resultado);
			
			if(Resultado.next()){
				UsuarioCorrecto = true;
				
			}else{
				
				UsuarioCorrecto = false;
			}
		}catch (Exception e) {

			System.out.println("Error al verificar Usuario " + e.getMessage());
			}
		return UsuarioCorrecto;
	}
}
