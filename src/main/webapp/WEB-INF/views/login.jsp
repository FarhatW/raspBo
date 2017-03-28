<%--
  Created by IntelliJ IDEA.
  User: Gamer
  Date: 11/01/2017
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <title>Login</title>
        <!-- Material Design fonts -->
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Roboto:300,400,500,700">
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/icon?family=Material+Icons">

        <link rel="stylesheet" href="<c:url value="../resources/CSS/main.css" />" />
        <link rel="stylesheet" href="<c:url value="../resources/js/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.min.css" />" />
        <link rel="stylesheet" href="<c:url value="../resources/js/bootstrap-material-design-master/dist/css/bootstrap-material-design.min.css" />" />
        <link rel="stylesheet" href="<c:url value="../resources/js/bootstrap-material-design-master/dist/css/ripples.min.css" />" />


        <script src="<c:url value="../resources/js/jquery-3.1.1.min.js" />" ></script>
        <script src="<c:url value="../resources/js/tether-1.3.3/dist/js/tether.min.js" />" ></script>


        <script src="<c:url value="../resources/js/bootstrap-material-design-master/dist/js/material.min.js" />" ></script>
        <script src="<c:url value="../resources/js/bootstrap-material-design-master/dist/js/ripples.js" />" ></script>
    <script>
        $.material.init();
    </script>
        <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">--%>
        <%--<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>--%>
        <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>--%>
        <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>--%>


    </head>
    <body>
    <div class="background-main">

    </div>
    <c:if test="${not empty error}">
        <div class="alert alert-warning">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="alert alert-info">${msg}</div>
    </c:if>

    <div class="form-login">
        <div class=" container col-lg-3 col-md-5 col-sm-5 col-xs-12">

            <form name='loginForm'
                  action="<c:url value='/j_spring_security_check' />" method='POST'>
                <fieldset>

                    <div class="form-group">
                        <%--<label for="inputEmail" class="col-md-2 control-label">Email</label>--%>

                        <div class="col-md-8" style="max-width: none">
                            <input type="email" class="form-control" id="email"
                                   placeholder="<spring:message code='label.email'/>" name='email'>
                        </div>
                    </div>
                    <div class="form-group">
                        <%--<label for="inputPassword" class="col-md-2 control-label">Password</label>--%>

                        <div class="col-md-8" style="max-width: none">
                            <input type="password" class="form-control" name='password' id="password"
                                   placeholder="<spring:message code='label.password'/>">
                        </div>
                    </div>
                    <div class="form-group" style="text-align: center">
                        <button type="submit" id="submit" class="btn btn-raised"><spring:message
                                code='btn.connect'/></button>
                    </div>
                    <div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
    </body>
</html>
