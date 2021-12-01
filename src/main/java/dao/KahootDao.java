package dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Kahoot;
import model.User;
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

			// get Kahoot object
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
	
	public static Kahoot getKahootByName(String name) {
		Transaction transaction = null;
		Kahoot kahoot = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();
			String query = "FROM Kahoot where title= '"+name+"'";
			kahoot = (Kahoot) session.createQuery(query).uniqueResult();
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				System.out.println("Error: " + e);
				transaction.rollback();
			}
		}
		return kahoot;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Kahoot> getAllKahootByUser(long userId) {
		Transaction transaction = null;
		List<Kahoot> kahoots = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();
			System.out.println("Kahoots: " + kahoots);
			String query = "FROM Kahoot where FK_ID_user="+userId;
			kahoots = session.createQuery(query).list();
			System.out.println("Kahoots 2: " + kahoots);
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				System.out.println(e);
				transaction.rollback();
			}
		}
		return kahoots;
	}
}
