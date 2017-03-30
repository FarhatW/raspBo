<%--
  Created by IntelliJ IDEA.
  User: Gamer
  Date: 30/03/2017
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="../resources/CSS/main.css" />" />

</head>
<body>
<form:form method="post" modelAttribute="classRoom" action="${pageContext.request.contextPath}/addClassRoom">
    <table>
        <tr>
            <th colspan="2">Add Class Room</th>
        </tr>

        <tr>
            <form:hidden path="id" />
            <td><form:label path="name">nom de la classe:</form:label></td>
            <td><form:input path="name" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="addMac">Adresse Mac:</form:label></td>
            <td><form:input path="addMac" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>

            <td><form:label path="site_id">Site</form:label></td>
            <td>
                <select name="site_id">
                <c:if test="${!empty listOfSites}">
                    <c:forEach items="${listOfSites}" var="site">
                        <option value="${site.id}">${site.name}</option>
                    </c:forEach>
                </c:if>
                </select>
            </td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" class="blue-button" /></td>
        </tr>
    </table>
</form:form>
</br>
<h3>class room List</h3>
<c:if test="${!empty listOfClassRoom}">
    <table class="tg">
        <tr>
            <th width="80">Id</th>
            <th width="120">Nom de la classe</th>
            <th width="120">Site</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listOfClassRoom}" var="classRoom">
            <tr>
                <td>${classRoom.id}</td>
                <td>${classRoom.name}</td>
                <td>${classRoom.site_id.name}</td>
                <td><a href="<c:url value='/updateClassRoom/${calssRoom.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/deleteClassRoom/${calssRoom.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
