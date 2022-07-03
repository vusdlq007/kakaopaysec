package com.kakaopaysec.accountmanagementapi.api.repo;


import com.kakaopaysec.accountmanagementapi.api.vo.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserVo, Integer> {     // <Entity, 기본키 타입>

    public Optional<UserVo> findById(Integer id);

    public List<UserVo> findByName(String name);

    //like검색
    public List<UserVo> findByNameLike(String name);


}
