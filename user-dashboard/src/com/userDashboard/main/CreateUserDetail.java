package com.userDashboard.main;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.userDashboard.model.Country;
import com.userDashboard.model.User;
import com.userDashboard.model.UserDetail;

public class CreateUserDetail {

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

			// print the user detail
						System.out.println("tempUser: " + tempUser);
						
			// create some user detail
			UserDetail tempUserDetail =
					new UserDetail(
							"abcd122123@gmail.com",
							"rajat",
							"porwal",
							"8871347017",
							d,
							"i am from indore",
							"cricket",
							1,
							"male",
							2);	
			
			UserDetail tempUserDetaill =
					new UserDetail(
							"pqrd11212@gmail.com",
							"rajat",
							"porwal",
							"8871347017",
							d,
							"i am from indore",
							"cricket",
							1,
							"male",
							2);	
			
             // add user details to user
						tempUser.add(tempUserDetail);
						tempUser.add(tempUserDetaill);
			
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
