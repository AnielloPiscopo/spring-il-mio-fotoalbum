package org.java.spring.repo;

import java.util.List;

import org.java.spring.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	public List<Category> findByTrashedFalse();
	
	public List<Category> findByTrashedTrue();
}
