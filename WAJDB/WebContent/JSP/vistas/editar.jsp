<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar Artículo</title>
</head>
<body>
<h1>Actualizar Artículo</h1>
	<form action="adminArticulo?action=editar" method="post" >
		<table>
			<tr>
				<td><label>Id</label></td>
				<td><input type="text" name="id" value="<c:out value="${articulo.id}"></c:out>" ></td>
			</tr>
			<tr>
				<td><label>Código</label></td>
				<td><input type="text" name="codigo" value='<c:out value="${articulo.codigo}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Nombre</label></td>
				<td><input type="text" name="nombre" value='<c:out value="${articulo.nombre}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Descripción</label></td>
				<td><input type="text" name="descripcion" value='<c:out value="${articulo.descripcion}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Existencia</label></td>
				<td><input type="text" name="existencia" value='<c:out value="${articulo.existencia }"></c:out>' ></td>
			</tr>
			
			<tr>
				<td><label>Precio</label></td>
				<td><input type="text" name="precio" value='<c:out value="${articulo.precio }"></c:out>' ></td>
			</tr>
		</table>
	
		<input type="submit" name="registrar" value="Guardar"> 
	</form>
</head>
</body>
</html>