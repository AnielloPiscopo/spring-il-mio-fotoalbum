package org.java.spring.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.java.spring.auth.pojo.Role;
import org.java.spring.auth.pojo.User;
import org.java.spring.auth.services.RoleServ;
import org.java.spring.auth.services.UserServ;
import org.java.spring.pojo.Category;
import org.java.spring.pojo.Photo;
import org.java.spring.services.CategoryServ;
import org.java.spring.services.PhotoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/photos")
public class PhotoController {
	private final static String SUPERADMIN="SUPERADMIN";
	private static String pageTitle;
	
	private String getLoggedUserName() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		return userName;
	}
	
	private User getLoggedUser() {
		Optional<User> userOpt = userServ.findByUsername(getLoggedUserName());
		User user = userOpt.get();
		return user;
	}
	
	private String getLoggedUserRole() {
		String userRole = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().findFirst().map(GrantedAuthority::getAuthority).orElse("");
		return userRole;
	}
	
	private Role getSpecialRole(){
		Optional<Role> roleOpt = roleServ.findByName(SUPERADMIN);
		Role role = roleOpt.get();
		return role;
	}
	
	private void photoAccessibilityCheck(Photo photo) throws Exception {
		if(getLoggedUserRole().equals(SUPERADMIN)){
			if((!photo.isVisible()) && (!photo.getUser().getRoles().contains(getSpecialRole()))) {
				throw new IllegalAccessException();
			}
		}else if(!getLoggedUserRole().equals(SUPERADMIN)) {
			if(photo.getUser().getId()!=getLoggedUser().getId() || photo.isVisible()) {
				throw new IllegalAccessException();
			}
		}
	}
	
	private List<Photo> getAvailablePhotos(){
		List<Photo> photos = new ArrayList<>();
		
		if(getLoggedUserRole().equals(SUPERADMIN)) {
			photos.addAll(serv.findAllVisiblePhotos());
			photos.addAll(serv.findAllPhotosWithoutUsers());
			photos.addAll(serv.findAllAvailablePhotos(getSpecialRole()));
		}else {
			photos.addAll(serv.findAllAvailablePhotos(getLoggedUser()));			
		}
		
		return photos;
	}
	
	private List<Photo> getAvailablePhotosFilteredByTitle(String title){
		List<Photo> photos = new ArrayList<>();
		
		if(getLoggedUserRole().equals(SUPERADMIN)) {
			photos.addAll(serv.filterByTitleForVisiblePhotos(title));
			photos.addAll(serv.filterByTitleForPhotosWithoutUsers(title));
			photos.addAll(serv.filterByTitleForAvailablePhotos(getSpecialRole(), title));
		}else {
			photos.addAll(serv.filterByTitleForAvailablePhotos(getLoggedUser(), title));
		}
		
		return photos;
	}
	
	private List<Photo> getTrashedPhotos(){
		List<Photo> photos = new ArrayList<>();
		
		if(getLoggedUserRole() == SUPERADMIN) {
			photos.addAll(serv.findAllTrashedPhotosWithoutUsers());
			photos.addAll(serv.findAllTrashedPhotos(getSpecialRole()));
		}else {
			photos.addAll(serv.findAllTrashedPhotos(getLoggedUser()));
		}
		
		return photos;
	}
	
	private List<Photo> getTrashedPhotosFilteredByTitle(String title){
		List<Photo> photos = new ArrayList<>();
		
		if(getLoggedUserRole() == SUPERADMIN) {
			photos.addAll(serv.filterByTitleForTrashedPhotosWithoutUsers(title));
			photos.addAll(serv.filterByTitleForTrashedPhotos(getSpecialRole(), title));
		}else {
			photos.addAll(serv.filterByTitleForTrashedPhotos(getLoggedUser(), title));
		}
		
		return photos;
	}
	
	/**
	 * 
	 * Return the HTML file to view in the Page(index/trash) and with the model add to this one a list of Photo elements and the title for the page
	 * @return template
	 */
	private String getPhotoTableTemplate(List<Photo> photos , String title , String template , Model model) {
		model.addAttribute("photos" , photos);
		model.addAttribute("title" , title);
		model.addAttribute("user" , getLoggedUserName());
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
			getPhotoFormTemplate(photo, title, btnText, templateToRedirect, model);
			return templateToEdit;
		}
		
		if(getLoggedUserRole()!=SUPERADMIN) photo.setVisible(false);
		
		photo.setUser(getLoggedUser());
		
		serv.save(photo);
		return templateToRedirect;
	}
	
	/**
	 * 
	 * Return the HTML file to view in the Page(create/edit) and with the model add to this one a Photo element, the title for the page , a text for the the button of the form
	 * @return template
	 */
	private String getPhotoFormTemplate(Photo photo , String title , String btnText , String template , Model model) {
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
		if(!photo.isVisible()) {
			photo.setTrashed(trashed);
			serv.save(photo);
		}
	}
	
	@Autowired
	private PhotoServ serv;
	
	@Autowired
	private CategoryServ categoryServ;
	
	@Autowired
	private UserServ userServ;
	
	@Autowired
	private RoleServ roleServ;
	
	/*
	 * 
	 * A Method that manages the index page by showing all the available Photo elements in a table
	 */
	@GetMapping
	public String index(Model model ) {
		return getPhotoTableTemplate(getAvailablePhotos() , "Lista foto ", "view/admin/photo/index" , model);
	}
	
	/*
	 * 
	 * A Method that manages the index page after a POST call for the filtering of the Photo elements according to the string given in the form
	 */
	@PostMapping
	public String index(Model model , @RequestParam(name = "title") String title) {
		return getPhotoTableTemplate(getAvailablePhotosFilteredByTitle(title) , "Lista foto" , "view/admin/photo/index" , model);
	}
	
	/*
	 * 
	 * A Method that manages the show page by showing the single Photo element details
	 */
	@GetMapping("/{id}")
	public String show(Model model , @PathVariable("id") int id) {
		try {
			Optional<Photo> optPhoto = serv.findById(id);
			Photo photo = optPhoto.get();
			
			photoAccessibilityCheck(photo);
			
			pageTitle = "Photo " + photo.getTitle();
			model.addAttribute("photo" , photo);
			model.addAttribute("title" , pageTitle);
			return "view/admin/photo/show";
		}catch(IllegalAccessException e){
			throw new ResponseStatusException(HttpStatus.LOCKED , "Access Locked");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Photo with id " + id + " not found");
		}
	}
	
	/*
	 * 
	 * A Method that manages the create page by showing the necessary form to create a new Photo element
	 */
	@GetMapping("/create")
	public String create(Model model) {
		return getPhotoFormTemplate(new Photo() , "Creazione foto" , "Aggiungi alla lista la foto" , "view/admin/photo/create" , model);
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
		try {
			Optional<Photo> optPhoto = serv.findById(id);
			Photo photo = optPhoto.get();
			
			photoAccessibilityCheck(photo);
			
			
			pageTitle = "Modifica la photo: " + photo.getTitle();
			return getPhotoFormTemplate(photo , pageTitle , "Modifica elemento" , "view/admin/photo/edit" , model);
		}catch(IllegalAccessException e){
			throw new ResponseStatusException(HttpStatus.LOCKED , "Access Locked");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Photo with id " + id + " not found");
		}
		
	}
	
	/*
	 * 
	 * A Method that manages the update of a Photo element in the database
	 */
	@PostMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("photo") Photo photo , BindingResult br , Model model) {
		pageTitle = "Modifica la photo: " + photo.getTitle();
		return saveInDb(photo, br , "view/admin/photo/edit" , "redirect:/photos/" + photo.getId() , pageTitle , "Modifica elemento" , model);
	}
	
	/*
	 * 
	 * A Method that manages the trash page by showing all the trashed Photo elements in a table
	 */
	@GetMapping("/trash")
	public String trash(Model model ) {
		return getPhotoTableTemplate(getTrashedPhotos() , "Lista foto cestinate" , "view/admin/photo/trash" , model);
	}
	
	/*
	 * 
	 * A Method that manages the trash page after a POST call for the filtering of the Photo elements according to the string given in the form
	 */
	@PostMapping("/trash")
	public String trash(Model model , @RequestParam(name = "title") String title) {
		return getPhotoTableTemplate(getTrashedPhotosFilteredByTitle(title) , "Lista foto cestinate" , "view/admin/photo/trash" , model);
	}
	
	/*
	 * 
	 * A Method that manages the soft-delete of a Photo element
	 */
	@PostMapping("/soft-delete/{id}")
	public String softDelete(@PathVariable("id") int id) {
		try {
			Optional<Photo> optPhoto = serv.findById(id);
			Photo photo = optPhoto.get();
			
			photoAccessibilityCheck(photo);
			
			changeTheTrashedValue(photo, true);
			
			return "redirect:/photos";
		}catch(IllegalAccessException e){
			throw new ResponseStatusException(HttpStatus.LOCKED , "Access Locked");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Photo with id " + id + " not found");
		}
		
	}
	
	/*
	 * 
	 * A Method that manages the soft-delete of all Photo elements
	 */
	@PostMapping("/soft-delete-all")
	public String softDeleteAll() {
		List<Photo> photos = getAvailablePhotos();
		photos.stream().forEach(photo -> changeTheTrashedValue(photo, true));
		return "redirect:/photos";
	}
	
	/*
	 * 
	 * A Method that manages the refresh of a Photo element
	 */
	@PostMapping("/refresh/{id}")
	public String refresh(@PathVariable("id") int id) {
		try {
			Optional<Photo> optPhoto = serv.findById(id);
			Photo photo = optPhoto.get();
			
			photoAccessibilityCheck(photo);
			
			changeTheTrashedValue(photo, false);
			
			return "redirect:/photos/trash";
		} catch(IllegalAccessException e){
			throw new ResponseStatusException(HttpStatus.LOCKED , "Access Locked");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Photo with id " + id + " not found");
		}
		
	}
	
	/*
	 * 
	 * A Method that manages the refresh of all Photo elements
	 */
	@PostMapping("/refresh-all")
	public String refreshAll() {
		List<Photo> photos = getTrashedPhotos();
		photos.stream().forEach(photo -> changeTheTrashedValue(photo, false));
		return "redirect:/photos/trash";
	}
	
	/*
	 * 
	 * A Method that manages the delete of a Photo element
	 */
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		try {
			Optional<Photo> optPhoto = serv.findById(id);
			Photo photo = optPhoto.get();
			
			photoAccessibilityCheck(photo);
			
			serv.delete(photo);
			
			return "redirect:/photos/trash";
		} catch(IllegalAccessException e){
			throw new ResponseStatusException(HttpStatus.LOCKED , "Access Locked");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Photo with id " + id + " not found");
		}
		
	}
	
	/*
	 * 
	 * A Method that manages the delete of all Photo elements
	 */
	@PostMapping("/delete-all")
	public String deleteAll() {
		List<Photo> photos = getTrashedPhotos();
		serv.deleteAll(photos);
		return "redirect:/photos/trash";
	}
}
