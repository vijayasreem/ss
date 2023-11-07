
package com.sales.demo.repository;

import com.sales.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.identityVerified = true AND u.addressVerified = true")
    boolean isIdentityAndAddressVerified();

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.annualIncome >= 30000 AND u.creditScore >= 700")
    boolean isEligibleForHighCreditLimit();

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.annualIncome >= 20000 AND u.creditScore >= 600")
    boolean isEligibleForModerateCreditLimit();

}
