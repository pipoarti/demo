package com.masmovil.phoneapp.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.masmovil.phoneapp.domain.Order;
import com.masmovil.phoneapp.service.OrderService;
import com.masmovil.phoneapp.wrapper.PhoneOrderWrapper;

@RestController
@RequestMapping("/Orders")
public class OrderController {
	
	private static final String PATH_ID = "/{id}";
	
	@Autowired
	OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> getOrders() {
		List<Order> orders = orderService.getOrders();
		return ResponseEntity.ok(orders);
	}

	@GetMapping(value=PATH_ID)
	public ResponseEntity<Order> getOrder(@PathVariable Long id) {
		Order order = orderService.getOrder(id);
		return ResponseEntity.ok(order);
	}
	
	@PostMapping
	public ResponseEntity<Order> createOrder(@Valid @RequestBody PhoneOrderWrapper phoneOrderWrapper) {
		Order savedOrder = orderService.save(phoneOrderWrapper);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(PATH_ID).buildAndExpand(savedOrder.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
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
