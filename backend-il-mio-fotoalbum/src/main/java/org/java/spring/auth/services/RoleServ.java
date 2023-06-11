package org.java.spring.auth.services;

import java.util.List;
import java.util.Optional;

import org.java.spring.auth.pojo.Role;
import org.java.spring.auth.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServ {

	@Autowired
	private RoleRepo repo;
	
	public List<Role> findAll() {
		return repo.findAll();
	}
	
	public Optional<Role> findById(int id) {
		return repo.findById(id);
	}
	
	public Optional<Role> findByName(String name){
		return repo.findByName(name);
	}
	
	public Role save(Role role) {	
		return repo.save(role);
	}
}
