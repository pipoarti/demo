package com.masmovil.phoneapp.service;

import java.util.List;

import com.masmovil.phoneapp.domain.Order;
import com.masmovil.phoneapp.wrapper.PhoneOrderWrapper;

public interface OrderService {
	public List<Order> getOrders();
	public Order getOrder(final Long id);
	public Order save(final PhoneOrderWrapper phoneOrderWrapper);
}
