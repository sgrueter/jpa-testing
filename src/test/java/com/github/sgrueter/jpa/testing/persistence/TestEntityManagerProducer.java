package com.github.sgrueter.jpa.testing.persistence;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jglue.cdiunit.ProducesAlternative;

@ApplicationScoped
public class TestEntityManagerProducer {

	private EntityManagerFactory emf;
	
	@PostConstruct
	void init() {
		emf = Persistence.createEntityManagerFactory("standalonePu");
	}

	@Produces
	@ProducesAlternative
	@ApplicationScoped
	EntityManager createEntityManager() {
		return emf.createEntityManager();
	}

}
