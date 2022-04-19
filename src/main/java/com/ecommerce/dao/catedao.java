package com.ecommerce.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.tables.category;

public class catedao {
	
	private SessionFactory factory;

	public catedao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public int savecate(category cat) {
		Session s = this.factory.openSession();
		Transaction tx = s.beginTransaction();
		int catid= (int) s.save(cat);
		tx.commit();
		s.close();
		return catid;
	}
	
	public List<category> getCategory(){
		Session s = this.factory.openSession();
		Query q = s.createQuery("from category");
		List<category> list = q.list();
		return list;
	}
	
	public category getCategoryById(int cid) {
		category cat = null;
		try {
			Session s = this.factory.openSession();
			cat = s.get(category.class, cid);
			s.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cat;
	}
}
