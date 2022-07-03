package com.kakaopaysec.accountmanagementapi.api.svc.impl;

import com.kakaopaysec.accountmanagementapi.api.dto.AccountDetailRequestDTO;
import com.kakaopaysec.accountmanagementapi.api.dto.AccountDetailResponseDTO;

import com.kakaopaysec.accountmanagementapi.api.dto.AccountResponseDTO;
import com.kakaopaysec.accountmanagementapi.api.repo.AccountDetailsRepository;
import com.kakaopaysec.accountmanagementapi.api.svc.AccountDetailService;
import com.kakaopaysec.accountmanagementapi.api.vo.AccountDetailVo;
import com.kakaopaysec.accountmanagementapi.api.vo.AccountVo;
import com.kakaopaysec.accountmanagementapi.cmm.constant.ResponseCode;
import com.kakaopaysec.accountmanagementapi.cmm.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class AccountDetailServiceImpl implements AccountDetailService {

    @Value("${custom.service.timezone}")
    String timeZone;

    @Autowired
    AccountDetailsRepository accountDetailsRepository;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");


    /**
     * 계좌 내역을 등록한다.
     * @param requestDTO
     * @return
     */
    @Override
    public AccountDetailResponseDTO accountDetailRegist(AccountDetailRequestDTO requestDTO) {

        LocalDateTime curTime = LocalDateTime.parse(LocalDateTime.now(ZoneId.of(timeZone)).format(formatter));

        AccountDetailVo accountDetailVo = new AccountDetailVo();

        accountDetailVo.setAccountNumber(requestDTO.getAccountNumber());
        accountDetailVo.setIsDeposit(requestDTO.getIsDeposit());
        accountDetailVo.setDepositAmount(requestDTO.getDepositAmount());
        accountDetailVo.setCreatedAt(curTime);

        // 기본적으로 Transactional이 동작함.
        accountDetailsRepository.save(accountDetailVo);


        return new AccountDetailResponseDTO(ResponseCode.ACCOUNT_DETAIL_REGIST_SUCCESS.getErrorCode(), ResponseCode.ACCOUNT_DETAIL_REGIST_SUCCESS.getMessage());

    }

    /**
     * 계좌 내역 목록을 페이징 정보에 맞춰 조회한다.
     * @param requestDTO
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public AccountDetailResponseDTO accountDetailSearch(AccountDetailRequestDTO requestDTO) {
        return null;
    }
}
