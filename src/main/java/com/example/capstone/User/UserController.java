// com.example.capstone.User.UserController.java
package com.example.capstone.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    //로그인 페이지 api
    @PostMapping("login")
    public ResponseEntity<UserDTO> login(@RequestBody UserLoginDTO userLoginDTO) {
        // id와 pw가 기존에 있던값인지 검증 후 로그인
        UserDTO userDTO = userService.login(userLoginDTO.getUID(), userLoginDTO.getUPW());
        return ResponseEntity.ok(userDTO);
    }

    //회원 정보 조회
    @GetMapping("{id}")
    public String find(@PathVariable("id") long id) {
        return userService.getUserById(id).toString();
    }

    //회원 목록 조회
    @GetMapping("list")
    public List<UserDTO> userLists() {
        return userService.findAll();
    }

    //회원가입 페이지
    @PostMapping("register")
    public String register(@RequestBody User user) {
        //리액트에서 입력받은 값으로 user 생성
        // userDTO -> user로 임시 수정
        /*
        User user = User.builder().
                cID("lbk").cPW("1234").cName("이본규").
                cGender('M').cbirthDate(new Date(2000,3,18)).
                ctel("01030116661").cEmail("lbk11@gmail.com").build();
        */
        System.out.println("사용자 DTO = "+ user.getCName());
        userService.saveUser(user);
        // 사용자 저장
        //회원가입 완료창 리턴
        return userService.getUserById(user.getUserId()).toString();
    }



    // Endpoints for User
}