<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>successful login</title>
</head>
<body>
<h1>welcome ${username}</h1>
<p>role: ${role}</p>
<p>current date: <%= LocalDate.now() %>
</p>
</body>
</html>
