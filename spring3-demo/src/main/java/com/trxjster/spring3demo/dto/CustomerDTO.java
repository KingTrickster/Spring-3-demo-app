package com.trxjster.spring3demo.dto;

public class CustomerDTO {
   public record NewCustomerRequest(String name, String email, Integer age){}
}
