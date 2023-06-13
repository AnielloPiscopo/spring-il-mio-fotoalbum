package org.java.spring.pojo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.URL;
import org.java.spring.auth.pojo.User;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Photo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(nullable = true)
	private User user;
	
	@ManyToMany
	private List<Category> categories;

	@NotBlank(message = "Devi inserire il titolo per la tua foto")
	@NotNull(message = "Devi inserire il titolo per la tua foto")
	@Size(min = 3 , max = 100 , message = "Il titolo della tua foto non ha almento 3 caratteri oppure nei hai inserito più di 100")
	@Column(unique = true , nullable = false , length = 100)
	private String title;
	
	@Size(min = 10 , max = 255 , message = "Il contenuto del messaggio deve contenere almeno 10 caratteri per poter essere spedito")
	@Column(nullable = true , length = 255)
	private String description;
	
	@NotBlank(message = "Devi inserire la tua foto")
	@NotNull(message = "Devi inserire la tua foto")
	@URL(message = "Non hai inserito un URL valido")
	private String imgUrl;
		
	private boolean visible;
	
	private boolean trashed = false;
	
	private String userRole;

	public Photo() {}
	
	public Photo(String title,  String description , String imgUrl, boolean visibile , Category...categories ) {
		setTitle(title);
		setDescription(description);
		setImgUrl(imgUrl);
		setVisible(visibile);
		setCategories(categories);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	@JsonIgnore
	public void setCategories(Category[] categories) {
		setCategories(Arrays.asList(categories));
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public boolean isTrashed() {
		return trashed;
	}

	public void setTrashed(boolean trashed) {
		this.trashed = trashed;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public void addCategory(Category category) {
		categories.add(category);
	}
	
	public void removeCategory(Category category) {
		categories.remove(category);
	}
	
	public void removeCategories() {
		categories.clear();
	}

	private String getInfo() {
		return "Id: " + getId() + ";"
			+ "\n" + "Title: " + getTitle() + ";"
			+ "\n" + "Description: " + getDescription() + ";"
			+ "\n" + "Img Url: " + getImgUrl() + ";"
			+ "\n" + "Visible: " + isVisible() + ";";
	}
	
	@Override
	public String toString() {
		return getInfo();
	}
}
