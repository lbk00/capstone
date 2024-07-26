package com.example.capstone.Manager;

import com.example.capstone.DTO.PageRequestDTO;
import com.example.capstone.DTO.PageResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("api/manager")
public class ManagerController {

    private final ManagerService managerService;

    @GetMapping("/{userId}")
    public ManagerDTO get(@PathVariable("userId") Long userId) {
        log.info("get............" + userId);
        return managerService.get(userId);
    }

    @GetMapping("/list")
    public PageResponseDTO<ManagerDTO> list(PageRequestDTO pageRequestDTO ) {
        log.info(pageRequestDTO);
        return managerService.getManagerList(pageRequestDTO);
    }




}