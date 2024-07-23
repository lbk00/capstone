package com.example.capstone;

import com.example.capstone.User.User;
import com.example.capstone.User.UserRepository;
import com.example.capstone.User.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@EnableWebMvc
@SpringBootTest
class CapstoneApplicationTests {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void cleanup() {
        userRepository.deleteAll();
    }


    @Test
    void test1() {
        // 사용자 객체 생성
        User user = User.builder().
                cID("lbk").cPW("1234").cName("이본규").
                cGender('M').cbirthDate("2000-03-18").
                ctel("01030116661").cEmail("lbk11@gmail.com").build();

        // 사용자 저장
        userService.saveUser(user);
        System.out.println("사용자 = " + user);
        // 사용자 조회
        //userService.findUserByCName("이본규");
        //System.out.println(finduser);
        // 생성한 것과 find 한 것이 같은 객체인지 테스트
        //assertThat(findUser).isPresent();
        //assertThat(user).isEqualTo(findUser.get());

        // getAllUser가 올바른 리스트를 반환하는지 테스트
        //List<User> users = userService.getAllUser();
        //System.out.println(users);
        //assertThat(users).containsExactly(user);
    }
}
