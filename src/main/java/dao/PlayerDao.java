package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Player;
import util.HibernateUtil;

public class PlayerDao {
	public void savePlayer(Player player) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// save Player object
			session.save(player);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public void updatePlayer(Player player) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// save Player object
			session.saveOrUpdate(player);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public static Player getPlayerById(long id) {
		Transaction transaction = null;
		Player player = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// get Player object
			//Player = session.load(Player.class, id);
			player = session.get(Player.class, id);
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return player;
	}
	
	@SuppressWarnings("unchecked")
	public List<Player> getAllPlayer() {
		Transaction transaction = null;
		List<Player> players = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();

			// get Player object
			//Player = session.load(Player.class, id);
			players = session.createQuery("from player").list();
			
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return players;
	}
	
	public void deletePlayer(long id) {
		Transaction transaction = null;
		Player player = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start the trasaction
			transaction = session.beginTransaction();
			
			player = session.get(Player.class, id);
			// save Player object
			session.remove(player);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
}
