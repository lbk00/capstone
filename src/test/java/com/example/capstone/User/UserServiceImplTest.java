package com.example.capstone.User;

import com.example.capstone.CapstoneApplication;
import com.example.capstone.User.User;
import com.example.capstone.User.UserRepository;
import com.example.capstone.User.UserServiceImpl;
import jakarta.annotation.security.RunAs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


//@SpringBootTest
//@ContextConfiguration(classes = CapstoneApplication.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUser() {
        // 사용자 객체 생성
        User user = new User(null, "lbk", "1234", "이본규", '남', new Date(2000 - 1900, 4 - 1, 15), "01030116661", "lbk11@gmail.com");

        // 사용자 저장
        userService.saveUser(user);

        // 사용자 조회
        Optional<User> findUser = userService.getUserById(1L);

        // 생성한 것과 find 한 것이 같은 객체인지 테스트
        assertThat(findUser).isPresent();
        assertThat(user).isEqualTo(findUser.get());

        // getAllUser가 올바른 리스트를 반환하는지 테스트
        List<User> users = userService.getAllUser();
        System.out.println(users);
        assertThat(users).containsExactly(user);
    }
}
