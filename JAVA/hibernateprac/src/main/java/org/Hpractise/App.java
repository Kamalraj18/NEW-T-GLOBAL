package org.Hpractise;

import java.util.List;

import org.Hpractise.Entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Users.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//insert
//			Users user = new Users(1,"Gojo","Gojo@123","Saturo","Gojo");
//			session.beginTransaction();
//			session.save(user);
//			session.getTransaction().commit();
//			System.out.println("Row inserted");
			
			//read
//			Users user = new Users();
//			session.beginTransaction();
//			user = session.get(Users.class, 0);
//			user.setPassword("raj@123");
//			session.getTransaction().commit();
//			System.out.println(user);
			
			//delete
//			Users user = new Users();
//			session.beginTransaction();
//			user = session.get(Users.class, 0);
//			session.delete(user);
//			session.getTransaction().commit();
//			System.out.println("deleted");
			
			session.beginTransaction();
			List<Users> user = session.createQuery("from Users u where u.username='kamal' AND "+"u.password like '%123'").getResultList();
			for(Users temp : user) {
				System.out.println(temp);
			}
			
			
			
			
		}finally {
			session.close();
			factory.close();
		}

	}

}
