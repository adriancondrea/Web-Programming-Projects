package com.condreadrian.Quiz.servlets;

import com.condreadrian.Quiz.domain.Question;
import com.condreadrian.Quiz.model.DBManager;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetQuestionsServlet extends HttpServlet {
    public GetQuestionsServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbmanager = new DBManager();
        List<Question> questions = dbmanager.getQuestions();
        int number_of_questions = Integer.parseInt(req.getParameter("questions_total"));
        if (questions.size() > number_of_questions){
            questions = questions.subList(0, number_of_questions);
        }

        String json = new Gson().toJson(questions);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
