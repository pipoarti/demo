package com.masmovil.phoneapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.masmovil.phoneapp.base.PhoneAppBaseTest;
import com.masmovil.phoneapp.domain.Order;
import com.masmovil.phoneapp.repository.OrderRepository;
import com.masmovil.phoneapp.service.impl.OrderServiceImpl;
import com.masmovil.phoneapp.service.impl.PhoneServiceImpl;
import com.masmovil.phoneapp.wrapper.PhoneOrderWrapper;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest extends PhoneAppBaseTest {
	
	private OrderServiceImpl orderService;
	private @Mock OrderServiceImpl orderServiceSpy;
	private @Mock OrderRepository orderRepository;
	private @Mock PhoneServiceImpl phoneService;
	
	@Before
	public void setUp() {
		orderService = new OrderServiceImpl();
		orderServiceSpy = spy(orderService);
	}
	
	@Test
	public void given_whengetOrders_thenReturnAllOrders() {
		when(orderRepository.findAll()).thenReturn(getOrders());
		List<Order> orders = orderService.getOrders();
		assertThat(orders).isNotNull();
		assertThat(orders.size()).isEqualTo(ORDERS_SIZE);
		assertThat(orders.get(0).getId()).isEqualTo(ORDER_ID1);
		assertThat(orders.get(0).getName()).isEqualTo(ORDER_NAME1);
		assertThat(orders.get(0).getSurname()).isEqualTo(ORDER_SURNAME1);
		assertThat(orders.get(0).getEmail()).isEqualTo(ORDER_EMAIL1);
		assertThat(orders.get(0).getPrice()).isEqualTo(ORDER_PRICE1);
		assertThat(orders.get(0).getPhones().size()).isEqualTo(PHONES_SIZE);
		assertThat(orders).isNotNull();
		assertThat(orders.size()).isEqualTo(ORDERS_SIZE);
		assertThat(orders.get(1).getId()).isEqualTo(ORDER_ID2);
		assertThat(orders.get(1).getName()).isEqualTo(ORDER_NAME2);
		assertThat(orders.get(1).getSurname()).isEqualTo(ORDER_SURNAME2);
		assertThat(orders.get(1).getEmail()).isEqualTo(ORDER_EMAIL2);
		assertThat(orders.get(1).getPrice()).isEqualTo(ORDER_PRICE2);
		assertThat(orders.get(1).getPhones().size()).isEqualTo(PHONES_SIZE);
		verify(orderRepository).findAll();
	}
	
	@Test
	public void givenId_whenGetOrder_thenReturnOrder() {
		when(orderRepository.findById(ORDER_ID1)).thenReturn(Optional.of(getOrder(ORDER_ID1, ORDER_NAME1, ORDER_SURNAME1, ORDER_EMAIL1, ORDER_PRICE1)));
		Order order = orderService.getOrder(ORDER_ID1);
		assertThat(order).isNotNull();
		assertThat(order.getId()).isEqualTo(ORDER_ID1);
		assertThat(order.getName()).isEqualTo(ORDER_NAME1);
		assertThat(order.getSurname()).isEqualTo(ORDER_SURNAME1);
		assertThat(order.getEmail()).isEqualTo(ORDER_EMAIL1);
		assertThat(order.getPrice()).isEqualTo(ORDER_PRICE1);
		assertThat(order.getPhones().size()).isEqualTo(2);
		verify(orderRepository).findById(ORDER_ID1);
	}
	
	@Test(expected=EntityNotFoundException.class)
	public void givenWrongId_whenGetOrder_thenReturnEntityNotFound() {
		when(orderRepository.findById(ORDER_ID2)).thenReturn(Optional.empty());
		orderService.getOrder(ORDER_ID2);
	}

	@Test
	public void givenPhoneOrderWrapper_whenSave_thenReturnOrder() {
		Order order = getOrder(null, ORDER_NAME1, ORDER_SURNAME1, ORDER_EMAIL1, ORDER_PRICE1);
		PhoneOrderWrapper phoneOrderWrapper = getPhoneOrderWrapper(ORDER_ID1, ORDER_NAME1, ORDER_SURNAME1, ORDER_EMAIL1, ORDER_PRICE1);
		when(orderRepository.existsById(ORDER_ID1)).thenReturn(Boolean.FALSE); 
		doReturn(order).when(orderServiceSpy).phoneOrderWrapperToOrder(phoneOrderWrapper);
		when(orderRepository.save(order)).thenReturn(order);
		Order savedOrder = orderServiceSpy.save(phoneOrderWrapper);
		assertThat(savedOrder).isNotNull();
		assertThat(savedOrder.getName()).isEqualTo(ORDER_NAME1);
		assertThat(savedOrder.getSurname()).isEqualTo(ORDER_SURNAME1);
		assertThat(savedOrder.getEmail()).isEqualTo(ORDER_EMAIL1);
		assertThat(savedOrder.getPrice()).isEqualTo(ORDER_PRICE1);
		assertThat(savedOrder.getPhones().size()).isEqualTo(PHONES_SIZE);
		verify(orderRepository).existsById(ORDER_ID1);
	}
	
	@Test(expected=EntityExistsException.class)
	public void givenAlreadyExistsPhoneOrderWrapper_whenSave_thenReturnEntityExists() {
		PhoneOrderWrapper phoneOrderWrapper = getPhoneOrderWrapper(ORDER_ID1, ORDER_NAME1, ORDER_SURNAME1, ORDER_EMAIL1, ORDER_PRICE1);
		when(orderRepository.existsById(ORDER_ID1)).thenReturn(Boolean.TRUE); 
		orderServiceSpy.save(phoneOrderWrapper);
	}
	
	@Test
	public void test() {
		when(phoneService.getPhone(PHONE_ID1)).thenReturn(getPhone(PHONE_ID1, PHONE_NAME1, PHONE_DESCRIPTION1, PHONE_IMAGE1, ORDER_PRICE1));
		when(phoneService.getPhone(PHONE_ID2)).thenReturn(getPhone(PHONE_ID2, PHONE_NAME2, PHONE_DESCRIPTION2, PHONE_IMAGE2, ORDER_PRICE2));
		Order order = orderService.phoneOrderWrapperToOrder(getPhoneOrderWrapper(ORDER_ID1, ORDER_NAME1, ORDER_SURNAME1, ORDER_EMAIL1, ORDER_PRICE1));
		assertThat(order).isNotNull();
		assertThat(order.getName()).isEqualTo(ORDER_NAME1);
		assertThat(order.getSurname()).isEqualTo(ORDER_SURNAME1);
		assertThat(order.getEmail()).isEqualTo(ORDER_EMAIL1);
		assertThat(order.getPrice()).isEqualTo(ORDERS_PRICE_TOTAL);
		assertThat(order.getPhones().size()).isEqualTo(PHONES_SIZE);
		verify(phoneService).getPhone(PHONE_ID1);
		verify(phoneService).getPhone(PHONE_ID2);
	}
}
