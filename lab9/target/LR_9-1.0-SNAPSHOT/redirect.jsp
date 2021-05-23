<%--
  Created by IntelliJ IDEA.
  User: Timofei
  Date: 03.05.2021
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="multipleRedirect" method="get">
    <input type="submit" value="go">
</form>
<form action="multipleRedirect" method="post">
    <input type="text" name="url" value="redirect-to">
    <input type="submit" value="go">
</form>
</body>
</html>
