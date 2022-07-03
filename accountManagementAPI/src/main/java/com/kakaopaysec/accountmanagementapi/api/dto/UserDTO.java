package com.kakaopaysec.accountmanagementapi.api.dto;

import com.kakaopaysec.accountmanagementapi.api.vo.UserVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

//@AllArgsConstructor
@Data
public class UserDTO {

    @ApiModelProperty(value = "사용자 ID")
    private Long userId;

    @ApiModelProperty(value = "사용자명", required = true)
    private String userName;

    @ApiModelProperty(value = "나이", required = true)
    private Integer age;

    public UserDTO() { }


    public UserDTO(Long userId, String userName, Integer age) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
    }
    

}
