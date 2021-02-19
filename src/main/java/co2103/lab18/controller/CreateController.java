package co2103.lab18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import co2103.lab18.model.Agent;
import co2103.lab18.model.Raid;
import co2103.lab18.model.Training;
import co2103.lab18.repo.AgentRepository;
import co2103.lab18.repo.RaidRepository;
import co2103.lab18.repo.TrainingRepository;

@Controller
public class CreateController {
	
	@Autowired
	private AgentRepository arepo;
	@Autowired
	private RaidRepository rrepo;
	@Autowired
	private TrainingRepository trepo;

	@RequestMapping("/createAgent")
	public String createAgent() {
		Agent a = new Agent();
		a.setName("Agent" + (int)(Math.random()*100));
		a.setConfirmedSkills((int)(Math.random()*100));
		arepo.save(a);
		return "redirect:/list";
	}
	
	@RequestMapping("/createRaid")
	public String createRaid() {
		Raid r = new Raid();
		r.setTarget("xy" + (int)(Math.random()*100));
		r.setSecret(Math.random() > 0.5);
		rrepo.save(r);
		return "redirect:/list";
	}
	
	@RequestMapping("/createTraining")
	public String createTraining() {
		Training t = new Training();
		t.setTopic("Mathematics " + (int)(Math.random()*100));
		t.setTrainee(arepo.findAll().iterator().next());
		trepo.save(t);		
		return "redirect:/list";
	}
}
