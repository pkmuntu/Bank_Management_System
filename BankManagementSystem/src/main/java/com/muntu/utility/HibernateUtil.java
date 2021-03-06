package com.muntu.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

//@Component("hibernateUtil")
public class HibernateUtil {

	private static SessionFactory factory;

	static {
		try {
			// Boot Strapping of Hibernate (Modren)
			Configuration cfg = new Configuration();
			// create ServiceRegistryBuilder
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			// add service registry through service Registry builder
			StandardServiceRegistry registry = builder.configure("/com/muntu/cfgs/hibernate.cfg.xml").build();
			// create SessionFactory with serviceRegistry
			factory = cfg.buildSessionFactory(registry);
		} catch (HibernateException he) {
			he.printStackTrace();
		}
	}// static block

	public static SessionFactory getSessionFactory() {
		return factory;
	}

	public static Session getSession() {
		Session ses = null;
		if (factory != null) {
			ses = factory.getCurrentSession();
		}
		return ses;
	}

	public static void closeSessionFactory() {
		if (factory != null)
			factory.close();
	}

}
