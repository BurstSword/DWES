<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                <a href="/NominasFinalV2/EmpleadoServlet?action=menu" class="text-dark" style="font-size: 25px;">Volver</a>
               
                    <div class="container">
                      <h1 class="text-center">Gestión de nominas</h1>   
                      
                    </div>
                </nav>
            
 
            

                <div class="container ">
                    <h3 class="text-center">Lista de empleados</h3>
                      
                    <hr>
                    <a id="btnNuevo" class="btn btn-primary" href="/NominasFinalV2/EmpleadoServlet?action=nuevoEmpleado">Nuevo empleado</a>
                   
<table class="table table-bordered text-center">
                        <thead class="thead-dark">
                            <tr>
                                <th>Nombre</th>
                                <th>DNI</th>
                                <th>Sexo</th>
                                <th>Categoría</th>
                                <th>Años</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
<c:forEach var="empleado" items="${listaEmpleado}">

                                <tr>
                                    <td>
                                        <c:out value="${empleado.nombre}" />
                                    </td>
                                    <td>
                                        <c:out value="${empleado.dni}" />
                                    </td>
                                    <td>
                                        <c:out value="${empleado.sexo}" />
                                    </td>
                                    <td>
                                        <c:out value="${empleado.anyos}" />
                                    </td>
                                     <td>
                                        <c:out value="${empleado.categoria}" />
                                    </td>
                                    <td><a href="/NominasFinalV2/EmpleadoServlet?action=editar&dni=${empleado.dni}">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; <a id="btnRemove"  href="/NominasFinalV2/EmpleadoServlet?action=eliminar&dni=${empleado.dni}">Eliminar</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>

                    </table>
                    
                    </div>
                   </div>
                   
                   <jsp:include page="/WEB-INF/pages/popup.jsp"></jsp:include>
                  
                   <script>
                   
                   $('#btnRemove').on('click', function(e) {
                	      var $form = $(this).closest('form');
                	      e.preventDefault();
                	      $('#confirm').modal({
                	          backdrop: 'static',
                	          keyboard: false
                	      })
                	      .on('click', '#delete', function(e) {
                	          $form.trigger('submit');
                	        });
                	      $("#cancel").on('click',function(e){
                	       e.preventDefault();
                	       $('#confirm').modal.model('hide');
                	      });
                	    });
                   
                   </script>
                 
       <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>            
</body>
</html>