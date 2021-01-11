<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
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
	
	<div class="container pt-5 f-flex">
		<h3>Formulario</h3>
		<f:form class="pt-3 col-2" action="guardarEmpleado"
			modelAttribute="empleado" method="POST">
			
			<f:hidden path="id" />
			<f:hidden path="nomina.dni"/>
			
			<div class="form-group d-flex flex-column">
				<label>Nombre:</label>
				<f:input path="nombre"></f:input>
			</div>
			<div class="form-group d-flex flex-column">
				<label>Dni:</label>
				<f:input path="dni"></f:input>
			</div>
			<div class="form-group d-flex flex-column">
				<label>Sexo:</label>
				<f:input path="sexo"></f:input>
			</div>
			<div class="form-group d-flex flex-column">
				<label>Categoria:</label>
				<f:input path="categoria"></f:input>
			</div>
			<div class="form-group d-flex flex-column">
				<label>Antiguedad:</label>
				<f:input path="antiguedad"></f:input>
			</div>

			<input class="btn btn-success" type="submit" value="Guardar empleado">

		</f:form>
	</div>
	<a class="btn btn-secondary ml-5" href="lista">Volver</a>
	
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