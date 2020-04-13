<%@ page import="model.User" %>
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
        <th>Login</th>
        <th>Password</th>
        <th>Role</th>
    </tr>
    <% User user = (User) request.getAttribute("user");%>
    <tr>
        <td><%= user.getId()%>
        </td>
        <td><%= user.getFirstName()%>
        </td>
        <td><%= user.getLastName()%>
        </td>
        <td><%= user.getLogin()%>
        </td>
        <td><%= user.getPassword()%>
        </td>
        <td><%= user.getRole()%>
        </td>
    </tr>
</table>
</body>
</html>
