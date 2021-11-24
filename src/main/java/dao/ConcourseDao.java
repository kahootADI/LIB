package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Concourse;
import model.Question;
import model.User;
import util.HibernateUtil;

public class ConcourseDao {
	public void saveConcourse(Concourse contest) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// save User object
			session.save(contest);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public void updateConcourse(Concourse concourse) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// save User object
			session.saveOrUpdate(concourse);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	
	public static Concourse getConcourseById(long id) {
		Transaction transaction = null;
		Concourse concourse = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// get contest object
			concourse = session.get(Concourse.class, id);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return concourse;
	}
}
