package co2103.lab18.repo;

import org.springframework.data.repository.CrudRepository;

import co2103.lab18.model.Agent;

public interface AgentRepository extends CrudRepository<Agent, Integer>{

	public Agent findByName(String name);

}
