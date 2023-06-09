package org.java.spring.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContactMessage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String email;
	
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
