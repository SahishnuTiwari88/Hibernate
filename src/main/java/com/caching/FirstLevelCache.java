package com.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class FirstLevelCache {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		//by default enabled
		
		Student stu = s.get(Student.class, 43);
		System.out.println(stu);
		
		System.out.println("Printing data and storing object in session cache memory");
		
		Student stu1 = s.get(Student.class, 43);
		System.out.println(stu1);
		
		//we have a method to check if session has any object, it will give boolean value, true if available, false if not
		
		System.out.println(s.contains(stu1));
		
		// it is available only till session is not closed
		
		
		s.close();
		sf.close();
	}

}
