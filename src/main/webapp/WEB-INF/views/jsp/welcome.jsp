<%--
  Created by IntelliJ IDEA.
  User: notgo
  Date: 30.09.2020
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>Welcome
	<form method="post" action="logout" id="form-logout">
		<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
		<div>
			<button type="submit">Logout</button>
		</div>
	</form>
</body>
</html>
