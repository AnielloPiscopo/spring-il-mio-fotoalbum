package org.java.spring.pojo;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JsonBackReference
	@ManyToMany(mappedBy = "categories")
	private List<Photo> photos;
	
	@NotNull(message = "Il nome non può essere vuoto")
	@NotBlank(message = "Il nome non può essere vuoto")
	@Size(min = 3, max = 100 , message = "Il nome deve contenere almeno 3 caratteri e meno di 100")
	@Column(unique = true , nullable = false , length = 100)
	private String name;
	
	private boolean trashed = false;
	
	public Category() {}

	public Category(String name) {
		setName(name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	
	@JsonIgnore
	public void setPhotos(Photo[] photos) {
		setPhotos(Arrays.asList(photos));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isTrashed() {
		return trashed;
	}

	public void setTrashed(boolean trashed) {
		this.trashed = trashed;
	}

	private String getInfo() {
		return "Id: " + getId() + ";"
			+ "\n" + "Name: " + getName() + ";";
	}
	
	@Override
	public String toString() {
		return getInfo();
	}
}
