package com.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Registration")
public class SignUp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmpassword = request.getParameter("confirmpassword");

        if (name != null && username != null && password != null && confirmpassword != null &&
                !name.isEmpty() && !username.isEmpty() && !password.isEmpty() && !confirmpassword.isEmpty() &&
                password.equals(confirmpassword))
        {
            HttpSession session = request.getSession();
            session.setAttribute("Registration", username);
            response.sendRedirect("success-register.jsp");

        } else {
            response.sendRedirect("registration.jsp");
        }
    }
}


