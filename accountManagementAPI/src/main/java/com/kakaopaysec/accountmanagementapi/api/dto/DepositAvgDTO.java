package com.kakaopaysec.accountmanagementapi.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

//@AllArgsConstructor
public interface DepositAvgDTO {

    @ApiModelProperty(value = "연령대", required = true)
    Integer getAges();

    @ApiModelProperty(value = "평균 예치금", required = true)
    Double getAvgDeposit();


}
