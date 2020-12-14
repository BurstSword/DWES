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
		background-color:#2e5d94;
	}
	.btn{
		color: #fff;
		background-color:#2e5d94;
		border: 0px solid;
	}
</style>
<title>Peliculas</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark">
                <a href="paginaPrincipal"><img src="./back.png"></a>
                </nav>
                <div class="container">
                <h1 class="text-center">Peliculas</h1>
                </div>
                <div class="container card col-md-5 justify-content-center">
                <f:form action="guardarPelicula" method="POST">
			
			<f:hidden path="id" />
			
			<div class="form-group">
				<label>Titulo:</label>
				<f:input path="titulo" class="form-control" required="required"></f:input>
			</div>
			<div class="form-group">
				<label>Director:</label>
				<f:input path="director" class="form-control" required="required"></f:input>
			</div>
			<div class="form-group">
				<label>Fecha:</label>
				<f:input path="fecha" class="form-control" required="required"></f:input>
			</div>

			<input class="btn btn-success" type="submit" value="Guardar pelicula">

		</f:form>
                </div>

</body>
</html>