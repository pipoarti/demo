package com.masmovil.phoneapp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity(name = "TPHONES")
public class Phone {
	
	private @Id @NotNull @JsonSerialize Long id;
	private @NotNull @JsonSerialize String name;
	private @NotNull @JsonSerialize String description;
	private @NotNull @JsonSerialize String image;
	private @NotNull @JsonSerialize Integer price;
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getImage() {
		return image;
	}
	
	public Integer getPrice() {
		return price;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}

}
