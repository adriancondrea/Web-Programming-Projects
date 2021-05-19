package com.condreadrian.Quiz.controller;

import com.condreadrian.Quiz.domain.Question;
import com.condreadrian.Quiz.model.DBManager;
import com.google.gson.Gson;

import javax.json.JsonArray;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetQuestionsController extends HttpServlet {
    public GetQuestionsController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbmanager = new DBManager();
        List<Question> questions = dbmanager.getQuestions();

        String json = new Gson().toJson(questions);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
