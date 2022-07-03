package com.kakaopaysec.accountmanagementapi.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//@AllArgsConstructor
@Data
public class UserRequestDTO {

    @ApiModelProperty(value = "요청 타입", dataType = "string")
    private String accessType;

    @ApiModelProperty(value = "상점 ID", required = true)
    private String storeId;

    @ApiModelProperty(value = "상점명", required = true)
    private String storeName;

    @ApiModelProperty(value = "요청 카테고리", required = true)
    private Long categoryId;

    @ApiModelProperty(value = "요청 바코드", required = true)
    private String barcode;

    @ApiModelProperty(value = "적립할 포인트", required = true)
    private Integer earnPoint;

    public UserRequestDTO() { }

    public UserRequestDTO(String accessType, Long categoryId, String barcode, Integer earnPoint) {
        this.accessType = accessType;
        this.categoryId = categoryId;
        this.barcode = barcode;
        this.earnPoint = earnPoint;
    }
}
