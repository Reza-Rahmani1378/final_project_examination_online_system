<%--
  Created by IntelliJ IDEA.
  User: ASUS CENTER QOM
  Date: 11/11/2021
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <h1 class="error" style="color: red">${msg}</h1>
    <form action="${pageContext.request.contextPath}/admin/success" method="post"
          style="max-width: 600px; margin: 0 auto;">
        <div class="m-3">
            <div class="form-group row">
                <label class="col-4 col-form-label">Title: </label>
                <div class="col-8">
                    <input class="form-control" type="text" name="titleCourse"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-4 col-form-label">Start Course: </label>
                <div class="col-8">
                    <input class="form-control" type="date" name="startCourse"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-4 col-form-label">End Course: </label>
                <div class="col-8">
                    <input class="form-control" required type="date" name="endCourse"/>
                </div>
            </div>


            <div>
                <button class="btn-dark" type="submit">Add Course</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>


<%--
endCourse , startCourse , titleCourse
--%>