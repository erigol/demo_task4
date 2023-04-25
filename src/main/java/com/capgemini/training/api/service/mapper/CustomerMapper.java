package com.capgemini.training.api.service.mapper;

import com.capgemini.training.api.model.CustomerDetails;
import com.capgemini.training.api.model.UpdateCustomerRequest;
import com.capgemini.training.api.repository.model.CustomerEntity;

//TODO en este caso utilizamos un utilityClass para que la veais y sepais que se puede hacer, pero
//os encontrareis muchos programadores encontra de usarlas. Simplemente es para que conozcais este tipo de clases.
public final class CustomerMapper {

  private CustomerMapper() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  public static CustomerEntity updateEntityFromRequest(CustomerDetails customerDetails) {

    return CustomerEntity.builder()
        .customerId(customerDetails.getCustomerId())
        .documentType(customerDetails.getDocumentType())
        .documentNumber(customerDetails.getDocumentNumber())
        .name(customerDetails.getName())
        .surname(customerDetails.getSurName())
        .lastname(customerDetails.getLastName())
        .country(customerDetails.getCountry())
        .telephone(Integer.valueOf(customerDetails.getTelephone()))
        .build();
  }

  public static void updateEntityFromRequest(
      CustomerEntity entity, UpdateCustomerRequest customerDetails) {
    entity.setDocumentType(customerDetails.getDocumentType());
    entity.setDocumentNumber(customerDetails.getDocumentNumber());
    entity.setName(customerDetails.getName());
    entity.setSurname(customerDetails.getSurName());
    entity.setLastname(customerDetails.getLastName());
    entity.setCountry(customerDetails.getCountry());
    entity.setTelephone(Integer.valueOf(customerDetails.getTelephone()));
  }

  public static CustomerDetails toCustomerDetails(CustomerEntity customer) {
    return CustomerDetails.builder()
        .customerId(customer.getCustomerId())
        .documentType(customer.getDocumentType())
        .documentNumber(customer.getDocumentNumber())
        .name(customer.getName())
        .surName(customer.getSurname())
        .lastName(customer.getLastname())
        .country(customer.getCountry())
        .telephone(customer.getTelephone().toString())
        .build();
  }
}
