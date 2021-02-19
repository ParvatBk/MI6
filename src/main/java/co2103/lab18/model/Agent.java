package co2103.lab18.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Agent {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private int confirmedSkills;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "trainee", fetch = FetchType.LAZY)
	private List<Training> trainings;
	
	@ManyToMany
	private List<Raid> raids;
	
	private String password;
	private boolean special;
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSpecial() {
		return special;
	}

	public void setSpecial(boolean special) {
		this.special = special;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getConfirmedSkills() {
		return confirmedSkills;
	}

	public void setConfirmedSkills(int confirmedSkills) {
		this.confirmedSkills = confirmedSkills;
	}

	public List<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}

	public List<Raid> getRaids() {
		return raids;
	}

	public void setRaids(List<Raid> raids) {
		this.raids = raids;
	}

	@Override
	public String toString() {
		return "Agent [name=" + name + ", confirmedSkills=" + confirmedSkills + ", trainings=" + trainings + ", raids="
				+ raids + "]";
	}

}
