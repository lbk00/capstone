package com.example.capstone;


import com.example.capstone.User.User;
import com.example.capstone.User.UserRepository;
import com.example.capstone.User.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void cleanup() {
        userRepository.deleteAll();
    }

    @Test
    void 사용자_생성및조회() {
        // 사용자 객체 생성
        User user = User.builder().
                cID("lbk").cPW("1234").cName("이본규").
                cGender('M').cbirthDate("2000-03-18").
                ctel("01030116661").cEmail("lbk11@gmail.com").build();

        // 사용자 저장
        userService.saveUser(user);
        System.out.println("사용자 = " + user);
        System.out.println("현재 사용자 목록 = " + userRepository.findAll());
        // 사용자 조회
        User findUser = userService.getUserById(7);
        // 생성한 것과 find 한 것이 같은 객체인지 테스트
        //Assertions.assertThat(user).isEqualTo(findUser);
        //사용자 삭제
        //userService.deleteUser(user);
        System.out.println("현재 사용자 목록 = " + userRepository.findAll());



    }

}
