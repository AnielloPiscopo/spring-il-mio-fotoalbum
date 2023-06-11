package org.java.spring.auth.services;

import java.util.List;
import java.util.Optional;

import org.java.spring.auth.pojo.User;
import org.java.spring.auth.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServ implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public Optional<User> findById(int id) {	
		return repo.findById(id);
	}
	
	public Optional<User> findByUsername(String userName){
		return repo.findByUsername(userName);
	}
	
	public User save(User user) {	
		return repo.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		Optional<User> userOpt = repo.findByUsername(username);
		
		if (userOpt.isEmpty()) throw new UsernameNotFoundException("Username not found");
		
		return userOpt.get();
	}
}