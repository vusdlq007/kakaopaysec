package com.kakaopaysec.accountmanagementapi;

import com.kakaopaysec.accountmanagementapi.api.repo.AccountDetailsRepository;
import com.kakaopaysec.accountmanagementapi.api.vo.AccountDetailVo;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@RunWith(SpringRunner.class)
public class AccountDetailRepoTest {

    @Value("${custom.service.timezone}")
    String timeZone;

    @Autowired
    AccountDetailsRepository accountDetailsRepository;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Autowired
    private AccountDetailsRepository accountDetailRepository;

    @Test
    @DisplayName("계좌 내역 정보가 DB에 저장이 잘 되는지 확인")
    public void saveAccountDetail() {
        LocalDateTime curTime = LocalDateTime.parse(LocalDateTime.now(ZoneId.of(timeZone)).format(formatter));


        // given
        AccountDetailVo accountDetail = new AccountDetailVo();
        accountDetail.setAccountNumber("1000-01");
        accountDetail.setIsDeposit("Y");
        accountDetail.setDepositAmount(Long.getLong("15000"));
        accountDetail.setCreatedAt(curTime);

        // when
        AccountDetailVo savedAccount = accountDetailRepository.save(accountDetail);
        // then
        Assertions.assertThat(savedAccount.getAccountNumber()).isNotNull();
    }


}
