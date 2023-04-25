package com.capgemini.training.api.exceptions;

public class CustomerNotFoundException extends RuntimeException {

  public CustomerNotFoundException(String msg) {
    super(msg);
  }
}
