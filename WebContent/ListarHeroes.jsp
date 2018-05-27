<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	HAS LLEGADO A ""LISTAR.JSP"

	<%
	String Mensaje = (String) request.getAttribute("MensajeDePrueba");
%>

	<div>${MensajeDePrueba}</div>
	<div>Esto es la lista entera: ${LISTAPERSONAJES}</div>
	<div>My name is ${MensajeDePrueba}</div>

	
	<div>------------------------------------------------------</div>
	
	
	
	<div>Esto es solo un Personaje ${LISTAPERSONAJES[0]}</div>


<div>------------------------------------------------------</div>


	
	
	
	<div>Esto es el nombre de un personaje ${LISTAPERSONAJES[0].getNombre()}</div>
	
		<div>------------------------------------------------------</div>

	<div>El tamaño recibido es de:  ${TamanoLista}</div>

<var></var>



<c:forEach var="Personaje" items="${LISTAPERSONAJES}">
<div>Cuantos bucles se hacen</div>
</c:forEach>

<%
int Longitud = (int) request.getAttribute("TamanoLista"); %>


<% for (int i = 0; i < Longitud; i++) { %>
<div>Bucleeeeeeeeee   ${LISTAPERSONAJES[0].getNombre()}     </div>

<%} %>



	<table>
		<tr>
			<th>Nombre</th>
			<th>Raza</th>
			<th>Clase</th>
			<th>Especializacion</th>
			<th>Propietario</th>
			<th>Nivel</th>
			<th>campaña</th>
		</tr>

<div>Ahora otro bucle final</div>
		<c:forEach var="Personaje" items="${LISTAPERSONAJES}">

			<!--

		<c:url var="linkVisualizarPersonaje" value="ServerGestorDatos">
				<c:param name="Instruccion" value="VisualizarPersonaje"></c:param>
				<c:param name="CArticulo" value="${Personaje.Nombre}"></c:param>
			</c:url>
			-->
			
			
			<tr>

				<td>${Personaje.getNombre()}</td>

			</tr>
			
		
			<!--
		
		
			<c:url var="linkTemp" value="ControladorProductos">
				<c:param name="instruccion" value="cargar"></c:param>
				<c:param name="CArticulo" value="${prod.cArt}"></c:param>
			</c:url>

			<c:url var="linkTempEliminar" value="ControladorProductos">
				<c:param name="instruccion" value="eliminar"></c:param>
				<c:param name="CArticulo" value="${prod.cArt}"></c:param>
			</c:url>
					
			<tr>
			
				<td>${prod.cArt}</td>
				<td>${prod.seccion}</td>
				<td>${prod.nArt}</td>
				<td>${prod.fecha}</td>
				<td>${prod.precio}</td>
				<td>${prod.importado}</td>
				<td>${prod.pOrig}</td>
				
		<td><a href="${linkTemp}">Actualizar</a>&nbsp;<a href="${linkTempEliminar}">Eliminar</a></td>
							
			</tr>
			 -->
		</c:forEach>
	</table>


	Se acabo la tabla
	<br>






</body>
</html>