package com.lavanya.gudimella.dao;
  
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.lavanya.gudimella.hibernate.HibernateConfiguration;
import com.lavanya.gudimella.vo.Person;

public class PersonDao {
	
	HibernateConfiguration hibernateConfiguration = new HibernateConfiguration();
	
	public void savePerson(Person person) {
		Session session = hibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(person);
		transaction.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons() {
		System.out.println("here 3");
		List<Person> personsList = new ArrayList<Person>();
		Session session = hibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		personsList = session.createQuery("from Person").list();
		transaction.commit();
		session.close();
		return personsList;
 	}

	public Person getPerson(int id) {
		Session session = hibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Person person = (Person) session.get(Person.class, id);
		transaction.commit();
		session.close();
		return person;
	}

	public void updatePerson(Person person) {
		Session session = hibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(person);
		transaction.commit();
		session.close();
	}

	public void deletePerson(Person person) {
		Session session = hibernateConfiguration.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("here 2");
		session.delete(person);
		transaction.commit();
		session.close();
	}
}
