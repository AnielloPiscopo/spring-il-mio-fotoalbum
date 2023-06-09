package org.java.spring.repo;

import java.util.List;

import org.java.spring.pojo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepo extends JpaRepository<Photo, Integer>{
	public List<Photo> findByTitleContaining(String title);
	
	public List<Photo> findByTrashedFalse();

	public List<Photo> findByTrashedTrue();
	
	public List<Photo> findByTitleContainingAndTrashedFalse(String title);
	
	public List<Photo> findByTitleContainingAndTrashedTrue(String title);
}
