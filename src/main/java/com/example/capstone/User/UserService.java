package com.example.capstone.User;

import org.springframework.stereotype.Service;

import java.util.List;



public interface UserService {

    void saveUser(User user);
    void deleteUser(User user);
    //id로 user조회
    User getUserById(long id);
    void updateUser(User user);
}
