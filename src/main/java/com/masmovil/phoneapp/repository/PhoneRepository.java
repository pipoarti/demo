package com.masmovil.phoneapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.masmovil.phoneapp.domain.Phone;

@RepositoryRestResource
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
