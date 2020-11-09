<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Cine</title>
</head>
<body>
<form method="post" action="/EjercicioCine/PeliculaServlet?action=inicio">
<label>Nombre: </label> <input type="text" name="nombre" required="required">
<label>Contraseña: </label> <input type="text" name="contrasena" required="required">
<input type="submit" value="Buscar" class="btn btn-success">
</form>
</body>
</html>