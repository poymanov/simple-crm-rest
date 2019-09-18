package com.learning.simplecrm.rest;

import com.learning.simplecrm.entity.Customer;
import com.learning.simplecrm.exception.CustomerNotFoundException;
import com.learning.simplecrm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id) {
        Customer customer = customerService.getCustomer(id);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + id);
        }

        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }
}
