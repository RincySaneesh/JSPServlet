package com.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.invalidate();
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if ("logout".equals(action)) {
            session.invalidate();
            response.sendRedirect("login.jsp");
        } else if ("logout".equals(action)) {
            session.invalidate();
            response.sendRedirect("login.jsp");
        }else {
            response.sendRedirect("login.jsp");
        }
    }
}