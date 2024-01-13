package com.hibernate;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started....." );
       // SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();// this factory has session so we get session and use it to save object to DB 
		Student student = new Student(104,"naresh","Chennai");
		System.out.println(student);
		
		//creating address object
		
		Address add = new Address();
		add.setStreet("4th street");
		add.setCity("Mau");
		add.setOpen(true);
		add.setX(10);
		add.setAddedDate(new Date());
		
		
		// reading image
		
		
//			FileInputStream fs = new FileInputStream("src/main/java/route.jpg");
//			byte []data = new byte[fs.available()]; //creating array which is size of image
//			fs.read(data); //reading image data
//			add.setImage(data);
//			fs.close();
		
		
//		Session session = factory.getCurrentSession();// curently we don't have current session so we have to open the session
		
		Session session = factory.openSession();
		//after that we have to start transaction and commit it to do physical changes in database
		
		Transaction tx = session.beginTransaction();
		session.save(student);
		session.save(add);
		tx.commit();//we have to commit transaction to see changes or save data to database
		session.close();
		System.out.println("done");
		
        
    }
}
