<%--
  Created by IntelliJ IDEA.
  User: eddie
  Date: 16/07/2019
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录系统</title>
</head>
<body>
<form action="login" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username" /></td>

        </tr>

        <tr>
            <td>密码:</td>>
            <td><input type="password" name="password" /></td>
        </tr>


        <tr>
            <td><input type="submit" vaule="登陆"></td>
        </tr>
    </table>
</form>
</body>
</html>
