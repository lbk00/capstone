// com.example.capstone.User.UserController.java
package com.example.capstone.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    //회원 정보 조회
    @GetMapping("{id}")
    public String find(@PathVariable("id") long id) {

        return userService.getUserById(id).toString();
    }

    //회원 목록
    @GetMapping("list")
    public String List() {
        return userRepository.findAll().toString();
    }

    //회원가입 페이지
    @PostMapping("register")
    public String register() {
        //리액트에서 입력받은 값으로 user 생성
        User user = User.builder().
                cID("lbk").cPW("1234").cName("이본규").
                cGender('M').cbirthDate(new Date(2000,3,18)).
                ctel("01030116661").cEmail("lbk11@gmail.com").build();

        // 사용자 저장
        userService.saveUser(user);

        //회원가입 완료창 리턴
        return userRepository.findAll().toString();
    }



    // Endpoints for User
}