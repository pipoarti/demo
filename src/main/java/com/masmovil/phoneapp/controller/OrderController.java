package com.masmovil.phoneapp.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
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
		log.info(String.format("The order has succesfully completed: %s", savedOrder.toString()));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(PATH_ID).buildAndExpand(savedOrder.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
}
