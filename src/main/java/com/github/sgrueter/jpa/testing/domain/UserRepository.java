package com.github.sgrueter.jpa.testing.domain;

import java.util.Optional;

public interface UserRepository {

	Optional<User> find(long userId);
	
	User save(User user);
}
