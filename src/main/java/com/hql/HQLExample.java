package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.Student;

public class HQLExample {
	
	public static void main(String[] args) {
		 SessionFactory sf = new Configuration().configure().buildSessionFactory();
		 
		 Session s = sf.openSession();
		 //HQL Syntax use
		// String query = "from Student";// for all details
		 
		 //String query = "from Student where city = 'Mahaveer'"; // for specific details like city
		 
		 String query = "from Student where city=:x"; // this technique is used if 'x' is dynamic
		 
		 //now we need object of query so we use createQuery and pass the query to it, it will give the object of the query
		 
		Query q =  s.createQuery(query); // this step is mandatory
		q.setParameter("x", "Mahaveer");
		
	   // above query can return single result or the list
		//for multiple or list we use
		
		List<Student>ls = q.list();
		
		for(Student stu : ls) {
			System.out.println(stu);
		}
		 
		System.out.println("_____________________________________________________________");
		//DELETE QUERY
//		String quer = "delete from Student where city=:p";
//		Transaction tx= s.beginTransaction();
//		Query q1 = s.createQuery(quer);
//		q1.setParameter("p", "Mahaveer");
//		int r = q1.executeUpdate();
//		System.out.println("Deleted :"+r);
		
		
	//UPDATE QUERY
		String quer = "update Student set city=:p where name =:n";
		Transaction tx= s.beginTransaction();
		Query q1 = s.createQuery(quer);
		q1.setParameter("p", "Mahaveer");
		q1.setParameter("n", "Anshika");
		int r = q1.executeUpdate();
		System.out.println("Updated :"+r);
		
		
		//Join Query(one to many relation)
		 
		 s.close();
		 
		 sf.close();
	}

}
