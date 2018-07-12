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

import com.masmovil.phoneapp.exception.EntityNotFoundException;
import com.masmovil.phoneapp.service.PhoneService;
import com.masmovil.phoneapp.service.ServiceBaseTest;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PhoneController.class)
public class PhoneControllerTest extends ServiceBaseTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PhoneService phoneService;

    @Test
    public void givenURL_whenGetPhones_thenReturnPhonesList() throws Exception {

    	when(phoneService.getPhones()).thenReturn(getPhones());
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders
        		.get("/Phones/")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertThat(HttpStatus.OK.value(),is(equalTo(result.getResponse().getStatus())));
        assertThat("application/json;charset=UTF-8",is(equalTo(result.getResponse().getContentType())));
        
    }

    @Test
    public void givenURL_whenGetPhone_thenReturnPhone() throws Exception {
    	
        when(phoneService.getPhone(PHONE_ID1)).thenReturn(getPhone(PHONE_ID1, PHONE_NAME1, PHONE_DESCRIPTION1, PHONE_IMAGE1, PHONE_PRICE1));
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/Phones/1")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertThat(HttpStatus.OK.value(),is(equalTo(result.getResponse().getStatus())));
        assertThat("application/json;charset=UTF-8",is(equalTo(result.getResponse().getContentType())));
    }
    
    @Test
    public void givenWrongURL_whenGetPhone_thenReturnNotFound() throws Exception {

    	when(phoneService.getPhone(PHONE_ID2)).thenThrow(new EntityNotFoundException());
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/Phones/2")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertThat(HttpStatus.NOT_FOUND.value(),is(equalTo(result.getResponse().getStatus())));
    }
    
}