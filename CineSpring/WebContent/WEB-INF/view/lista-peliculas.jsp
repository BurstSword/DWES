<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion del cine</title>
</head>
<body>
	<div class="container bg-dark text-light pt-4 col-12">
		<h2>Gestion de Peliculas</h2>
	</div>

	<div class="container">
	<div class=" d-flex justify-content-between">
	<a href="formulario" class="btn btn-success btn-lg mt-5 mb-3">Insertar</a>
	<a href="paginaPrincipal" class="btn btn-secondary btn-lg mt-5 mb-3">Volver</a>
	</div>
		<table class="table table-striped table-dark overflow-auto">
			<thead class="thead-light text-dark modal-body">
				<tr class="lead text-center">
					<th>Director</th>
					<th>Titulo</th>
					<th>Fecha</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pelicula" items="${peliculas}">

					<c:url var="actualizar" value="actualizar">
						<c:param name="tituloPelicula" value="${pelicula.titulo}"></c:param>
					</c:url>

					<c:url var="eliminar" value="eliminar">
						<c:param name="tituloPelicula" value="${pelicula.titulo}"></c:param>
					</c:url>

					<tr class="lead text-center">
						<td>${pelicula.director}</td>
						<td>${pelicula.titulo}</td>
						<td>${pelicula.fecha}</td>
						<td><a href="${actualizar}" class="btn btn-warning">Actualizar</a></td>
						<td><a href="${eliminar}" class="btn btn-danger" onclick="if (!(confirm('¿Seguro que quieres eliminar  ${pelicula.nombre}?'))) return false">Eliminar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>