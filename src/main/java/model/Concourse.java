package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "concourse")
public class Concourse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@ManyToOne()
	@JoinColumn(name = "FK_ID_kahoot")
	private Kahoot kahoot;

	@ManyToMany(mappedBy = "concourses")
	private List<Player> players = new ArrayList<Player>();

	public Concourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Concourse(Kahoot kahoot) {
		super();
		this.kahoot = kahoot;
	}
	
	public Concourse(Kahoot kahoot, List<Player> players) {
		super();
		this.kahoot = kahoot;
		this.players = players;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Kahoot getKahoot() {
		return kahoot;
	}

	public void setKahoot(Kahoot kahoot) {
		this.kahoot = kahoot;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
}
