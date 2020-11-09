<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Cine</title>
</head>
<body>
<div class="">
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: lightblue">
                <a href="/EjercicioCine/PeliculaServlet?action=inicio" class="text-dark" style="font-size: 25px;">Volver</a>
               
                    <div class="container">
                      <h1 class="text-center">Cine Gueno</h1>   
                      
                    </div>
                </nav>
            
 
            

                <div class="container ">
                    <h3 class="text-center">Lista de peliculas</h3>
                      
                    <hr>
                   
<table class="table table-bordered text-center">
                        <thead class="thead-dark">
                            <tr>
                                <th>Nombre</th>
                                <th>Fecha</th>
                                
                            </tr>
                        </thead>
                        <tbody>
<c:forEach var="pelicula" items="${listaPeliculas}">

                                <tr>
                                    <td>
                                        <c:out value="${pelicula.titulo}" />
                                    </td>
                                    <td>
                                        <c:out value="${pelicula.fecha}" />
                                    </td>
                                    
                   
                                </tr>
                            </c:forEach>
                            </tbody>

                    </table>
                    
                    </div>
                   </div>
                   <a href="/EjercicioCine/PeliculaServlet?action=formDirector" class="text-dark" style="font-size: 25px;">Volver a consultar</a>
</body>
</html>