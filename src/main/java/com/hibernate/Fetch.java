package com.hibernate;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch {
	//get or load
	public static void main(String args[]) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		//get
//		Student student = (Student)session.get(Student.class, 103);
//		System.out.println(student);
		
		try {
		Student student = (Student)session.load(Student.class, 12);//only stores object and don't fire select query
		System.out.println(student);//if we don't use this line select query will not be executed
		}
		catch(ObjectNotFoundException e){
			System.out.println("Not found");
		}
		
		session.close();
		factory.close();
		
		
	}
	
	// we can get/fetch objects from hibernate if we know the id
	//when using get call it stores object(data) in session as cache and when we again want to get data it check's session cache first 
	//if data is available there it shows it otherwise it hit's database
	
	//Load returns proxy object(i.e. stores object in a variable) and only work or hit database if we call method other than getId.
	//increase performance also known as Lazy Initialization

}
