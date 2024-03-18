package com.finalproject.hotelbookingsystem.service;

import com.finalproject.hotelbookingsystem.dto.CustomerDto;
import com.finalproject.hotelbookingsystem.entity.CustomerEntity;
import com.finalproject.hotelbookingsystem.exceptions.CustomerIdDoesNotExistException;
import com.finalproject.hotelbookingsystem.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;
    private ModelMapper modelMapper;
    private Logger logger;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        logger.info("Customer Service called");
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        logger.info("getALlCustomers called");
        return customerRepository.findAll()
                .stream()
                .map(e -> modelMapper.map(e, CustomerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        logger.info("getCustomerById called");
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        if(customerEntity.isEmpty()){
            throw new CustomerIdDoesNotExistException("Customer ID not found");
        }
        logger.info("getALlCustomers exiting");
        return modelMapper.map(customerEntity.get(), CustomerDto.class);
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        logger.info("createCustomer called");
        CustomerEntity customerEntity = customerRepository.save(modelMapper.map(customerDto, CustomerEntity.class));
        logger.info("createCustomer exiting");
        return modelMapper.map(customerEntity, CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
        logger.info("updateCustomer called");
        CustomerEntity customerEntity = customerRepository.save(modelMapper.map(customerDto, CustomerEntity.class));
        logger.info("updateCustomer exiting");
        return modelMapper.map(customerEntity, CustomerDto.class);
    }

    @Override
    public void deleteCustomer(Long id) {
        logger.info("deleteCustomer called");
        if(customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            logger.info("Customer deleted successfully");
        }
        else{
            logger.error("Customer Id to be deleted does not exist");
        }
        logger.info("deleteCustomer exiting");
    }
}
