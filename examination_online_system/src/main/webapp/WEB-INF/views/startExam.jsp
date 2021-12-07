<%--
  Created by IntelliJ IDEA.
  User: ASUS CENTER QOM
  Date: 11/26/2021
  Time: 12:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/startExam.css">
    <title>Exam Session</title>
</head>
<body>
<input type="hidden" id="timer" value="${exam.timeExam}">
<input type="hidden" id="idOfQuiz" name="idOfQuiz" value="${exam.id}">
<h1>Remaining Time</h1>
<div id="grb"></div>

<p id="demo"></p>
<main id="main">
    <div class="list" id="list"></div>
    <div class="pagenumbers" id="pagination"></div>
    <button id="submitButton">End The Exam</button>
</main>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/startExam.js"></script>
</body>
</html>