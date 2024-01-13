package com.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//session factory is a interface, factory for providing session, it is a thread safe object
		Session s = sf.openSession();
		Person person = new Person(20,"Sonam Saini","Varanasi - Mahaveer","8808912345");
		
		Transaction tx = s.beginTransaction();
		s.save(person);
		
		tx.commit();
		
		s.close();
		sf.close();

	}

}
