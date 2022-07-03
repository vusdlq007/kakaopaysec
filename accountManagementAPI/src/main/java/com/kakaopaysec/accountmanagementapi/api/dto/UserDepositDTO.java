package com.kakaopaysec.accountmanagementapi.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//@AllArgsConstructor
public interface UserDepositDTO {

    @ApiModelProperty(value = "계좌번호", required = true)
    String getAccountNumber();

    @ApiModelProperty(value = "잔고", required = true)
    Long getDepositCount();


}
