package com.finalproject.hotelbookingsystem.repository;

import com.finalproject.hotelbookingsystem.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
