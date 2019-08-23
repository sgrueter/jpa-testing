package com.github.sgrueter.jpa.testing.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProducer {

	@PersistenceContext
	private EntityManager em;
	
	@Produces
	EntityManager produceEntityManager() {
		return em;
	}
}
