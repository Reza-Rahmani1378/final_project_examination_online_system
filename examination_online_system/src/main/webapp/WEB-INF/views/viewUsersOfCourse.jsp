<%--
  Created by IntelliJ IDEA.
  User: ASUS CENTER QOM
  Date: 11/4/2021
  Time: 4:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>List Of Users</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
          type="text/css"/>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/js/bootstrap.min.js"
            type="text/javascript"></script>

    <style>
        @import url(http://fonts.googleapis.com/css?family=Ubuntu:400,700);

        body {
            background: #563c55 url(/assets/img/users-back.jpg) no-repeat center top;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            background-size: cover;
        }

        .container > header h1,
        .container > header h2 {
            color: #fff;
            text-shadow: 0 1px 1px rgba(0, 0, 0, 0.7);
        }

        td {
            background: #0c5460;
            font-size: large;
            color: lime;
        }
    </style>
</head>


<body>
<div class="container text-center" align="center">
    <h1>List Of Users</h1>
    <br><br>
    <form>
        <label>
            Filter:
            <input type="text" name="keyword" size="50" required>

        </label>

        <label>
            <input type="submit" class="btn-dark" value="Search">
        </label>

        <label>
            <input type="button" class="btn-dark" value="Clear" onclick="clearSearch()">
        </label>

    </form>
    <br><br>

    <div class="text-center">
        <table class="table text-center table-bordered table-striped">
            <thead class="thead-dark">
            <tr>
                <th colspan="9" align="center">${course.titleCourse}</th>
            </tr>
            </thead>

            <tbody>
            <tr>

                <td>First Name</td>
                <td>Last Name</td>
                <td>Username</td>
                <td>Email</td>
                <td>National Code</td>
                <td>User Type</td>
                <td>Is Confirmed</td>
                <td colspan="2">Selection</td>

            </tr>


            <tr>
                <td>${professor.firstName}</td>
                <td>${professor.lastName}</td>
                <td>${professor.username}</td>
                <td>${professor.email}</td>
                <td>${professor.nationalCode}</td>
                <td>${professor.userType}</td>
                <td>${professor.confirmed}</td>
                <td><a href="editUser?userId=${professor.id}">Delete</a></td>
                <td><a href="editUser?userId=${professor.id}">Edit</a></td>
            </tr>

            <c:forEach items="${students}" var="user">
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.nationalCode}</td>
                    <td>${user.userType}</td>
                    <td>${user.confirmed}</td>
                    <td><a href="editUser?userId=${user.id}">Delete</a></td>
                    <td><a href="editUser?userId=${user.id}">Edit</a></td>
                </tr>
            </c:forEach>


            </tbody>

        </table>
    </div>


</div>
<script type="text/javascript">
    function clearSearch() {
        window.location = "listOfUsers";
    }
</script>

</body>
</html>
