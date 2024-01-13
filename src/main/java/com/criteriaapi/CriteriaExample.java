package com.criteriaapi;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hibernate.Student;

public class CriteriaExample {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		
		 Criteria c =  s.createCriteria(Student.class);//using criteria api, here we can add restriction on the criteria(c)
		 
		 //c.add(Restrictions.eq("certi.course", "Btech"));//adding restriction, it has static methods like 'eq' ,course 
		 // available in certificate so we use certi.course
		 
		 c.add(Restrictions.gt("id", 41));//gt-->greater than(i.e. id greater than 420
		 
		 c.add(Restrictions.like("certi.course", "c%"));// like is case insensitive and c% indicates starting with c
		 
		 List<Student> ls = c.list();
		 for(Student stu:ls) {
			 System.out.println(stu);
		 }
		
		
		s.close();
		sf.close();
	}

}
