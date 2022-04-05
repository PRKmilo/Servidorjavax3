<%--
  Created by IntelliJ IDEA.
  User: jafev
  Date: 4/4/2022
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>comprador</title>
    <!--incluir CSS-->

    <head>

        <!--incluir CSS-->


    </head>

<body>
<header style="background: black" ><h1 style="color: #0097A7"><%= "Costumer : " + request.getParameter("username") %></h1></header>

<div class="Galeria">
    <div class="foto">
        <img src="img/bote.jpg" alt="">
    </div>


    <div class="pie">

    </div>

</div>
<div class="Galeria">
    <div class="foto">
        <img src="img/demonios.jpg" alt="">
    </div>

    <div class="pie">

    </div>


</div>
<div class="Galeria">
    <div class="foto">
        <img src="img/puente.jpg" alt="">
    </div>
    <div class="pie">


    </div>


</div>
<div class = "Galeria">
    <div class="foto">
        <img src="img/musica.jpg" alt="">
    </div>
    <div class="pie">

    </div>


    </div>

    </body>
</html>