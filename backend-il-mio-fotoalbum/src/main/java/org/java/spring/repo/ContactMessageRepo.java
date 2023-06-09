package org.java.spring.repo;

import org.java.spring.pojo.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepo extends JpaRepository<ContactMessage, Integer> {

}
