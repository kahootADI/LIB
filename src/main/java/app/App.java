package app;

import java.util.ArrayList;

import dao.KahootDao;
import dao.PlayerDao;
import dao.QuestionDao;
import dao.UserDao;
import model.Kahoot;
import model.Player;
import model.Question;
import model.User;

public class App {
	public static void main(String[] args) {	
		
		
		/* FOR NEW USERS - ADMINS - TEACHERS
		UserDao userDao = new UserDao();
		User user = new User();
		userDao.saveUser(user);
		*/
		
		/* FOR NEW PLAYERS - STUDENTS
		PlayerDao playerDao =  new PlayerDao();
		Player player = new Player();
		playerDao.savePlayer(player);
		*/
		
		/* FOR NEW QUESTIONS WITH ANSWERS
		QuestionDao questionDao = new QuestionDao();
		ArrayList<String> respuestas = new ArrayList<String>();
		respuestas.add("OPCION 1");
		respuestas.add("OPCION 2");
		respuestas.add("OPCION 3");
		respuestas.add("OPCION 4");
		Question question = new Question();
		questionDao.saveQuestion(question);
		*/
		
		
		/* FOR NEW KAHOOTS 
		-- Create Question
		-- Create Kahoot with  Existing questions
		KahootDao kahootDao = new KahootDao();
		ArrayList<Question> preguntas = new ArrayList<Question>();
		preguntas.add(QuestionDao.getQuestionById(3));
		Kahoot kahoot = new Kahoot("Kahoot de prueba", preguntas, UserDao.getUserById(1));
		kahootDao.saveKahoot(kahoot);		
		System.out.println("Esto no funciona");
		*/
	}
}
