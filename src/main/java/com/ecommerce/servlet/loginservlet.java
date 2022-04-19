package com.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.dao.userdoa;
import com.project.factoryProvider;
import com.project.tables.user;


public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		
		userdoa dao=new userdoa(factoryProvider.getFactory());
		user User = dao.getEmailandPassword(email, password);	
//		System.out.println(User);
		HttpSession hs = request.getSession(); 
		
		if (User==null) {
			hs.setAttribute("message", "Invaled details");
			response.sendRedirect("login.jsp");
			return;
		}
		else {
			hs.setAttribute("current-user", User);
			
			if(User.getUtype().equals("admin")) {
				response.sendRedirect("admin.jsp");
			}
			else if(User.getUtype().equals("normal")) {
				response.sendRedirect("normal.jsp");
			}
			else {
				out.println("We are not identitified user type");
			}
		}
		
	}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
