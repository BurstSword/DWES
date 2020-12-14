<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
	.thead{
		color: #fff;
		background-color:#73c7ae;
	}
	.btn{
		color: #fff;
		background-color:#73c7ae;
		border: 0px solid;
	}
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
                <div class="container">
                <h1 class="text-center">Administradores</h1>
                </div>
                <div class="container card col-md-5 justify-content-center">
                <f:form action="insertarAdmin" modelAttribute="admin" method="POST">
			
			<f:hidden path="id" />
			
			<div class="form-group">
				<label>Nombre</label>
				<f:input path="nombre" class="form-control" required="required"></f:input>
			</div>
			<div class="form-group">
				<label>Contraseña</label>
				<f:input path="pass" class="form-control" required="required"></f:input>
			</div>
			

			<input class="btn btn-success mb-3 mt-3" type="submit" value="Guardar">

		</f:form>
                </div>

</body>
</html>