package com.condreadrian.Quiz.model;

import com.condreadrian.Quiz.domain.Question;
import com.condreadrian.Quiz.domain.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by forest.
 */
public class DBManager {
    private static Connection connection;
    private Statement stmt;

    public DBManager() {
        connect();
    }

    public void connect() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Quiz", "root", "");
            stmt = connection.createStatement();
        } catch (Exception ex) {
            System.out.println("eroare la connect:" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public User authenticate(String username, String password) {
        ResultSet rs;
        User u = null;
        System.out.println(username + " " + password);
        try {
            rs = stmt.executeQuery("select * from users where user='" + username + "' and password='" + password + "'");
            if (rs.next()) {
                u = new User(rs.getInt("id"), rs.getString("user"), rs.getString("password"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public boolean checkExistingUser(String username) {
        String sql = String.format("select * from users where user = '%s'", username);
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            return stmt.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void createUser(String username, String password) {
        if (checkExistingUser(username)) {
            return;
        }
        String sql = String.format("insert into users(id, user, password) values (null, '%s', '%s')", username, password);
        System.out.println(sql);
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Question> getQuestions() {
        List<Question> questions = new LinkedList<Question>();
        ResultSet rs;
        try {
            rs = stmt.executeQuery("select * from questions");
            while (rs.next()) {
                questions.add(new Question(rs.getInt("id"), rs.getString("question"), rs.getString("answers"), rs.getString("correctAnswer")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }
}