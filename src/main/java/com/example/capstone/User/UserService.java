package com.example.capstone.User;

import org.springframework.stereotype.Service;

import java.util.List;



public interface UserService {

    void saveUser(User user);
    void deleteUser(User user);

    User getUserById(long id);
}
