package com.finalproject.hotelbookingsystem.service;

import com.finalproject.hotelbookingsystem.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerDto> getAllCustomers();
    CustomerDto getCustomerById(Long id);
    CustomerDto createCustomer(CustomerDto customer);
    CustomerDto updateCustomer(Long id, CustomerDto customer);
    void deleteCustomer(Long id);
}
