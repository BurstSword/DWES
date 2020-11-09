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
<nav class="navbar navbar-expand-md navbar-dark" style="background-color: lightblue">
                <a href="/EjercicioCine/PeliculaServlet?action=inicioDefecto" class="text-dark" style="font-size: 25px;">Volver</a>
               
                    <div class="container">
                      <h1 class="text-center">Cine</h1>   
                      
                    </div>
                </nav>

<form method="post" action="/EjercicioCine/PeliculaServlet?action=consultarPorDirector">
<label>Director: </label> <input class="mt-3" type="text" name="director" required="required">
<input type="submit" value="Buscar" class="btn btn-success">
</form>
</body>
</html>