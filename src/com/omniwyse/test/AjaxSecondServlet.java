package com.omniwyse.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/AjaxSecondServlet")
public class AjaxSecondServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Map<String, String> map = new HashMap<String, String>();
	map.put("1", "one");
	map.put("2", "two");
	map.put("3", "three");
	map.put("4", "four");
	map.put("5", "five");

	//String userName = request.getParameter("userName").trim();
	//System.out.println(userName);

	String json =new Gson().toJson(map);

	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");

	response.getWriter().write(json);
    }

}
