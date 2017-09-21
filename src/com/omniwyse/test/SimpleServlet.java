package com.omniwyse.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Simple Servlet", description = "This is a simple servlet with annotations", urlPatterns = "/getServlet")
public class SimpleServlet extends HttpServlet {

 @Override
 protected void doGet(HttpServletRequest request,
   HttpServletResponse response) throws ServletException, IOException {
  System.out.println("get request");
  request.getRequestDispatcher("/WEB-INF/annotregister.jsp").forward(request, response);
 }

 @Override
 protected void doPost(HttpServletRequest request,
   HttpServletResponse response) throws ServletException, IOException {
     Map<String,String> map=new HashMap<String,String>();
     map.put("1", "one");
     map.put("2", "two");
     map.put("3", "three");
     map.put("4", "four");
     map.put("5", "five");
     
  System.out.println("Name : " + request.getParameter("name"));
  System.out.println("Gender : " + request.getParameter("gender"));
  System.out.println("Email : " + request.getParameter("email"));
  System.out.println("Phone : " + request.getParameter("phone"));
  System.out.println("City : " + request.getParameter("city"));

  request.setAttribute("map", map);
  
  request.getRequestDispatcher("/WEB-INF/annotdetails.jsp").forward(request, response);

 }
}
