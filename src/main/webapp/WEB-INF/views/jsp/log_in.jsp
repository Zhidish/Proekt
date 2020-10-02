<%--
  Created by IntelliJ IDEA.
  User: notgo
  Date: 29.09.2020
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<div>
    <form action="login" method="post">
        <fieldset>
            <legend>Please Login</legend>



            <label for="username">Username</label> <input type="text"
                                                          id="username" name="username"/> <br>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/> <br>
            <div>
                <button type="submit">Log in</button>
            </div>
        </fieldset>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
</body>
</html>
