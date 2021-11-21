<%--
  Created by IntelliJ IDEA.
  User: ASUS CENTER QOM
  Date: 11/3/2021
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Registration Page</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
          type="text/css"/>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/js/bootstrap.min.js"
            type="text/javascript"></script>
</head>
<body>

<h2>User Registration:</h2>

<div class="container text-center">
    <div>
        <h1>User Registration - Sign Up</h1>
    </div>

    <%--    <c:url var="registerUser" value="${registerUser}"></c:url>--%>
    <form action="/registerUser" method="post" style="max-width: 600px; margin: 0 auto;">
        <div class="m-3">
            <div class="form-group row">
                <label class="col-4 col-form-label">First Name: </label>
                <div class="col-8">
                    <input class="form-control" type="text" name="firstName"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-4 col-form-label">Last Name: </label>
                <div class="col-8">
                    <input class="form-control" type="text" name="lastName"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-4 col-form-label">Password: </label>
                <div class="col-8">
                    <input class="form-control" required type="password" name="password"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-4 col-form-label">E-mail: </label>
                <div class="col-8">
                    <input class="form-control"
                           required type="text" name="email"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-4 col-form-label">Username: </label>
                <div class="col-8">
                    <input class="form-control"
                           required type="text" name="username"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-4 col-form-label">National Code: </label>
                <div class="col-8">
                    <input class="form-control"
                           required type="text" name="nationalCode"/>
                </div>
            </div>

            <div>
                <select name="userType">
                    <option value="STUDENT">Student</option>
                    <option value="PROFESSOR">Professor</option>
                </select>
            </div>

            <div>
                <button class="btn-dark" type="submit">Sign Up</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
