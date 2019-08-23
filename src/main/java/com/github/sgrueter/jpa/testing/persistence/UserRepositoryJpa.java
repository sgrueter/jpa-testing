package com.github.sgrueter.jpa.testing.persistence;

import com.github.sgrueter.jpa.testing.domain.User;
import com.github.sgrueter.jpa.testing.domain.UserRepository;

import java.util.Objects;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class UserRepositoryJpa implements UserRepository {

	@Inject
	private EntityManager em;
	
	@Override
	public Optional<User> find(long userId) {
		User foundUser = em.find(User.class, userId);
		return Optional.ofNullable(foundUser);
	}

	@Override
	public User save(User user) {
		Objects.requireNonNull(user);
		if (user.getId() == null) {
			em.persist(user);
			return user;
		}
		return em.merge(user);
	}

}
