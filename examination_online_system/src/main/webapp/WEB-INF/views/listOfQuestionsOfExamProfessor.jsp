<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: ASUS CENTER QOM
  Date: 11/4/2021
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
    <h1>List Of Questions Of Exam With Id ${examId}</h1>
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
                <th colspan="9" align="center">Available Questions</th>
            </tr>
            </thead>

            <tbody>
            <tr>

                <td>ID</td>
                <td>Title</td>
                <td>Question Text</td>
                <td>Type</td>
                <td>Score</td>
                <td colspan="3">Selection</td>

            </tr>

            <c:forEach items="${questions}" var="exam">
                <tr>
                    <td>${exam.id}</td>
                    <td>${exam.questionTitle}</td>
                    <td>${exam.questionText}</td>
                    <td>${exam.questionType.name()}</td>
                    <form action="${pageContext.request.contextPath}/question-rest/change-score" method="post">
                        <td>
                            <input name="grade" type="number" value="${exam.questionScores.get(0)}"
                                   min="0">
                        </td>
                        <td>
                            <input type="hidden" name="questionId" value="${exam.id}">
                            <input type="hidden" name="examId" value="${examId}">
                            <input type="submit" value="Record the Score">
                        </td>
                    </form>
                    <td><a href=editQuestion?questionId=${exam.id}&&examId=${examId}>Edit</a></td>
                    <td><a href=deleteQuestionOfExam?examId=${exam.id}>Delete</a></td>
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

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/js/changeQuestionScore.js"></script>

</body>
</html>
