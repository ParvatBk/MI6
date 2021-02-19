package co2103.lab18.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co2103.lab18.model.Agent;
import co2103.lab18.repo.AgentRepository;
import co2103.lab18.repo.RaidRepository;
import co2103.lab18.repo.TrainingRepository;

@Controller
public class ListController {
	
	@Autowired
	private AgentRepository arepo;
	@Autowired
	private RaidRepository rrepo;
	@Autowired
	private TrainingRepository trepo;
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("agents", arepo.findAll());
		model.addAttribute("trainings", trepo.findAll());
		model.addAttribute("raids", rrepo.findAll());
		return "list";
	}
	
	@GetMapping("/agent")
	public String agent(Principal principal,Model model) {
		Agent agt = arepo.findByName(principal.getName());
		
		model.addAttribute("agent", agt.getName());
		model.addAttribute("trainings", agt.getTrainings());
		model.addAttribute("raids", agt.getRaids());
		
		return "agent";
		
	}

}
