package com.example.capstone.User;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Optional;

public class UserServiceImplTest {

    UserRepository userRepository = new UserRepositotyImpl();
    UserService userService = new UserServiceImpl(userRepository);

    //사용자 저장 테스트
    @Test
    void register() {
        //사용자 객체 생성
        User user = new User("lbk", "1234","이본규", '남',  new Date(2000, 4, 15), "01030116661", "lbk11@gmail.com");
        //사용자 저장
        userService.saveUser(user);
        //사용자 고유번호 가져오기
        Long userId = user.getUserId();
        // userId로 사용자 찾기
        Optional<User> findUser = userService.getUserById(userId);



    }

}
