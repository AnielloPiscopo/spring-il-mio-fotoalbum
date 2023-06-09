package org.java.spring.services;

import java.util.List;
import java.util.Optional;

import org.java.spring.pojo.ContactMessage;
import org.java.spring.repo.ContactMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactMessageServ {
	@Autowired
	private ContactMessageRepo repo;
	
	/**
	 * 
	 * Return all ContactMessage elements in the database
	 * @return contactMessages
	 */
	public List<ContactMessage> findAll(){
		return repo.findAll();
	}
	
	/**
	 * 
	 * Return a ContactMessage element with an identical id to the given ones
	 * @return contactMessageOpt
	 */
	public Optional<ContactMessage> findById(int id) {
		return repo.findById(id);
	}
	
	/**
	 * 
	 * Save an element in the ContactMessage table of the database
	 */
	public void save(ContactMessage contactMessage) {
		repo.save(contactMessage);
	}
	
	/**
	 * 
	 * Delete an element from the ContactMessage table of the database
	 */
	public void delete(ContactMessage contactMessage) {
		repo.delete(contactMessage);
	}
	
	/**
	 * 
	 * Delete all elements from the ContactMessage table of the database
	 */
	public void deleteAll(List<ContactMessage> contactMessages) {
		repo.deleteAll(contactMessages);
	}
}
