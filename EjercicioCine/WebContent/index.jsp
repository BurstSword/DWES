<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cine</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="">
<nav class="navbar navbar-expand-md navbar-dark" style="background-color: lightblue">
                
               
                    <div class="container">
                      <h1 class="text-center">Cine Gueno</h1>   
                      
                    </div>
                    <a href="/EjercicioCine/PeliculaServlet?action=info" class="text-dark" style="font-size: 25px;">Info</a>
                </nav>

<a class="btn btn-warning mt-3" href="/EjercicioCine/PeliculaServlet?action=formDirector">Consultar por director</a>
<c:if test="${!logeado}">
<a class="btn btn-warning mt-3" href="/EjercicioCine/PeliculaServlet?action=login">Login</a>
</c:if>
<c:if test="${logeado}">
<a class="btn btn-warning mt-3" href="/EjercicioCine/PeliculaServlet?action=nuevoAdmin">Nuevo admin</a>
<a class="btn btn-warning mt-3" href="/EjercicioCine/PeliculaServlet?action=gestionPeliculas">GestionarPeliculas</a>
</c:if>





</div>
</body>
</html>