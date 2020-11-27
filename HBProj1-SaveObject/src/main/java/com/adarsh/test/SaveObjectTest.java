package com.adarsh.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.adarsh.entity.Aircraft;
import com.adarsh.util.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction txn=null;
		Aircraft air=null;
		boolean flag=false;
		
		//create entity obj with data
		air=new Aircraft("Transport", 4, "Boeing");
		try {
			//get session obj
			ses=HibernateUtil.getSession();
			//get txn
			if(!ses.getTransaction().isActive());{
				txn=ses.beginTransaction();
			}
			//save entity obj
			ses.save(air);
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//perform txn mgmt
			if(flag) {
				txn.commit();
				System.out.println("Airplane record saved");
			}
			else {
				txn.rollback();
				System.out.println("Record not saved...try again");
			}
		}
	}

}
