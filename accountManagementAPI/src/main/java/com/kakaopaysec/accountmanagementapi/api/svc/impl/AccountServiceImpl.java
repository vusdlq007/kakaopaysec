package com.kakaopaysec.accountmanagementapi.api.svc.impl;

import com.kakaopaysec.accountmanagementapi.api.dto.AccountRequestDTO;
import com.kakaopaysec.accountmanagementapi.api.dto.AccountResponseDTO;

import com.kakaopaysec.accountmanagementapi.api.repo.AccountRepository;
import com.kakaopaysec.accountmanagementapi.api.svc.AccountService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Value("${custom.service.timezone}")
    String timeZone;

    @Autowired
    AccountRepository accountRepository;

    @Override
    @Transactional
    public AccountResponseDTO accountRegist(AccountRequestDTO requestDTO) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public AccountResponseDTO accountList(AccountRequestDTO requestDTO) {
        return null;
    }
}
