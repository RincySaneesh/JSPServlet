package com.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");

        if (uname.equals("Rincy") && pass.equals("R@123")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", uname);
            response.sendRedirect("welcome.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if ("register".equals(action)) {
            response.sendRedirect("registration.jsp");
        }else if ("logout".equals(action)) {
            session.invalidate();
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}