<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
</style>
<title>Peliculas</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: lightblue">
		<a href="paginaPrincipal" class="text-dark" style="font-size: 25px;">Volver</a>

		<div class="container">
			<h1 class="text-center">Cine Güeno 2.0</h1>

		</div>
	</nav>
	<div class="container card col-md-5 justify-content-center mt-3">
<form action="logger">
<div class="form-group">
<label>Nombre: </label> <input type="text" class="form-control" name="nombre" required="required">
</div>
<div class="form-group">
<label>Contraseña: </label> <input type="text" class="form-control" name="pass" required="required">
</div>
<input type="submit" value="Buscar" class="btn btn-success">
</form>
</div>
</body>
</html>