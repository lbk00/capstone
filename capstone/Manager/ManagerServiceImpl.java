package com.example.capstone.Manager;

import com.example.capstone.DTO.PageRequestDTO;
import com.example.capstone.DTO.PageResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService{

    private final ManagerRepository managerRepository;

    @Override
    public ManagerDTO get(Long userid) {

        Optional<Manager> result = managerRepository.findById(userid);

        Manager manager = result.orElseThrow();

        return entityToDTO(manager);
    }

    @Override
    public Long register(ManagerDTO dto) {

        Manager manager = dtoToEntity(dto);

        Manager result = managerRepository.save(manager);

        return result.getUserId();
    }

    @Override
    public void modify(ManagerDTO dto) {



    }

    @Override
    public void remove(Long userid) {

        managerRepository.deleteById(userid);
    }

    @Override
    public PageResponseDTO<ManagerDTO> getManagerList(PageRequestDTO pageRequestDTO) {

        //JPA를 이용한 페이징 처리
        Page<Manager> result = managerRepository.search1(pageRequestDTO);

        List<ManagerDTO> dtoList = result.get().map(manager -> entityToDTO(manager)).collect(Collectors.toList());

        PageResponseDTO<ManagerDTO> responseDTO =
                PageResponseDTO.<ManagerDTO>withAll()
                        .dtoList(dtoList)
                        .pageRequestDTO(pageRequestDTO)
                        .total(result.getTotalElements())
                        .build();





        return responseDTO;
    }


}
