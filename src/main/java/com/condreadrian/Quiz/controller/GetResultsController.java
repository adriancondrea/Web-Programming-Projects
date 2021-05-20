package com.condreadrian.Quiz.controller;

import com.condreadrian.Quiz.domain.Result;
import com.condreadrian.Quiz.model.DBManager;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetResultsController extends HttpServlet {
    public GetResultsController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String score = req.getParameter("score");
        Result r = new Result(Integer.parseInt(userId), Float.parseFloat(score));

        DBManager dbmanager = new DBManager();
        Result newResult = dbmanager.updateBestResult(r);

        String json = new Gson().toJson(newResult);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
