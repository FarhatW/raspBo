<%--
  Created by IntelliJ IDEA.
  user: Gamer
  Date: 08/01/2017
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="<c:url value="../resources/CSS/main.css" />" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello</title>
</head>
<body>
<%--<sec:authorize access="hasRole('admin')">--%>
<!-- For login user -->
<c:url value="/j_spring_security_logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>
        user : ${pageContext.request.userPrincipal.name} | <a
            href="javascript:formSubmit()"> Logout</a>
    </h2>
</c:if>

<form:form method="post" modelAttribute="user" action="${pageContext.request.contextPath}/addUser">
    <table>
        <tr>
            <th colspan="2">Add user</th>
        </tr>
        <tr>
            <form:hidden path="id" />
            <td><form:label path="first_name">Prénom :</form:label></td>
            <td><form:input path="first_name" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="last_name">Nom :</form:label></td>
            <td><form:input path="last_name" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="email">Email :</form:label></td>
            <td><form:input path="email" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="phone">Email :</form:label></td>
            <td><form:input path="phone" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="password">Mot de passe :</form:label></td>
            <td><form:input path="password" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
        <tr>
            <td><form:label path="groupe_id">Groupes</form:label></td>
            <td>
                <select name="groupe_id">
                    <c:if test="${!empty listOfGroupes}">
                        <c:forEach items="${listOfGroupes}" var="groupe">
                            <option value="${groupe.id}">${groupe.groupeName}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </td>
        </tr>
        <tr>
            <td><form:label path="company_id">Entreprise</form:label></td>
            <td>
                <select name="company_id">
                    <c:if test="${!empty listOfCompany}">
                        <c:forEach items="${listOfCompany}" var="company">
                            <option value="${company.id}">${company.name}</option>
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
<h3>class user List</h3>
<c:if test="${!empty listOfUsers}">
    <table class="tg">
        <tr>
            <th width="80">Id</th>
            <th width="120">user name</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listOfUsers}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.first_name}</td>
                <td><a href="<c:url value='/updateUser/${user.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/deleteUser/${user.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<%--</sec:authorize>--%>

</body>
</html>