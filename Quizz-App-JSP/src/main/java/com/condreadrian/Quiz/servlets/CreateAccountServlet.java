package com.condreadrian.Quiz.servlets;

import com.condreadrian.Quiz.model.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateAccountServlet extends HttpServlet {
    public CreateAccountServlet() {
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
