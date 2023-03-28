package com.example.lab_assignment2;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookieArray = request.getCookies();
        Cookie tempCookie = null;
        int fl = 0;

        for (Cookie c : cookieArray) {
            if (c.getName().equals("usernameKey")) {
                fl = 1;
                tempCookie = c;
            }
        }
        if (tempCookie == null) {
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            rd.include(request, response);
        } else {
            out.println("<h1> Successfully logged in </h1>");

            RequestDispatcher rd = request.getRequestDispatcher("Homepage");
            rd.include(request, response);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookieArray = request.getCookies();
        Cookie tempCookie = null;
        int fl = 0;

        for (Cookie c : cookieArray) {
            if (c.getName().equals("usernameKey")) {
                fl = 1;
                tempCookie = c;
            }
        }
        if (tempCookie == null) {
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            rd.include(request, response);
        } else {
            out.println("<h1> Successfully logged in </h1>");

            RequestDispatcher rd = request.getRequestDispatcher("Homepage");
            rd.forward(request, response);
        }
    }

    public void destroy() {}
}
