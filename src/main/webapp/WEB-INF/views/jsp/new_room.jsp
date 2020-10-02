<%--
  Created by IntelliJ IDEA.
  User: notgo
  Date: 22.09.2020
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <form id="logoutForm" method="POST" action="${contextPath}/new_room">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

    <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
    </h2>

</c:if>

</div>



<form method="post" action="${pageContext.request.contextPath}/new_room">
    <input name="typeOfService" type="text" placeholder="typeOfService">
    <input name="price" type="number" placehplder="Money">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit">

</form>

</body>
</html>
