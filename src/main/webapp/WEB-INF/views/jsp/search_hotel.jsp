<%--
  Created by IntelliJ IDEA.
  User: notgo
  Date: 02.10.2020
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/search">
    <input name="country" type="text" placeholder="country">
    <input name="date_from" type="date" placeholder="date_from">
    <input name="date_to" type="date" placeholder="date_to">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit">

</form>

</body>
</html>
