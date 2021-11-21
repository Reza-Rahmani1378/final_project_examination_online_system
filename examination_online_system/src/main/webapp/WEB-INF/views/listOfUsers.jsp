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
    <link href="${pageContext.request.contextPath}/assets/css/tableCss.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="logedUser" value="${logedUser}"/>
</jsp:include>
<div class="container text-center">
    <h1>List Of Users</h1>
    <br><br>
    <form action="listOfUsers">
        <label>
            <h1 style="display: block">Filter:</h1>
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

    <div>
        <table class=" text-center table-bordered">
            <thead class=thead-dark>
            <tr>
                <th colspan="9">Available Users</th>
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
                <td colspan="4">Selection</td>

            </tr>

            <c:forEach items="${listOfUsers}" var="user">
                <tr>
                    <c:if test="${user.confirmed==false}">
                        <div class="dis">
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.username}</td>
                            <td>${user.email}</td>
                            <td>${user.nationalCode}</td>
                            <td>${user.userType}</td>
                            <td>${user.confirmed}</td>
                            <td class="btn btn-dark"><a href="editUser?userId=${user.id}">Delete</a></td>
                            <td class="btn btn-dark"><a href="editUser?userId=${user.id}">Edit</a></td>
                            <td class="btn btn-dark"><a href="addUser?userId=${user.id}">Add To Course</a></td>
                        </div>

                    </c:if>
                    <c:if test="${user.confirmed==true}">
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.nationalCode}</td>
                        <td>${user.userType}</td>
                        <td>${user.confirmed}</td>
                        <td class="btn btn-dark"><a href="editUser?userId=${user.id}">Delete</a></td>
                        <td class="btn btn-dark"><a href="editUser?userId=${user.id}">Edit</a></td>
                        <td class="btn btn-dark"><a href="addUser?userId=${user.id}">Add To Course</a></td>
                    </c:if>

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
