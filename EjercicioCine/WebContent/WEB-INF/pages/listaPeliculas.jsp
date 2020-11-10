<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Gestión de Nóminas</title>
<style>
#btnNuevo{
margin-bottom: 25px;
}
</style>
</head>
<body>
<div class="">
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: lightblue">
                <a href="/EjercicioCine/PeliculaServlet?action=inicioDefecto" class="text-dark" style="font-size: 25px;">Volver</a>
               
                    <div class="container">
                      <h1 class="text-center">Cine Gueno</h1>   
                      
                    </div>
                </nav>
            
 
            

                <div class="container ">
                    <h3 class="text-center">Lista de películas</h3>
                      
                    <hr>
                    <a id="btnNuevo" class="btn btn-primary float-right" href="/EjercicioCine/PeliculaServlet?action=nuevaPelicula">Nueva película</a>
                   
<table class="table table-bordered text-center">
                        <thead class="thead-dark">
                            <tr>
                                <th>Director</th>
                                <th>Título</th>
                                <th>Fecha</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
<c:forEach var="pelicula" items="${listaPeliculas}">

                                <tr>
                                    <td>
                                        <c:out value="${pelicula.director}" />
                                    </td>
                                    <td>
                                        <c:out value="${pelicula.titulo}" />
                                    </td>
                                    <td>
                                        <c:out value="${pelicula.fecha}" />
                                    </td>       
                                    <td><a href="/EjercicioCine/PeliculaServlet?action=editar&titulo=${pelicula.titulo}">Editar</a>  &nbsp;&nbsp;&nbsp;&nbsp; <a id="btnRemove"  href="/EjercicioCine/PeliculaServlet?action=eliminar&titulo=${pelicula.titulo}">Eliminar</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>

                    </table>
                    
                    </div>
                   </div>

</body>
</html>