package com.ecommerce.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.project.tables.user;

public class userdoa {
	
	private SessionFactory factory;
	
	public userdoa(SessionFactory factory) 
	{
		this.factory = factory;
	}
	public user getEmailandPassword (String email, String password) {
		
		user User =null;
		
		try {
			String query = "from user where uemail=: e and upassword=: p";
			Session session = this.factory.openSession();
			Query q = session.createQuery(query);
			q.setParameter("e", email);
			q.setParameter("p", password);
			User = (user) q.uniqueResult();
			session.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return User;
	}

}