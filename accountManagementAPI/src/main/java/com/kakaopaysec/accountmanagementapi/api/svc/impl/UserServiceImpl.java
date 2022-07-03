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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Value("${custom.service.timezone}")
    String timeZone;

    @Autowired
    UserRepository userRepository;


    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");




    /**
     * 사용자 정보 추가.
     * @param requestDTO
     * @return
     */
    @Override
    @Transactional
    public UserResponseDTO userRegist(UserRequestDTO requestDTO) {

        LocalDateTime curTime = LocalDateTime.parse(LocalDateTime.now(ZoneId.of(timeZone)).format(formatter));


        UserVo userVo = new UserVo();

        userVo.setName(requestDTO.getUserName());
        userVo.setAge(requestDTO.getAge());
        userVo.setCreatedAt(curTime);

        try{
            userRepository.save(userVo);
        }catch (Exception e){
            e.printStackTrace();
            log.error(ResponseCode.USER_REGIST_FAIL.getMessage());
            return new UserResponseDTO(ResponseCode.USER_REGIST_FAIL.getErrorCode(), ResponseCode.USER_REGIST_FAIL.getMessage());
        }

        return new UserResponseDTO(ResponseCode.USER_REGIST_SUCCESS.getErrorCode(), ResponseCode.USER_REGIST_SUCCESS.getMessage(), requestDTO);
    }

    /**
     * 사용자 정보를 모두 조회한다.
     * @param requestDTO
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public UserResponseDTO userSearch(UserRequestDTO requestDTO) {
        PageRequest pageRequest = PageRequest.of(0, 5);


        Page<UserVo> userVoPage = userRepository.findAll(pageRequest);


        return null;
    }
}
