package com.kakaopaysec.accountmanagementapi.api.svc;


import com.kakaopaysec.accountmanagementapi.api.dto.AccountRequestDTO;
import com.kakaopaysec.accountmanagementapi.api.dto.AccountResponseDTO;
import org.springframework.data.domain.Pageable;

public interface AccountService {

    AccountResponseDTO accountRegist(AccountRequestDTO requestDTO);

    AccountResponseDTO accountList(Pageable pageable);

}
