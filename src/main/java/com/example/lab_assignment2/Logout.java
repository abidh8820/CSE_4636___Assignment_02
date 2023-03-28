package com.example.lab_assignment2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Logout extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookieArray = request.getCookies();
        Cookie tempCookie = null;
        Cookie mapCookie = null;

        for (Cookie c : cookieArray) {
            if (c.getName().equals("cartList")) {
                mapCookie = c;
            }
            if (c.getName().equals("usernameKey")) {
                tempCookie = c;
            }
        }

        // remove the cartlist cookie
        if (mapCookie != null) {
            mapCookie.setMaxAge(0); // since cookie does not have any
            // invalidate method like HttpSession object, we need to
            // invalidate it by setting its lifetime to 0.
            // out.println("cartlist");
        }

        // remove the username cookie
        if (tempCookie != null) {
            tempCookie.setMaxAge(0); // since cookie does not have any
            // invalidate method like HttpSession object, we need to
            // invalidate it by setting its lifetime to 0.
            // out.println("user");
        }

        out.println("<h1> Successfully logged out </h1>");

        RequestDispatcher rd = request.getRequestDispatcher("login.html");
        rd.include(request, response);
    }
}
