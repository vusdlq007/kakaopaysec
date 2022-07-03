package com.kakaopaysec.accountmanagementapi;



import com.kakaopaysec.accountmanagementapi.api.dto.AccountRequestDTO;
import com.kakaopaysec.accountmanagementapi.api.dto.AccountResponseDTO;
import com.kakaopaysec.accountmanagementapi.api.repo.AccountRepository;

import com.kakaopaysec.accountmanagementapi.api.svc.AccountService;

import com.kakaopaysec.accountmanagementapi.api.svc.impl.AccountServiceImpl;

import com.kakaopaysec.accountmanagementapi.cmm.constant.ResponseCode;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@RunWith(SpringRunner.class)
public class AccountServiceTest {


    AccountService accountService;

    @Autowired
    AccountRepository accountRepository;

    @Before
    public void before(){
        this.accountService = new AccountServiceImpl(accountRepository);
    }

    @Test
    @DisplayName("계좌 추가 성공")
    public void AccountPushSuccess() throws Exception {

        AccountRequestDTO requestDTO = new AccountRequestDTO();
        ReflectionTestUtils.setField(requestDTO,"userId",10);

        AccountResponseDTO responseDTO = new AccountResponseDTO();
        ReflectionTestUtils.setField(responseDTO,"resCode", ResponseCode.ACCOUNT_REGIST_SUCCESS.getStatus());
        ReflectionTestUtils.setField(responseDTO,"resResult", ResponseCode.ACCOUNT_REGIST_SUCCESS.getMessage());
        ReflectionTestUtils.setField(responseDTO,"resMessage", ResponseCode.ACCOUNT_REGIST_SUCCESS.getErrorCode());

        // when
        //then
        Assertions.assertThat(accountService.accountRegist(requestDTO).getResCode()).isEqualTo(responseDTO.getResCode());
    }


    @Test
    @DisplayName("계좌추가 실패, 잘못된요청")
    public void AccountPushFail() throws Exception {

        AccountRequestDTO requestDTO = new AccountRequestDTO();
        ReflectionTestUtils.setField(requestDTO,"userId",10);

        AccountResponseDTO responseDTO = new AccountResponseDTO();
        ReflectionTestUtils.setField(responseDTO,"resCode", ResponseCode.ACCOUNT_REGIST_FAIL.getStatus());
        ReflectionTestUtils.setField(responseDTO,"resResult", ResponseCode.ACCOUNT_REGIST_FAIL.getMessage());
        ReflectionTestUtils.setField(responseDTO,"resMessage", ResponseCode.ACCOUNT_REGIST_FAIL.getErrorCode());

        // when
        //then
        Assertions.assertThat(accountService.accountRegist(requestDTO).getResCode()).isEqualTo(responseDTO.getResCode());
    }
}
