package com.github.sgrueter.jpa.testing.domain;

import java.util.Optional;

public interface CompanyRepository {

	Optional<Company> find(long companyId);

	Company save(Company company);
}
