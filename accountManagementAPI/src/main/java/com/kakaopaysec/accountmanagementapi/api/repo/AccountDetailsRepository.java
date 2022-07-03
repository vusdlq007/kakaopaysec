package com.kakaopaysec.accountmanagementapi.api.repo;

import com.kakaopaysec.accountmanagementapi.api.vo.AccountDetailVo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AccountDetailsRepository extends JpaRepository<AccountDetailVo, Integer> {     // <Entity, 기본키 타입>

    public List<AccountDetailVo> findAll();

    public Optional<AccountDetailVo> findByAccountNumber(String accountNum);

    public List<AccountDetailVo> findAllByAccountNumberAndCreatedAtBetween(String accountNum, LocalDateTime startedAt, LocalDateTime endedAt);


}
