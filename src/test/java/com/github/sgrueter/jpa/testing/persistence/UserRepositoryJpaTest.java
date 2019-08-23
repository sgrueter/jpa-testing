package com.github.sgrueter.jpa.testing.persistence;

import com.github.sgrueter.jpa.testing.domain.Company;
import com.github.sgrueter.jpa.testing.domain.User;

import javax.inject.Inject;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CdiRunner.class)
@AdditionalClasses(TestEntityManagerProducer.class)
public class UserRepositoryJpaTest {

	@Inject
	private UserRepositoryJpa cut;
	
	@Test
	public void shouldSaveNewUser() {
		User user = cut.save(createUser());
		Assert.assertNotNull(user.getId());
		Assert.assertEquals(0, user.getVersion().intValue());
		Assert.assertNotNull(user.getCompany().getId());
		Assert.assertEquals(0, user.getCompany().getVersion().intValue());
	}
	
	@Test
	public void shouldFindSavedUser() {
		User user = cut.save(createUser());
		User foundUser = cut.find(user.getId()).orElse(null);
		Assert.assertEquals(user.getId(), foundUser.getId());
	}
	
	private User createUser() {
		Company company = new Company();
		company.setName("new company");		
		User user = new User();
		user.setFirstName("new");
		user.setLastName("user");
		user.setCompany(company);
		return user;
	}
}
