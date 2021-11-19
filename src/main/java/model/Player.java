package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "nickname")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "token")
	private String token;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "player_concourse", joinColumns = { @JoinColumn(name = "player_id") }, inverseJoinColumns = {
			@JoinColumn(name = "concourse_id") })
	private List<Concourse> concourses = new ArrayList<Concourse>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "player_answer", joinColumns = { @JoinColumn(name = "player_id") }, inverseJoinColumns = {
			@JoinColumn(name = "id") })
	private List<Answer> answers = new ArrayList<Answer>();

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(String username, String password, String token) {
		super();
		this.username = username;
		this.password = password;
		this.token = token;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<Concourse> getConcourses() {
		return concourses;
	}

	public void setConcourses(List<Concourse> concourses) {
		this.concourses = concourses;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
