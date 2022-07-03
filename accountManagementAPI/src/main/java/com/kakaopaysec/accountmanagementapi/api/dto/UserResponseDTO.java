package com.kakaopaysec.accountmanagementapi.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

//@AllArgsConstructor
@Data
public class UserResponseDTO {

    @ApiModelProperty(value = "응답 코드", dataType = "integer", example = "200")
    private Integer resCode;
    @ApiModelProperty(value = "응답 메시지", dataType = "string")
    private String resMessage;

    @ApiModelProperty(value = "사용자 ID", required = true)
    private Integer userId;

    @ApiModelProperty(value = "사용자명", required = true)
    private String userName;

    @ApiModelProperty(value = "나이", required = true)
    private Integer age;

    @ApiModelProperty(value = "생성일자", required = true)
    private LocalDateTime careatedAt;

    @ApiModelProperty(value = "요청 유저정보", required = true)
    private UserRequestDTO userRequestDTO;

    public UserResponseDTO() { }

    public UserResponseDTO(Integer resCode, String resMessage) {
        this.resCode = resCode;
        this.resMessage = resMessage;
    }

    public UserResponseDTO(Integer resCode, String resMessage, UserRequestDTO userRequestDTO) {
        this.resCode = resCode;
        this.resMessage = resMessage;
        this.userRequestDTO = userRequestDTO;
    }

    public UserResponseDTO(Integer resCode, String resMessage, Integer userId, String userName, Integer age, String accessType, LocalDateTime careatedAt) {
        this.resCode = resCode;
        this.resMessage = resMessage;
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.careatedAt = careatedAt;
    }


}
