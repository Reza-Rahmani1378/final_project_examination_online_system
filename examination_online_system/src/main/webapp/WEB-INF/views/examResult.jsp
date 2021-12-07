<%--
  Created by IntelliJ IDEA.
  User: ASUS CENTER QOM
  Date: 11/26/2021
  Time: 8:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/examResult.css">
    <title>Exam Result</title>
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
                        Workbench</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div id="examResult" class="displayNone">
    <c:forEach items="${questions}" var="question">


        <div>


            <table>
                <thead>
                <tr>
                    <th>Question</th>
                    <th>View Details</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <div>
                        <c:choose>
                            <c:when test="${question.questionOptions.size()==0}">
                                <div>
                                    <td style="margin-left: 100px">${question.questionText}</td>
                                    <td>

                                        <form class="quizPage"
                                              action="${pageContext.request.contextPath}/professor/findQuestionByStudentResultExamId"
                                              method="post">
                                            <input type="hidden" name="studentResultExamId"
                                                   value="${question.studentResultExams.get(0).id}">
                                            <input type="submit" value="See The Answers">
                                        </form>
                                    </td>
                                </div>
                            </c:when>


                            <c:otherwise>
                                <div>
                                    <td style="margin-left: 100px">${question.questionText}</td>

                                    <td>
                                        <form class="quizPage"
                                              action="${pageContext.request.contextPath}/professor/findQuestionByStudentResultExamId"
                                              method="post">
                                            <input type="hidden" name="studentResultExamId"
                                                   value="${question.studentResultExams.get(0).id}">
                                            <input type="submit" value="See The Answers">
                                        </form>
                                    </td>
                                </div>

                            </c:otherwise>
                        </c:choose>
                    </div>
                </tr>
                </tbody>
            </table>

        </div>
    </c:forEach>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>
