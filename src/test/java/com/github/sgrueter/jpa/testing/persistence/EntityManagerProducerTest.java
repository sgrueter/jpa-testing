package com.github.sgrueter.jpa.testing.persistence;

import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.Assert;

@RunWith(CdiRunner.class)
public class EntityManagerProducerTest {

	@Produces
	@Model
	private EntityManager mockedEntityManager;
	
	@Inject
	private EntityManagerProducer cut;
		
	@Test
	public void shouldProduceEntityManager() {
		Assert.assertEquals(mockedEntityManager, cut.produceEntityManager());
	}
}
