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
<form action="logger">
<label>Nombre: </label> <input type="text" name="nombre" required="required">
<label>Contraseña: </label> <input type="text" name="pass" required="required">
<input type="submit" value="Buscar" class="btn btn-success">
</form>

</body>
</html>