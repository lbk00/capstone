// com.example.capstone.User.UserService.java
package com.example.capstone.User;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;




@Service
public class UserServiceImpl implements UserService{

    //jpaRepository 빈 등록
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    @Override
    public List<User> findUserByCName(String cName) {
        return userRepository.findByCName(cName);
    }
    */



    @Override
    public void saveUser(User user){
        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    // Business methods for User
}