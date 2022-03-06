<%--
  Created by IntelliJ IDEA.
  User: galib
  Date: 3/2/22
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<h1>Welcome to our shop</h1>
<form action="LoginServlet" method="post">
    Username:<input type="text" name="username"><br>
    Password:<input type="password"name="password"><br>
    <input type="submit" value="login">


</form>
</body>

</html>
