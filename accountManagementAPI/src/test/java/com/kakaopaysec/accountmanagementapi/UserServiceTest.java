package com.kakaopaysec.accountmanagementapi;



import com.kakaopaysec.accountmanagementapi.api.dto.UserRequestDTO;
import com.kakaopaysec.accountmanagementapi.api.dto.UserResponseDTO;
import com.kakaopaysec.accountmanagementapi.api.repo.UserRepository;
import com.kakaopaysec.accountmanagementapi.api.svc.UserService;
import com.kakaopaysec.accountmanagementapi.api.svc.impl.UserServiceImpl;
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
public class UserServiceTest {


    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Before
    public void before(){
        this.userService = new UserServiceImpl(userRepository);
    }

    @Test
    @DisplayName("사용자 추가 성공")
    public void userSaveSuccess() throws Exception {

        UserRequestDTO requestDTO = new UserRequestDTO();
        ReflectionTestUtils.setField(requestDTO,"userName","김윤권");
        ReflectionTestUtils.setField(requestDTO,"age",30);

        UserResponseDTO responseDTO = new UserResponseDTO();
        ReflectionTestUtils.setField(responseDTO,"resCode", ResponseCode.USER_REGIST_SUCCESS.getStatus());
        ReflectionTestUtils.setField(responseDTO,"resResult", ResponseCode.USER_REGIST_SUCCESS.getMessage());
        ReflectionTestUtils.setField(responseDTO,"resMessage", ResponseCode.USER_REGIST_SUCCESS.getErrorCode());

        // when
        //then
        Assertions.assertThat(userService.userRegist(requestDTO).getResCode()).isEqualTo(responseDTO.getResCode());
    }


    @Test
    @DisplayName("사용자 가입 실패, 잘못된요청")
    public void userSaveFail() throws Exception {

        UserRequestDTO requestDTO = new UserRequestDTO();
        ReflectionTestUtils.setField(requestDTO,"userName","김윤권");
        ReflectionTestUtils.setField(requestDTO,"age",30);

        UserResponseDTO responseDTO = new UserResponseDTO();
        ReflectionTestUtils.setField(responseDTO,"resCode", ResponseCode.USER_REGIST_FAIL.getStatus());
        ReflectionTestUtils.setField(responseDTO,"resResult", ResponseCode.USER_REGIST_FAIL.getMessage());
        ReflectionTestUtils.setField(responseDTO,"resMessage", ResponseCode.USER_REGIST_FAIL.getErrorCode());

        // when
        //then
        Assertions.assertThat(userService.userRegist(requestDTO).getResCode()).isEqualTo(responseDTO.getResCode());
    }
}
