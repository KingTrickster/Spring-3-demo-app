package com.trxjster.spring3demo.service;

import com.trxjster.spring3demo.dto.CustomerDTO;
import com.trxjster.spring3demo.model.Customer;
import com.trxjster.spring3demo.repository.CustomerRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class CustomerService {
    private CustomerRepo customerRepo;

    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    public Customer getCustomerById(Integer id){
        return customerRepo.findById(id).orElseThrow( () -> new RuntimeException("Customer with id "+id +" not found"));
    }

    @Transactional
    public Customer createCustomer(CustomerDTO.NewCustomerRequest customer){
        Customer newCustomer = new Customer();
        newCustomer.setName(customer.name());
        newCustomer.setAge(customer.age());
        newCustomer.setEmail(customer.email());
        return customerRepo.save(newCustomer);
    }

    @Transactional
    public void deleteById(Integer id){
        customerRepo.deleteById(getCustomerById(id).getId());
    }

    @Transactional
    public Customer updateCustomer(Customer updatedCustomer){
        return customerRepo.saveAndFlush(updatedCustomer);
    }

}
