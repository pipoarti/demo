package com.masmovil.phoneapp.wrapper;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class PhoneOrderWrapper {

	private @JsonSerialize Long id;
	private @JsonSerialize String name;
	private @JsonSerialize String surname;
	private @JsonSerialize String email;
	private @JsonSerialize List<Long> phones;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Long> getPhones() {
		return phones;
	}
	public void setPhones(List<Long> phones) {
		this.phones = phones;
	}
		
}
