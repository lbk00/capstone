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
    public UserServiceImpl(UserRepository repository) {
        this.userRepository = repository;
    }

    //사용자 저장
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    //사용자 리스트 반환
    @Override
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    //사용자 조회
    @Override
    public Optional<User> getUserById(Long userId){
        return userRepository.findById(userId);
    }
    //사용자 삭제
    @Override
    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }

    // Business methods for User
}