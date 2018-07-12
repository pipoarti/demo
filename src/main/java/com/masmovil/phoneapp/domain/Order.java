package com.masmovil.phoneapp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity(name = "TORDERS")
public class Order {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @NotNull
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String surname;
	@NotNull
	private String email;
	@NotNull
	private Integer price;
	@ManyToMany
	private List<Phone> phones;
	
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
	
	public Integer getPrice() {
		return price;
	}
	
	public List<Phone> getPhones() {
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
	
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", price=" + price
				+ ", phones=" + phones + "]";
	}
	
}
