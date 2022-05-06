package com.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/param")
public class GetParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String color = request.getParameter("color");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
//		out.println("<html style='background:" + color + "'></html>");
		out.println("<style>");
		out.print("body{background:");
		out.print(color);
		out.println("}");
		out.println("</style>");
		
		
	}

}
