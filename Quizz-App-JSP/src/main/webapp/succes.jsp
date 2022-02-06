<%@ page import="com.condreadrian.Quiz.domain.User" %>
<%@ page import="com.condreadrian.Quiz.servlets.GetQuestionsServlet" %>
<%@ page import="com.condreadrian.Quiz.domain.Question" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script src="js/jquery-2.0.3.js"></script>
    <script src="js/utils.js"></script>
</head>
<body>
<%! User user; %>
<% user = (User) session.getAttribute("user");
    if (user != null) {
        out.println("Welcome, " + user.getUsername());
    }
%>

<form action="LogoutServlet" method="post">
    <input type="submit" value="Logout"/>
</form>

<div>
    Total number of questions: <input type="number" id="questions_total" value="5"/>
    <%--    Questions per page: <input type="number" id="questions_page" value="5"/>--%>
    <button id="get-questions">Get Questions</button>
</div>
<br>

<div id="questions"></div>

<button id="submit-button" style="display: none">Submit</button>

<div id="result"></div>

<h3 id="best"></h3>

<script>
    function updateScore(questions) {
        let score = {right: 0, wrong: 0};
        for (const questionNumber in questions) {
            let inputName = "\"" + questionNumber + "\"";
            let selected_value = $("input[name=" + inputName + "]:checked").val()
            let actual_value = questions[questionNumber].correctAnswer
            if (selected_value != undefined && selected_value === actual_value) {
                score["right"]++;
            } else {
                score["wrong"]++;
            }
        }

        $("#result").html("");
        $("#result").append("<h1> Quiz Done! You have given " + score.right + " correct answers");
        if (score.wrong === 0) {
            $("#result").append("Congrats! All your responses were correct! Your average is 100%")
        } else {
            $("#result").append("Unfortunately, you have given " + score.wrong + " wrong answers.Your average is " +
                (score.right / (questions.length) * 100).toFixed(1) + "%")
        }

        let userId = ${user.getId()};
        let s = (score.right / questions.length).toFixed(2)
        $.ajax({
            url: '/GetResultsServlet',
            type: 'GET',
            data: {userId: userId, score: s},
            success: function (data) {
                $('#best').html("Best result:" + parseFloat(data.score) * 100 + "%");
            }
        });
    }

    $(document).ready(function () {
        $("#get-questions").click( function() {
            $("#submit-button").show()
            $.ajax({
                url: '/GetQuestionsServlet',
                type: 'GET',
                data: {questions_total: $("#questions_total").val()},
                success: function (questions) {
                    $("#questions").html("");
                    for (var questionNumber in questions) {
                        $("#questions").append("<h1>" + questions[questionNumber].question + "</h1>")
                        let answers = questions[questionNumber].answers.split(";")
                        for (const answer in answers) {
                            $("#questions").append("<input type = \"radio\" name = \"" + questionNumber + "\" value = \"" + answers[answer].toString() + "\">" + answers[answer] + "<br>");
                        }
                    }
                    $("#submit-button").click(function () {
                        updateScore(questions)
                    })
                }})
            })})
</script>

</body>
</html>