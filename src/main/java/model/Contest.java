package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "contest")
public class Contest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@ManyToOne
	@JoinColumn(name = "kahoot_id")
	private Kahoot kahoot;
	
		
	@ManyToOne
	@JoinColumn(name = "player_id")
	private List<Player> player;


	public Contest() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Contest(Kahoot kahoot, List<Player> player) {
		super();
		this.kahoot = kahoot;
		this.player = player;
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
		return player;
	}


	public void setPlayers(List<Player> players) {
		this.player = players;
	}
	
	
	
}

