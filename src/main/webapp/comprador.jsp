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
        <link rel="stylesheet" href="./Costumer.css">

    </head>

<body style="background: #513B67    ">
<header style="background: black" ><h1 style="color: #0097A7"><%= "Costumer : " + request.getParameter("username") %></h1></header>

<h1>Pictures avaibles</h1>
<div id="images"  ></div>

<script>

    var imagesDiv = document.getElementById("images");

    // Making a fetch call to the servlet
    fetch("list-files")
        .then(response => response.json())
        .then(images => {
            images.map(image => {
                // Creating the image element in DOM
                let imgElem = document.createElement("img");
                imgElem.src = "./" + image;
                imgElem.width = 200;

                // Attaching element to DIV
                imagesDiv.appendChild(imgElem);
            });
        });
</script>

<h1>your count have <%=  request.getAttribute("fcoins") %> Fcoins</h1>
<a href="./recargar.html" style="background: #65FF33" style="color: #FFFFFF" > Loaded your count</a>
    </body>
</html>