// com.example.capstone.User.UserController.java
package com.example.capstone.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    // users/{id}
    @GetMapping("{id}")
    public String find(@PathVariable Long id) {

        //회원 목록
        //회원가입 페이지
        //회원 상세정보
        //로그인 페이지

        User user = User.builder().
                cID("lbk").cPW("1234").cName("이본규").
                cGender('M').cbirthDate("2000-03-18").
                ctel("01030116661").cEmail("lbk11@gmail.com").build();

        // 사용자 저장
        userService.saveUser(user);
        System.out.println(user);
        return "userfind";
    }



    // Endpoints for User
}