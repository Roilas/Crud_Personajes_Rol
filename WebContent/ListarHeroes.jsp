<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	
	<div>Esto es el nombre de un personaje ${LISTAPERSONAJES[0].getNombre()}</div>
	<div>El tamaño recibido es de:  ${TamanoLista}</div>


<c:forEach var="prod" items="${LISTAPERSONAJES}">
	${prod.getNombre()}<br>
</c:forEach>

</body>
</html>