<%@ page import="com.condreadrian.Quiz.domain.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script src="js/jquery-2.0.3.js"></script>
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

</body>
</html>