package com.kakaopaysec.accountmanagementapi.api.svc;


import com.kakaopaysec.accountmanagementapi.api.dto.UserRequestDTO;
import com.kakaopaysec.accountmanagementapi.api.dto.UserResponseDTO;

public interface UserService {

    UserResponseDTO userRegist(UserRequestDTO requestDTO);

    UserResponseDTO userSearch(UserRequestDTO requestDTO);


}
