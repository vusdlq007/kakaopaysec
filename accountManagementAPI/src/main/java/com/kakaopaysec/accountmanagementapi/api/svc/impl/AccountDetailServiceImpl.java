package com.kakaopaysec.accountmanagementapi.api.svc.impl;

import com.kakaopaysec.accountmanagementapi.api.dto.AccountDetailRequestDTO;
import com.kakaopaysec.accountmanagementapi.api.dto.AccountDetailResponseDTO;

import com.kakaopaysec.accountmanagementapi.api.repo.AccountDetailsRepository;
import com.kakaopaysec.accountmanagementapi.api.svc.AccountDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class AccountDetailServiceImpl implements AccountDetailService {

    @Value("${custom.service.timezone}")
    String timeZone;

    @Autowired
    AccountDetailsRepository accountDetailsRepository;


    @Override
    @Transactional
    public AccountDetailResponseDTO accountDetailRegist(AccountDetailRequestDTO requestDTO) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public AccountDetailResponseDTO accountDetailSearch(AccountDetailRequestDTO requestDTO) {
        return null;
    }
}
