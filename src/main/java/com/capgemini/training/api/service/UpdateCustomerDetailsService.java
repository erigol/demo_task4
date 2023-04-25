package com.capgemini.training.api.service;

import com.capgemini.training.api.exceptions.CustomerNotFoundException;
import com.capgemini.training.api.model.CustomerDetails;
import com.capgemini.training.api.model.UpdateCustomerRequest;
import com.capgemini.training.api.repository.CustomerRepository;
import com.capgemini.training.api.repository.model.CustomerEntity;
import com.capgemini.training.api.service.mapper.CustomerMapper;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCustomerDetailsService {

  private final CustomerRepository repository;


  @Transactional
  public CustomerDetails updateCustomerDetails(String customerId, UpdateCustomerRequest customerRequest) {
    // TODO puesto que estas usando el código original quiero darte una pista de cara a la siguiente
    // tarea.. Cuando en la definición de APIs usamos el método PUT
    // quiere decir que nunca actualizamos registros de forma parcial. Sino que debemos obtener toda
    // la información que hay en base de datos,
    // modificar el dato o datos que nos están diciendo de cambiar y luego actualizar el registro.
    // Es decir, se actualiza el registro completo,
    // no de forma parcial. Si queremos actualizar de forma parcial deberíamos usar el metodo PATCH
    // (Os dejo este tema interesante para que investigueis, es algo teorico solamente, a nivel
    // practico os encontrareis sitios que no se respeta).
    CustomerEntity customerEntity = repository
        .findById(customerId)
        .orElseThrow(
            () -> new CustomerNotFoundException("customer does not exist in database"));
    CustomerMapper.updateEntityFromRequest(customerEntity, customerRequest);
    return CustomerMapper.toCustomerDetails(this.repository.save(customerEntity));
  }
}
