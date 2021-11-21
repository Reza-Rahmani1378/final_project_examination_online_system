<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: ASUS CENTER QOM
  Date: 11/4/2021
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>

<head>
    <title>List Of Courses</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
          type="text/css"/>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/js/bootstrap.min.js"
            type="text/javascript"></script>


    <style>
        @import url(http://fonts.googleapis.com/css?family=Ubuntu:400,700);

        body {
            background: #563c55 url(/assets/img/online-courses.jpg) no-repeat center top;
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
    <h1>List Of Course</h1>
    <br><br>
    <form action="listOfCourses">
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
                <th colspan="5" align="center">Available Courses</th>
            </tr>
            </thead>

            <tbody>
            <tr>

                <td>Id Of Course</td>
                <td>Title Of Course</td>
                <td>Start Of Course</td>
                <td>End Of Course</td>
                <td>Selection</td>

            </tr>

            <c:forEach items="${courses}" var="course">
                <tr>
                    <td>${course.id}</td>
                    <td>${course.titleCourse}</td>
                    <td>${course.startCourse}</td>
                    <td>${course.endCourse}</td>
                    <td><a href=viewExamsOfCourse?courseId=${course.id}>View Exams Course</a></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>


</div>
<script type="text/javascript">
    function clearSearch() {
        window.location = "listOfCourses";
    }
</script>

</body>
</html>
