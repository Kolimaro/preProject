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
        <th>First Name</th>
        <th>Last Name</th>
        <th>Login</th>
        <th>Password</th>
        <th>Role</th>
    </tr>

    <tr>
        <form action="/admin/add" method="post">
            <td><input required type="text" name="firstname" placeholder="name"></td>
            <td><input required type="text" name="lastname" placeholder="last name"></td>
            <td><input required type="text" name="login" placeholder="login"></td>
            <td><input required type="text" name="password" placeholder="password"></td>
            <td><input required type="text" name="role" placeholder="role"></td>
            <td>
                <button type="submit">Add user</button>
            </td>
        </form>
    </tr>

</table>
</body>
</html>
