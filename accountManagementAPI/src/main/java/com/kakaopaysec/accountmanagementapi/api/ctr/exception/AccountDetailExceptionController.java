package com.kakaopaysec.accountmanagementapi.api.ctr.exception;

import com.kakaopaysec.accountmanagementapi.api.ctr.AccountDetailRestController;
import com.kakaopaysec.accountmanagementapi.api.dto.UserResponseDTO;
import com.kakaopaysec.accountmanagementapi.cmm.constant.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;


@RestControllerAdvice(basePackageClasses = AccountDetailRestController.class)
@Slf4j
public class AccountDetailExceptionController {

    // 400
    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<?> handleNoSuchUserException(Exception e) {
        final UserResponseDTO errorResponse = new UserResponseDTO(ResponseCode.ACCOUNT_DETAIL_REGIST_FAIL.getErrorCode(), ResponseCode.ACCOUNT_DETAIL_REGIST_FAIL.getMessage());

        return ResponseEntity.status(ResponseCode.ACCOUNT_DETAIL_REGIST_FAIL.getErrorCode()).body(errorResponse);
    }


    // 500
    @ExceptionHandler()
    protected ResponseEntity<?> handleRegistUserException(Exception e) {
        final UserResponseDTO errorResponse = new UserResponseDTO(ResponseCode.ACCOUNT_DETAIL_REGIST_FAIL.getErrorCode(), ResponseCode.ACCOUNT_DETAIL_REGIST_FAIL.getMessage());

        return ResponseEntity.status(ResponseCode.ACCOUNT_DETAIL_REGIST_FAIL.getErrorCode()).body(errorResponse);
    }

}
