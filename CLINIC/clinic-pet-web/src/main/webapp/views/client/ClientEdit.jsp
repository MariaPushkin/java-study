<%--
  Created by IntelliJ IDEA.
  User: rtutm
  Date: 12.04.2018
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Client Edit</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/client/edit" method="POST">
    <p>Редактирование клиента:</p>
    <table>
        <tr>
            <td align="right" >Client name : </td>
            <td>
                ${client.getId()}
            </td>
        </tr>
        <tr>
            <td align="right" >Pet name : </td>
            <td>
                <input type="text" name="petname" value="${client.getPet().getName()}">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" align="center" value="Submit"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
