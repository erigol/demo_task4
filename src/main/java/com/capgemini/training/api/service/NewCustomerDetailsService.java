package com.capgemini.training.api.service;

import com.capgemini.training.api.exceptions.CustomerDetailsException;
import com.capgemini.training.api.model.CustomerDetails;
import com.capgemini.training.api.repository.CustomerRepository;
import com.capgemini.training.api.service.mapper.CustomerMapper;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewCustomerDetailsService {

  private final CustomerRepository repository;

  public CustomerDetails createNewCustomer(CustomerDetails customerDetails) {
   return Optional.of(this.repository.save(CustomerMapper.updateEntityFromRequest(customerDetails)))
        .map(CustomerMapper::toCustomerDetails)
        .orElseThrow(()-> new CustomerDetailsException("error save customer"));
  }
}
