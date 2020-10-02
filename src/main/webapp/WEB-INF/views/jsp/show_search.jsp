<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: notgo
  Date: 02.10.2020
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:forEach items="${set}" var="reservation">


    <c:forEach items="${reservation.rooms}" var="rooms">

        Room
        <c:out value="${reservation.id}"/>

        </td>

        <c:if test="${rooms.id_room==reservation.room_id}">
            <tr>
                <td>floor<br/>
                    <c:out value="${rooms.floor}"/>
                </td>
            </tr>
            <tr>
                <td>

                    Number<br/>
                    <c:out value="${rooms.room_number}"/>
                </td>
            </tr>

            <tr>
                <td>
                    Hotel<br/>
                    <c:out value="${rooms.hotel_room.name}"/>
                </td>
            </tr>
        </c:if>

    </c:forEach>
    </tr>


</c:forEach>


<form method="post" action="${pageContext.request.contextPath}/add_booking">


    <input name="date_from" type="hidden" value="${date_from}">
    <input name="date_to" type="hidden" value="${date_to}">
    <input name="room_id" type="number" placeholder="room_id">
    <input name="user_name" type="text" placeholder="user_name">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit">


</form>
</body>
</html>
