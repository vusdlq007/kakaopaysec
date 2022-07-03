package com.kakaopaysec.accountmanagementapi.api.vo;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "T_ACCOUNT_DETAIL")
public class AccountDetailVo {

    @Id
    @JoinColumn
//    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "IS_DEPOSIT")        // 입출금 여부 Y: 입금, N: 출금
    private String isDeposit;

    @Column(name = "DEPOSIT_AMOUNT")    // 입금액
    private Long depositAmount;

    @Column(name = "APPROVED_AT")
    private LocalDateTime approvedAt;


    public void update(String isDeposit, Long depositAmount, LocalDateTime approvedAt) {
        this.isDeposit = isDeposit;
        this.depositAmount = depositAmount;
        this.approvedAt = approvedAt;
    }

}
