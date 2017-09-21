package com.omniwyse.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectBoxReq
 */
@WebServlet("/SelectBoxReq")
public class SelectBoxReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("html/text");
	    PrintWriter out=response.getWriter();
	    String selectedvalue  =  request.getParameter("jobCat");
	    out.println("<html><body><p>successfully done :::  "+selectedvalue+"</p><body></html>");
	    
	}

}
