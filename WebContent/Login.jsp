<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center">Login</h1>
<form action="ServletCorePrincipal" method="post">
<input type="hidden" name="Instruccion" value="VerificarUsuario"/>
  <table width="25%">
    
    <tr>
      <td><label for="usuario">Usuario: </label></td>
      <td><input type="text" name="Usuario" id="Usuario"></td>
    </tr>
    <tr>
      <td><label for="contra">Contraseña: </label></td>
      <td><input type="text" name="Contra" id="Contra"></td>
    </tr>
    
    <tr>
      <td colspan="2" align="center"><input type="submit" name="button" id="button" value="Enviar" style="width: 73px; "></td>
    </tr>
  </table>
  <p><br>
  </p>
</form>
</body>
</html>