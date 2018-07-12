package com.masmovil.phoneapp.service;

import java.util.List;

import com.masmovil.phoneapp.domain.Phone;

public interface PhoneService {
	public List<Phone> getPhones();
	public Phone getPhone(final Long id);
}
