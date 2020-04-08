<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: saith
  Date: 06.04.2020
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>

<table>
    <tr>
        <th>id</th>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    <c:forEach items="${usersFromDB}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>
                <form action="/update" method="get">
                    <button type="submit" name="id" value="${user.id}">Update</button>
                </form>
            </td>
            <td>
                <form action="/delete" method="post">
                    <button type="submit" name="id" value="${user.id}">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
