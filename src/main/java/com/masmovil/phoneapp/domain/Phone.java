package com.masmovil.phoneapp.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity(name = "TPHONES")
public class Phone implements Serializable {
	private static final long serialVersionUID = 320023047303013201L;
	@Id @NotNull Integer id;
	@NotNull String name;
	@NotNull String description;
	@NotNull String image;
	@NotNull Integer price;
	
	@Override
	public String toString() {
		return "Phone [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image + ", price="
				+ price + "]";
	}
	
}
