package com.hibernate.lifecycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.Certificate;
import com.hibernate.Student;

public class States {

	
	//transient,persistent,detached,removed states
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		//creating student object
		Student st = new Student();
		st.setId(41);
		st.setName("Ishika");
		st.setCity("Mahaveer");
		st.setCerti(new Certificate("12th","1 year"));
		//after setting the property of the student object it is in transient state
		
		Student st1 = new Student();
		st1.setId(42);
		st1.setName("Sonam");
		st1.setCity("Varanasi");
		st1.setCerti(new Certificate("CTET","1 year"));
		
		Student st2 = new Student();
		st2.setId(43);
		st2.setName("Sarvesh");
		st2.setCity("Bangalore");
		st2.setCerti(new Certificate("Btech","4 year"));
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(st);
		s.save(st1);
		s.save(st2);
		//once we save data data stored to the database and available to the session so now we are in the persistent state 
		//st.setName("Anshika");// before committing if we change/update any value then new data saved into database
		tx.commit();
		s.close();
		// after closing the session, session object is closed and moved to the detached state
		//st.setName("Ishika");//no change in database after session is closed
		sf.close();
	}
}
