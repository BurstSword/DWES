<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion de empleados</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>
	<div class="container bg-dark text-light pt-4 col-12">
		<h2>Gestion de empleados</h2>
	</div>

	<div class="container">
	<div class=" d-flex justify-content-between">
	<a href="formulario" class="btn btn-success btn-lg mt-5 mb-3">Insertar</a>
	<a href="paginaPrincipal" class="btn btn-secondary btn-lg mt-5 mb-3">Volver</a>
	</div>
		<table class="table table-striped table-dark overflow-auto">
			<thead class="thead-light text-dark modal-body">
				<tr class="lead text-center">
					<th>Nombre</th>
					<th>Dni</th>
					<th>Sexo</th>
					<th>Categoria</th>
					<th>Antiguedad</th>
					<th>Actualizar</th>
					<th>Eliminar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="empleado" items="${empleados}">

					<c:url var="actualizar" value="actualizar">
						<c:param name="empleadoId" value="${empleado.id}"></c:param>
					</c:url>

					<c:url var="eliminar" value="eliminar">
						<c:param name="empleadoId" value="${empleado.id}"></c:param>
					</c:url>

					<tr class="lead text-center">
						<td>${empleado.nombre}</td>
						<td>${empleado.dni}</td>
						<td>${empleado.sexo}</td>
						<td>${empleado.categoria}</td>
						<td>${empleado.antiguedad}</td>
						<td><a href="${actualizar}" class="btn btn-warning">Actualizar</a></td>
						<td><a href="${eliminar}" class="btn btn-danger" onclick="if (!(confirm('¿Seguro que quieres eliminar a ${empleado.nombre}?'))) return false">Eliminar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>