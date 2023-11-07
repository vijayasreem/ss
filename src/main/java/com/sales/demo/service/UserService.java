package com.sales.demo.service;

import com.sales.demo.model.User;
import com.sales.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isIdentityAndAddressVerified() {
        return userRepository.isIdentityAndAddressVerified();
    }

    public boolean isEligibleForHighCreditLimit() {
        return userRepository.isEligibleForHighCreditLimit();
    }

    public boolean isEligibleForModerateCreditLimit() {
        return userRepository.isEligibleForModerateCreditLimit();
    }

    public String verifyDocumentAndEvaluateCredit(User user) {
        StringBuilder message = new StringBuilder();

        if (user.isIdentityVerified() && user.isAddressVerified()) {
            message.append("Document verification is complete. ");

            if (user.getAnnualIncome() >= 30000 && user.getCreditScore() >= 700) {
                message.append("Congratulations! You are eligible for banking services with a high credit limit.");
            } else if (user.getAnnualIncome() >= 20000 && user.getCreditScore() >= 600) {
                message.append("You are eligible for banking services with a moderate credit limit.");
            } else {
                message.append("You are not eligible for banking services at the moment.");
            }
        } else {
            message.append("Document verification is incomplete. You are not eligible for banking services at the moment.");
        }

        return message.toString();
    }
}