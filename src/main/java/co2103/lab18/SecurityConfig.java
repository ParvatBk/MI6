package co2103.lab18;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import co2103.lab18.service.AgentDetailsService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http.requiresChannel().anyRequest().requiresSecure()
		.and().formLogin()
			//set up the urls for login page and handlers
			.loginPage("/login-form")
			//this is the action for the login form
			//automatically performed by the Spring Security
			.loginProcessingUrl("/myLogin")
			//redirect to this url after successful login
			.defaultSuccessUrl("/success-login",true)
			//redirect to this url if login failed
			.failureUrl("/login-form")
			//permit all to access these requests
			.permitAll()
		.and().logout()
			//end the Https session and delete all the info about the session
			.invalidateHttpSession(true)
			// redirect to the following /logout url for 
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login-form")
			.permitAll()
		.and().authorizeRequests()
			.antMatchers("/list","/create*").hasRole("SPECIAL_AGENT")
			.antMatchers("/agent").hasAnyRole("ORDINARY_AGENT","SPECIAL_AGENT")
			.anyRequest().authenticated()
		.and().exceptionHandling().accessDeniedPage("/access-denied");
	}
	
	@Autowired
	private AgentDetailsService agentDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(agentDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}
