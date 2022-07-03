package com.kakaopaysec.accountmanagementapi;

import com.kakaopaysec.accountmanagementapi.api.repo.UserRepository;
import com.kakaopaysec.accountmanagementapi.api.vo.UserVo;
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
public class UserRepoTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("사용자 정보가 DB에 저장이 잘 되는지 확인")
    public void saveUser() {
        // given
        UserVo user = new UserVo();
        user.setName("김윤권");
        user.setAge(30);
        // when
        UserVo savedUser = userRepository.save(user);
        // then
        Assertions.assertThat(savedUser.getUserId()).isNotNull();
    }




}
