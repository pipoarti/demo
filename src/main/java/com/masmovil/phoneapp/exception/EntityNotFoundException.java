package com.masmovil.phoneapp.exception;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Phone/Order not found")
public class EntityNotFoundException extends ResourceNotFoundException {
	private static final long serialVersionUID = 84234736801569760L;
}
