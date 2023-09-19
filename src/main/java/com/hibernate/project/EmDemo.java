package com.hibernate.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		System.out.println("project started...");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Student student1=new Student();
		
		student1.setId(10);
		student1.setName("pk");
		student1.setCity("kanpur");
		Certificate certificate=new Certificate();
		certificate.setCourse("anoriod");
		certificate.setDuration("2year");
	    student1.setCerti(certificate); 
	    
		Student student2=new Student();
	    student2.setId(11);
		student2.setName("dadi");
		student2.setCity("kanpuri");
		Certificate certificate1=new Certificate();
		certificate1.setCourse("java");
		certificate1.setDuration("3year");
	    student2.setCerti(certificate1); 
	    
	    Session s=factory.openSession();
	    Transaction tx=s.beginTransaction();
	    s.save(student1);
	    s.save(student2);
	    tx.commit();
	    s.close();
	  factory.close();
	}
}
