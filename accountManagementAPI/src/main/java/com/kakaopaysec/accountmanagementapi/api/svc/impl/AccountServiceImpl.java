package com.kakaopaysec.accountmanagementapi.api.svc.impl;

import com.kakaopaysec.accountmanagementapi.api.dto.AccountRequestDTO;
import com.kakaopaysec.accountmanagementapi.api.dto.AccountResponseDTO;
import com.kakaopaysec.accountmanagementapi.api.repo.AccountRepository;
import com.kakaopaysec.accountmanagementapi.api.repo.UserRepository;
import com.kakaopaysec.accountmanagementapi.api.svc.AccountService;
import com.kakaopaysec.accountmanagementapi.api.vo.AccountVo;
import com.kakaopaysec.accountmanagementapi.cmm.constant.ResponseCode;
import com.kakaopaysec.accountmanagementapi.cmm.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    /**
     * 특정 사용자의 계좌를 등록한다.
     *
     * @param requestDTO
     * @return
     */
    @Override
    public AccountResponseDTO accountRegist(AccountRequestDTO requestDTO) {

        // Member 랜덤 고유키 생성(8자리)
        String accountNumber = Util.generateAccountUUID(8);

        AccountVo accountVo = new AccountVo();

        accountVo.setUserId(requestDTO.getUserId());
        accountVo.setAccountNumber(accountNumber);

        // 기본적으로 Transactional이 동작함.
        accountRepository.save(accountVo);


        return new AccountResponseDTO(ResponseCode.ACCOUNT_REGIST_SUCCESS.getErrorCode(), ResponseCode.ACCOUNT_REGIST_SUCCESS.getMessage());
    }

    /**
     * 계좌 목록을 페이징 정보에 맞춰 조회한다.
     *
     * @param pageable
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public AccountResponseDTO accountList(Pageable pageable) {

        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());

        Page<AccountVo> accountVoPage = null;

        accountVoPage = accountRepository.findAll(pageRequest);


        return new AccountResponseDTO(ResponseCode.ACCOUNT_SEARCH_SUCCESS.getErrorCode(), ResponseCode.ACCOUNT_SEARCH_SUCCESS.getMessage(), accountVoPage.getContent());

    }
}
