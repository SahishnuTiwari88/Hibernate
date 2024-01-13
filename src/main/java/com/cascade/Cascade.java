package com.cascade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Cascade {

	public static void main(String[] args) {
		// Suppose in case of one to many mapping one question can have many answer, suppose we created a question
		//and number of answers related to it(as list) but when we try to save these information only question part get saved 
		//and answer has to be saved manually using save(), this problem can be solved by using cascading
		//cascading simply means saving main entity/information and all other related information automatically got saved
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		
		
		s.close();
		sf.close();
	}

}
