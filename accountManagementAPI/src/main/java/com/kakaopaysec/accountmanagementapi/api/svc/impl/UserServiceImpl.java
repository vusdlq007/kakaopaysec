package com.kakaopaysec.accountmanagementapi.api.svc.impl;

import com.kakaopaysec.accountmanagementapi.api.dto.UserRequestDTO;
import com.kakaopaysec.accountmanagementapi.api.dto.UserResponseDTO;
import com.kakaopaysec.accountmanagementapi.api.repo.UserRepository;
import com.kakaopaysec.accountmanagementapi.api.svc.UserService;
import com.kakaopaysec.accountmanagementapi.api.vo.UserVo;
import com.kakaopaysec.accountmanagementapi.cmm.constant.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Value("${custom.service.timezone}")
    String timeZone;

    @Autowired
    UserRepository userRepository;


    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");


    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * 사용자 정보 추가.
     *
     * @param requestDTO
     * @return
     */
    @Override
    public UserResponseDTO userRegist(UserRequestDTO requestDTO) {

        LocalDateTime curTime = LocalDateTime.parse(LocalDateTime.now(ZoneId.of(timeZone)).format(formatter));


        UserVo userVo = new UserVo();

        userVo.setName(requestDTO.getUserName());
        userVo.setAge(requestDTO.getAge());
        userVo.setCreatedAt(curTime);


        // 기본적으로 Transactional이 동작함.
        userRepository.save(userVo);


        return new UserResponseDTO(ResponseCode.USER_REGIST_SUCCESS.getErrorCode(), ResponseCode.USER_REGIST_SUCCESS.getMessage());
    }

    /**
     * 사용자 정보를 모두 조회한다.
     *
     * @param pageable
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public UserResponseDTO userSearch(Pageable pageable) {

        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());

        Page<UserVo> userVoPage = null;

        userVoPage = userRepository.findAll(pageRequest);


        return new UserResponseDTO(ResponseCode.USER_SEARCH_SUCCESS.getErrorCode(), ResponseCode.USER_SEARCH_SUCCESS.getMessage(), userVoPage.getContent());
    }
}
