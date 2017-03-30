<%--
  Created by IntelliJ IDEA.
  User: Gamer
  Date: 30/03/2017
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="../resources/CSS/main.css" />" />
</head>
<body>
<form:form method="post" modelAttribute="groupes" action="${pageContext.request.contextPath}/addGroupes">
    <table>
        <tr>
            <th colspan="2">Add Groupe</th>
        </tr>
        <tr>
            <form:hidden path="id" />
            <td><form:label path="groupeName">Groupe Name:</form:label></td>
            <td><form:input path="groupeName" size="30" maxlength="30"></form:input></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit"
                                   class="blue-button" /></td>
        </tr>
    </table>
</form:form>
</br>
<h3>Groupe List</h3>
<c:if test="${!empty listOfGroupes}">
    <table class="tg">
        <tr>
            <th width="80">Id</th>
            <th width="120">groupe Name</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listOfGroupes}" var="groupes">
            <tr>
                <td>${groupes.id}</td>
                <td>${groupes.groupeName}</td>
                <td><a href="<c:url value='/updateGroupes/${groupes.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/deleteGroupes/${groupes.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
