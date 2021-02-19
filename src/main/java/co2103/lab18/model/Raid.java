package co2103.lab18.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Raid {

	@Id
	@GeneratedValue
	private int id;
	
	private boolean secret;
	private String target;

	public boolean isSecret() {
		return secret;
	}

	public void setSecret(boolean secret) {
		this.secret = secret;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return "Raid [secret=" + secret + ", target=" + target + "]";
	}

}
