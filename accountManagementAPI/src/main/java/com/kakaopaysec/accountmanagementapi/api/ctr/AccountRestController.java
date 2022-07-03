package com.kakaopaysec.accountmanagementapi.api.ctr;

import com.kakaopaysec.accountmanagementapi.api.dto.*;
import com.kakaopaysec.accountmanagementapi.api.svc.AccountDetailService;
import com.kakaopaysec.accountmanagementapi.api.svc.AccountService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Slf4j
@CrossOrigin("*")
@Api(tags = {" 계좌 관리 서비스 컨트롤러"})
@SwaggerDefinition(tags = {
        @Tag(name = "계좌 관리 서비스 컨트롤러", description = "계좌 추가, 목록 조회, 계좌 내역 추가, 목록 조회 이용에 필요한 기능 제공")
})
@RequestMapping("/api/account")
@RestController
public class AccountRestController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountDetailService accountDetailService;


    /**
     * 계좌 추가.
     * @param
     * @return
     */
    @ApiOperation(value="계좌 추가 액션", notes="사용자 ID, 계좌 번호를 받아 등록 처리한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 응답"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PostMapping("")
    public AccountResponseDTO accountRegist(@RequestBody AccountRequestDTO requestDTO){

        return accountService.accountRegist(requestDTO);
    }

    /**
     * 계좌 목록 조회.
     * @param
     * @return
     */
    @ApiOperation(value="계좌 목록 조회", notes="페이징 정보를 받아 조회 처리한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 응답"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("")
    public AccountResponseDTO accountList(Pageable pageable){

        return accountService.accountList(pageable);
    }

    /**
     * 계좌내역 추가.
     * @param
     * @return
     */
    @ApiOperation(value="계좌 정보 추가 액션", notes="계좌번호, 입출금여부, 입금액, 입금일을 받아 추가 처리한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 응답"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PostMapping("/detail")
    public AccountDetailResponseDTO accountDetailPush(@RequestBody AccountDetailRequestDTO requestDTO){

        return accountDetailService.accountDetailRegist(requestDTO);
    }

    /**
     * 계좌내역 조회.
     * @param
     * @return
     */
    @ApiOperation(value="계좌 정보 조회 액션", notes="계좌번호, 입출금여부, 조회 시작일, 마감일을 받아 범위조회 처리한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 응답"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/detail")
    public AccountDetailResponseDTO accountDetailSearch(@RequestBody AccountDetailRequestDTO requestDTO){

        return accountDetailService.accountDetailSearch(requestDTO);
    }


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementFoundException(NoSuchElementException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

}
