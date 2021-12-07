<%--
  Created by IntelliJ IDEA.
  User: ASUS CENTER QOM
  Date: 11/26/2021
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page isELIgnored="false" %>

<html xmlns:th="http://www.thymeleaf.org" lang="">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/questionAnswer.css">
    <title>Answer Of Students</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <span class="navbar-brand">Online Exam</span>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/professor/professorWorkBench">Back To The
                        WorkBench</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div>
    <c:choose>
    <c:when test="${question == null}">
        <p>No Answers Found</p>
    </c:when>
    <c:otherwise>
    <div class="ticketInformation">
        <table class="table">
            <thead>
            <div>
                <c:choose>
                    <c:when test="${question.questionType.name().equals('OPTIONAL')}">
                        <div>
                            <th>
                                Question
                            </th>
                            <th style="text-align: left;"><span>
                                    ${question.questionText}</span>
                            </th>
                            <th>
                                Correct Answer:
                            </th>
                            <th style="text-align: left;"><span>
                                    ${question.questionAnswer}</span>
                            </th>
                            <th>Selection</th>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div>
                            <th>
                                Question :
                            </th>
                            <th style="text-align: left;"><span>
                                    ${question.questionText}</span>
                            </th>
                            <th>
                                Correct Answer:
                            </th>
                            <th style="text-align: left;"><span>
                                    ${question.questionAnswer}</span>
                            </th>
                            <th>Selection</th>
                        </div>

                    </c:otherwise>

                </c:choose>
            </div>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Answer</th>
                <th>Point</th>
                <th>Submit</th>
            </tr>
            </thead>
            <tbody>
            <div>
                <c:choose>
                    <c:when test="${question.questionType.name().equals('OPTIONAL')}">
                        <div>
                            <c:forEach items="${question.studentResultExams}" var="studentResult">
                                <tr>
                                    <td>${studentResult.student.firstName}</td>
                                    <td>${studentResult.student.lastName}</td>
                                    <td>${studentResult.studentAnswer}</td>
                                    <td>${studentResult.studentPoint}</td>
                                    <td>-</td>
                                </tr>
                            </c:forEach>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${question.studentResultExams}" var="studentResult">
                            <tr>
                                <td>${studentResult.student.firstName}</td>
                                <td>${studentResult.student.lastName}</td>
                                <td>${studentResult.studentAnswer}</td>
                                <form action="${pageContext.request.contextPath}/studentResult/changeScore"
                                      method="post">
                                    <td>
                                        <input name="grade" type="number" value="${studentResult.studentPoint}"
                                               max="${question.questionScores.get(0)}" min="0">
                                    </td>
                                    <td>
                                        <input type="hidden" name="studentResultExamId" value="${studentResult.id}">
                                        <input type="submit" value="Record the Score">
                                    </td>
                                </form>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
            </tbody>
        </table>
        </c:otherwise>
        </c:choose>

    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/assets/js/questionAnswer.js"></script>
</body>
</html>