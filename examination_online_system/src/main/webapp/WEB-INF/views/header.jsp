<%@ page import="ir.maktab.examination_online_system.models.User" %>
<%@ page import="ir.maktab.examination_online_system.models.enumeration.UserType" %><%--
  Created by IntelliJ IDEA.
  User: ASUS CENTER QOM
  Date: 11/4/2021
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <meta charset="UTF-8">

    <title>
        Online Examination System
    </title>
</head>

<body>
<div class="header">
    <div class="container">
        <div class="header_content">
            Online Examination System
        </div>
        <div class="main_nav">
            <ul class="nav nav-pills pull-left">

                <c:if test="${logedUser.get().userType.name().equals('ADMIN')}">
                <li class="nav-item"><a class="nav-link" href="/dashbord">Dashboard</a></li>
                <li class="nav-item">
                    <a class="nav-link" href="admin/listOfUsers">List Of Users</a>
                </li>
                <li class="nav-item"><a class="nav-link" href="{/tickets}">List Of Tickets</a></li>
                <li class="nav-item"><a class="nav-link" href="">Destinations</a></li>
                <li class="nav-item"><a class="nav-link" href="/">Logout</a></li>

                </c:if>

                <c:if test="${logedUser.get().userType.name().equals('STUDENT')}">

                <div>
                    <li class="nav-item"><a class="nav-link" href="">Dashboard</a></li>
                    <li class="nav-item"><a class="nav-link" href="">Purses Ticket</a></li>
                    <li class="nav-item"><a class="nav-link" href="">My Tickets</a></li>
                    <li class="nav-item"><a class="nav-link" href="">Logout</a></li>

                </div>
                </c:if>


                <c:if test="${logedUser.get().userType.name().equals('PROFESSOR')}">

                <div>
                    <li class="nav-item"><a class="nav-link" href="">Dashboard</a></li>
                    <li class="nav-item"><a class="nav-link" href="">Purses Ticket</a></li>
                    <li class="nav-item"><a class="nav-link" href="professor/listOfCoursesProfessor">List Of Courses</a>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="">Logout</a></li>

                </div>
                </c:if>


        </div>
    </div>
</div>
<section class="main_contents"></section>

<div class="container"></div>
<div class="main_contents_inner"></div>


</body>


</html>
