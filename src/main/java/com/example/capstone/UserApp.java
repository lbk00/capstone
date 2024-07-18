package com.example.capstone;

import com.example.capstone.User.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class UserApp {
    public static void main(String[] args) {


        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserServiceImpl(userRepository);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.APRIL, 15);
        Date birthDate = calendar.getTime();

        //사용자 객체 생성
        User user = new User(1L, "lbk", "1234","이본규", '남',  birthDate, "01030116661", "lbk11@gmail.com");
        //사용자 저장
        userService.saveUser(user);
        Optional<User> findUser = userService.getUserById(1L);
        System.out.println(user.getCName());
        if (findUser.isPresent()) {
            System.out.println(findUser.get().getCName());
        }



    }
}
