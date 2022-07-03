package com.kakaopaysec.accountmanagementapi.api.ctr;

import com.kakaopaysec.accountmanagementapi.api.dto.AccountDetailRequestDTO;
import com.kakaopaysec.accountmanagementapi.api.dto.AccountDetailResponseDTO;
import com.kakaopaysec.accountmanagementapi.api.svc.AccountDetailService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@CrossOrigin("*")
@Api(tags = {" 계좌 관리 서비스 컨트롤러"})
@SwaggerDefinition(tags = {
        @Tag(name = "계좌 관리 서비스 컨트롤러", description = "계좌 추가, 목록 조회, 계좌 내역 추가, 목록 조회 이용에 필요한 기능 제공")
})
@RequestMapping("/api/account/detail")
@RestController
public class AccountDetailRestController {

    @Autowired
    private AccountDetailService accountDetailService;

    /**
     * 계좌내역 추가.
     *
     * @param
     * @return
     */
    @ApiOperation(value = "계좌 정보 추가 액션", notes = "계좌번호, 입출금여부, 입금액, 입금일을 받아 추가 처리한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 응답"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PostMapping("")
    public AccountDetailResponseDTO accountDetailPush(@RequestBody AccountDetailRequestDTO requestDTO) {

        return accountDetailService.accountDetailRegist(requestDTO);
    }

    /**
     * 계좌내역 조회.
     *
     * @param
     * @return
     */
    @ApiOperation(value = "계좌 정보 조회 액션", notes = "계좌번호, 입출금여부, 조회 시작일, 마감일을 받아 범위조회 처리한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 응답"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("")
    public AccountDetailResponseDTO accountDetailSearch(@RequestBody AccountDetailRequestDTO requestDTO, Pageable pageable) {

        return accountDetailService.accountDetailSearch(requestDTO, pageable);
    }

    /**
     * 1. 사용자의 계좌별 예치금 조회.
     *
     * @param
     * @return
     */
    @ApiOperation(value = "[추가 API] 사용자의 계좌별 예치금 조회", notes = "사용자의 계좌별 예치금 출력.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 응답"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/all")
    public AccountDetailResponseDTO userDepositInfo(@RequestParam String userId) {

        return accountDetailService.userDepositInfo(userId);
    }

    /**
     * 2. 연령별 평균 예치금 조회.
     *
     * @param
     * @return
     */
    @ApiOperation(value = "[추가 API] 연령별 평균 예치금 조회", notes = "사용자 나이대 별로, 평균 예치금을 출력.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 응답"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/avg")
    public AccountDetailResponseDTO agesDepositAvg() {

        return accountDetailService.agesAvgDeposit();
    }


    /**
     * 4. 입력한 기간내에 가장 많이 예치한 사용자 순으로 정렬해서 출력.
     *
     * @param
     * @return
     */
    @ApiOperation(value = "[추가 API] 기간 범위에 돈을 많이 예치한 사용자 리스트 조회", notes = "사용자의 모든 계좌를 합산한 기간안의 총 예치금중 가장 많은 사용자 순으로 리스트 출력.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 응답"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/rank")
    public AccountDetailResponseDTO mostDepositUserOfLange(@RequestParam("startTime") String startTime, @RequestParam String endTime) {

        return accountDetailService.mostDepositUserOfLange(startTime, endTime);
    }

}
