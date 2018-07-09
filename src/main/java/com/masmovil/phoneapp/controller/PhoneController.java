package com.masmovil.phoneapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.masmovil.phoneapp.domain.Phone;
import com.masmovil.phoneapp.service.PhoneService;

@RestController
public class PhoneController {
	
	@Autowired
	PhoneService phoneService;
	
	@RequestMapping(value="/Phones", method=RequestMethod.GET)
	public ResponseEntity<List<Phone>> getPhones() {
		List<Phone> phones = phoneService.getPhones();
		return ResponseEntity.ok().body(phones);
	}

	@RequestMapping(value="/Phone/{id}", method=RequestMethod.GET)
	public ResponseEntity<Phone> getPhone(@PathVariable Integer id) {
		Phone phone = phoneService.getPhone(id);
		ResponseEntity<Phone> response = new ResponseEntity<Phone>(phone, HttpStatus.OK);
		return response;
	}
}
