package com.masmovil.phoneapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masmovil.phoneapp.domain.Phone;
import com.masmovil.phoneapp.exception.EntityNotFoundException;
import com.masmovil.phoneapp.repository.PhoneRepository;
import com.masmovil.phoneapp.service.PhoneService;

@Service
public class PhoneServiceImpl implements PhoneService {
	
	private PhoneRepository phoneRepository;
	
	public PhoneServiceImpl(final PhoneRepository phoneRepository) {
		this.phoneRepository = phoneRepository;
	}

	public List<Phone> getPhones() {
		return (List<Phone>) phoneRepository.findAll();  
	}
	
	public Phone getPhone(final Long id) {
		final Optional<Phone> phone = phoneRepository.findById(id);
		if (!phone.isPresent())
			throw new EntityNotFoundException();
		return phone.get();  
	}
}
