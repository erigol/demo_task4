package com.capgemini.training.api.service;

import com.capgemini.training.api.exceptions.CustomerNotFoundException;
import com.capgemini.training.api.model.CustomerDetails;
import com.capgemini.training.api.repository.CustomerRepository;
import com.capgemini.training.api.service.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService {

  private final CustomerRepository customerRepository;

  public CustomerDetails getCustomerDetails(String customerId){
    return customerRepository
        .findById(customerId)
        .map(CustomerMapper::toCustomerDetails)
        .orElseThrow(() ->new CustomerNotFoundException("customer does not exist in database"));
  }
}
