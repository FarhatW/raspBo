<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value="../resources/CSS/main.css" />" />
    <link rel="stylesheet" href="<c:url value="../resources/CSS/bootstrap.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="../resources/CSS/simple-sidebar.css" />"/>
    <title>Groupes</title>
</head>
<body>
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
                    <div class="col-xs-12 menu">
                        <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">=</a>
                    </div>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <h2>
                            user : ${pageContext.request.userPrincipal.name} | <a
                                href="javascript:formSubmit()"> Logout</a>
                        </h2>
                    </c:if>
                    <div class="col-xs-12 firstblock">
                        <h3>Ajouter une nouvelle promotion :</h3>
                        <form:form method="post" modelAttribute="groupes" action="${pageContext.request.contextPath}/addGroupes">
                            <div class="col-xs-4 col-xs-offset-1 indentblock">
                                <div class="form-group">
                                    <form:hidden path="id" />
                                    <form:label path="groupeName">Nom du groupe:</form:label>
                                    <form:input path="groupeName" size="30" maxlength="30" class="form-control" placeholder="Nom du groupe"></form:input>
                                </div>

                                <button type="submit" class="btn btn-default pull-right btnstyle">Valider</button>
                            </div>
                        </form:form>
                    </div>
                    <div class="col-xs-12 secondblock">
                        <h3>Afficher les promotions :</h3>
                        <c:if test="${!empty listOfGroupes}">
                        <div class="col-xs-10 col-xs-offset-1">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th width="80">Id</th>
                                    <th width="120">groupe Name</th>
                                    <th width="60">Edit</th>
                                    <th width="60">Delete</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listOfGroupes}" var="groupes">
                                    <tr>
                                        <td>${groupes.id}</td>
                                        <td>${groupes.groupeName}</td>
                                        <td><a href="<c:url value='/updateGroupes/${groupes.id}' />" ><img src="../resources/images/edit.png"></a></td>
                                        <td><a href="<c:url value='/deleteGroupes/${groupes.id}' />" ><img src="../resources/images/delete.png"></a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            </c:if></div>
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
