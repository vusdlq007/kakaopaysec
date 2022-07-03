package com.kakaopaysec.accountmanagementapi.api.svc;


import com.kakaopaysec.accountmanagementapi.api.dto.UserRequestDTO;
import com.kakaopaysec.accountmanagementapi.api.dto.UserResponseDTO;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResponseDTO userRegist(UserRequestDTO requestDTO);

    UserResponseDTO userSearch(Pageable pageable);


}
