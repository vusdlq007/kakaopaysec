package com.kakaopaysec.accountmanagementapi;

import com.kakaopaysec.accountmanagementapi.api.repo.AccountRepository;
import com.kakaopaysec.accountmanagementapi.api.vo.AccountVo;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@RunWith(SpringRunner.class)
public class AccountRepoTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    @DisplayName("계좌 정보가 DB에 저장이 잘 되는지 확인")
    public void saveAccount() {
        // given
        AccountVo account = new AccountVo();
        account.setUserId(Long.getLong("30"));
        account.setAccountNumber("4000-2045");
        // when
        AccountVo savedAccount = accountRepository.save(account);
        // then
        Assertions.assertThat(savedAccount.getAccountNumber()).isNotNull();
    }


}
