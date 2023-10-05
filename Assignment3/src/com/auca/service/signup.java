package com.auca.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class signup extends HttpServlet{
    String email, password;
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        email = req.getParameter("Email");
        password = req.getParameter("password");
        if (email != null && password != null) {
            res.sendRedirect("Acceptance.html");
        } else {
           System.out.println("No Field Should be empty");
        }
    }
}
