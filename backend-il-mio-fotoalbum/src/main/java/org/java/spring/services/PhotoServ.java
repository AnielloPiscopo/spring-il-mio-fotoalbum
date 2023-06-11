package org.java.spring.services;

import java.util.List;
import java.util.Optional;

import org.java.spring.auth.pojo.Role;
import org.java.spring.auth.pojo.User;
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
	 * Return a list of private Photo elements with the boolean "deleted" set to false by filtering according to the string given in input
	 * @return photos
	 */
	public List<Photo> filterByTitleForVisiblePhotos(String title) {
		return repo.findByTitleContainingAndVisibleTrue(title);
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
	
	public List<Photo> findAllPhotosWithoutUsers(){
		return repo.findByUserAndVisibleFalseAndTrashedFalse(null);
	}
	
	public List<Photo> findAllTrashedPhotosWithoutUsers(){
		return repo.findByUserAndVisibleFalseAndTrashedTrue(null);
	}
	
	/**
	 * 
	 * Return all private Photo elements in the database with the boolean "deleted" set to false
	 * @return photos
	 */
	public List<Photo> findAllAvailablePhotos(User user) {
		return repo.findByUserAndVisibleFalseAndTrashedFalse(user);
	}
	
	/**
	 * 
	 * Return all private Photo elements in the database with the boolean "deleted" set to true
	 * @return photos
	 */
	public List<Photo> findAllTrashedPhotos(User user) {
		return repo.findByUserAndVisibleFalseAndTrashedTrue(user);
	}
	
	public List<Photo> filterByTitleForPhotosWithoutUsers(String title){
		return repo.findByUserAndTitleContainingAndVisibleFalseAndTrashedFalse(null, title);
	}
	
	public List<Photo> filterByTitleForTrashedPhotosWithoutUsers(String title){
		return repo.findByUserAndTitleContainingAndVisibleFalseAndTrashedTrue(null, title);
	}
	
	/**
	 * 
	 * Return a list of private Photo elements with the boolean "deleted" set to false by filtering according to the string given in input
	 * @return photos
	 */
	public List<Photo> filterByTitleForAvailablePhotos(User user , String title) {
		return repo.findByUserAndTitleContainingAndVisibleFalseAndTrashedFalse(user,title);
	}
	
	/**
	 * 
	 * Return a list of private Photo elements with the boolean "deleted" set to true by filtering according to the string given in input
	 * @return photos
	 */
	public List<Photo> filterByTitleForTrashedPhotos(User user , String title) {
		return repo.findByUserAndTitleContainingAndVisibleFalseAndTrashedTrue(user , title);
	}
	
	public List<Photo> findByRole(Role role){
		return repo.findByRole(role);
	}
	
	public List<Photo> findAllAvailablePhotos(Role role){
		return repo.findByRoleAndVisibleFalseAndTrashedFalse(role);
	}
	
	public List<Photo> findAllTrashedPhotos(Role role) {
		return repo.findByRoleAndVisibleFalseAndTrashedTrue(role);
	}
	
	public List<Photo> filterByTitleForAvailablePhotos(Role role , String title){
		return repo.findByRoleAndTitleContainingAndVisibleFalseAndTrashedFalse(role, title);
	}
	
	public List<Photo> filterByTitleForTrashedPhotos(Role role , String title){
		return repo.findByRoleAndTitleContainingAndVisibleFalseAndTrashedTrue(role, title);
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
