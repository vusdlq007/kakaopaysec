package com.kakaopaysec.accountmanagementapi.api.svc.impl;

import com.kakaopaysec.accountmanagementapi.api.dto.UserRequestDTO;
import com.kakaopaysec.accountmanagementapi.api.dto.UserResponseDTO;
import com.kakaopaysec.accountmanagementapi.api.repo.UserRepository;
import com.kakaopaysec.accountmanagementapi.api.svc.UserService;
import com.kakaopaysec.accountmanagementapi.api.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Value("${custom.service.timezone}")
    String timeZone;

    @Autowired
    UserRepository userRepository;


    /**
     * 현재 포인트 조회.
     * @param requestDTO
     * @return
     */

//    public EarnResponseDTO searchPoint(EarnRequestDTO requestDTO) {
//
//        Optional<PointVo> pointVo = null;
//
//        MemberVo memberVo = new MemberVo();
//        memberVo.setBarcode(requestDTO.getBarcode());
//
//        StoreCategoryVo categoryVo = new StoreCategoryVo();
//        categoryVo.setCategoryId(requestDTO.getCategoryId());
//        try{
//            pointVo = pointRepository.findByBarcodeAndCategory(requestDTO.getBarcode(), requestDTO.getCategoryId());
//        }catch (Exception e){
//            log.error("ERRMSG ",e.getMessage());
//            return new EarnResponseDTO(ResponseCode.POINT_SEARCH_FAIL.getStatus(), ResponseCode.POINT_SEARCH_FAIL.getErrorCode(), requestDTO.getCategoryId(), requestDTO.getStoreId(), null, TypeConstant.EARN, requestDTO.getStoreName(), requestDTO.getBarcode(), requestDTO.getEarnPoint());
//        }
//
//        return new EarnResponseDTO(ResponseCode.POINT_SEARCH_SUCCESS.getStatus(), ResponseCode.POINT_SEARCH_SUCCESS.getErrorCode(), requestDTO.getCategoryId(), requestDTO.getStoreId(), null, TypeConstant.EARN, requestDTO.getStoreName(), requestDTO.getBarcode(), requestDTO.getEarnPoint());
//    }

    /**
     * 사용자 정보를 추가한다.
     * @param requestDTO
     * @return
     */
    @Override
    @Transactional
    public UserResponseDTO userRegist(UserRequestDTO requestDTO) {
        return null;
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
