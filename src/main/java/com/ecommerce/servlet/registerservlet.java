package com.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.project.factoryProvider;
import com.project.tables.user;

public class registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	try {
		
		String userName= request.getParameter("user_name");
		String userEmail= request.getParameter("user_email");
		String userpass= request.getParameter("user_pass");
		String userPhone= request.getParameter("user_phone");
		String userAddress= request.getParameter("user_address");
		
		user User = new user(userName, userEmail, userpass, userPhone, "default.jpg" , userAddress, "normal");
		
		Session s = (Session) factoryProvider.getFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		int userId = (int) s.save(User);
		
		tx.commit();
		s.close();
		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("message", "Registered Sussessfully!!");
		response.sendRedirect("register.jsp");
		return;

		
		
		
	}catch(Exception ex) {ex.printStackTrace();}
		
		
	}

}
