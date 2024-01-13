package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Question q = new Question();
		q.setqId(11);
		q.setQuestion("What is Java ?");
		
		Answer a = new Answer();
		a.setAnsId(22);
		a.setAnswer("It is a OOP language");
		a.setQue(q);
		
		q.setAnswer(a);
		
		
		
		Question q1 = new Question();
		q1.setqId(33);
		q1.setQuestion("What is Hibernate ?");
		
		Answer a1 = new Answer();
		a1.setAnsId(66);
		a1.setAnswer("Framework to build fast application");
		a1.setQue(q1);
		
		q1.setAnswer(a1);
		//
		
		Question q2 = new Question();
		q2.setqId(34);
		q2.setQuestion("What is Spring ?");
		
		Answer a2 = new Answer();
		a2.setAnsId(67);
		a2.setAnswer("Spring is child of hibernate to build fast application");
		a2.setQue(q2);
		
		q2.setAnswer(a2);
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(q);
		session.save(q1);
		session.save(q2);
	
		tx.commit();
		session.close();
		
		sf.close();
		
		//mapping can be unidirectional or bidirectional both
		
	}

}
