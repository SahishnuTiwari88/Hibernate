package com.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class SecondLevelCache {

	public static void main(String[] args) {
// for using second level cache we have to add some dependency in pom.xml file as ehcache maven and hibernate ehcache
//and also mention property in hibernate.cfg.xml(configuration file)		
// by default entity is not Cacheable, to make it in second level cache we have to use @Cacheable annotation in entity class
//have to mention strategy, read only if want to read
		
	//fetch data using one session and close it and again fetch data using other session and this time no query executed
		//this show that second level caching is enabled
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		//first call
		Student student = s.get(Student.class,43);
		System.out.println(student);
		s.close();
		
		Session s1 = sf.openSession();
		Student student1 = s1.get(Student.class,43);
		System.out.println(student1);
		s1.close();
		
		sf.close();
	}

}
