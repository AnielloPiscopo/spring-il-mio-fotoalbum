package org.java.spring.repo;

import java.util.List;

import org.java.spring.auth.pojo.Role;
import org.java.spring.auth.pojo.User;
import org.java.spring.pojo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhotoRepo extends JpaRepository<Photo, Integer>{
	public List<Photo> findByTitleContaining(String title);
	
	public List<Photo> findByVisibleTrue();
	
	public List<Photo> findByVisibleFalseAndTrashedFalse();

	public List<Photo> findByVisibleFalseAndTrashedTrue();
	
	public List<Photo> findByTitleContainingAndVisibleTrue(String title);
	
	public List<Photo> findByTitleContainingAndVisibleFalseAndTrashedFalse(String title);
	
	public List<Photo> findByTitleContainingAndVisibleFalseAndTrashedTrue(String title);
	
	public List<Photo> findByUserAndVisibleFalseAndTrashedFalse(User user);

	public List<Photo> findByUserAndVisibleFalseAndTrashedTrue(User user);
	
	public List<Photo> findByUserAndTitleContainingAndVisibleFalseAndTrashedFalse(User user , String title);
	
	public List<Photo> findByUserAndTitleContainingAndVisibleFalseAndTrashedTrue(User user , String title);
	
	@Query(
		    "SELECT p " +
		    "FROM Photo p " +
		    "JOIN p.user u " +
		    "JOIN u.roles r " +
		    "WHERE r = ?1"
		)
	public List<Photo> findByRole(Role role);
	
	@Query(
		    "SELECT p " +
		    "FROM Photo p " +
		    "JOIN p.user u " +
		    "JOIN u.roles r " +
		    "WHERE r = ?1"
		)
	public List<Photo> findByRoleAndVisibleTrue(Role role);
	
	@Query(
		    "SELECT p " +
		    "FROM Photo p " +
		    "JOIN p.user u " +
		    "JOIN u.roles r " +
		    "WHERE r = ?1"
		)
	public List<Photo> findByRoleAndVisibleFalseAndTrashedFalse(Role role);
	
	@Query(
		    "SELECT p " +
		    "FROM Photo p " +
		    "JOIN p.user u " +
		    "JOIN u.roles r " +
		    "WHERE r = ?1"
		)
	public List<Photo> findByRoleAndVisibleFalseAndTrashedTrue(Role role);
	
	@Query(
		    "SELECT p " +
		    "FROM Photo p " +
		    "JOIN p.user u " +
		    "JOIN u.roles r " +
		    "WHERE r = ?1"
		)
	public List<Photo> findByRoleAndTitleContainingAndVisibleFalseAndTrashedFalse(Role role , String title);
	
	@Query(
		    "SELECT p " +
		    "FROM Photo p " +
		    "JOIN p.user u " +
		    "JOIN u.roles r " +
		    "WHERE r = ?1"
		)
	public List<Photo> findByRoleAndTitleContainingAndVisibleFalseAndTrashedTrue(Role role , String title);
}
