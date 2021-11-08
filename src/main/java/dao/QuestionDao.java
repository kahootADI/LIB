package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Question;
import model.User;
import util.HibernateUtil;

public class QuestionDao {
	public void saveQuestion(Question question) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// save User object
			session.save(question);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public static Question getQuestionById(long id) {
		Transaction transaction = null;
		Question question = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// get User object
			//User = session.load(User.class, id);
			question = session.get(Question.class, id);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return question;
	}

}
