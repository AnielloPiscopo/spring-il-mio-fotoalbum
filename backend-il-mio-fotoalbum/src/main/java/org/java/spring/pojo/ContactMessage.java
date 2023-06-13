package org.java.spring.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class ContactMessage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "L'email non può essere vuota")
	@NotNull(message = "L'email non può essere vuota")
	@Email(message = "Non hai inserito un'email valida")
	@Column(unique = true , nullable = false , length = 255)
	private String email;
	
	@NotBlank(message = "Il contenuto del messaggio non può essere vuoto")
	@NotNull(message = "Il contenuto del messaggio non può essere vuoto")
	@Size(min = 10 , max = 255 , message = "Il contenuto del messaggio deve contenere almeno 10 caratteri per poter essere spedito")
	@Column(nullable = false , length = 255)
	private String content;
	
	public ContactMessage() {}

	public ContactMessage(String email, String content) {
		setEmail(email);
		setContent(content);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	private String getInfo() {
		return "Id: " + getId() + ";"
			+ "\n" + "Email: " + getEmail() + ";"
			+ "\n" + "Content: " + getContent() + ";";
	}
	
	@Override
	public String toString() {
		return getInfo();
	}
}
