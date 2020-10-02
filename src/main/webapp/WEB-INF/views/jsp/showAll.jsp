<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: notgo
  Date: 02.10.2020
  Time: 7:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr>
        <th>User name</th>
    </tr>

    <c:forEach items="${users}" var="reservation">

        <td><c:out value="${reservation.username}"/></td>



        <c:forEach items="${reservation.booking}" var="book">


            <tr>
                <td>
                    date_to
                    <c:out value="${book.date_to}"/>
                </td>
            </tr>
            <tr>
                <td>
                    date_from
                    <c:out value="${book.date_from}"/>
                </td>
            </tr>
            <tr>
                <td>
                   id_room
                    <c:out value="${book.room_id}" />

                </td>
            </tr>

        </c:forEach>

       <%-- <c:forEach items="${reservation.rooms}" var="room">
            <td><c:out value="${room.floor}"/></td>
        </c:forEach>--%>
        <%--<c:forEach items="${reservation.rooms}" var="room">
        <c:forEach items="${room.hotel}" var = "hotel">

        </c:forEach>


        </c:forEach>--%>
        <%--    <td><c:out
                    value="${reservation.checkInDate.getDay()}/${reservation.checkInDate.getMonth()}
                /${reservation.checkInDate.getYear()}" /></td>
            <td><c:out
                    value="${reservation.checkOutDate.getDay()}/${reservation.checkOutDate.getMonth()}
                /${reservation.checkOutDate.getYear()}" /></td>
--%>

    </c:forEach>
</table>

</body>
</html>
