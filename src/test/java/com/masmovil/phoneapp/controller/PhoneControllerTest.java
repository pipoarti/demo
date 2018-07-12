package com.masmovil.phoneapp.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.masmovil.phoneapp.PhoneApplication;
import com.masmovil.phoneapp.domain.Phone;
import com.masmovil.phoneapp.repository.PhoneRepository;
import com.masmovil.phoneapp.service.PhoneService;
import com.masmovil.phoneapp.service.impl.PhoneServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PhoneApplication.class)
@AutoConfigureMockMvc
public class PhoneControllerTest {

	private static final Long ID = 1L;
	private static final String NAME = "Phone1";
	private static final String DESCRIPTION = "Phone1 description.";
	private static final String IMAGE = "/path/image.abc";
	private static final Integer PRICE = 1000000;
	
	@Autowired
    private MockMvc mvc;
 
	@MockBean
    private PhoneService phoneService;
	
	
	
	@Test
	public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
	  throws Exception {
	     
	    Phone phone = new Phone();
	    phone.setId(ID);
	    phone.setName(NAME);
	    phone.setDescription(DESCRIPTION);
	    phone.setImage(IMAGE);
	    phone.setPrice(PRICE);
	    List<Phone> phones = Arrays.asList(phone);

	    when(phoneService.getPhones()).thenReturn(phones);
	 
	    MvcResult result = mvc.perform(get("/Phones")
	       .contentType(MediaType.APPLICATION_JSON))
	       .andReturn();
	    
//	      .andExpect(status().isOk())
//	      .andExpect(jsonPath("$", is(1)))
//	      .andExpect(jsonPath("$[0].id", is(ID)))
//	      .andExpect(jsonPath("$[0].name", is(NAME)))
//	      .andExpect(jsonPath("$[0].description", is(DESCRIPTION)))
//	      .andExpect(jsonPath("$[0].image", is(IMAGE)))
//	      .andExpect(jsonPath("$[0].price", is(PRICE)));
	    result.getResponse().getContentAsString();
	}
}
