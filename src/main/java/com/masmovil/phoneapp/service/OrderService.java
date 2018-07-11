package com.masmovil.phoneapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masmovil.phoneapp.domain.Order;
import com.masmovil.phoneapp.domain.Phone;
import com.masmovil.phoneapp.repository.OrderRepository;
import com.masmovil.phoneapp.wrapper.PhoneOrderWrapper;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	PhoneService phoneService;
	
	public List<Order> getOrders() {
		List<Order> orders = (List<Order>) orderRepository.findAll();
		return orders;  
	}
	
	public Order getOrder(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		if (!order.isPresent())
			throw new EntityNotFoundException("id-" + id);
		return order.get();  
	}
	
	public Order save(PhoneOrderWrapper phoneOrderWrapper) {
		Long id = phoneOrderWrapper.getId();
		if(id != null && orderRepository.existsById(id)) 
			throw new EntityExistsException(String.format("Order(%s) already exists.", id));
		Order order = phoneOrderWrapperToOrder(phoneOrderWrapper);
		return  orderRepository.save(order);
	}

	private Order phoneOrderWrapperToOrder(PhoneOrderWrapper wrapper) {
		Order result = new Order();
		result.setName(wrapper.getName());
		result.setSurname(wrapper.getSurname());
		result.setEmail(wrapper.getEmail());
		result.setPhones(getPhones(wrapper.getPhones()));
		return result;
	}
	
	private List<Phone> getPhones(List<Long> phoneIds) {
		List<Phone> result = new ArrayList<>();
		phoneIds.stream().forEach(phone -> result.add(phoneService.getPhone(phone)));
		return result;
	}
}
