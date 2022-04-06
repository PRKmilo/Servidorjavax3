<%--
  Created by IntelliJ IDEA.
  User: jafev
  Date: 4/4/2022
  Time: 20:47
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
<header style="background: black" ><h1 style="color: #0097A7"><%= "Artist : " + request.getParameter("username") %></h1></header>
<form  action="./uploadFile" method="post" enctype="multipart/form-data">
    Name: <input type="text" name="name"/>
    Choose a file: <input type="file" name="multiPartServlet"/>
    <input type="submit" value="Upload"/>
</form>
</body>
</html>
