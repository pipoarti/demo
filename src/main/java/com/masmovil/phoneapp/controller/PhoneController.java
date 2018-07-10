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
	PhoneService phoneService;
	
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

//	@PostMapping
//	public ResponseEntity<Phone> createPhone(@Valid @RequestBody Phone phone) {
//		Phone savedPhone = phoneService.save(phone);
//
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(savedPhone.getId()).toUri();
//
//		return ResponseEntity.created(location).build();
//	}
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<Phone> updatePhone(@PathVariable Long id, @RequestBody Phone phone) {
//
//		Phone savedPhone = phoneService.update(id, phone);
//
//		return ResponseEntity.noContent().build();
//	}
//	
//	o si vas a devolver el objeto modificado: 
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<Phone> updatePhone(@PathVariable Long id, @RequestBody Phone phone) {
//
//		Phone savedPhone = phoneService.update(id, phone);
//
//		return ResponseEntity.ok().body(savedPhone);
//	}
//	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Phone> deleteStudent(@PathVariable Long id) {
//		Optional<Phone> phoneOptional = phoneService.findById(id);
//
//		if (!phoneOptional.isPresent())
//			return ResponseEntity.notFound().build();
//
//		phoneService.deleteById(id);
//		
//		return ResponseEntity.noContent().build();
//	}
	
}
