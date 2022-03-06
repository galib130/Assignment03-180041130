<%--
  Created by IntelliJ IDEA.
  User: galib
  Date: 3/3/22
  Time: 1:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/TEST" user="user" password="2467810Ag*"/>
<sql:query var="result" dataSource="${snapshot}">
    SELECT * FROM ITEMS;
</sql:query>

<c:forEach var="row" items="${result.rows}">
    <c:out value="${row.id}"/> <br>
    <c:out value="${row.NAME}"/><br>
    <c:out value="${row.PRICE}"/><br>
    <img src="${row.IMAGE}"><br>
    <br>

    <form action="addServlet"  method="get">
        <button type="submit" name=cart value="${row.id}"  >Add to cart!</button>]
    </form>
    <br>


</c:forEach>

</body>
</html>
