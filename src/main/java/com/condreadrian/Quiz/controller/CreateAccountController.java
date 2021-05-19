package com.condreadrian.Quiz.controller;

import com.condreadrian.Quiz.domain.User;
import com.condreadrian.Quiz.model.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateAccountController extends HttpServlet {
    public CreateAccountController() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        RequestDispatcher rd = null;

        DBManager dbmanager = new DBManager();
        dbmanager.createUser(username, password);

        resp.sendRedirect("index.html");
    }
}
