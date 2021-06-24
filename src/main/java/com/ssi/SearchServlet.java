package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//read-code
		int code=Integer.parseInt(request.getParameter("code"));
		//fetch-details-from-db(code,name,price)
		Configuration config=new Configuration().configure();
		Session session=config.buildSessionFactory().openSession();
		Product product=session.get(Product.class, code);
		session.close();
		//discount-compute
		int price=product.getPrice();
		if(price>=7000) {
			product.setDiscount(price*15/100);
		}
		else {
			product.setDiscount(price*10/100);
		}
		//response-provide
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>Product-Details</h3>");
		out.println("<hr>");
		out.println("Code  : "+product.getPcode()+"<br>");
		out.println("Name  : "+product.getPname()+"<br>");
		out.println("Price : "+product.getPrice()+"<br>");
		out.println("Disc. : "+product.getDiscount()+"<br>");
		out.println("<hr>");
		out.println("<a href=index.jsp>Home</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

}
