package app;

import dao.UserDao;
import model.User;

public class App {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		User user = new User("Alex", "Contrase�a1");
		userDao.saveUser(user);
	}
}
