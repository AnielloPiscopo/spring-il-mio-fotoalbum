package org.java.spring.auth.repo;

import java.util.Optional;

import org.java.spring.auth.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
	public Optional<Role> findByName(String name);
}
