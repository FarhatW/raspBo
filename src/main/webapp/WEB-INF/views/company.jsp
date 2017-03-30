<%--
  Created by IntelliJ IDEA.
  User: Gamer
  Date: 30/03/2017
  Time: 16:44
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
<form:form method="post" modelAttribute="company" action="${pageContext.request.contextPath}/addCompany">
    <table>
        <tr>
            <th colspan="2">Add Country</th>
        </tr>
        <tr>
            <form:hidden path="id" />
            <td><form:label path="name">Country Name:</form:label></td>
            <td><form:input path="name" size="30" maxlength="30"></form:input></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit"
                                   class="blue-button" /></td>
        </tr>
    </table>
</form:form>
</br>
<h3>Country List</h3>
<c:if test="${!empty listOfCompany}">
    <table class="tg">
        <tr>
            <th width="80">Id</th>
            <th width="120">Country Name</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listOfCompany}" var="company">
            <tr>
                <td>${company.id}</td>
                <td>${company.name}</td>
                <td><a href="<c:url value='/updateCompany/${company.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/deleteCompany/${company.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
