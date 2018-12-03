package com.userDashboard.main;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.userDashboard.model.User;
import com.userDashboard.model.UserDetail;
import com.userDashboard.model.Country;

public class CreateUser {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(User.class)
								.addAnnotatedClass(UserDetail.class)
								.addAnnotatedClass(Country.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			Date d = new Date(2000, 11, 21); 
			
			// create the objects
			
			User tempUser = 
					new User("rajat@gmail.com", "rajat", "porwal", "123456");	
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving instructor: " + tempUser);
			session.save(tempUser);					
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





