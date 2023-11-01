package com.rapid;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConverterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ron = Integer.parseInt(request.getParameter("ron"));
		int euro = Integer.parseInt(request.getParameter("EURO"));
		
		int result = ron / euro;
		
		request.setAttribute("conversie", result);
		request.getRequestDispatcher("converterpage.jsp").forward(request, response);
		
	}
}
