package org.java.spring.services;

import java.util.Comparator;
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
	
	public List<Photo> orderById(List<Integer> photosIds){
		List<Photo> photos = repo.findAllById(photosIds);
		photos.sort(Comparator.comparingInt(Photo::getId));
		return photos;
	}
	
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
	 * Return a list of private Photo elements with the boolean "trashed" set to false by filtering according to the string given in input
	 * @return photos
	 */
	public List<Photo> filterByTitleForVisiblePhotos(String title) {
		return repo.findByTitleContainingAndVisibleTrue(title);
	}
	
	/**
	 * 
	 * Return all private Photo elements in the database with the boolean "trashed" set to false
	 * @return photos
	 */
	public List<Photo> findAllAvailablePhotos() {
		return repo.findByVisibleFalseAndTrashedFalse();
	}
	
	/**
	 * 
	 * Return all private Photo elements in the database with the boolean "trashed" set to true
	 * @return photos
	 */
	public List<Photo> findAllTrashedPhotos() {
		return repo.findByVisibleFalseAndTrashedTrue();
	}
	
	/**
	 * 
	 * Return a list of private Photo elements with the boolean "trashed" set to false by filtering according to the string given in input
	 * @return photos
	 */
	public List<Photo> filterByTitleForAvailablePhotos(String title) {
		return repo.findByTitleContainingAndVisibleFalseAndTrashedFalse(title);
	}
	
	/**
	 * 
	 * Return a list of private Photo elements with the boolean "trashed" set to true by filtering according to the string given in input
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
	 * Return a list of Photo elements without a User with the boolean trashed set to false
	 * @return photos
	 */
	public List<Photo> findAllPhotosWithoutUsers(){
		return repo.findByUserAndTrashedFalse(null);
	}
	
	/**
	 * 
	 * Return a list of Photo elements without a User with the boolean "trashed" set to true
	 * @return photos
	 */
	public List<Photo> findAllTrashedPhotosWithoutUsers(){
		return repo.findByUserAndTrashedTrue(null);
	}
	
	/**
	 * 
	 * Return all Photo elements with a User in the database with the boolean "trashed" set to false
	 * @return photos
	 */
	public List<Photo> findAllAvailablePhotos(User user) {
		return repo.findByUserAndTrashedFalse(user);
	}
	
	/**
	 * 
	 * Return all Photo elements  with a User in the database with the boolean "trashed" set to true
	 * @return photos
	 */
	public List<Photo> findAllTrashedPhotos(User user) {
		return repo.findByUserAndTrashedTrue(user);
	}
	
	/**
	 * 
	 * Return a list of Photo elements without a User with the boolean "trashed" set to false by filtering according to the 
	 * 	string given in input
	 * @return photos
	 */
	public List<Photo> filterByTitleForPhotosWithoutUsers(String title){
		return repo.findByUserAndTitleContainingAndTrashedFalse(null, title);
	}
	
	/**
	 * 
	 * Return a list of Photo elements without a User with the boolean "trashed" set to true by filtering according to the 
	 * 	string given in input
	 * @return photos
	 */
	public List<Photo> filterByTitleForTrashedPhotosWithoutUsers(String title){
		return repo.findByUserAndTitleContainingAndTrashedTrue(null, title);
	}
	
	/**
	 * 
	 * Return a list of Photo elements with a User with the boolean "trashed" 
	 * set to false by filtering according to the string given in input
	 * @return photos
	 */
	public List<Photo> filterByTitleForAvailablePhotos(User user , String title) {
		return repo.findByUserAndTitleContainingAndTrashedFalse(user,title);
	}
	
	/**
	 * 
	 * Return a list of Photo elements with a User with the boolean "trashed"
	 *  set to true by filtering according to the string given in input
	 * @return photos
	 */
	public List<Photo> filterByTitleForTrashedPhotos(User user , String title) {
		return repo.findByUserAndTitleContainingAndTrashedTrue(user , title);
	}
	
	/**
	 * 
	 * Return all Photo elements by a Role
	 * @return photos
	 */
	public List<Photo> findByRole(Role role){
		return repo.findByRole(role);
	}
	
	/**
	 * 
	 * Return all Photo elements by a Role in the database with the boolean "trashed" set to false
	 * @return photos
	 */
	public List<Photo> findAllAvailablePhotos(Role role){
		return repo.findByRoleAndVisibleFalseAndTrashedFalse(role);
	}
	
	/**
	 * 
	 * Return all Photo elements by a Role in the database with the boolean "trashed" set to true
	 * @return photos
	 */
	public List<Photo> findAllTrashedPhotos(Role role) {
		return repo.findByRoleAndVisibleFalseAndTrashedTrue(role);
	}
	
	/**
	 * 
	 * Return all Photo elements by a Role in the database with the boolean "trashed" set to false 
	 * by filtering according to the 
	 * 	string given in input
	 * @return photos
	 */
	public List<Photo> filterByTitleForAvailablePhotos(Role role , String title){
		return repo.findByRoleAndTitleContainingAndVisibleFalseAndTrashedFalse(role, title);
	}
	
	/**
	 * 
	 * Return all Photo elements by a Role in the database with the boolean "trashed" set to true 
	 * by filtering according to the 
	 * 	string given in input
	 * @return photos
	 */
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
