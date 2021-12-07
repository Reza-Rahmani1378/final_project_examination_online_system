<%--
  Created by IntelliJ IDEA.
  User: ASUS CENTER QOM
  Date: 11/24/2021
  Time: 1:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Exam</title>
</head>
<body>
<c:set var="p" value="${page}" scope="session"/>
<c:set var="q" value="${questions}" scope="session"/>
<c:set var="examId" value="${examId}" scope="session"/>
<div class="container">

    <form action="${pageContext.request.contextPath}/quiz" method="POST">
        <fieldset id="${q.get(p-1)}">
            <legend> Question: ${q.get(p-1).questionText}</legend>
            <br>
            <c:forEach var="option" items="${q.get(p-1).questionOptions}">
                <c:set var="qzSelected" scope="session" value="${qz.questions[p-1].isSelected}"/>
                <input type="radio" id="${q.get(p-1).id}" name="${q.get(p-1).id}" value="${option.optionText}">
                <label for="${q.get(p-1).id}"><c:out value="${option.optionText}"></c:out></label>

                <br>
            </c:forEach>
            <c:if test="${p > 1}">
                <c:out value="${qz.questions[p-1].questionId}"></c:out>
                <a href="${pageContext.request.contextPath}/quiz?quizTypeId=${qz.quizType.quizTypeId}&page=${p - 1}&choiceId=${qz.questions[p-1].questionId}">Before</a>
                <c:set var="p" value="${page - 1}" scope="session"/>
            </c:if>
            <c:if test="${p < 9}">
                <a href="${pageContext.request.contextPath}/quiz?quizTypeId=${qz.quizType.quizTypeId}&page=${page + 1}&choiceId=${qz.questions[p-1].questionId}">Next</a>
                <c:set var="p" value="${page + 1}" scope="session"/>
            </c:if>
            <c:if test="${p == 9}">
                <a href="">Submit</a>
                <c:set var="p" value="${page}" scope="session"/>
            </c:if>
        </fieldset>
    </form>
</div>


</body>
</html>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script>
    var exam;
    $(document).ready(function () {
        $.ajax({
            type: "GET",
            url: "http://localhost:2375/student/jsonConverter",
            dataType: 'html',
            success: function (data) {
                exam = {"JS": [JSON.parse(data)]}
                console.log(data);
            }
        })
    })
</script>
