package com.userDashboard.main;


import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.userDashboard.model.Country;
import com.userDashboard.model.User;
import com.userDashboard.model.UserDetail;

public class GetUserDetail {

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
			
			// start a transaction
			session.beginTransaction();
			
			// get the user from DB
			int theId = 2;
			User tempUser =
					session.get(User.class, theId);	
			
			Country tempUserCountry =
					session.get(Country.class, 1);	

			// print the user detail
//						System.out.println("tempUser: " + tempUser);
			
//			 print the user
			System.out.println("tempUser: " + tempUser);
						
			// print  the associated user detail
			System.out.println("the associated user details: " + 
					tempUser.getUserId());
			
//			print  the associated country name
			System.out.println("the associated country name: " + 
					tempUserCountry.getUserCountry());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			
			factory.close();
		}
	}

}





