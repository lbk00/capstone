package com.example.demo.service;

import com.example.capstone.DTO.PageRequestDTO;
import com.example.capstone.FinalApplication;
import com.example.capstone.Manager.ManagerDTO;
import com.example.capstone.Manager.ManagerService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes= FinalApplication.class)
@Log4j2
public class MangerServiceTests {

    @Autowired
    ManagerService managerService;

    @Test
    public void testGet() {

        Long userId = 4L;

        log.info(managerService.get(userId));
    }
    @Test
    public void testRegister() {

        for (int i = 0; i < 20; i++) {
            ManagerDTO managerDTO = ManagerDTO.builder()
                    .userId((long) i)
                    .mID("admin" + i)
                    .mPW("admin" + i)
                    .mName("admin" + i)
                    .mGender("남")
                    .mbirthDate(null)
                    .mtel("010-1234-567" + i)
                    .mEmail("eocndsjadjrk" + i + "@naver.com")
                    .uAdr("서울시 강남구")
                    .build();

            log.info(managerService.register(managerDTO));
        }
    }

    @Test
    public void testGetList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(12)
                .build();

        log.info(managerService.getManagerList(pageRequestDTO));
    }
}
