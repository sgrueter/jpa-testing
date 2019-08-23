package com.github.sgrueter.jpa.testing.persistence;

import com.github.sgrueter.jpa.testing.domain.Company;
import com.github.sgrueter.jpa.testing.domain.CompanyRepository;

import java.util.Objects;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class CompanyRepositoryJpa implements CompanyRepository {

	@Inject
	private EntityManager em;
	
	@Override
	public Optional<Company> find(long companyId) {
		Company foundCompany = em.find(Company.class, companyId);
		return Optional.ofNullable(foundCompany);
	}

	@Override
	public Company save(Company company) {
		Objects.requireNonNull(company);
		if (company.getId() == null) {
			em.persist(company);
			return company;
		}
		return em.merge(company);
	}

}
