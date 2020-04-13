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
        <th>Login</th>
        <th>Password</th>
    </tr>

    <tr>
        <form action="/login" method="post">
            <td><input required type="text" name="login" placeholder="login"></td>
            <td><input required type="text" name="password" placeholder="password"></td>
            <td>
                <button type="submit">Sign in</button>
            </td>
        </form>
    </tr>

</table>
</body>
</html>
