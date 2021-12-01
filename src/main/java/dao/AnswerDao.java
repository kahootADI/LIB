package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Answer;
import model.Player;
import model.Question;
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
	
	@SuppressWarnings("unchecked")
	public static List getAllAnswerByQuestion(long questionId) {
		Transaction transaction = null;
		List answers = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();
			System.out.println("Kahoots: " + answers);
			String query = "FROM Answer where FK_ID_question="+questionId;
			answers = session.createQuery(query).list();
			System.out.println("Kahoots 4: " + answers);
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				System.out.println(e);
				transaction.rollback();
			}
		}
		return answers;
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
	
	public static Answer getAnswerByNameAndQuestion(String name, long questionId) {
		Transaction transaction = null;
		Answer answer = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();
			String query = "FROM Answer where Answer="+name+"and FK_ID_question="+questionId;
			answer = (Answer) session.createSQLQuery(query).uniqueResult();
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				System.out.println(e);
				transaction.rollback();
			}
		}
		return answer;
	}
}
