<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Películas</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
.thead {
	color: #fff;
	background-color: #2e5d94;
}

.btn {
	color: #fff;
	background-color: #2e5d94;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: lightblue">
		<a href="paginaPrincipal" class="text-dark" style="font-size: 25px;">Volver</a>

		<div class="container">
			<h1 class="text-center">Cine Güeno 2.0</h1>

		</div>
	</nav>
	<div>
		<div class="container">
			<h1 class="text-center">Películas</h1>
		</div>
		<div class="container">
			<table class="table text-center table-bordered">
				<thead class="thead">
					<tr>
						<th>Director</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="director" items="${directores}">

						<tr>
							<td><c:out value="${director.nombre}" /></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
			<a href="paginaPrincipal" class="btn btn-info">Volver a consultar</a>
			<a href="paginaPrincipal" class="btn btn-info">Inicio</a>
		</div>

	</div>
</body>
</html>