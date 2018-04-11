<%--
  Created by IntelliJ IDEA.
  User: rtutm
  Date: 26.12.2017
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Pet Clinic</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/client/add" method="POST">
    <p>Добавить клиента:</p>
    <table>
        <tr>
            <td align="right" >Client name : </td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td align="right" >Pet name : </td>
            <td>
                <input type="text" name="petname">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" align="center" value="Submit"/>
            </td>
        </tr>
    </table>
</form>
<a href="${pageContext.servletContext.contextPath}/views/client/ClientAdd.jsp">Добавить клиента</a>
<p>Список клиентов с животными:</p><br>
<table border="1">
    <c:forEach items="${clients}" var="client" varStatus="status">
        <tr valign="top">
            <td>${client.getId()}</td>
            <td>${client.getPet().getName()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
