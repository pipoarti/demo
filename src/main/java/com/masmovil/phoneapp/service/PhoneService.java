package com.masmovil.phoneapp.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masmovil.phoneapp.domain.Phone;
import com.masmovil.phoneapp.repository.PhoneRepository;

@Service
public class PhoneService {
	
	@Autowired
	PhoneRepository phoneRepository;

	public List<Phone> getPhones() {
		List<Phone> phones = (List<Phone>) phoneRepository.findAll();
		return phones;  
	}
	
	public Phone getPhone(Long id) {
		Optional<Phone> phone = phoneRepository.findById(id);
		
		if (!phone.isPresent())
			throw new EntityNotFoundException("id-" + id);

		return phone.get();  
	}
}
