package com.kakaopaysec.accountmanagementapi.api.dto;

import com.kakaopaysec.accountmanagementapi.api.vo.AccountDetailVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

//@AllArgsConstructor
@Data
public class AccountDetailResponseDTO {

    @ApiModelProperty(value = "응답 코드", dataType = "integer", example = "200")
    private Integer resCode;
    @ApiModelProperty(value = "응답 메시지", dataType = "string")
    private String resMessage;

    @ApiModelProperty(value = "사용자 계좌 정보 리스트 페이징 데이터")
    private List<AccountDetailVo> accountDetailList;

    @ApiModelProperty(value = "사용자 계좌 정보 리스트 페이징 데이터2")
    private Object object;

    public AccountDetailResponseDTO() { }

    public AccountDetailResponseDTO(Integer resCode, String resMessage) {
        this.resCode = resCode;
        this.resMessage = resMessage;
    }

    public AccountDetailResponseDTO(Integer resCode, String resMessage, List<AccountDetailVo> accountDetailList) {
        this.resCode = resCode;
        this.resMessage = resMessage;
        this.accountDetailList = accountDetailList;
    }

    public AccountDetailResponseDTO(Integer resCode, String resMessage, Object object) {
        this.resCode = resCode;
        this.resMessage = resMessage;
        this.object = object;
    }


}
