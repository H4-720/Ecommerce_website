package com.project;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class helper {
	
	public static String get10word(String desc) {
		String[] strs = desc.split(" ");
		if(strs.length>10) {
			String res="";
			for(int i=0;i<10;i++) {
				res=res+strs[i];
			}
			return (res+"...");
		}else {
			return (desc+"...");
		}
	}
	
	
	public static Map<String,Long> getCount(SessionFactory factory) {
		Session session = factory.openSession();
		String q1 = "Select count(*) from user";
		String q2 = "Select count(*) from Product";
		
		Query query1 = session.createQuery(q1);
		Query query2 = session.createQuery(q2);
		
		Long userCount = (Long) query1.list().get(0);
		Long ProductCount = (Long) query2.list().get(0);
		
		Map<String,Long> map = new HashMap<>();
		map.put("userCount", userCount);
		map.put("ProductCount", ProductCount);
		
		session.close();
		return map;
	}

}
