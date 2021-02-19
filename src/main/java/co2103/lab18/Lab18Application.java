package co2103.lab18;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import co2103.lab18.model.Agent;
import co2103.lab18.model.Raid;
import co2103.lab18.model.Training;
import co2103.lab18.repo.AgentRepository;
import co2103.lab18.repo.RaidRepository;
import co2103.lab18.repo.TrainingRepository;

@SpringBootApplication
public class Lab18Application implements ApplicationRunner {
	
	@Autowired
	private AgentRepository arepo;
	@Autowired
	private RaidRepository rrepo;
	@Autowired
	private TrainingRepository trepo;
	@Autowired
	private PasswordEncoder pe;
	

	public static void main(String[] args) {
		SpringApplication.run(Lab18Application.class, args);
	}

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		Agent a = new Agent();
		a.setName("Navy Seal");
		a.setConfirmedSkills(300);
		a.setPassword(pe.encode("password"));
		a.setSpecial(true);
		
		Agent b = new Agent();
		b.setName("Sleepy Tiger");
		b.setConfirmedSkills(300);
		b.setPassword(pe.encode("password"));
		b.setSpecial(false);
			
		a = arepo.save(a);
		
		Raid r = new Raid();
		r.setSecret(true);
		r.setTarget("El Quedo");
		
		r = rrepo.save(r);
		
		Training t = new Training();
		Training t1 = new Training();
		
		t.setTopic("Gorilla Warfare");
		t1.setTopic("Sofa Scratching");

		t = trepo.save(t);
		t1= trepo.save(t1);
				
		t.setTrainee(a);
		a.setTrainings(new ArrayList<>());
		a.getTrainings().add(t);
		
		t1.setTrainee(b);
		b.setTrainings(new ArrayList<>());
		b.getTrainings().add(t1);
		
		t = trepo.save(t);
		t1= trepo.save(t1);
		
		a.setRaids(new ArrayList<>());
		a.getRaids().add(r);
		
		a = arepo.save(a);
		b = arepo.save(b);
	}

}
