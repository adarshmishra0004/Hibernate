package com.adarsh.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adarsh.entity.Aircraft;
import com.adarsh.util.HibernateUtil;

public class LoadObjectUsingGet {

	public static void main(String[] args) {
		Session ses=null;
		Transaction txn=null;
		Aircraft air=null;
		
		try {
			//get session obj
			ses=HibernateUtil.getSession();
			//get dummy txn since txn is mandatory for getCurrentSession()
			if(!ses.getTransaction().isActive());{
				txn=ses.beginTransaction();
			}
			//loading the record to entity obj
			air=ses.get(Aircraft.class, 1);//mandatory for entity class to have a 0 param constructor
			if(air==null)
				System.out.println("Object not found");
			else 
				System.out.println(air);
		}
		catch(HibernateException he) {
			System.out.println("Error loading obj");
			he.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("Error loading obj");
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}
	}
	

}
