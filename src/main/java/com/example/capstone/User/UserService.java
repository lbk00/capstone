package com.example.capstone.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(User user);
    List<User> getAllUser(Long userId);
    Optional<User> getUserById(Long userId);
    void deleteUser(Long userId);


}
