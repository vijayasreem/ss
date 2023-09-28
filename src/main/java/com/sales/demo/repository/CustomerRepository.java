
package com.sales.demo.repository;

import com.sales.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Custom queries
    @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    Customer findByEmail(String email);

    @Query("SELECT c FROM Customer c WHERE c.mobileNumber = ?1")
    Customer findByMobileNumber(String mobileNumber);

    // Additional methods
    boolean existsByEmail(String email);

    boolean existsByMobileNumber(String mobileNumber);
}
