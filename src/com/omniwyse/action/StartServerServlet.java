package com.omniwyse.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.omniwyse.server.AppiumStartStop;
import com.omniwyse.server.OpenServer;
import com.omniwyse.xml.XmlReader;

@WebServlet("/OpenServerServlet")
public class StartServerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StartServerServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
   	response.setContentType("text/html");
   	try {
	    AppiumStartStop.appiumStart();
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
   	new OpenServer().getOpenServer();
   	new XmlReader().getXmlElement();
   	AppiumStartStop.appiumStop();
   	request.getSession().setAttribute("xmlDetails", XmlReader.xmlAttrDetails);
   	request.getRequestDispatcher("WEB-INF/imageCapture.jsp").forward(request, response);
       }

}
