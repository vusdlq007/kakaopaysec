package com.kakaopaysec.accountmanagementapi.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

//@AllArgsConstructor
@Data
public class AccountDetailDTO {

    @ApiModelProperty(value = "계좌 번호", required = true)
    private String accountNumber;

    @ApiModelProperty(value = "입출금여부", required = true)
    private String isDeposit;

    @ApiModelProperty(value = "입금액", required = true)
    private Long depositAmount;

    @ApiModelProperty(value = "조회시작일", required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "조회종료일", required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    private LocalDateTime endTime;


    public AccountDetailDTO() { }

    public AccountDetailDTO(String accountNumber, String isDeposit, Long depositAmount, LocalDateTime startTime, LocalDateTime endTime) {
        this.accountNumber = accountNumber;
        this.isDeposit = isDeposit;
        this.depositAmount = depositAmount;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public class DepositAvgDTO{

    }

}
