package com.example.lab_assignment2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Homepage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie [] cookieArray = request.getCookies();
        Cookie tempCookie = null;
        int fl=0;


        for (Cookie c:cookieArray)
        {

            if (c.getName().equals("usernameKey")) {
                fl = 1;
                tempCookie = c;
            }
        }

        if(fl==0){
            out.println("<h1> Invalid session. Please log in again. " + "</h1>");
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            rd.include(request, response);
        }

        else{
            out.println("<h1> Welcome "+ tempCookie.getValue() + "!</h1>");
            out.println("<h2> To log out, please press the following button.</h2><br>");

            out.println("<form method=\"post\" action=\"Logout\"> " +
                    "<input type=\"submit\" value=\"Log out\"> " +
                    "</form> " +
                    "</br>");

            out.println("<form action=\"Homepage\" method=\"post\"> " +
                    "<h1>Tomato</h1> " +
                    "<p>add to cart</p> " +
                    "<input type=\"submit\" name=\"tomaton\" value=\"-\"/> " +

                    "<input type=\"submit\" name=\"tomatop\" value=\"+\"/> " +
                    "</form> " +
                    "</br>");

            out.println("<form action=\"Homepage\" method=\"post\"> " +
                    "<h1>Onion</h1> " +
                    "<p>add to cart</p> " +
                    "<input type=\"submit\" name=\"onionn\" value=\"-\" /> " +

                    "<input type=\"submit\" name=\"onionp\" value=\"+\" /> " +
                    "</form> " +
                    "</br>");


            Map<String, Integer> cartMap = new HashMap<>();

            String tommoreadd = request.getParameter("tomatop");
            String tomlessadd = request.getParameter("tomaton");

            String onimoreadd = request.getParameter("onionp");
            String onilessadd = request.getParameter("onionn");


            if (tommoreadd != null) {
                Cookie mapCookie = null;
                for (Cookie c:cookieArray){
                    if (c.getName().equals("cartList")) {
                        mapCookie = c;
                        break;
                    }
                }

                int flt=0;
                if (mapCookie != null) {

                    String mapString = mapCookie.getValue();
                    mapString = mapString.substring(1, mapString.length() - 1);
                    String[] mapElements = mapString.split(", ");
                    Map<String, Integer> map = new HashMap<>();


                    for(int i=0;i<mapElements.length;i+=1){
                        String[] keyValue=mapElements[i].split("=");
                        map.put(keyValue[0], Integer.valueOf(keyValue[1]) );
                        if(keyValue[0].equals("tomato")){
                            flt=1;
                        }
                    }


                    if(flt==0){
                        map.put("tomato",1);
                        String cartListString = map.toString();
                        Cookie cookie = new Cookie("cartList", cartListString);
                        response.addCookie(cookie);
                        out.println(map);
                        cartMap=map;
                    }
                    else{
                        map.put("tomato",(int)map.get("tomato") +1);
                        String cartListString = map.toString();
                        Cookie cookie = new Cookie("cartList", cartListString);
                        response.addCookie(cookie);
                        out.println(map);
                        cartMap=map;
                    }
                }
                else{
                    Map<String, Integer> cartList=new HashMap<>();
                    cartList.put("tomato",1);
                    String cartListString = cartList.toString();
                    Cookie cookie = new Cookie("cartList", cartListString);
                    response.addCookie(cookie);
                    out.println(cartList);
                    cartMap=cartList;
                }
                out.println("hi3");
            }

            else if (tomlessadd != null) {
                Cookie mapCookie = null;
                for (Cookie c:cookieArray){
                    if (c.getName().equals("cartList")) {
                        mapCookie = c;
                        break;
                    }
                }

                int flt=0;
                if (mapCookie != null) {

                    String mapString = mapCookie.getValue();
                    mapString = mapString.substring(1, mapString.length() - 1);
                    String[] mapElements = mapString.split(", ");
                    Map<String, Integer> map = new HashMap<>();


                    for(int i=0;i<mapElements.length;i+=1){
                        String[] keyValue=mapElements[i].split("=");
                        map.put(keyValue[0], Integer.valueOf(keyValue[1]) );
                        if(keyValue[0].equals("tomato")){
                            flt=1;
                        }
                    }


                    if(flt==0){
                        map.put("tomato",1);
                        String cartListString = map.toString();
                        Cookie cookie = new Cookie("cartList", cartListString);
                        response.addCookie(cookie);
                        out.println(map);
                        cartMap=map;
                    }
                    else{
                        if((int)map.get("tomato") == 0){
                            map.put("tomato",0);
                        }
                        else{
                            map.put("tomato",(int)map.get("tomato") -1);
                        }
                        String cartListString = map.toString();
                        Cookie cookie = new Cookie("cartList", cartListString);
                        response.addCookie(cookie);
                        out.println(map);
                        cartMap=map;
                    }
                }
                else{
                    Map<String, Integer> cartList=new HashMap<>();
                    cartList.put("tomato",1);
                    String cartListString = cartList.toString();
                    Cookie cookie = new Cookie("cartList", cartListString);
                    response.addCookie(cookie);
                    out.println(cartList);
                    cartMap=cartList;
                }
                out.println("hi4");
            }


            else if (onimoreadd != null) {
                Cookie mapCookie = null;
                for (Cookie c:cookieArray){
                    if (c.getName().equals("cartList")) {
                        mapCookie = c;
                        break;
                    }
                }

                int flt=0;
                if (mapCookie != null) {

                    String mapString = mapCookie.getValue();
                    mapString = mapString.substring(1, mapString.length() - 1);
                    String[] mapElements = mapString.split(", ");
                    Map<String, Integer> map = new HashMap<>();


                    for(int i=0;i<mapElements.length;i+=1){
                        String[] keyValue=mapElements[i].split("=");
                        map.put(keyValue[0], Integer.valueOf(keyValue[1]) );
                        if(keyValue[0].equals("onion")){
                            flt=1;
                        }
                    }


                    if(flt==0){
                        map.put("onion",1);
                        String cartListString = map.toString();
                        Cookie cookie = new Cookie("cartList", cartListString);
                        response.addCookie(cookie);
                        out.println(map);
                        cartMap=map;
                    }
                    else{
                        map.put("onion",(int)map.get("onion") +1);
                        String cartListString = map.toString();
                        Cookie cookie = new Cookie("cartList", cartListString);
                        response.addCookie(cookie);
                        out.println(map);
                        cartMap=map;
                    }
                }
                else{
                    Map<String, Integer> cartList=new HashMap<>();
                    cartList.put("onion",1);
                    String cartListString = cartList.toString();
                    Cookie cookie = new Cookie("cartList", cartListString);
                    response.addCookie(cookie);
                    out.println(cartList);
                    cartMap=cartList;
                }
                out.println("hi5");
            }

            else if (onilessadd != null) {
                Cookie mapCookie = null;
                for (Cookie c:cookieArray){
                    if (c.getName().equals("cartList")) {
                        mapCookie = c;
                        break;
                    }
                }

                int flt=0;
                if (mapCookie != null) {

                    String mapString = mapCookie.getValue();
                    mapString = mapString.substring(1, mapString.length() - 1);
                    String[] mapElements = mapString.split(", ");
                    Map<String, Integer> map = new HashMap<>();


                    for(int i=0;i<mapElements.length;i+=1){
                        String[] keyValue=mapElements[i].split("=");
                        map.put(keyValue[0], Integer.valueOf(keyValue[1]) );
                        if(keyValue[0].equals("onion")){
                            flt=1;
                        }
                    }


                    if(flt==0){
                        map.put("onion",1);
                        String cartListString = map.toString();
                        Cookie cookie = new Cookie("cartList", cartListString);
                        response.addCookie(cookie);
                        out.println(map);
                        cartMap=map;
                    }
                    else{
                        if((int)map.get("onion") == 0){
                            map.put("onion",0);
                        }
                        else{
                            map.put("onion",(int)map.get("onion") -1);
                        }
                        String cartListString = map.toString();
                        Cookie cookie = new Cookie("cartList", cartListString);
                        response.addCookie(cookie);
                        out.println(map);
                        cartMap=map;
                    }
                }
                else{
                    Map<String, Integer> cartList=new HashMap<>();
                    cartList.put("onion",1);
                    String cartListString = cartList.toString();
                    Cookie cookie = new Cookie("cartList", cartListString);
                    response.addCookie(cookie);
                    out.println(cartList);
                    cartMap=cartList;
                }
                out.println("hi6");
            }


            out.println("</br><h2>your cart: " + cartMap + "</h2>");
            int price=0;

            String cartMapString = cartMap.toString();

            out.println("<form action=\"Homepage\" method=\"post\"> " +
                    "<p>checkout: </p> " +

                    "<input type=\"submit\" name=\"buybutton\" value=\"buy\"/> " +

                    "</form> " +
                    "</br>");

            String buybutton = request.getParameter("buybutton");

            if (buybutton != null) {
                Cookie mapCookie = null;
                for (Cookie c:cookieArray){
                    if (c.getName().equals("cartList")) {
                        mapCookie = c;
                        break;
                    }
                }

                if (mapCookie != null) {
                    String mapString = mapCookie.getValue();
                    mapString = mapString.substring(1, mapString.length() - 1);
                    String[] mapElements = mapString.split(", ");
                    Map<String, Integer> map = new HashMap<>();

                    for (int i = 0; i < mapElements.length; i += 1) {
                        String[] keyValue = mapElements[i].split("=");
                        map.put(keyValue[0], Integer.valueOf(keyValue[1]));
                    }

                    map.put("onion", 0);
                    map.put("tomato", 0);
                    String cartListString = map.toString();
                    Cookie cookie = new Cookie("cartList", cartListString);
                    response.addCookie(cookie);
                    cartMap = map;
                    out.println("payment successful");
                }
            }

        }
    }
}
