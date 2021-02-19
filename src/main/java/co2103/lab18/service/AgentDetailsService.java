package co2103.lab18.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co2103.lab18.model.Agent;
import co2103.lab18.repo.AgentRepository;

@Service
public class AgentDetailsService implements UserDetailsService {
	@Autowired
	private AgentRepository arepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Agent userAgent = arepo.findByName(username);
		
		List <GrantedAuthority> authorities = new ArrayList <GrantedAuthority> ();
		if(userAgent.isSpecial()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_SPECIAL_AGENT"));
		}else {
			authorities.add(new SimpleGrantedAuthority("ROLE_ORDINARY_AGENT"));
		}
		return new User(userAgent.getName(), userAgent.getPassword(),true,true,true,true,authorities);
	}

}
