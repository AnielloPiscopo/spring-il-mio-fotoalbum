package org.java.spring.auth.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="Devi inserire il nome del ruolo")
	@NotBlank(message="Devi inserire il nome del ruolo")
	@Size(max = 100 , message = "Puoi inserire fino a 100 caratteri per il nome del ruolo")
	@Column(nullable = false , length = 100)
	private String name;
	
	public Role() { }
	
	public Role(String name) {
		setName(name);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	private String getInfo() {
		return "Id: " + getId()
			+ "\n" + "Name: " + getName();
	}
	
	@Override
	public String toString() {
		return getInfo();
	}
}
