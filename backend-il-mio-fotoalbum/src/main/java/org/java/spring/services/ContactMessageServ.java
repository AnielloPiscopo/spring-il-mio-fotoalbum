package org.java.spring.services;

import java.util.List;
import java.util.Optional;

import org.java.spring.pojo.ContactMessage;
import org.java.spring.pojo.Photo;
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
	 * Return a Photo element with an identical id to the given ones
	 * @return photoOpt
	 */
	public Optional<Photo> findById(int id) {
		return repo.findById(id);
	}
	
	/**
	 * 
	 * Save an element in the Photo table of the database
	 */
	public void save(Photo photo) {
		repo.save(photo);
	}
	
	/**
	 * 
	 * Delete an element from the Photo table of the database
	 */
	public void delete(Photo photo) {
		repo.delete(photo);
	}
	
	/**
	 * 
	 * Delete all elements from the Photo table of the database
	 */
	public void deleteAll(List<Photo> photos) {
		repo.deleteAll(photos);
	}
}
