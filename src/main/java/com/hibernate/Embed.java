package com.hibernate;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Embed {

	public static void main(String[] args) {
		 Configuration cfg= new Configuration();
			cfg.configure("hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			Student student = new Student();
			student.setId(12);
			student.setName("Sarvesh");
			student.setCity("Mau");
			
			Certificate certi  = new Certificate();
			certi.setCourse("Python");
			certi.setDuration("3 months");
			student.setCerti(certi);
			
			Student student1 = new Student();
			student1.setId(14);
			student1.setName("Anjali");
			student1.setCity("Varanasi");
			
			Certificate certi1  = new Certificate();
			certi1.setCourse("Java");
			certi1.setDuration("3 months");
			student1.setCerti(certi1);
			
			Transaction tx = session.beginTransaction();
			session.save(student);
			session.save(student1);
			
			tx.commit();
			session.close();
			factory.close();
		System.out.println("done....");
	}
}
