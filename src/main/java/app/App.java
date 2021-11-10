package app;

import dao.UserDao;
import model.User;

public class App {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		User user = new User("Alex", "Contraseña1");
		userDao.saveUser(user);
	}
}
