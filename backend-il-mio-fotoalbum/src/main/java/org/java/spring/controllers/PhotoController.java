package org.java.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.java.spring.pojo.Category;
import org.java.spring.pojo.Photo;
import org.java.spring.services.CategoryServ;
import org.java.spring.services.PhotoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/photos")
public class PhotoController {
	private static String pageTitle;
	
	/**
	 * 
	 * Return the HTML file to view in the Page(index/trash) and with the model add to this one a list of Photo elements and the title for the page
	 * @return template
	 */
	private String getPhotos(List<Photo> photos , String title , String template , Model model) {
		model.addAttribute("photos" , photos);
		model.addAttribute("title" , title);
		return template;
	}
	
	/**
	 * 
	 * Return a redirect to a specific web page and with the model add to this one a Photo element , a list of eventual errors , a text for the title of the page , a text for the title of the button of the form
	 * @return templateToRedirect
	 */
	private String saveInDb(Photo photo , BindingResult br , String templateToEdit , String templateToRedirect , String title , String btnText , Model model) {
		if(br.hasErrors()) {
			model.addAttribute("errors" , br);
			modifyOrCreatePhoto(photo, title, btnText, templateToRedirect, model);
			return templateToEdit;
		}
		
		serv.save(photo);
		return templateToRedirect;
	}
	
	/**
	 * 
	 * Return the HTML file to view in the Page(create/edit) and with the model add to this one a Photo element, the title for the page , a text for the the button of the form
	 * @return template
	 */
	private String modifyOrCreatePhoto(Photo photo , String title , String btnText , String template , Model model) {
		List<Category> categories = categoryServ.findAll();
		model.addAttribute("categories" , categories);
		model.addAttribute("btnText" , btnText);
		model.addAttribute("photo", photo);
		model.addAttribute("title" , title);
		return template;
	}
	
	/**
	 * 
	 * Change the boolean trashed value of a Photo element 
	 */
	private void changeTheTrashedValue(Photo photo , boolean trashed) {
		photo.setTrashed(trashed);
		serv.save(photo);
	}
	
	@Autowired
	private PhotoServ serv;
	
	@Autowired
	private CategoryServ categoryServ;
	
	/*
	 * 
	 * A Method that manages the index page by showing all the available Photo elements in a table
	 */
	@GetMapping
	public String index(Model model ) {
		List<Photo> photos = serv.findAllAvailablePhotos();
		return getPhotos(photos , "Lista foto" , "view/admin/photo/index" , model);
	}
	
	/*
	 * 
	 * A Method that manages the index page after a POST call for the filtering of the Photo elements according to the string given in the form
	 */
	@PostMapping
	public String index(Model model , @RequestParam(name = "title") String title) {
		List<Photo> photos = serv.filterByTitleForAvailablePhotos(title);
		return getPhotos(photos , "Lista foto" , "view/admin/photo/index" , model);
	}
	
	/*
	 * 
	 * A Method that manages the show page by showing the single Photo element details
	 */
	@GetMapping("/{id}")
	public String show(Model model , @PathVariable("id") int id) {
		Optional<Photo> optPhoto = serv.findById(id);
		Photo photo = optPhoto.get();
		pageTitle = "Photo " + photo.getTitle();
		model.addAttribute("photo" , photo);
		model.addAttribute("title" , pageTitle);
		return "view/admin/photo/show";
	}
	
	/*
	 * 
	 * A Method that manages the create page by showing the necessary form to create a new Photo element
	 */
	@GetMapping("/create")
	public String create(Model model) {
		return modifyOrCreatePhoto(new Photo() , "Creazione foto" , "Aggiungi alla lista la foto" , "view/admin/photo/create" , model);
	}
	
	/*
	 * 
	 * A Method that manages the store of a Photo element in the database
	 */
	@PostMapping("/create")
	public String store(@Valid @ModelAttribute("photo") Photo photo , BindingResult br , Model model) {
		return saveInDb(photo, br , "view/admin/photo/create" ,  "redirect:/photos" , "Creazione foto" , "Aggiungi alla lista la foto" , model);
	}
	
