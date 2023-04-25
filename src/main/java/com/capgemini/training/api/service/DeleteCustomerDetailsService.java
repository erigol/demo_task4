package com.capgemini.training.api.service;

import com.capgemini.training.api.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCustomerDetailsService {

  private final CustomerRepository customerRepository;

  public void deleteCustomerDetails(String customerId){
    customerRepository.deleteById(customerId);
  }
}
