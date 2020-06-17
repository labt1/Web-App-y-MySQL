<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Articulo</title>
</head>
<body>
	<h1>Registrar Artículo</h1>
	<form action="/WAJDB/MyServlet?action=register" method="post">
		<table border="1" align="center">
		<tr>
			<td><a> Código:</a></td>		
			<td><input type="text" name="codigo"/></td>	
		</tr>
		<tr>
			<td><a> Nombre:</a></td>		
			<td><input type="text" name="nombre"/></td>	
		</tr>
		<tr>
			<td><a> Descripción:</a></td>		
			<td><input type="text" name="descripcion"/></td>	
		</tr>
		<tr>
			<td><a> Cantidad:</a></td>		
			<td><input type="text" name="cantidad"/></td>	
		</tr>
		<tr>
			<td><a> Precio:</a></td>		
			<td><input type="text" name="precio"/></td>	
		</tr>		
		
	</table>
	<br>
	<table border="0" align="center">
		<tr>
		<td><input type="submit" value="Agregar" name="agregar"></td>	
		</tr>
	</table>
	</form>
</body>
</html>