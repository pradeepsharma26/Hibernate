package com.hibernate.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("project started...");
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();

//		 System.out.println(factory);
//		 System.out.println(factory.isClosed());
		// creating student object
		Student student = new Student();
		student.setId(6);
		student.setName("shubham");
		student.setCity("bharat");
		System.out.println(student);
		// create object of address class
		Address address = new Address();
		address.setStreet("strret5");
		address.setCity("city4");
		address.setOpen(true);
		address.setAddedDate(new Date());
		address.setX(1231.45);
		
		//Reading File
		FileInputStream fis =new FileInputStream("src/main/java/pk.png");
		byte[] data=new byte[fis.available()];
		fis.read(data);
		address.setImage(data);
		
//		System.out.println(address);
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(student);
		session.save(address);

		tx.commit();
		session.close();
		System.out.println("done");
	}
}
