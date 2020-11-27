package com.adarsh.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	private static ThreadLocal<Session> lt=new ThreadLocal<Session>();	
	static {
		try {
			//bootstrap hibernate
			Configuration cfg=new Configuration();
			//provide with configuration file
			cfg.configure("com/adarsh/cfg/hibernate.cfg.xml");
			//create sessionFactory
			factory=cfg.buildSessionFactory();
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//method to get Session obj
	public static Session getSession(){
		Session ses=null;
		ses=lt.get();
		if(ses==null) {
			if(factory!=null) {
				ses=factory.getCurrentSession();
				lt.set(ses);
			}
		}
		return ses;
	}
	
	//method to close SessionFactory
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
}
