package com.kakaopaysec.accountmanagementapi;


import com.kakaopaysec.accountmanagementapi.api.dto.AccountDetailRequestDTO;
import com.kakaopaysec.accountmanagementapi.api.dto.AccountDetailResponseDTO;
import com.kakaopaysec.accountmanagementapi.api.repo.AccountDetailsRepository;
import com.kakaopaysec.accountmanagementapi.api.svc.AccountDetailService;

import com.kakaopaysec.accountmanagementapi.api.svc.impl.AccountDetailServiceImpl;
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
public class AccountDetailServiceTest {


    AccountDetailService accountDetailService;

    @Autowired
    AccountDetailsRepository accountDetailRepository;

    @Before
    public void before(){
        this.accountDetailService = new AccountDetailServiceImpl(accountDetailRepository);
    }

    @Test
    @DisplayName("계좌 내역 추가 성공")
    public void AccountDetailPushSuccess() throws Exception {

        AccountDetailRequestDTO requestDTO = new AccountDetailRequestDTO();
        ReflectionTestUtils.setField(requestDTO,"accountNumber","1000-01");
        ReflectionTestUtils.setField(requestDTO,"isDeposit","Y");
        ReflectionTestUtils.setField(requestDTO,"depositAmount",15000);

        AccountDetailResponseDTO responseDTO = new AccountDetailResponseDTO();
        ReflectionTestUtils.setField(responseDTO,"resCode", ResponseCode.ACCOUNT_DETAIL_REGIST_SUCCESS.getStatus());
        ReflectionTestUtils.setField(responseDTO,"resResult", ResponseCode.ACCOUNT_DETAIL_REGIST_SUCCESS.getMessage());
        ReflectionTestUtils.setField(responseDTO,"resMessage", ResponseCode.ACCOUNT_DETAIL_REGIST_SUCCESS.getErrorCode());

        // when
        //then
        Assertions.assertThat(accountDetailService.accountDetailRegist(requestDTO).getResCode()).isEqualTo(responseDTO.getResCode());
    }


    @Test
    @DisplayName("계좌내역 추가 실패, 잘못된요청")
    public void AccountDetailPushFail() throws Exception {

        AccountDetailRequestDTO requestDTO = new AccountDetailRequestDTO();
        ReflectionTestUtils.setField(requestDTO,"accountNumber","1000-01");
        ReflectionTestUtils.setField(requestDTO,"isDeposit","Y");
        ReflectionTestUtils.setField(requestDTO,"depositAmount",15000);

        AccountDetailResponseDTO responseDTO = new AccountDetailResponseDTO();
        ReflectionTestUtils.setField(responseDTO,"resCode", ResponseCode.ACCOUNT_DETAIL_REGIST_FAIL.getStatus());
        ReflectionTestUtils.setField(responseDTO,"resResult", ResponseCode.ACCOUNT_DETAIL_REGIST_FAIL.getMessage());
        ReflectionTestUtils.setField(responseDTO,"resMessage", ResponseCode.ACCOUNT_DETAIL_REGIST_FAIL.getErrorCode());

        // when
        //then
        Assertions.assertThat(accountDetailService.accountDetailRegist(requestDTO).getResCode()).isEqualTo(responseDTO.getResCode());
    }
}
