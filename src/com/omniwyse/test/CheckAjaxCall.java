package com.omniwyse.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckAjaxCall")
public class CheckAjaxCall extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CheckAjaxCall() {
	super();
    }

    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String text = ",some Message from Ser Servlet..."; // message you will recieve
	String name = request.getParameter("name");
	PrintWriter out = response.getWriter();
	out.println(name + " " + text);
	
	
    }
}
