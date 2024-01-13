package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.Student;

public class HQLPagination {
	public static void main(String[] args) {
		
		//pagination mainly gives us idea that number of elements we want on a page and page size, which keeps on increasing a/c our needs
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		Query <Student>q = s.createQuery("from Student",Student.class);
		
		//Query q = s.createQuery("from Student"); both work similarly
		
		//implementing pagination using hibernate
		q.setFirstResult(0);
		q.setMaxResults(4);
		
		List<Student>ls = q.list();
		for(Student st:ls) {
			System.out.println(st.getId()+" : "+st.getName()+" : "+st.getCity());
		}
		
		
		s.close();
		
		
		
		sf.close();
	}

}
