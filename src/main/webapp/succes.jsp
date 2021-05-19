<%@ page import="com.condreadrian.Quiz.domain.User" %>
<%@ page import="com.condreadrian.Quiz.controller.GetQuestionsController" %>
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

<form action="LogoutController" method="post">
    <input type="submit" value="Logout"/>
</form>

<div id="questions"></div>
<script>
    $(document).ready(function () {
        getQuestions(function (questions) {
            console.log(questions);
            $("#questions").html("");
            for(var questionNumber in questions) {
                $("#questions").append("<h1>" + questions[questionNumber].question + "</h1>")
                let answers = questions[questionNumber].answers.split(";")
                for(const answer in answers){
                    $("#questions").append("<input type = \"radio\" name = \"" + questionNumber + "\" value = \"" + (answer + 1) + "\">" + answers[answer]+ "<br>");
                }


            }
        })
    })
</script>

</body>
</html>