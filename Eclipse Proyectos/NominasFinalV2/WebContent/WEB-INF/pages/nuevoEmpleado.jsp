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
                            <label>DNI</label> <input type="text" class="form-control" name="dni" pattern="[0-9]{8}[A-Za-z]{1}" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Sexo</label> <input type="text" class="form-control" name="sexo" pattern="[HM]{1}"  required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Años</label> <input pattern="[0-9]{1-2}" class="form-control" name="categoria">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Categoría</label> <input pattern="^(?:[1-9]|0[1-9]|10)$" class="form-control" name="anyos">
                        </fieldset>


                        <input type="submit" value="Guardar" class="btn btn-success">
                        </form>

                        
                        

                    </div>
                </div>
            </div>
            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
        </body>

        </html>