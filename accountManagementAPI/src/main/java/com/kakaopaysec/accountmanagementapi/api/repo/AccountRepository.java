package com.kakaopaysec.accountmanagementapi.api.repo;


import com.kakaopaysec.accountmanagementapi.api.vo.AccountVo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountVo, String> {     // <Entity, 기본키 타입>

    public List<AccountVo> findAll();

    public Optional<AccountVo> findById(String id);

//    public Optional<AccountVo> findByIdAndUserId(String id, String userId);


}
