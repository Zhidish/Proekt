<%--
  Created by IntelliJ IDEA.
  User: notgo
  Date: 02.10.2020
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/Manager/add_room">


    <input name="room_number" type="number" placeholder="room_number">
    <input name="type_room" type="number" placeholder="type_room">
    <input name="id_hotel" type="number" placeholder="room and his hotel">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <input type="submit">

</form>


</body>
</html>
