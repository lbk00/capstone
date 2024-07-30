// com.example.capstone.User.UserService.java
package com.example.capstone.User;

import org.springframework.beans.factory.annotation.Autowired;
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

    //사용자 생성
    @Override
    public void saveUser(User user){

        /*
        User user = User.builder().
                cID(userDTO.getCID()).cPW(userDTO.getCPW()).cName(userDTO.getCName()).
                cGender(userDTO.getCGender()).cbirthDate(userDTO.getCbirthDate()).
                ctel(userDTO.getCtel()).cEmail(userDTO.getCEmail()).build();
        */

        User createuser = User.builder().
                cID(user.getCID()).cPW(user.getCPW()).cName(user.getCName()).
                cGender(user.getCGender()).cbirthDate(user.getCbirthDate()).
                ctel(user.getCtel()).cEmail(user.getCEmail()).build();
        // 사용자 저장
        userRepository.save(createuser);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    //id로 user 조회
    @Override
    public User getUserById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null); // 없을 경우 null 반환
    }

    //사용자 정보 수정
    @Override
    public void updateUser(User user) {
        //사용자 객체 생성 후 새로 저장
        //userRepository.save();
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDtos = users.stream()
                .map(user -> UserDTO.toDto(user))
                .toList();
        return userDtos;
    }

    // Business methods for User
}