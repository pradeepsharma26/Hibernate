package com.hibernate.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
   public static void main(String[] args) {
	//get //load  
	   System.out.println("project started...");
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session=factory.openSession();
		
		//get method id 
		  Student student=(Student)session.get(Student.class, 4);
		  System.out.println(student);
		  
		  Address address=(Address)session.load(Address.class, 1);
		  System.out.println(address.getStreet()+":"+address.getCity());
		  
		session.close();
		factory.close();
}
}
