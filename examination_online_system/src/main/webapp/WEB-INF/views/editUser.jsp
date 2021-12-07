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

    <form action="/admin/confirmEditUser" method="post" style="max-width: 600px; margin: 0 auto;">
        <div class="m-3">
            <div class="form-group row">
                <label class="col-4 col-form-label">Is Confirmed: </label>
                <div class="col-8">
                    <label>
                        <select name="isConfirmed">
                            <option value="YES">Yes</option>
                            <option value="NO">NO</option>
                        </select>
                    </label>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-4 col-form-label">User Type: </label>
                <div class="col-8">
                    <label>
                        <select name="userType">
                            <option value="PROFESSOR">Professor</option>
                            <option value="STUDENT">Student</option>
                        </select>
                    </label>
                </div>
            </div>


            <div>
                <input type="hidden" name="userId" value="${userId}">
                <button class="btn-dark" type="submit">Edit User</button>
            </div>
        </div>
    </form>
</div>

<%--<div class="center">--%>
<%--    <form action="/admin/confirmEditUser" method="post" style="max-width: 600px; margin: 0 auto;">--%>

<%--        <select name="sources" class="custom-select sources" placeholder="User Type">--%>
<%--            <option value="PROFESSOR">Professor</option>--%>
<%--            <option value="STUDENT">Student</option>--%>
<%--        </select>--%>

<%--        <select name="sources" class="custom-select sources" placeholder="Is Confirmed">--%>
<%--            <option value="true">Yes</option>--%>
<%--            <option value="false">NO</option>--%>
<%--        </select>--%>

<%--    </form>--%>

<%--</div>--%>


</body>
</html>
