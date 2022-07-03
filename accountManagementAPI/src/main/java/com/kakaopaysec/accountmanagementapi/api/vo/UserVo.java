package com.kakaopaysec.accountmanagementapi.api.vo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "T_USER")
public class UserVo {

    @Id
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

}
