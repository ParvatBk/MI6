package co2103.lab18.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Training {

	@Id
	@GeneratedValue
	private int id;
	
	private String topic;
	@ManyToOne
	@JoinColumn
	private Agent trainee;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Agent getTrainee() {
		return trainee;
	}

	public void setTrainee(Agent trainee) {
		this.trainee = trainee;
	}

	@Override
	public String toString() {
		return "Training [topic=" + topic + ", trainee=" + trainee.getName() + "]";
	}

}
