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

    <% long id = Long.parseLong(request.getParameter("id"));%>
    <tr>
        <form action="/update" method="post">
            <td><%= id%></td>
            <input required type="hidden" name="id" value="<%= id%>">
            <td><input required type="text" name="firstname" placeholder="new name"></td>
            <td><input required type="text" name="lastname" placeholder="new last name"></td>
            <td><button type="submit">Update</button></td>
        </form>
    </tr>

</table>
</body>
</html>
