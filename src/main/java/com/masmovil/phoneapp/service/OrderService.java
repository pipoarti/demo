package com.masmovil.phoneapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.masmovil.phoneapp.domain.Order;
import com.masmovil.phoneapp.domain.Phone;
import com.masmovil.phoneapp.repository.OrderRepository;
import com.masmovil.phoneapp.wrapper.PhoneOrderWrapper;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	private PhoneService phoneService;

	public OrderService(final OrderRepository orderRepository, final PhoneService phoneService) {
		this.orderRepository = orderRepository;
		this.phoneService = phoneService;
	}
	
	public List<Order> getOrders() {
		return (List<Order>) orderRepository.findAll();  
	}
	
	public Order getOrder(final Long id) {
		final Optional<Order> order = orderRepository.findById(id);
		if (!order.isPresent())
			throw new EntityNotFoundException("id-" + id);
		return order.get();  
	}
	
	public Order save(final PhoneOrderWrapper phoneOrderWrapper) {
		final Long id = phoneOrderWrapper.getId();
		if(id != null && orderRepository.existsById(id)) 
			throw new EntityExistsException(String.format("Order(%s) already exists.", id));
		final Order order = phoneOrderWrapperToOrder(phoneOrderWrapper);
		return orderRepository.save(order);
	}

	protected Order phoneOrderWrapperToOrder(final PhoneOrderWrapper wrapper) {
		final Order result = new Order();
		result.setName(wrapper.getName());
		result.setSurname(wrapper.getSurname());
		result.setEmail(wrapper.getEmail());
		result.setPhones(getPhones(wrapper.getPhones()));
		result.setPrice(result.getPhones().stream().mapToInt(phone -> phone.getPrice()).sum());
		return result;
	}
	
	private List<Phone> getPhones(final List<Long> phoneIds) {
		final List<Phone> result = new ArrayList<>();
		phoneIds.stream().forEach(phone -> result.add(phoneService.getPhone(phone)));
		return result;
	}
}
