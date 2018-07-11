package com.masmovil.phoneapp.wrapper;

import java.util.List;

public class PhoneOrderWrapper {

	private Long id;
	private String name;
	private String surname;
	private String email;
	private List<Long> phones;
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public List<Long> getPhones() {
		return phones;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPhones(List<Long> phones) {
		this.phones = phones;
	}

}
