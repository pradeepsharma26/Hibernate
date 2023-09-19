package com.reationship.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		System.out.println("project started...");
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();

		// creating question
		Question question = new Question();
		question.setQuestionId(1212);
		question.setQuestion("What is java");

		// create answer
		Answer answer = new Answer();
		answer.setAnswerId(343);
		answer.setAnswer("java is programming language");

		question.setAnswer(answer);
		
		Question question1 = new Question();
		question1.setQuestionId(242);
		question1.setQuestion("What is collection framework");

		// create answer
		Answer answer1 = new Answer();
		answer1.setAnswerId(344);
		answer1.setAnswer("Api to work with objects in java");

		question1.setAnswer(answer1);

		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();

		s.save(question);
		s.save(question1);
		s.save(answer);
		s.save(answer1);
		tx.commit();
		s.close();
		factory.close();
	}

}
