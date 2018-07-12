package com.masmovil.phoneapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.masmovil.phoneapp.controller.OrderController;
import com.masmovil.phoneapp.controller.PhoneController;
import com.masmovil.phoneapp.repository.OrderRepository;
import com.masmovil.phoneapp.repository.PhoneRepository;
import com.masmovil.phoneapp.service.OrderService;
import com.masmovil.phoneapp.service.PhoneService;
import com.masmovil.phoneapp.service.impl.OrderServiceImpl;
import com.masmovil.phoneapp.service.impl.PhoneServiceImpl;

@Configuration
public class PhoneAppConfig {
	
	@Bean
	public PhoneController phoneController(PhoneService phoneService) {
		return new PhoneController();
	}
	
	@Bean
	public OrderController orderController(OrderService orderService) {
		return new OrderController();
	}
	
    @Bean
    public PhoneService phoneService(PhoneRepository phoneRepository) {
        return new PhoneServiceImpl();
    }
    
    @Bean
    public OrderService orderService(OrderRepository orderRepository, PhoneService phoneService) {
        return new OrderServiceImpl();
    }
    
}
