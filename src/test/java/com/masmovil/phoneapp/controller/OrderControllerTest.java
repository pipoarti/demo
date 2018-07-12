package com.masmovil.phoneapp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.masmovil.phoneapp.base.PhoneAppBaseTest;
import com.masmovil.phoneapp.service.OrderService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(value = OrderController.class)
public class OrderControllerTest extends PhoneAppBaseTest {
	
	private static final String TYPE = "application/json;charset=UTF-8";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void givenURL_whenGetOrders_thenReturnOrdersList() throws Exception {

    	when(orderService.getOrders()).thenReturn(getOrders());
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders
        		.get("/Orders/")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertThat(result.getResponse().getStatus(),is(equalTo(HttpStatus.OK.value())));
        assertThat(result.getResponse().getContentType(),is(equalTo(TYPE)));
        
    }

    @Test
    public void givenURL_whenGetOrder_thenReturnOrder() throws Exception {
    	
        when(orderService.getOrder(ORDER_ID1)).thenReturn(getOrder(ORDER_ID1, ORDER_NAME1, ORDER_SURNAME1, ORDER_EMAIL1, ORDER_PRICE1));
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/Orders/1")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertThat(result.getResponse().getStatus(),is(equalTo(HttpStatus.OK.value())));
        assertThat(result.getResponse().getContentType(),is(equalTo(TYPE)));
    }
    
   @Test
    public void givenWrongOrder_whenPost_thenError() throws Exception {
    	
    	when(orderService.save(getPhoneOrderWrapper(ORDER_ID1, ORDER_NAME1, ORDER_SURNAME1, ORDER_EMAIL1, ORDERS_PRICE_TOTAL))).thenReturn(getOrder(ORDER_ID1, ORDER_NAME1, ORDER_SURNAME1, ORDER_EMAIL1, ORDERS_PRICE_TOTAL));
    	
    	RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/Orders/")
                .contentType(MediaType.APPLICATION_JSON);
    	
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        
        assertThat(result.getResponse().getStatus(),is(equalTo(HttpStatus.BAD_REQUEST.value())));
        assertThat(result.getResponse().getContentType(),is(equalTo(TYPE)));
    }
    	
}