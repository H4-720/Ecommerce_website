package com.ecommerce.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.tables.Product;

public class productdao {
	private SessionFactory factory;

	public productdao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	public boolean saveProduct(Product product) {
		boolean f = false;
		try {
			Session s = this.factory.openSession();
			Transaction tx = s.beginTransaction();
			s.save(product);
			tx.commit();
			s.close();
			f=true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			f=false;
		}
		return f;	
	}
	public List<Product> getallproduct(){
		Session s = this.factory.openSession();
		Query query = s.createQuery("from Product");
		List<Product> list = query.list();
		return list;
	}
	public List<Product> getallproductById(int cid){
		Session s = this.factory.openSession();
		Query query = s.createQuery("from Product as p where p.cate.catid =: id");
		query.setParameter("id",cid);
		List<Product> list = query.list();
		return list;
	}
}
