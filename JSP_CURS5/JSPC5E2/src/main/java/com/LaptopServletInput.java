package com;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LaptopServletInput extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		String laptopBrand = request.getParameter("brand");
		
		if(laptopBrand != null) {
			int brandLength = laptopBrand.length();
			request.setAttribute("laptopBrandLength",brandLength);
			
			String odd = "impar";
			String even = "par";
			
			if(brandLength % 2 == 0) {
				request.setAttribute("oddEven", even);
			} else {
				request.setAttribute("oddEven", odd);
			}
		}
		
		request.setAttribute("laptopBrandName", laptopBrand);
		request.getRequestDispatcher("LaptopServletInput.jsp").forward(request, response);

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.getRequestDispatcher("LaptopServletInput.jsp").forward(request, response);
	}
}
