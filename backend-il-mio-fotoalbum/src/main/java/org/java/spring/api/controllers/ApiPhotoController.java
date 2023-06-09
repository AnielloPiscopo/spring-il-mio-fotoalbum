package org.java.spring.api.controllers;

import java.util.List;

import org.java.spring.pojo.Photo;
import org.java.spring.services.PhotoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/photos")
public class ApiPhotoController {
	
	@Autowired
	PhotoServ photoServ;
	
	/*
	 * 
	 * A Method that manages the index page by showing all the available Photo elements in a table
	 */
	@GetMapping() 
	public List<Photo> index(){
		return photoServ.findAllVisiblePhotos();
	}
	
	
}
