<%--
  Created by IntelliJ IDEA.
  User: notgo
  Date: 26.09.2020
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/registry">


    <input name="username" type="text" placeholder="" >
    <input name="password" type="password">
    <input type="submit">


</form>

</body>
</html>