	/*
	 * 
	 * A Method that manages the edit page by showing the necessary form to edit the Photo element
	 */
	@GetMapping("/edit/{id}")
	public String edit(Model model , @PathVariable("id") int id) {
		Optional<Photo> optPhoto = serv.findById(id);
		Photo photo = optPhoto.get();
		pageTitle = "Modifica la photo: " + photo.getTitle();
		return modifyOrCreatePhoto(photo , pageTitle , "Modifica elemento" , "view/admin/photo/edit" , model);
	}
	
	/*
	 * 
	 * A Method that manages the update of a Photo element in the database
	 */
	@PostMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("photo") Photo photo , BindingResult br , Model model) {
		pageTitle = "Modifica la photo: " + photo.getTitle();
		return saveInDb(photo, br , "view/admin/photo/edit" , "redirect:/photos" + photo.getId() , pageTitle , "Modifica elemento" , model);
	}
	
	/*
	 * 
	 * A Method that manages the trash page by showing all the trashed Photo elements in a table
	 */
	@GetMapping("/trash")
	public String trash(Model model ) {
		List<Photo> photos = serv.findAllTrashedPhotos();
		return getPhotos(photos , "Lista foto cestinate" , "view/admin/photo/trash" , model);
	}
	
	/*
	 * 
	 * A Method that manages the trash page after a POST call for the filtering of the Photo elements according to the string given in the form
	 */
	@PostMapping("/trash")
	public String trash(Model model , @RequestParam(name = "title") String title) {
		List<Photo> photos = serv.filterByTitleForTrashedPhotos(title);
		return getPhotos(photos , "Lista foto cestinate" , "view/admin/photo/trash" , model);
	}
	
	/*
	 * 
	 * A Method that manages the soft-delete of a Photo element
	 */
	@PostMapping("/soft-delete/{id}")
	public String softDelete(@PathVariable("id") int id) {
		Optional<Photo> optPhoto = serv.findById(id);
		Photo photo = optPhoto.get();
		changeTheTrashedValue(photo, true);
		return "redirect:/photos";
	}
	
	/*
	 * 
	 * A Method that manages the soft-delete of all Photo elements
	 */
	@PostMapping("/soft-delete-all")
	public String softDeleteAll() {
		List<Photo> photos = serv.findAllAvailablePhotos();
//		for(Photo photo : photos) {
//			changeTheTrashedValue(photo, true);
//		}
		photos.stream().forEach(photo -> changeTheTrashedValue(photo, true));
		return "redirect:/photos";
	}
	
	/*
	 * 
	 * A Method that manages the refresh of a Photo element
	 */
	@PostMapping("/refresh/{id}")
	public String refresh(@PathVariable("id") int id) {
		Optional<Photo> optPhoto = serv.findById(id);
		Photo photo = optPhoto.get();
		changeTheTrashedValue(photo, false);
		return "redirect:/photos/trash";
	}
	
	/*
	 * 
	 * A Method that manages the refresh of all Photo elements
	 */
	@PostMapping("/refresh-all")
	public String refreshAll() {
		List<Photo> photos = serv.findAllTrashedPhotos();
//		for(Photo photo : photos) {
//			changeTheTrashedValue(photo, false);
//		}
		photos.stream().forEach(photo -> changeTheTrashedValue(photo, false));
		return "redirect:/photos/trash";
	}
	
	/*
	 * 
	 * A Method that manages the delete of a Photo element
	 */
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		Optional<Photo> optPhoto = serv.findById(id);
		Photo photo = optPhoto.get();
		serv.delete(photo);
		return "redirect:/photos/trash";
	}
	
	/*
	 * 
	 * A Method that manages the delete of all Photo elements
	 */
	@PostMapping("/delete-all")
	public String deleteAll() {
		List<Photo> photos = serv.findAllTrashedPhotos();
		serv.deleteAll(photos);
		return "redirect:/photos/trash";
	}
}
