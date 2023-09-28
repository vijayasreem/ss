package com.sales.demo.service;

import com.sales.demo.model.Customer;
import com.sales.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public Customer findCustomerByMobileNumber(String mobileNumber) {
        return customerRepository.findByMobileNumber(mobileNumber);
    }

    public boolean existsCustomerByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    public boolean existsCustomerByMobileNumber(String mobileNumber) {
        return customerRepository.existsByMobileNumber(mobileNumber);
    }
}
