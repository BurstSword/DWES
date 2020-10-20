<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

</body>
</html>