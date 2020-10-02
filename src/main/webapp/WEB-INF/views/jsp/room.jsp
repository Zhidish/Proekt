<%--
  Created by IntelliJ IDEA.
  User: notgo
  Date: 22.09.2020
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<c:forEach items="${room}" var="em">
    <li>${em.$price}</li>
    <li>${em.typeOfService}</li>
</c:forEach>


</body>
</html>
