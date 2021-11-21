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
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>

    <style>
        #descriptive {
            display: none;
        }

        .textBox {
            border: #005cbf solid 5px;
            margin-right: 100px;
        }

        ::placeholder {
            color: #6f42c1;
            font-size: large;
        }
    </style>
</head>
<body>
<div class="container text-center">


    <select onchange="showDiv('descriptive','optional',this)">
        <option value="0">Optional</option>
        <option value="1">Descriptive</option>
    </select>


    <div id="descriptive">
        <form action="/professor/confirmAddQuestionDescriptive" method="post" style="max-width: 600px; margin: 0 auto;">
            <div class="m-3">
                <div class="form-group row">
                    <label class="col-4 col-form-label">Question Title </label>
                    <div class="col-8">
                        <input id="title" class="form-control" type="text" name="questionTitle"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-4 col-form-label">Question Text </label>
                    <div class="col-8">
                        <input id="text" class="form-control" type="text" name="questionText"/>
                    </div>
                </div>

                <input id="type" type="hidden" value="DESCRIPTIVE" name="questionType">

                <div>
                    <input id="courseId" type="hidden" name="courseId" value="${courseId}">
                    <input id="examId" type="hidden" name="examId" value="${examId}">
                    <button class="btn-dark" type="submit">Add Question</button>
                </div>
            </div>
        </form>
        <textarea class="textBox" rows="10" cols="90" placeholder="Place For Answer The Question By Student"></textarea>
    </div>

</div>

<div id="optional" class="myInputs">

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 table-responsive">
                <div class="container text-center">

                    <form action="/professor/confirmAddQuestionOptional" method="post"
                          style="max-width: 600px; margin: 0 auto;">
                        <div class="m-3">
                            <div class="form-group row">
                                <label class="col-4 col-form-label">Question Title </label>
                                <div class="col-8">
                                    <input class="form-control" type="text" name="questionTitle"/>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="col-4 col-form-label">Question Text </label>
                                <div class="col-8">
                                    <input class="form-control" type="text" name="questionText"/>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="col-4 col-form-label">Question Answer </label>
                                <div class="col-8">
                                    <input class="form-control" type="text" name="questionAnswer"/>
                                </div>
                            </div>

                            <input type="hidden" value="OPTIONAL" name="questionType">

                            <div>
                                <input type="hidden" name="courseId" value="${courseId}">
                                <input type="hidden" name="examId" value="${examId}">
                                <button name="addQuestion" class="btn-dark" type="submit">Add Question</button>
                            </div>
                        </div>
                        <table class="table table-bordered table-hover table-sortable" id="tab_logic">
                            <thead>
                            <tr>
                                <th class="text-center">
                                    Option Text
                                </th>

                                <th class="text-center">
                                    Delete Option
                                </th>
                                <%--                        <th class="text-center">--%>
                                <%--                            Score--%>
                                <%--                        </th>--%>
                                <th class="text-center"
                                    style="border-top: 1px solid #ffffff; border-right: 1px solid #ffffff;">
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr data-id="0" class="hidden">
                                <td data-name="options">

                                    <input id='addr0' name="options" type="text" placeholder="Option Text"
                                           class="form-control">

                                </td>

                                <td data-name="del" style="text-align: center">
                                    <button name="del0"
                                            class='btn btn-danger glyphicon glyphicon-remove row-remove'><span
                                            aria-hidden="true">×</span></button>
                                </td>
                            </tr>
                            </tbody>
                        </table>

                    </form>
                </div>
            </div>
        </div>
        <a id="add_row" class="btn btn-primary float-right">Add New Option</a>
    </div>
</div>

<script>
    function myFunction() {
        document.getElementById("descriptive").style.display = "block";
    }

    function showDiv(divId, optionId, element) {
        document.getElementById(divId).style.display = element.value == 1 ? 'block' : 'none';
        document.getElementById(optionId).style.display = 'none';
        if (element.value == 0) {
            document.getElementById(optionId).style.display = 'block';

        }
    }

    $(document).ready(function () {
        $("#add_row").on("click", function () {
            // Dynamic Rows Code

            // Get max row id and set new id
            var newid = 0;
            $.each($("#tab_logic tr"), function () {
                if (parseInt($(this).data("id")) > newid) {
                    newid = parseInt($(this).data("id"));
                }
            });
            newid++;

            var tr = $("<tr></tr>", {
                id: "addr" + newid,
                "data-id": newid
            });

            // loop through each td and create new elements with name of newid
            $.each($("#tab_logic tbody tr:nth(0) td"), function () {
                var td;
                var cur_td = $(this);

                var children = cur_td.children();

                // add new td and element if it has a nane
                if ($(this).data("name") !== undefined) {
                    td = $("<td style='text-align: center'></td>", {
                        "data-name": $(cur_td).data("name")
                    });

                    var c = $(cur_td).find($(children[0]).prop('tagName')).clone().val("");
                    c.attr("name", $(cur_td).data("name"));
                    c.appendTo($(td));
                    td.appendTo($(tr));
                } else {
                    td = $("<td style='text-align: center'></td>", {
                        'text': $('#tab_logic tr').length
                    }).appendTo($(tr));
                }
            });

            // add delete button and td
            /*
            $("<td></td>").append(
                $("<button class='btn btn-danger glyphicon glyphicon-remove row-remove'></button>")
                    .click(function() {
                        $(this).closest("tr").remove();
                    })
            ).appendTo($(tr));
            */

            // add the new row
            $(tr).appendTo($('#tab_logic'));

            $(tr).find("td button.row-remove").on("click", function () {
                $(this).closest("tr").remove();
            });
        });


        // Sortable Code
        var fixHelperModified = function (e, tr) {
            var $originals = tr.children();
            var $helper = tr.clone();

            $helper.children().each(function (index) {
                $(this).width($originals.eq(index).width())
            });

            return $helper;
        };

        $(".table-sortable tbody").sortable({
            helper: fixHelperModified
        }).disableSelection();

        $(".table-sortable thead").disableSelection();


        $("#add_row").trigger("click");
    });


</script>

</body>
</html>
