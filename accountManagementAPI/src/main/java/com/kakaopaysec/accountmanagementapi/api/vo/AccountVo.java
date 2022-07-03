package com.kakaopaysec.accountmanagementapi.api.vo;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "T_ACCOUNT")
public class AccountVo {

    @Id
    @JoinColumn
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

}
