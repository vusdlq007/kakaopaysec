package com.kakaopaysec.accountmanagementapi.api.dto;

import io.swagger.annotations.ApiModelProperty;

//@AllArgsConstructor
public interface MostDepositDTO {

    @ApiModelProperty(value = "사용자 ID", required = true)
    String getUser_Id();

    @ApiModelProperty(value = "이름", required = true)
    String getName();

    @ApiModelProperty(value = "예치금", required = true)
    Long getDeposit_Amount();

}
