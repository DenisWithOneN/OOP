package com.rapid;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LaptopServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		String laptopBrand = request.getParameter("brand");
		int brandLength = laptopBrand.length();
		
		
		String odd = "impar";
		String even = "par";
		
		if(brandLength % 2 == 0)
			request.setAttribute("parity", even);
		else request.setAttribute("parity", odd);
		
		request.setAttribute("laptopBrand", laptopBrand);
		request.setAttribute("brandLength",brandLength);
		request.getRequestDispatcher("laptopPage.jsp").forward(request, response);
	}
}
