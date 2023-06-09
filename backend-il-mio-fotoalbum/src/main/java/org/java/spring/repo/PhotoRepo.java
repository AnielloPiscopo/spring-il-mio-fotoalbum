package org.java.spring.repo;

import java.util.List;

import org.java.spring.pojo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepo extends JpaRepository<Photo, Integer>{
	public List<Photo> findByTitleContaining(String title);
	
	public List<Photo> findByVisibleTrue();
	
	public List<Photo> findByVisibleFalseAndTrashedFalse();

	public List<Photo> findByVisibleFalseAndTrashedTrue();
	
	public List<Photo> findByTitleContainingAndVisibleTrue(String title);
	
	public List<Photo> findByTitleContainingAndVisibleFalseAndTrashedFalse(String title);
	
	public List<Photo> findByTitleContainingAndVisibleFalseAndTrashedTrue(String title);
}
