package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.Kahoot;
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
	
	@SuppressWarnings("unchecked")
	public static List<Question> getAllQuestionByKahoot(long kahootId) {
		Transaction transaction = null;
		List<Question> questions = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();
			System.out.println("Kahoots: " + questions);
			String query = "FROM Question where FK_ID_kahoot="+kahootId;
			questions = session.createQuery(query).list();
			System.out.println("Kahoots 3: " + questions);
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				System.out.println(e);
				transaction.rollback();
			}
		}
		return questions;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Question> getAllQuestionForNewKahoot() {
		Transaction transaction = null;
		List<Question> questions = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();
			Criteria cr = session.createCriteria(Question.class);
			questions = cr.add(Restrictions.isNull("kahoot")).list();
			System.out.println("Kahoots 3: " + questions);
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				System.out.println(e);
				transaction.rollback();
			}
		}
		return questions;
	}
	
	public static Question UpdateQuestionKahoot(Question question, Kahoot kahoot) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// get Question object
			question.setKahoot(kahoot);
			session.saveOrUpdate(question);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return question;
	}
	
	public static Question getQuestionById(long id) {
		Transaction transaction = null;
		Question question = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// get Question object
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
