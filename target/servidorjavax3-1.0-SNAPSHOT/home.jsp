<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello!, " + request.getParameter("username") %>
</h1>
<h2> <%= "your role is " +  request.getParameter("rol")  %>   </h2>

<br/>
<a href="./index.html">log</a>
</body>
</html>