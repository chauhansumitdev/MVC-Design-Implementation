package com.example.controller;
import com.example.model.JDBC;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class UserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String getUsername = req.getParameter("username");
        String getPassword = req.getParameter("password");

        JDBC db = new JDBC();
        db.executeQuery(getUsername, getPassword);

        PrintWriter out = resp.getWriter();
        out.println("<h1>Done</h1>");
    }
}
