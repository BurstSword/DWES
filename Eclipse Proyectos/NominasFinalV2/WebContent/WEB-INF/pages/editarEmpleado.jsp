<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Gestión de Nóminas</title>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>

<body>

	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: lightblue">
		<a href="/NominasFinalV2/EmpleadoServlet?action=lista"
			class="text-dark" style="font-size: 25px;">Volver</a>

		<div class="container">
			<h1 class="text-center">Gestión de nóminas</h1>
		</div>
	</nav>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<h2>Editar empleado</h2>

				<form method="post"
					action="/NominasFinalV2/EmpleadoServlet?action=modificar">

					<fieldset class="form-group">
						<label>Nombre</label> <input type="text"
							value="<c:out value='${empleado.nombre}' />" class="form-control"
							name="nombre" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>DNI</label> <input readonly type="text"
							value="<c:out value='${empleado.dni}' />" class="form-control"
							name="dni" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Sexo</label> <input pattern="[HM]{1}" type="text"
							value="<c:out value='${empleado.sexo}' />" class="form-control"
							name="sexo" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Años</label> <input pattern="[0-9]{1-2}" type="text"
							value="<c:out value='${empleado.categoria}' />" name="categoria"
							class="form-control">
					</fieldset>

					<fieldset class="form-group">
						<label>Categoría</label> <input pattern="^(?:[1-9]|0[1-9]|10)$" type="text"
							value="<c:out value='${empleado.anyos}' />" name="anyos"
							class="form-control">
					</fieldset>
					<fieldset class="form-group">
						<label>Salario</label> <input readonly type="text"
							value="<c:out value='${nomina.sueldo}' />" name="sueldo"
							class="form-control">
					</fieldset>
					<input type="submit" value="Guardar" class="btn btn-success">
				</form>
			</div>
		</div>
	</div>
	
</body>

</html>