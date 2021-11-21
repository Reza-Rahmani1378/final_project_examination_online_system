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
                        <select>
                            <option value="true" name="isConfirmed">Yes</option>
                            <option value="false" name="isConfirmed">NO</option>
                        </select>
                    </label>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-4 col-form-label">User Type: </label>
                <div class="col-8">
                    <label>
                        <select>
                            <option value="PROFESSOR" name="userType">Professor</option>
                            <option value="PROFESSOR" name="userType">Student</option>
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

<div class="center">
    <form action="/admin/confirmEditUser" method="post" style="max-width: 600px; margin: 0 auto;">

        <select name="sources" class="custom-select sources" placeholder="User Type">
            <option value="PROFESSOR">Professor</option>
            <option value="STUDENT">Student</option>
        </select>

        <select name="sources" class="custom-select sources" placeholder="Is Confirmed">
            <option value="true">Yes</option>
            <option value="false">NO</option>
        </select>

    </form>

</div>


<script>
    $(".custom-select").each(function () {
        var classes = $(this).attr("class"),
            id = $(this).attr("id"),
            name = $(this).attr("name");
        var template = '<div class="' + classes + '">';
        template += '<span class="custom-select-trigger">' + $(this).attr("placeholder") + '</span>';
        template += '<div class="custom-options">';
        $(this).find("option").each(function () {
            template += '<span class="custom-option ' + $(this).attr("class") + '" data-value="' + $(this).attr("value") + '">' + $(this).html() + '</span>';
        });
        template += '</div></div>';

        $(this).wrap('<div class="custom-select-wrapper"></div>');
        $(this).hide();
        $(this).after(template);
    });
    $(".custom-option:first-of-type").hover(function () {
        $(this).parents(".custom-options").addClass("option-hover");
    }, function () {
        $(this).parents(".custom-options").removeClass("option-hover");
    });
    $(".custom-select-trigger").on("click", function () {
        $('html').one('click', function () {
            $(".custom-select").removeClass("opened");
        });
        $(this).parents(".custom-select").toggleClass("opened");
        event.stopPropagation();
    });
    $(".custom-option").on("click", function () {
        $(this).parents(".custom-select-wrapper").find("select").val($(this).data("value"));
        $(this).parents(".custom-options").find(".custom-option").removeClass("selection");
        $(this).addClass("selection");
        $(this).parents(".custom-select").removeClass("opened");
        $(this).parents(".custom-select").find(".custom-select-trigger").text($(this).text());
    });
</script>

</body>
</html>
