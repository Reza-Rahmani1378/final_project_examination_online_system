<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <meta name="description" content="Custom Login Form Styling with CSS3"/>
    <meta name="keywords" content="css3, login, form, custom, input, submit, button, html5, placeholder"/>
    <meta name="author" content="Codrops"/>
    <%--    <link rel="shortcut icon" href="../favicon.ico">--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css"/>
    <script src="${pageContext.request.contextPath}/assets/js/modernizr.custom.63321.js"></script>
    <!--[if lte IE 7]>
    <style>.main {
        display: none;
    }

    .support-note .note-ie {
        display: block;
    }</style><![endif]-->
    <style>
        @import url(http://fonts.googleapis.com/css?family=Ubuntu:400,700);

        body {
            background: #563c55 url(/assets/img/login-back.jpg) no-repeat center top;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            background-size: cover;
        }

        .container > header h1,
        .container > header h2 {
            color: #fff;
            text-shadow: 0 1px 1px rgba(0, 0, 0, 0.7);
        }
    </style>
</head>
<body>
<div class="container">


    <header>

        <h1>Login Form</h1>

    </header>

    <section class="main">
        <form action="${pageContext.request.contextPath}/login" method="post" class="form-3">
            <p class="clearfix">
                <label for="login">Username</label>
                <input type="text" name="username" id="login" placeholder="Username" required>
            </p>
            <p class="clearfix">
                <label for="password">Password</label>
                <input type="password" name="password" id="password" placeholder="Password" required>
            </p>
            <p class="clearfix">
                <input type="checkbox" name="remember" id="remember">
                <label for="remember">Remember me</label>
            </p>
            <p class="clearfix">
                <input type="submit">
            </p>
        </form>
    </section>

</div>
</body>
</html>
