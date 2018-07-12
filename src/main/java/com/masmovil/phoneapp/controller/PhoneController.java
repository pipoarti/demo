package com.masmovil.phoneapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masmovil.phoneapp.domain.Phone;
import com.masmovil.phoneapp.service.PhoneService;

@RestController
@RequestMapping("/Phones")
public class PhoneController {
	
	@Autowired
	private PhoneService phoneService;
	
	@GetMapping
	public ResponseEntity<List<Phone>> getPhones() {
		List<Phone> phones = phoneService.getPhones();
		return ResponseEntity.ok(phones);
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<Phone> getPhone(@PathVariable Long id) {
		Phone phone = phoneService.getPhone(id);
		return ResponseEntity.ok(phone);
	}

}
