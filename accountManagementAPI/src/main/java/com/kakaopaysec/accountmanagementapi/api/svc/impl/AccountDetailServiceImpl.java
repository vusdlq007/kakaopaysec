package com.kakaopaysec.accountmanagementapi.api.svc.impl;

import com.kakaopaysec.accountmanagementapi.api.dto.*;

import com.kakaopaysec.accountmanagementapi.api.repo.AccountDetailsRepository;
import com.kakaopaysec.accountmanagementapi.api.svc.AccountDetailService;
import com.kakaopaysec.accountmanagementapi.api.vo.AccountDetailVo;

import com.kakaopaysec.accountmanagementapi.api.vo.AccountVo;
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
import java.util.List;
import java.util.Optional;

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
     *
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
     *
     * @param requestDTO
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public AccountDetailResponseDTO accountDetailSearch(AccountDetailRequestDTO requestDTO, Pageable pageable) {

        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());

        Page<AccountDetailVo> accountDetailVoPage = null;

        accountDetailVoPage = accountDetailsRepository.findAll(pageRequest);


        return new AccountDetailResponseDTO(ResponseCode.ACCOUNT_DETAIL_SEARCH_SUCCESS.getErrorCode(), ResponseCode.ACCOUNT_DETAIL_SEARCH_SUCCESS.getMessage(), accountDetailVoPage.getContent());

    }

    /**
     * 사용자의 계좌별 예치금 조회.
     *
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public AccountDetailResponseDTO userDepositInfo(String userId) {

        List<UserDepositDTO> userDepositList = null;
        try {
             userDepositList = accountDetailsRepository.findAllByUserAccountEachDeposit(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new AccountDetailResponseDTO(ResponseCode.ACCOUNT_DETAIL_SEARCH_SUCCESS.getErrorCode(), ResponseCode.ACCOUNT_DETAIL_SEARCH_SUCCESS.getMessage(), userDepositList);
    }

    /**
     * 연령별 예치금 평균 조회.
     *
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public AccountDetailResponseDTO agesAvgDeposit() {

        List<DepositAvgDTO> depositAvg = accountDetailsRepository.findByAgesTotalAvg();

        return new AccountDetailResponseDTO(ResponseCode.ACCOUNT_DETAIL_SEARCH_SUCCESS.getErrorCode(), ResponseCode.ACCOUNT_DETAIL_SEARCH_SUCCESS.getMessage(), depositAvg);
    }

    /**
     * 해당기간안에 돈을 가장 많이 예치한 사용자 순으로 정렬해서 출력함.
     * @param startTime
     * @param endTime
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public AccountDetailResponseDTO mostDepositUserOfLange(String startTime, String endTime) {

        LocalDateTime localStartTime = LocalDateTime.parse(startTime);
        LocalDateTime localsEndTime = LocalDateTime.parse(endTime);

        List<MostDepositDTO> mostDepositList = accountDetailsRepository.findAllByMostDepositEarnUserBetween(localStartTime,localsEndTime);

        return new AccountDetailResponseDTO(ResponseCode.ACCOUNT_DETAIL_SEARCH_SUCCESS.getErrorCode(), ResponseCode.ACCOUNT_DETAIL_SEARCH_SUCCESS.getMessage(), mostDepositList);
    }
}
