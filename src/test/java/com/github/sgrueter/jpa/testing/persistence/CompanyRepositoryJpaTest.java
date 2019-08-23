package com.github.sgrueter.jpa.testing.persistence;

import com.github.sgrueter.jpa.testing.domain.Company;

import javax.inject.Inject;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CdiRunner.class)
@AdditionalClasses(TestEntityManagerProducer.class)
public class CompanyRepositoryJpaTest {

	@Inject
	private CompanyRepositoryJpa cut;

	@Test
	public void shouldSaveNewCompany() {
		Company company = cut.save(createCompany());
		Assert.assertNotNull(company.getId());
		Assert.assertEquals(0, company.getVersion().intValue());
	}

	@Test
	public void shouldFindSavedCompany() {
		Company company = cut.save(createCompany());
		Company foundCompany = cut.find(company.getId()).orElse(null);
		Assert.assertEquals(company.getId(), foundCompany.getId());
	}

	private Company createCompany() {
		Company company = new Company();
		company.setName("new company");		
		return company;
	}
}
