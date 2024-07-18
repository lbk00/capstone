package com.example.capstone.User;

import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {


    void saveUser(User user);
    List<User> getAllUser();
    Optional<User> getUserById(Long userId);
    void deleteUser(Long userId);


}
