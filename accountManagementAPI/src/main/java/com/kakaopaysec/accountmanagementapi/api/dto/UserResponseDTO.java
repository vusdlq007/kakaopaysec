package com.kakaopaysec.accountmanagementapi.api.dto;

import com.kakaopaysec.accountmanagementapi.api.vo.UserVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

//@AllArgsConstructor
@Data
public class UserResponseDTO {

    @ApiModelProperty(value = "응답 코드", dataType = "integer", example = "200")
    private Integer resCode;
    @ApiModelProperty(value = "응답 메시지", dataType = "string")
    private String resMessage;

    @ApiModelProperty(value = "사용자 정보 리스트 페이징 데이터")
    private List<UserVo> userInfoList;

    public UserResponseDTO() { }

    public UserResponseDTO(Integer resCode, String resMessage) {
        this.resCode = resCode;
        this.resMessage = resMessage;
    }


    public UserResponseDTO(Integer resCode, String resMessage, List<UserVo> userInfoList) {
        this.resCode = resCode;
        this.resMessage = resMessage;
        this.userInfoList = userInfoList;
    }


}
