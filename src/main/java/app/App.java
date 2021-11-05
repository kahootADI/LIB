package app;

import java.util.List;

import dao.UserDao;
import model.User;

public class App {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		User user = new User("Alex", "Larios");
		User user2 = new User("Pepe", "Viyuela");
		User user3 = new User("Mario", "Casas");
		User user4 = new User("Paco", "Leon");
		User user5 = new User("Penelope", "Cruz");

		userDao.saveUser(user);
		userDao.saveUser(user2);
		userDao.saveUser(user3);
		userDao.saveUser(user4);
		userDao.saveUser(user5);



		List<User> users = userDao.getAllUser();
		users.forEach(User7 -> System.out.println(User7.getId()));
	}

}
