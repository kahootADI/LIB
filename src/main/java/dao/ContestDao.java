package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Contest;
import model.Question;
import util.HibernateUtil;

public class ContestDao {
	public void saveContest(Contest contest) {
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
	
	public static Contest getContestById(long id) {
		Transaction transaction = null;
		Contest contest = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// get User object
			//User = session.load(User.class, id);
			contest = session.get(Contest.class, id);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return contest;
	}
}
