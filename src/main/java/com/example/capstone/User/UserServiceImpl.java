// com.example.capstone.User.UserService.java
package com.example.capstone.User;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public void saveUser(UserDTO userDTO){

        /*
        User user = User.builder().
                cID(userDTO.getCID()).cPW(userDTO.getCPW()).cName(userDTO.getCName()).
                cGender(userDTO.getCGender()).cbirthDate(userDTO.getCbirthDate()).
                ctel(userDTO.getCtel()).cEmail(userDTO.getCEmail()).build();
        */
        User user = new User();
        user.setCID(userDTO.getCID());
        user.setCPW(userDTO.getCPW());
        user.setCName(userDTO.getCName());
        user.setCGender(userDTO.getCGender());
        user.setCbirthDate(userDTO.getCbirthDate());
        user.setCtel(userDTO.getCtel());
        user.setCEmail(userDTO.getCEmail());
        user.setUserId(userDTO.getUserId());
        // 사용자 저장
        userRepository.save(user);
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

    }

    // Business methods for User
}