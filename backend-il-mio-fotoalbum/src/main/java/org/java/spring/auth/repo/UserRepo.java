package org.java.spring.auth.repo;

import java.util.Optional;

import org.java.spring.auth.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
	public Optional<User> findByUsername(String username);
}
