package com.masmovil.phoneapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.masmovil.phoneapp.domain.Phone;

@RepositoryRestResource
public interface PhoneRepository extends CrudRepository<Phone, Integer> {

}
