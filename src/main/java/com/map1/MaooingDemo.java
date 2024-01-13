package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MaooingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		
		Emp e1 = new Emp();
		e1.setEid(10);
		e1.setName("Sonam");
		
		Emp e2 = new Emp();
		e2.setEid(11);
		e2.setName("Sarvesh");
		
		Project p1 = new Project();
		p1.setPid(20);
		p1.setProjectName("Library Management");
		
		Project p2 = new Project();
		p2.setPid(30);
		p2.setProjectName("Chat Bot");
		
		List<Project> li = new ArrayList<Project>();
		li.add(p1);
		li.add(p2);
		
		List<Emp> li1 = new ArrayList<Emp>();
		li1.add(e1);
		li1.add(e2);
		e1.setProjects(li);//setting projects to employee
		
		p1.setEmployees(li1);
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		tx.commit();
		session.close();
		
		sf.close();
		
		

	}

}
