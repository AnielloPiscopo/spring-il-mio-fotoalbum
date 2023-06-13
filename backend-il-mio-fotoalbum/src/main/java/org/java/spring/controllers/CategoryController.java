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

import jakarta.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	/**
	 * 
	 * Return the HTML file to view in the Page(index/trash) and with the model add to this one a list of Category elements and the title for the page
	 * @return template
	 */
	private String getCategoryTableTemplate(List<Category> categories , String title , String template , Model model) {
		model.addAttribute("categories" , categories);
		model.addAttribute("title" , title);
		return template;
	}
	
	/**
	 * 
	 * Return a redirect to a specific web page and with the model add to this one a Category element , a list of eventual errors , a text for the title of the page , a text for the title of the button of the form
	 * @return templateToRedirect
	 */
	private String saveInDb(Category category , Model model , BindingResult br) {
		if(br.hasErrors()) {
			model.addAttribute("errors" , br);
			return "redirect:/categories";
		}

		serv.save(category);
		return "redirect:/categories";
	}
	
	/**
	 * 
	 * Change the boolean trashed value of a Category element 
	 */
	private void changeTheTrashedValue(Category category , boolean trashed) {
		category.setTrashed(trashed);
		serv.save(category);
	}
	
	/**
	 * 
	 * Remove a Category element from all its Photo elements 
	 */
	private void removeCategoryFromPhotos(Category i) {
		for(Photo p : i.getPhotos()) {
			p.removeCategory(i);
			photoServ.save(p);
		}
	}
	
	@Autowired
	private CategoryServ serv;
	
	@Autowired
	private PhotoServ photoServ;
	
	/*
	 * 
	 * A Method that manages the index page by showing all the available Category elements in a table
	 */
	@GetMapping()
	public String index(Model model ) {
		List<Category> categories = serv.findAllAvailableCategorys();
		return getCategoryTableTemplate(categories , "Lista categorie" , "view/admin/category/index" , model);
	}
	
	/*
	 * 
	 * A Method that manages the store of a Category element in the database
	 */
	@PostMapping("/create")
	public String store(@Valid @ModelAttribute("category") Category category , Model model , BindingResult br) {
		return saveInDb(category , model , br);
	}
	
	@PostMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("category") Category category , Model model , BindingResult br ) {
		return saveInDb(category , model , br);
	}
	
	/*
	 * 
	 * A Method that manages the trash page by showing all the trashed Category elements in a table
	 */
	@GetMapping("/trash")
	public String trash(Model model ) {
		List<Category> categories = serv.findAllTrashedCategorys();
		return getCategoryTableTemplate(categories , "Lista categorie cestinate" , "view/admin/category/trash" , model);
	}
	
	/*
	 * 
	 * A Method that manages the soft-delete of a Category element
	 */
	@PostMapping("/soft-delete/{id}")
	public String softDelete(@PathVariable("id") int id) {
		Optional<Category> optCategory = serv.findById(id);
		Category category = optCategory.get();
		changeTheTrashedValue(category, true);
		return "redirect:/categories";
	}
	
	/*
	 * 
	 * A Method that manages the soft-delete of all Category elements
	 */
	@PostMapping("/soft-delete-all")
	public String softDeleteAll() {
		List<Category> categories = serv.findAllAvailableCategorys();
		categories.stream().forEach(i->changeTheTrashedValue(i, true));
		return "redirect:/categories";
	}
	
	/*
	 * 
	 * A Method that manages the refresh of a Category element
	 */
	@PostMapping("/refresh/{id}")
	public String refresh(@PathVariable("id") int id) {
		Optional<Category> optCategory = serv.findById(id);
		Category category = optCategory.get();
		changeTheTrashedValue(category, false);
		return "redirect:/categories/trash";
	}
	
	/*
	 * 
	 * A Method that manages the refresh of all Category elements
	 */
	@PostMapping("/refresh-all")
	public String refreshAll() {
		List<Category> categories = serv.findAllTrashedCategorys();
		categories.stream().forEach(i->changeTheTrashedValue(i, false));
		return "redirect:/categories/trash";
	}
	
	/*
	 * 
	 * A Method that manages the delete of a Category element
	 */
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		Optional<Category> optCategory = serv.findById(id);
		Category category = optCategory.get();
		
		removeCategoryFromPhotos(category);
		
		serv.delete(category);
		return "redirect:/categories/trash";
	}
	
	/*
	 * 
	 * A Method that manages the delete of all Category elements
	 */
	@PostMapping("/delete-all")
	public String deleteAll() {
		List<Category> categories = serv.findAllTrashedCategorys();
		categories.forEach(i->removeCategoryFromPhotos(i));
		serv.deleteAll(categories);
		return "redirect:/categories/trash";
	}
}
