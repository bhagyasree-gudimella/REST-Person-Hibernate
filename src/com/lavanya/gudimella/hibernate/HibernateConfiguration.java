package com.lavanya.gudimella.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfiguration {
	
	private Configuration configuration;
	private SessionFactory sessionFactory;
	
	public HibernateConfiguration() {
		super();
	}
	
	/**
	 * get the session factory to store the student values into the database
	 * assign it a static method later - class level
	 * @return sessionfactory
	 */
	public SessionFactory getSessionFactory() {
//		configuration = new Configuration();
//		sessionfactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
		
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
	    ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build(); 
		sessionFactory = configuration.configure().buildSessionFactory(serviceRegistryObj);
		return sessionFactory;
	}
}
