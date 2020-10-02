<%--
  Created by IntelliJ IDEA.
  User: notgo
  Date: 02.10.2020
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form method="post" action="${pageContext.request.contextPath}/Manager/add_hotel">


    <input name="country" type="text" placeholder="country">
    <input name="city" type="text" placeholder="city">
    <input name="area" type="text" placeholder="area">
    <input name="email" type="email" placeholder="email">
    <input name="phone_number" type="text" placeholder="phone_number">
    <input name="name" type="text" placeholder="name">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit">

</form>

</body>
</html>
