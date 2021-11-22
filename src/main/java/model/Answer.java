package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "answer")
	private String answer;
	
	@Column(name = "correct")
	private boolean correct;

	@ManyToOne
	@JoinColumn(name = "FK_ID_question")
	private Question question;
	

	@ManyToMany(mappedBy = "answers")
	private List<Player> players = new ArrayList<Player>();

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Answer(String answer, boolean correct, Question question) {
		super();
		this.answer = answer;
		this.correct = correct;
		this.question = question;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
	
	
}
