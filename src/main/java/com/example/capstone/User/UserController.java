// com.example.capstone.User.UserController.java
package com.example.capstone.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    public UserController(UserServiceImpl userServiceImpl) {
    }

    // Endpoints for User
}