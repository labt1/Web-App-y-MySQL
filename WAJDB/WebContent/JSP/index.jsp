<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%--Esto es una directiva para utilizar la clase Date --%>
	<%@ page import="java.util.Date"  %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web App Java y Base de Datos</title>
</head>
<body>
	<h1>Administrar Artículos</h1>
	<table border="1" width="50%" align="center">
		<tr>
			<td align="center"><a href="/WAJDB/MyServlet?action=nuevo">Nuevo</a></td>
		</tr>
		
		<tr>
			<td align="center"><a href="/WAJDB/MyServlet?action=mostrar">Mostrar</a></td>
		</tr>
	</table>
</body>
</html>

