package com.kakaopaysec.accountmanagementapi.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


//@AllArgsConstructor
@Data
public class UserRequestDTO {

    @ApiModelProperty(value = "사용자 ID", example = "")
    private Long userId;

    @ApiModelProperty(value = "사용자명", example = "김윤권", required = true)
    private String userName;

    @ApiModelProperty(value = "나이 integer", example = "30", required = true)
    private Integer age;


    public UserRequestDTO() { }

    public UserRequestDTO(Integer age, Long userId, String userName) {
        this.userId = userId;
        this.age = age;
        this.userName = userName;
    }
}
