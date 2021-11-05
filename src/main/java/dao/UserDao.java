package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.User;
import util.HibernateUtil;

public class UserDao {
	
	public void saveUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// save User object
			session.save(user);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	

	public void updateUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// save User object
			session.saveOrUpdate(user);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public static User getUserById(long id) {
		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// get User object
			//User = session.load(User.class, id);
			user = session.get(User.class, id);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
		Transaction transaction = null;
		List<User> users = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// get User object
			//User = session.load(User.class, id);
			users = session.createQuery("from User").list();
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return users;
	}
	
	public void deleteUser(long id) {
		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();
			
			user = session.get(User.class, id);
			// save User object
			session.remove(user);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	

}
