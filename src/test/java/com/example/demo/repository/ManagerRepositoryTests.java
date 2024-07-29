package com.example.demo.repository;
import com.example.capstone.FinalApplication;
import com.example.capstone.Manager.Manager;
import com.example.capstone.Manager.ManagerRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@SpringBootTest(classes= FinalApplication.class)
@Log4j2
class ManagerRepositoryTests {

    @Autowired
    private ManagerRepository managerRepository;

    @Test
    public void test1() {
        log.info("--------------------------");
        log.info(managerRepository.getClass().getName());
    }
    @Test
    public void testInsert() {

        Manager manager = Manager.builder()
                .mID("admin")
                .mPW("admin")
                .mName("admin")
                .mGender("남")
                .mbirthDate(null)
                .mtel("010-1234-5678")
                .mEmail("eocndsjadjrk@naver.com")
                .mProfileImage(null)
                .uAdr("서울시 강남구")
                .build();

        Manager result = managerRepository.save(manager);

        log.info(result);
    }
    @Test
    public void testRead() {

        Long  userId = 4L;

        Optional<Manager> result = managerRepository.findById(userId);

        Manager manager = result.orElseThrow();

        log.info(manager);
    }

    @Test
    public void testUpdate() {
        // 먼저 로딩 하고 엔티티 객체를 변경

        Long userId = 4L;

        Optional<Manager> result = managerRepository.findById(userId);

        Manager manager = result.orElseThrow();

        manager.changemPW("1234");

        managerRepository.save(manager);
    }

    @Test
    public void testDelete() {

        Long userId = 4L;

        managerRepository.deleteById(userId);
    }

    @Test
    public void testPaging() {
//import org.springframework.data.domain.Pageable;
        Pageable pageable = PageRequest.of(0,10, Sort.by("tno").descending());
        Page<Manager> result = managerRepository.findAll(pageable);
        log.info(result.getTotalElements());
        result.getContent().stream().forEach(todo -> log.info(todo));
    }
//    @Test
//    public void testSearch() {
//
//        managerRepository.search1();
//
//    }
@Test
public void testExists() {
    Long userId = 5L;

    Optional<Manager> result = managerRepository.findById(userId);

    if (result.isPresent()) {
        log.info("userId = 5 exists in the database");
    } else {
        log.info("userId = 5 does not exist in the database");
    }
}
}

