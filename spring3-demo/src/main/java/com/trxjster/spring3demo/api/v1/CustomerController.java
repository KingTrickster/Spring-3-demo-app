package com.trxjster.spring3demo.api.v1;

import com.trxjster.spring3demo.dto.CustomerDTO;
import com.trxjster.spring3demo.model.Customer;
import com.trxjster.spring3demo.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable Integer customerId){
        return customerService.getCustomerById(customerId);
    }

    @GetMapping("/mock")
    public Customer mockCustomer(){
        CustomerDTO.NewCustomerRequest c = new CustomerDTO.NewCustomerRequest("Alex", "@mail.com", 25);
        return customerService.createCustomer(c);
    }

    @PostMapping("")
    public Customer create(@RequestBody CustomerDTO.NewCustomerRequest customer){
        return customerService.createCustomer(customer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable Integer customerId){
        customerService.deleteById(customerId);
    }

    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable Integer customerId, @RequestBody CustomerDTO.NewCustomerRequest updatedCustomer){
        Customer customer = customerService.getCustomerById(customerId);
        customer.setName(updatedCustomer.name());
        customer.setAge(updatedCustomer.age());
        customer.setEmail(updatedCustomer.email());
        return customerService.updateCustomer(customer);
    }
}
