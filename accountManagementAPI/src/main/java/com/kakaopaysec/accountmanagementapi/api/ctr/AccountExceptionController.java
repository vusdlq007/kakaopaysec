package com.kakaopaysec.accountmanagementapi.api.ctr;

import com.kakaopaysec.accountmanagementapi.api.dto.UserResponseDTO;
import com.kakaopaysec.accountmanagementapi.cmm.constant.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateError;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;


@RestControllerAdvice(basePackageClasses = AccountRestController.class)
@Slf4j
public class AccountExceptionController {

    // 400
    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<?> handleNoSuchUserException(Exception e) {
        final UserResponseDTO errorResponse = new UserResponseDTO(ResponseCode.ACCOUNT_SEARCH_FAIL.getErrorCode(), ResponseCode.ACCOUNT_SEARCH_FAIL.getMessage());

        return ResponseEntity.status(ResponseCode.ACCOUNT_SEARCH_FAIL.getErrorCode()).body(errorResponse);
    }

    // 400
    @ExceptionHandler({
            JpaSystemException.class,
            HibernateError.class
    })
    protected ResponseEntity<?> handleExistUserException(Exception e) {
        final UserResponseDTO errorResponse = new UserResponseDTO(ResponseCode.ACCOUNT_REGIST_EXIST_FAIL.getErrorCode(), ResponseCode.ACCOUNT_REGIST_EXIST_FAIL.getMessage());

        return ResponseEntity.status(ResponseCode.ACCOUNT_REGIST_EXIST_FAIL.getErrorCode()).body(errorResponse);
    }

    // 500
    @ExceptionHandler()
    protected ResponseEntity<?> handleRegistUserException(Exception e) {
        final UserResponseDTO errorResponse = new UserResponseDTO(ResponseCode.USER_REGIST_FAIL.getErrorCode(), ResponseCode.USER_REGIST_FAIL.getMessage());

        return ResponseEntity.status(ResponseCode.USER_REGIST_FAIL.getErrorCode()).body(errorResponse);
    }


}
