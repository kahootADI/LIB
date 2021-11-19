package app;

import dao.KahootDao;
import dao.PlayerDao;
import dao.UserDao;
import model.Kahoot;
import model.Player;
import model.User;
import util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		
		//La primera vez que se inicie la aplicacion hay que cambiar settings.put(Environment.HBM2DDL_AUTO, "none");
		// a settings.put(Environment.HBM2DDL_AUTO, "create") de la classe Hibernate util
		
		//HibernateUtil.getSessionFactory(); --> To create all tables		
	}
}
