package org.java.spring.services;

import java.util.List;
import java.util.Optional;

import org.java.spring.pojo.Category;
import org.java.spring.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServ {
	@Autowired
	private CategoryRepo repo;
	
	/**
	 * 
	 * Return all Category elements in the database
	 * @return categories
	 */
	public List<Category> findAll() {
			return repo.findAll();
	}
	
	/**
	 * 
	 * Return all Category elements in the database with the boolean "deleted" set to false
	 * @return categories
	 */
	public List<Category> findAllAvailableCategorys() {
		return repo.findByTrashedFalse();
	}
	
	/**
	 * 
	 * Return all Category elements in the database with the boolean "deleted" set to true
	 * @return categories
	 */
	public List<Category> findAllTrashedCategorys() {
		return repo.findByTrashedTrue();
	}
	
	/**
	 * 
	 * Return a Category element with an identical id to the given ones
	 * @return categoryOpt
	 */
	public Optional<Category> findById(int id) {
		return repo.findById(id);
	}
	
	/**
	 * 
	 * Save an element in the Category table of the database
	 */
	public void save(Category category) {
		repo.save(category);
	}
	
	/**
	 * 
	 * Delete an element from the Category table of the database
	 */
	public void delete(Category category) {
		repo.delete(category);
	}
	
	/**
	 * 
	 * Delete all elements from the Category table of the database
	 */
	public void deleteAll(List<Category> categories) {
		repo.deleteAll(categories);
	}
}
