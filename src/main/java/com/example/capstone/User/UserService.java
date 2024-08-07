package com.example.capstone.User;

import java.util.List;

public interface UserService {

    UserDTO saveUser(User user);
    void deleteUser(User user);
    //id로 user조회
    User getUserById(long id);
    void updateUser(User user);
    List<UserDTO> findAll();
    //UserDTO login(String uId, String uPw);
}
