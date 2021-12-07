$(document).ready(function () {
    $('form').on("submit", function (event) {
        $.ajax({
            method: "post",
            url: "http://localhost:2375/question-rest/change-score",
            data: $(this).serialize(),
            success: function () {
                alert("The score was successfully recorded")
                location.reload();
            },
            error: function () {
                alert("The score was not successfully recorded")
            }
        })
        event.preventDefault();
    })
})