package co2103.lab18.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co2103.lab18.model.Agent;
import co2103.lab18.repo.AgentRepository;


@Controller
public class AuthenticationController {
	@Autowired
	private AgentRepository arepo;
	
	@RequestMapping(value="/login-form", method=RequestMethod.GET)
	public String loginForm() {
		return "security/login";
	}
	
	@RequestMapping(value="/success-login", method=RequestMethod.GET)
	public String successLogin(Principal principal) {
		Agent agt = arepo.findByName(principal.getName());
		if(agt.isSpecial()) {
			return "redirect:/list";
		}
		return "redirect:/agent";	
	}
	
	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public String error() {
		return "security/denied";
	}
	

}
