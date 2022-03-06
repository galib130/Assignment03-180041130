<%--
  Created by IntelliJ IDEA.
  User: galib
  Date: 3/3/22
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<%
    ArrayList<String> cartlist=new ArrayList<>();
    ArrayList<Integer> priceList=new ArrayList<>();
    ArrayList<String> imageList=new ArrayList<>();
    ArrayList<Integer> countList=new ArrayList<>();



    if(session.getAttribute("cartList")!=null){
 cartlist= (ArrayList<String>) session.getAttribute("cartList");
 priceList= (ArrayList<Integer>) session.getAttribute("priceList");
imageList= (ArrayList<String>) session.getAttribute("imageList");
countList= (ArrayList<Integer>) session.getAttribute("countList");

}

int length=cartlist.size();
System.out.println(length+ "length");
pageContext.setAttribute("length",length);
%>
<c:if test="${length>0}">
<c:forEach var="object" begin="0" end="${length-1}">
    
    <h1>Name:${cartList[object]}</h1>

    <h1>Price:$${priceList[object]}</h1>

    <img src="${imageList[object]}">
    <form action="deleteServlet">
        <button type="submit" name="Delete" value="${object}">Delete</button>
    </form>

    <form action="updateServlet">
        <button type="submit" name="Add" value="${object}">Add</button>${countList[object]}<button type="submit" name="Subtract" value="${object}">Subtract</button>
    </form>
</c:forEach>
</c:if>
<c:if test="${length==0}">
    <c:out value="Cart is empty"></c:out>
</c:if>
</body>
</html>
