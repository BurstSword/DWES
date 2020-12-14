<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cine</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div class="">
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: lightblue">


			<div class="container">
				<h1 class="text-center">Cine Güeno 2.0</h1>
				<c:if test="${!logged}">
					<a href="login" class="btn btn-info">Login</a>
				</c:if>
				<c:if test="${logged}">
					<a href="logout" class="btn btn-info">Logout</a>
				</c:if>
				
			</div>
			<a href="info" class="text-dark" style="font-size: 25px;">Info</a>
		</nav>

		<div class="container card col-md-5 justify-content-center mt-2">
			<form action="lista" method="GET">
				<div class="container">
					<br>
					<h3>Director</h3>
					<input type="text" placeholder="Introduce el nombre del director"
						name="director" class="form-control" required="required" /> <br>
					<input type="submit" class="btn btn-warning" value="Buscar" /> <br>
					<br>
				</div>
			</form>
			<div></div>
			


		</div>
		<c:if test="${logged}">
				<a class="btn btn-warning mt-3"
					href="nuevoAdmin">Nuevo
					admin</a>
				<a class="btn btn-warning mt-3"
					href="listarPeliculasAdmin">GestionarPeliculas</a>
			</c:if>
	</div>
</body>
</html>