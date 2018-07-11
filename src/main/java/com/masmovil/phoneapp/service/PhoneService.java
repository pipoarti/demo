package com.masmovil.phoneapp.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.masmovil.phoneapp.domain.Phone;
import com.masmovil.phoneapp.repository.PhoneRepository;

@Service
public class PhoneService {
	
	private PhoneRepository phoneRepository;
	
	public PhoneService(final PhoneRepository phoneRepository) {
		this.phoneRepository = phoneRepository;
	}

	public List<Phone> getPhones() {
		return (List<Phone>) phoneRepository.findAll();  
	}
	
	public Phone getPhone(final Long id) {
		final Optional<Phone> phone = phoneRepository.findById(id);
		if (!phone.isPresent())
			throw new EntityNotFoundException("id-" + id);
		return phone.get();  
	}
}
