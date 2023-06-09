package org.java.spring.services;

import java.util.List;
import java.util.Optional;

import org.java.spring.pojo.Photo;
import org.java.spring.repo.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoServ {
	@Autowired
	private PhotoRepo repo;
	
	/**
	 * 
	 * Return all Photo elements in the database
	 * @return photos
	 */
	public List<Photo> findAll() {
			return repo.findAll();
	}
	
	/**
	 * 
	 * Return all the Photo elements visible for all the users in the database
	 * @return photos
	 */
	public List<Photo> findAllVisiblePhotos() {
		return repo.findByVisibleTrue();
	}
	
	/**
	 * 
	 * Return all private Photo elements in the database with the boolean "deleted" set to false
	 * @return photos
	 */
	public List<Photo> findAllAvailablePhotos() {
		return repo.findByVisibleFalseAndTrashedFalse();
	}
	
	/**
	 * 
	 * Return all private Photo elements in the database with the boolean "deleted" set to true
	 * @return photos
	 */
	public List<Photo> findAllTrashedPhotos() {
		return repo.findByVisibleFalseAndTrashedTrue();
	}
	
	/**
	 * 
	 * Return a list of private Photo elements with the boolean "deleted" set to false by filtering according to the string given in input
	 * @return photos
	 */
	public List<Photo> filterByTitleForAvailablePhotos(String title) {
		return repo.findByTitleContainingAndVisibleFalseAndTrashedFalse(title);
	}
	
	/**
	 * 
	 * Return a list of private Photo elements with the boolean "deleted" set to true by filtering according to the string given in input
	 * @return photos
	 */
	public List<Photo> filterByTitleForTrashedPhotos(String title) {
		return repo.findByTitleContainingAndVisibleFalseAndTrashedTrue(title);
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
