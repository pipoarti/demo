package com.masmovil.phoneapp.base;

import java.util.ArrayList;
import java.util.List;

import com.masmovil.phoneapp.domain.Order;
import com.masmovil.phoneapp.domain.Phone;
import com.masmovil.phoneapp.wrapper.PhoneOrderWrapper;

public class PhoneAppBaseTest {
	
	protected static final Integer PHONES_SIZE = new Integer(2);
	protected static final Integer ORDERS_SIZE = new Integer(2);
	protected static final Integer ORDERS_PRICE_TOTAL = new Integer(300);

	protected static final Long PHONE_ID1 = new Long(1L);
	protected static final String PHONE_NAME1 = "Telefono 1";
	protected static final String PHONE_DESCRIPTION1 = "Descripcion del telefono 1";
	protected static final String PHONE_IMAGE1 = "/ruta/de/la/imagen1";
	protected static final Integer PHONE_PRICE1 = new Integer(100); 
	
	protected static final Long PHONE_ID2 = new Long(2L);
	protected static final String PHONE_NAME2 = "Telefono 2";
	protected static final String PHONE_DESCRIPTION2 = "Descripcion del telefono 2";
	protected static final String PHONE_IMAGE2 = "/ruta/de/la/imagen2";
	protected static final Integer PHONE_PRICE2 = new Integer(200); 
	
	protected static final Long ORDER_ID1 = new Long(1L);
	protected static final String ORDER_NAME1 = "Sergio";
	protected static final String ORDER_SURNAME1 = "Artigas";
	protected static final String ORDER_EMAIL1 = "sergio.artigas@gmail.com";
	protected static final Integer ORDER_PRICE1 = new Integer(100);
	
	protected static final Long ORDER_ID2 = new Long(1L);
	protected static final String ORDER_NAME2 = "Sergio";
	protected static final String ORDER_SURNAME2 = "Artigas";
	protected static final String ORDER_EMAIL2 = "sergio.artigas@gmail.com";
	protected static final Integer ORDER_PRICE2 = new Integer(200);
	
	protected Phone getPhone(Long id, String name, String description, String image, Integer price) {
		Phone phone = new Phone();
		phone.setId(id);
		phone.setName(name);
		phone.setDescription(description);
		phone.setImage(image);
		phone.setPrice(price);
		return phone;
	}
	
	protected Order getOrder(Long id, String name, String surname, String email, Integer price) {
		Order order = new Order();
		order.setId(id);
		order.setName(name);
		order.setSurname(surname);
		order.setEmail(email);
		order.setPrice(price);
		order.setPhones(getPhones());
		return order;
	}
	
	protected List<Phone> getPhones() {
		List<Phone> phones = new ArrayList<>();
		phones.add(getPhone(PHONE_ID1, PHONE_NAME1, PHONE_DESCRIPTION1, PHONE_IMAGE1, PHONE_PRICE1));
		phones.add(getPhone(PHONE_ID2, PHONE_NAME2, PHONE_DESCRIPTION2, PHONE_IMAGE2, PHONE_PRICE2));
		return phones;
	}
	
	protected List<Order> getOrders() {
		List<Order> orders = new ArrayList<>();
		orders.add(getOrder(ORDER_ID1, ORDER_NAME1, ORDER_SURNAME1, ORDER_EMAIL1, ORDER_PRICE1));
		orders.add(getOrder(ORDER_ID2, ORDER_NAME2, ORDER_SURNAME2, ORDER_EMAIL2, ORDER_PRICE2));
		return orders;
	}
	
	protected PhoneOrderWrapper getPhoneOrderWrapper(Long id, String name, String surname, String email, Integer price) {
		PhoneOrderWrapper phoneOrderWrapper = new PhoneOrderWrapper();
		phoneOrderWrapper.setId(id);
		phoneOrderWrapper.setName(name);
		phoneOrderWrapper.setSurname(surname);
		phoneOrderWrapper.setEmail(email);
		List<Long> phones = new ArrayList<>();
		phones.add(PHONE_ID1);
		phones.add(PHONE_ID2);
		phoneOrderWrapper.setPhones(phones);
		return phoneOrderWrapper;
	}
}
