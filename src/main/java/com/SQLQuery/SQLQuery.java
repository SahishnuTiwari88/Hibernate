package com.SQLQuery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.hibernate.Student;

public class SQLQuery {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		//sql query
		String query = "select * from student";
		NativeQuery nq = s.createSQLQuery(query);
		List<Object[]>ls = nq.list();// here we have used object because we are returning data from the database table not
		//from the Student class, it is stored in the object type
		for(Object[] st:ls) {
			System.out.println(Arrays.toString(st));
			System.out.println();
			System.out.println(st[4]+"  "+st[3]+"  "+st[1]);
		}
		
		
		s.close();
		sf.close();
	}

}
