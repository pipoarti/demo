package com.masmovil.phoneapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.masmovil.phoneapp.base.PhoneAppBaseTest;
import com.masmovil.phoneapp.domain.Phone;
import com.masmovil.phoneapp.repository.PhoneRepository;
import com.masmovil.phoneapp.service.impl.PhoneServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PhoneServiceImplTest extends PhoneAppBaseTest {

	private PhoneServiceImpl phoneService;
	private @Mock PhoneRepository phoneRepository;
	
	@Before
	public void setUp() {
		phoneService = new PhoneServiceImpl();
	}
	
	@Test
	public void given_whenGetPhones_thenReturnAllPhonesTest() {
		when(phoneRepository.findAll()).thenReturn(getPhones());
		List<Phone> phones = phoneService.getPhones();
		assertThat(phones).isNotNull();
		assertThat(phones.size()).isEqualTo(PHONES_SIZE);
		assertThat(phones.get(0).getId()).isEqualTo(PHONE_ID1);
		assertThat(phones.get(0).getName()).isEqualTo(PHONE_NAME1);
		assertThat(phones.get(0).getDescription()).isEqualTo(PHONE_DESCRIPTION1);
		assertThat(phones.get(0).getImage()).isEqualTo(PHONE_IMAGE1);
		assertThat(phones.get(0).getPrice()).isEqualTo(PHONE_PRICE1);
		assertThat(phones.get(1).getId()).isEqualTo(PHONE_ID2);
		assertThat(phones.get(1).getName()).isEqualTo(PHONE_NAME2);
		assertThat(phones.get(1).getDescription()).isEqualTo(PHONE_DESCRIPTION2);
		assertThat(phones.get(1).getImage()).isEqualTo(PHONE_IMAGE2);
		assertThat(phones.get(1).getPrice()).isEqualTo(PHONE_PRICE2);
		verify(phoneRepository).findAll();
	}
	
	@Test
	public void givenId_whenGetPhone_thenReturnPhoneTest() {
		when(phoneRepository.findById(PHONE_ID1)).thenReturn(Optional.of(getPhone(PHONE_ID1, PHONE_NAME1, PHONE_DESCRIPTION1, PHONE_IMAGE1, PHONE_PRICE1)));
		Phone phone = phoneService.getPhone(PHONE_ID1);
		assertThat(phone).isNotNull();
		assertThat(phone.getId()).isEqualTo(PHONE_ID1);
		assertThat(phone.getName()).isEqualTo(PHONE_NAME1);
		assertThat(phone.getDescription()).isEqualTo(PHONE_DESCRIPTION1);
		assertThat(phone.getImage()).isEqualTo(PHONE_IMAGE1);
		assertThat(phone.getPrice()).isEqualTo(PHONE_PRICE1);
		verify(phoneRepository).findById(PHONE_ID1);
	}
	
	@Test(expected=EntityNotFoundException.class)
	public void givenWrongId_whenGetPhone_thenReturnEntityNotFound() {
		when(phoneRepository.findById(PHONE_ID2)).thenReturn(Optional.empty());
		phoneService.getPhone(PHONE_ID2);
	}
	
}
