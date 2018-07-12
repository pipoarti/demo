package com.masmovil.phoneapp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "TPHONES")
public class Phone {
	
	private @Id @NotNull Long id;
	private @NotNull String name;
	private @NotNull String description;
	private @NotNull String image;
	private @NotNull Integer price;
	
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

	@Override
	public String toString() {
		return "Phone [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image + ", price="
				+ price + "]";
	}

}
