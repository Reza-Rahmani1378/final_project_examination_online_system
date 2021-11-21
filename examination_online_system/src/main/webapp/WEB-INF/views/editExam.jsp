<%--
  Created by IntelliJ IDEA.
  User: ASUS CENTER QOM
  Date: 11/11/2021
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
          type="text/css"/>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.3.1/js/bootstrap.min.js"
            type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/assets/css/tableCss.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container text-center">


    <form action="/professor/confirmEditExam" method="post" style="max-width: 600px; margin: 0 auto;">
        <div class="m-3">
            <div class="form-group row">
                <label class="col-4 col-form-label">Title: </label>
                <div class="col-8">
                    <input class="form-control" type="text" name="description"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-4 col-form-label">Description: </label>
                <div class="col-8">
                    <input class="form-control" type="text" name="description"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-4 col-form-label">Time Of Exam(IN Minutes): </label>
                <div class="col-8">
                    <input class="form-control" required type="number" name="timeExam"/>
                </div>
            </div>


            <div>
                <input type="hidden" name="examId" value="${examId}">
                <button class="btn-dark" type="submit">Edit Exam</button>
            </div>
        </div>
    </form>

    <div class="container text-center" align="center">
        <h1>List Of Questions</h1>
        <br><br>
        <form action="listOfCourses">
            <label>
                <h1 style="display: inline">Filter:</h1>
                <input type="text" name="keyword" size="50" required>

            </label>

            <label>
                <input type="submit" class="btn-dark" value="Search">
            </label>

            <label>
                <input type="button" class="btn-dark" value="Clear" onclick="clearSearch()">
            </label>
            <label class="btn-dark btn btn-success"><a href="addQuestion?courseId=${courseId}&&examId=${examId}">Add
                Question</a></label>


        </form>
        <br><br>

        <div class="text-center">
            <table class="table text-center table-bordered table-striped">
                <thead class="thead-dark">
                <tr>
                    <th colspan="7" style="text-align: center">Available Questions</th>
                </tr>
                </thead>

                <tbody>
                <tr>

                    <td>ID</td>
                    <td>Title</td>
                    <td>Question Text</td>
                    <td>Type</td>
                    <td colspan="2">Selection</td>

                </tr>

                <c:forEach items="${questions}" var="exam" varStatus="loop">
                    <tr>
                        <td>${exam.id}</td>
                        <td>${exam.questionTitle}</td>
                        <td>${exam.questionText}</td>
                        <td>${exam.questionType.name()}</td>
                        <td><a href=addQuestionToExam?questionId=${exam.id}&&examId=${examId}>Add To Exam</a></td>
                        <td><a href=deleteExam?examId=${exam.id}>Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>

    </div>

</div>

</body>
</html>
