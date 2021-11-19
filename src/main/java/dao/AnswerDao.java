package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Answer;
import model.Player;
import util.HibernateUtil;

public class AnswerDao {
	public void saveAnswer(Answer answer) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// save Player object
			session.save(answer);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	
	public static Answer getAnswerById(long id) {
		Transaction transaction = null;
		Answer answer = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// get Answer object
			answer = session.get(Answer.class, id);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return answer;
	}
}
