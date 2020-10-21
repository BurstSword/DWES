<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Gestión de Nóminas</title>
            <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        </head>

        <body>

            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: lightblue">
                <a href="/NominasFinalV2/EmpleadoServlet?action=lista" class="text-dark" style="font-size: 25px;">Volver</a>
               
                    <div class="container">
                      <h1 class="text-center">Gestión de nominas</h1>   
                    </div>
                </nav>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <h2>Nuevo empleado</h2>

                        <form method="post" action="/NominasFinalV2/EmpleadoServlet?action=insertar">

                        <fieldset class="form-group">
                            <label>Nombre</label> <input type="text" class="form-control" name="nombre"   required="required">
                        </fieldset>

						<fieldset class="form-group">
                            <label>DNI</label> <input type="text" class="form-control" name="dni" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Sexo</label> <input type="text" class="form-control" name="sexo"  required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Categoría</label> <input class="form-control" name="categoria">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Años</label> <input class="form-control" name="anyos">
                        </fieldset>

                        <input type="submit" value="Guardar" class="btn btn-success">
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>