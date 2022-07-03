package com.kakaopaysec.accountmanagementapi.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//@AllArgsConstructor
@Data
public class UserRequestDTO {

    @ApiModelProperty(value = "요청 타입", dataType = "string")
    private String accessType;

    @ApiModelProperty(value = "사용자 ID")
    private Integer userId;

    @ApiModelProperty(value = "사용자명", required = true)
    private String userName;

    @ApiModelProperty(value = "나이", required = true)
    private Integer age;


    public UserRequestDTO() { }

    public UserRequestDTO(String accessType, Integer age, Integer userId, String userName) {
        this.accessType = accessType;
        this.userId = userId;
        this.age = age;
        this.userName = userName;
    }
}
