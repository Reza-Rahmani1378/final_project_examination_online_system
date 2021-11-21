<%--
  Created by IntelliJ IDEA.
  User: ASUS CENTER QOM
  Date: 11/4/2021
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Course</title>
    <%-- <link crossorigin="anonymous" href="/assets/css/bootstrap.min.css"
           integrity="sha384-MCw98/SFnGE8fJT3GXwEOnesV7Zt27NXFooApmYm81iuXoPkFOJwJ8ERedskinLPMO" rel="stylesheet">
     <link href="/assets/css/assets/owl.carousel.css" rel="stylesheet">
     <link href="/assets/assets/owl.theme.default.css" rel="stylesheet">
     <link href="/assets/main.css" rel="stylesheet">--%>
</head>
<body>
<%--<%@include file="header.jsp"%>--%>

<form action="success" method="post" style="max-width: 350px">
    <div>
        <h3>
            Add Course
        </h3>
        <div>
            <label>Title Of Course</label>
            <label>
                <input type="text" class="btn-dark form-controller" name="titleCourse">
            </label>
        </div>


        <div>
            <label>Start Course</label>
            <div>
                <label>
                    <input autocomplete="off" name="startCourse" type="date"/>
                </label>
            </div>
        </div>

        <div>
            <label>End Course</label>
            <div>
                <label>
                    <input autocomplete="off" name="endCourse" type="date"/>
                </label>
            </div>
        </div>
    </div>
    <div>
        <div>
            <button type="submit">Add Course</button>
        </div>
    </div>
</form>

</body>
</html>
