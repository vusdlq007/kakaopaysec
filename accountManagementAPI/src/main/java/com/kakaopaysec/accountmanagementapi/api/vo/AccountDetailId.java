package com.kakaopaysec.accountmanagementapi.api.vo;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class AccountDetailId implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "IS_DEPOSIT")
    private String isDeposit;

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "DEPOSIT_AMOUNT")
    private Long depositAmount;

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

}
