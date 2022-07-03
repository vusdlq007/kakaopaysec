package com.kakaopaysec.accountmanagementapi.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//@AllArgsConstructor
@Data
public class AccountRequestDTO {


    @ApiModelProperty(value = "사용자 ID", example = "1", required = true)
    private Long userId;

    @ApiModelProperty(value = "계좌번호",  example = "1000-01", required = true)
    private String accountNumber;


    public AccountRequestDTO() { }

    public AccountRequestDTO( Long userId, String accountNumber) {
        this.userId = userId;
        this.accountNumber = accountNumber;
    }
}
