package app;

import java.util.ArrayList;

import dao.AnswerDao;
import dao.ConcourseDao;
import dao.KahootDao;
import dao.PlayerDao;
import dao.QuestionDao;
import dao.UserDao;
import model.Answer;
import model.Concourse;
import model.Kahoot;
import model.Player;
import model.Question;
import model.User;
import util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		
		User user1 = new User("Leandro", "Zabala");
		User user2 = new User("Enric", "Mieza");
		User user3 = new User("Lluis", "Vila");
		
		userDao.saveUser(user1);
		userDao.saveUser(user2);
		userDao.saveUser(user3);
		
		PlayerDao playerDao = new PlayerDao();
		
		Player player1 = new Player("Nacho", "Hidalgo", "1234");
		Player player2 = new Player("Dani", "Nuño", "abcd" );
		Player player3 = new Player("Alex", "Larios", "1a2b");
		
		playerDao.savePlayer(player1);
		playerDao.savePlayer(player2);
		playerDao.savePlayer(player3);
		
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player1);
		players.add(player2);
		players.add(player3);
		
		
		KahootDao kahootDao = new KahootDao();
		
		Kahoot kahoot1 = new Kahoot("Equipos de Futbol", user1);
//		Kahoot kahoot2 = new Kahoot("Aplicaciones de Android", user2);
//		Kahoot kahoot3 = new Kahoot("Tipos de Arboles", user3);
		
		kahootDao.saveKahoot(kahoot1);
//		kahootDao.saveKahoot(kahoot2);
//		kahootDao.saveKahoot(kahoot3);
		
		QuestionDao questionDao = new QuestionDao();
		
		Question question1 = new Question("Donde juega el FC Barcelona?", kahoot1);
		Question question2 = new Question("Donde juega el FC Bayern?", kahoot1);
		Question question3 = new Question("Donde juega el PSG?", kahoot1);
		
		questionDao.saveQuestion(question1);
		questionDao.saveQuestion(question2);
		questionDao.saveQuestion(question3);
		
		
		AnswerDao answerDao = new AnswerDao();
		
		Answer answer1 = new Answer("Liga Santander", true, question1);
		Answer answer4 = new Answer("Premier League", false, question1);
		
		Answer answer2 = new Answer("Liga Santander", false, question2);
		Answer answer5 = new Answer("Premier League", false, question2);
		Answer answer8 = new Answer("Bundesliga", true, question2);
		
		Answer answer3 = new Answer("Liga Santander", false, question3);
		Answer answer6 = new Answer("Premier League", false, question3);
		Answer answer9 = new Answer("Bundesliga", false, question3);
		Answer answer10 = new Answer("Ligue 1", true, question3);
		
		answerDao.saveAnswer(answer1);
		answerDao.saveAnswer(answer2);
		answerDao.saveAnswer(answer3);
		answerDao.saveAnswer(answer4);
		answerDao.saveAnswer(answer5);
		answerDao.saveAnswer(answer6);
		answerDao.saveAnswer(answer8);
		answerDao.saveAnswer(answer9);
		answerDao.saveAnswer(answer10);
		
		ConcourseDao concourseDao = new ConcourseDao();
		Concourse concourse = new Concourse(kahoot1);
		concourseDao.saveConcourse(concourse);
		
		//table player_concourse
		for (Player p: players) {
			p.getConcourses().add(concourse);
			playerDao.updatePlayer(p);
		}
	}
}
