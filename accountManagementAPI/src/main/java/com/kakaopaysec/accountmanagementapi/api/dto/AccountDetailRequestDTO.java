package com.kakaopaysec.accountmanagementapi.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//@AllArgsConstructor
@Data
public class AccountDetailRequestDTO {

    @ApiModelProperty(value = "계좌 번호", example = "1000-01", required = true)
    private String accountNumber;

    @ApiModelProperty(value = "입출금여부 (Y/N)", example = "Y", required = true)
    private String isDeposit;

    @ApiModelProperty(value = "입금액", example = "15000", required = true)
    private Long depositAmount;


    public AccountDetailRequestDTO() { }

    public AccountDetailRequestDTO( String accountNumber, String isDeposit, Long depositAmount) {
        this.accountNumber = accountNumber;
        this.isDeposit = isDeposit;
        this.depositAmount = depositAmount;
    }
}
