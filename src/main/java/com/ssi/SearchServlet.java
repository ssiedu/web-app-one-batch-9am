package com.ssi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchServlet extends HttpServlet {

	ProductService service=new ProductService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code=Integer.parseInt(request.getParameter("code"));
		Product product=service.computeDiscount(code);
		HttpSession session=request.getSession();
		session.setAttribute("details",product);
		response.sendRedirect("details.jsp");
	}

}
