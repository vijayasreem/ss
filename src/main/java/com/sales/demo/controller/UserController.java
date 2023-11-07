package com.sales.demo.controller;

import com.sales.demo.model.User;
import com.sales.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/verifyDocumentAndEvaluateCredit")
    public String verifyDocumentAndEvaluateCredit(@RequestBody User user) {
        return userService.verifyDocumentAndEvaluateCredit(user);
    }
}