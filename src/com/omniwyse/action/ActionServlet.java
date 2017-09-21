package com.omniwyse.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omniwyse.cmd.ReadCmdContent;

@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ActionServlet() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	response.setContentType("text/html");// setting the content type
	try {
	    new ReadCmdContent().getCmdData();
	 
	} catch (Exception e) {
	    e.printStackTrace();
	}
	System.out.println("From servlet::" + ReadCmdContent.deviceDetails);

	request.getSession().setAttribute("deviceDetailsList", ReadCmdContent.deviceDetails);
	   
	if (ReadCmdContent.deviceDetails.get(0).isEmpty() == false)
	    request.getRequestDispatcher("WEB-INF/ok.jsp").forward(request, response);
	else
	    request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
	ReadCmdContent.deviceDetails.clear();

    }

}
