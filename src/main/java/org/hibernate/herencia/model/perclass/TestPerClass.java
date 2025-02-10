package org.hibernate.herencia.model.perclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.herencia.model.perclass.util.HibernateUtil;

public class TestPerClass {

	private static SessionFactory sessionFactory = null;

	private static Session session = null;

	private static Transaction tx = null;

	public static void main(String[] args) {
		try {
		// Get the singleton instance of HibernateUtil
		HibernateUtil hibernateUtil = HibernateUtil.getInstance();

		// Retrieve the SessionFactory
		sessionFactory = hibernateUtil.getSessionFactory();

		// Open a session
		session = sessionFactory.openSession();

		
			tx = session.beginTransaction();
			addEmployees();

			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}
	}

	
	public static void addEmployees() {

		System.out.println("\n\n*** addEmployees  ***\n");

		try {

			Technician technician = new Technician();
			technician.setName("Yo soy el técnico!!!");
			technician.setExperienceYears(24);
			session.persist(technician);
			System.out.println("La clave del nuevo objeto es: " + technician.getId());

			Developer developer = new Developer();
			developer.setName("Yo soy el desarrollador!!!");
			developer.setExperienceYears(14);
			developer.setExpertLanguajes("Java");
			session.persist(developer);
			System.out.println("La clave del nuevo objeto es: " + developer.getId());

			Externo externo = new Externo();
			externo.setName("Yo soy Externo");
			externo.setEmpresa("IBM");

			session.persist(externo);
			System.out.println("La clave del nuevo objeto es: " + externo.getId());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
