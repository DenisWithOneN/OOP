package com;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConverterServletInput extends HttpServlet{

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nrRon = request.getParameter("nrRoni");
		
		int ron = Integer.parseInt(request.getParameter("nrRoni"));
		int result = ron/5;
		
		request.setAttribute("nrRoni", ron);
		request.setAttribute("convertedResult", result);
		request.getRequestDispatcher("ConverterSum.jsp").forward(request, response);
	}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.getRequestDispatcher("ConverterServletinput.jsp").forward(request, response);
}
}
