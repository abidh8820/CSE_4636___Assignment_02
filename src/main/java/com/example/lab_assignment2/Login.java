package com.example.lab_assignment2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");


        //if credentials ok
        if (username.equals("tafsir") && password.equals("123"))
        {
            Cookie usernameCookie = new Cookie("usernameKey", username);
            response.addCookie(usernameCookie);

            out.println("<h1> Successfully logged in </h1>");

            RequestDispatcher rd = request.getRequestDispatcher("Homepage");
            rd.include(request, response);
        }
        //if credentials not ok
        else
        {

            out.println("<h1> Wrong credentials </h1>");

            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            rd.include(request, response);
        }
    }

}
