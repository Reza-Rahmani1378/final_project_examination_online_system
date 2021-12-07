<%--
  Created by IntelliJ IDEA.
  User: ASUS CENTER QOM
  Date: 11/23/2021
  Time: 4:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>
        Exams
    </title>

</head>
<body>
<div class="container">
    <div class="row">
        <c:forEach items="${allowExamForStudent}" var="exam">
            <div class="col-sm-4">
                <div class="card border-primary mb-3" style="max-width: 25rem;">
                    <img class="card-img-top" src="${pageContext.request.contextPath}${exam.examImageUrl}"
                         alt="Card image" width="100%" height="200">

                    <div class="card-body">
                        <h4 class="card-title"><c:out value="${exam.title}"/></h4>
                        <p class="card-text"><c:out value="${exam.description}"/></p>
                        <form action="/student/startExam" method=post>
                            <div class="form-group">
                                <input type="hidden" class="form-control" name="examId"
                                       value="${exam.id}">
                            </div>
                            <div class="form-group">
                                <input type="hidden" class="form-control" name="page" value="1">
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block">Start Quiz</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
