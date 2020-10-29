<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="/NominasFinalV2/WebContent/WEB-INF/pages/error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Gestión de Nóminas</title>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<style>
#wrapper {
  width: 100%;
  height: 400px;
  transform: translateY(132%);
  display: flex;
   margin-left: -205px;
  align-items: center;
  justify-content: flex-end;
}

button {
  height: 50px;
  width: 240px;
   border-radius: 16px;
   font-size:24px;
   background-color: #01ffff;
   border-color:#01ffff;
   text-align:center;
   color:#5d5fb2;
  }
body {
  background-image: url("DesktopHD.png");
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: 100% 100%;
 
}
h1{
justify-content:flex end;
transform: translateY(-900%);
font-size:52px;
color:#6061b1;
}
</style>



</head>
<body>



<div id="wrapper">
<h1>CONSULTA TUS NÓMINAS</h1>
  <a href="/NominasFinalV2/EmpleadoServlet?action=lista"><button type="button">Acceder</button></a>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>
</html>