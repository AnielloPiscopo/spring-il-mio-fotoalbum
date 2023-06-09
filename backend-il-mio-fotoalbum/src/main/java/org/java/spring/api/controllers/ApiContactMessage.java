package org.java.spring.api.controllers;

import org.java.spring.pojo.ContactMessage;
import org.java.spring.services.ContactMessageServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/contact-messages")
public class ApiContactMessage {
	@Autowired
	ContactMessageServ cmServ;
	
	/*
	 * 
	 * A Method that manages the store of a ContactMessage element in the database
	 */
	@PostMapping("/store")
	public ResponseEntity<ContactMessage> store(
			@RequestBody ContactMessage cm) {
		cmServ.save(cm);
		
		return new ResponseEntity<ContactMessage>(HttpStatus.OK);	
	}
}
