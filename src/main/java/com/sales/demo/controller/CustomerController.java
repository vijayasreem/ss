package com.sales.demo.controller;

import com.sales.demo.model.Customer;
import com.sales.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/email/{email}")
    public Customer findCustomerByEmail(@PathVariable String email) {
        return customerService.findCustomerByEmail(email);
    }

    @GetMapping("/mobile/{mobileNumber}")
    public Customer findCustomerByMobileNumber(@PathVariable String mobileNumber) {
        return customerService.findCustomerByMobileNumber(mobileNumber);
    }

    @GetMapping("/exists/email/{email}")
    public boolean existsCustomerByEmail(@PathVariable String email) {
        return customerService.existsCustomerByEmail(email);
    }

    @GetMapping("/exists/mobile/{mobileNumber}")
    public boolean existsCustomerByMobileNumber(@PathVariable String mobileNumber) {
        return customerService.existsCustomerByMobileNumber(mobileNumber);
    }

    // Add additional methods for OTP authentication, PASA display, and HLV integration here

}
