package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Kahoot;

import util.HibernateUtil;

public class KahootDao {
	public void saveKahoot(Kahoot kahoot) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// save User object
			session.save(kahoot);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public static Kahoot getKahootById(long id) {
		Transaction transaction = null;
		Kahoot kahoot = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// get User object
			//User = session.load(User.class, id);
			kahoot = session.get(Kahoot.class, id);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return kahoot;
	}
}
