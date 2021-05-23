<%--
  Created by IntelliJ IDEA.
  User: Timofei
  Date: 01.05.2021
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>invalid login</title>
</head>
<body>
<h1>access denied: invalid credentials</h1>
<a href="${pageContext.request.contextPath}/login.jsp">try again</a>
<a href="${pageContext.request.contextPath}/register.jsp">register</a>
</body>
</html>
