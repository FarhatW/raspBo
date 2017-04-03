<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value="../resources/CSS/main.css" />" />
    <link rel="stylesheet" href="<c:url value="../resources/CSS/bootstrap.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="../resources/CSS/simple-sidebar.css" />"/>
    <title>Bienvenue</title>
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
<div id="wrapper">
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
                <a href="#">
                    Menu
                </a>
            </li>
            <li>
                <a href="/welcome">Utilisateurs</a>
            </li>
            <li>
                <a href="/classRoom">Gestion des classes</a>
            </li>
            <li>
                <a href="/presence">Presence du jour</a>
            </li>
        </ul>
    </div>
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <div class="col-xs-12">
                        <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">=</a>
                    </div>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <h2>
                            user : ${pageContext.request.userPrincipal.name} | <a
                                href="javascript:formSubmit()"> Logout</a>
                        </h2>
                    </c:if>
                    <div class="col-xs-12 blockbtn">
                        <button class="btn btn-primary pull-right"><a href="/groupes"><p>Ajouter une nouvelle promotion</p></a></button>
                        <button class="btn btn-primary pull-right"><a href="/company"><p>Ajouter une nouvelle entreprise</p></a></button>
                    </div>
                    <div class="col-xs-12 firstblock">
                        <h3>Ajouter un nouvel utilisateur :</h3>
                        <form:form method="post" modelAttribute="user" action="${pageContext.request.contextPath}/addUser">
                            <div class="col-xs-4 col-xs-offset-1 indentblock">
                                <div class="form-group">
                                    <form:hidden path="id" />
                                    <form:label path="first_name">Prénom :</form:label>
                                    <form:input path="first_name" maxlength="30" class="form-control" placeholder="Votre prenom"></form:input>
                                </div>
                                <div class="form-group">
                                    <form:label path="last_name">Nom :</form:label>
                                    <form:input path="last_name" size="30" maxlength="30" class="form-control" placeholder="Votre nom"></form:input>
                                </div>
                                <div class="form-group">
                                    <form:label path="email">Email :</form:label>
                                    <form:input path="email" size="30" maxlength="30" class="form-control" placeholder="Votre email"></form:input>
                                </div>
                                <div class="form-group">
                                    <form:label path="phone">Telephone :</form:label>
                                    <form:input path="phone" size="30" maxlength="30" class="form-control" placeholder="Votre numero de telephone"></form:input>
                                </div>
                            </div>
                            <div class="col-xs-4 col-xs-offset-1">
                                <div class="form-group">
                                    <label for="password">Mot de passe :</label>
                                    <input path="password" size="30" maxlength="30" class="form-control" placeholder="Votre mot de passe" id="password">
                                </div>
                                <div class="form-group">
                                    <label for="groupe_id">Groupes</label>
                                    <select name="groupe_id" id="groupe_id" class="form-control">
                                        <c:if test="${!empty listOfGroupes}">
                                            <c:forEach items="${listOfGroupes}" var="groupe">
                                                <option value="${groupe.id}">${groupe.groupeName}</option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                                <label for="company_id">Entreprise</label>
                                <select name="company_id" id="company_id" class="form-control">
                                    <c:if test="${!empty listOfCompany}">
                                        <c:forEach items="${listOfCompany}" var="company">
                                            <option value="${company.id}">${company.name}</option>
                                        </c:forEach>
                                    </c:if>
                                </select>

                                <button type="submit" class="btn btn-default pull-right btnstyle">Envoyer</button>
                            </div>
                        </form:form>
                    </div>
                    <div class="col-xs-12 secondblock">
                        <h3>Afficher les utilisateurs : </h3>
                        <c:if test="${!empty listOfUsers}">
                            <div class="col-xs-10 col-xs-offset-1">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th width="80">Id</th>
                                        <th width="120">Nom</th>
                                        <th width="60">Editer</th>
                                        <th width="60">Supprimer</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${listOfUsers}" var="user">
                                        <tr>
                                            <td>${user.id}</td>
                                            <td>${user.first_name}</td>
                                            <td><a href="<c:url value='/updateUser/${user.id}' />" ><img src="../resources/images/edit.png"></a></td>
                                            <td><a href="<c:url value='/deleteUser/${user.id}' />" ><img src="../resources/images/delete.png"></a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../resources/js/jquery-3.1.1.min.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>

</body>
</html>