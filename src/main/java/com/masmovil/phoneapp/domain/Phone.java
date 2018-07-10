package com.masmovil.phoneapp.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TPHONES")
public class Phone implements Serializable {
	
	private static final long serialVersionUID = -9115667835434531212L;
	@Id @NotNull @JsonSerialize Long id;
	@NotNull @JsonSerialize String name;
	@NotNull @JsonSerialize String description;
	@NotNull @JsonSerialize String image;
	@NotNull @JsonSerialize Integer price;
	
}
