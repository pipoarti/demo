package com.masmovil.phoneapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.masmovil.phoneapp.domain.Order;

@RepositoryRestResource
public interface OrderRepository extends CrudRepository<Order, Long> {

}
