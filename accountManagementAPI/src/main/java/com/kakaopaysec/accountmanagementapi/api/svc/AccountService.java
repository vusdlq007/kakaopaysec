package com.kakaopaysec.accountmanagementapi.api.svc;


import com.kakaopaysec.accountmanagementapi.api.dto.AccountRequestDTO;
import com.kakaopaysec.accountmanagementapi.api.dto.AccountResponseDTO;

public interface AccountService {

    AccountResponseDTO accountRegist(AccountRequestDTO requestDTO);

    AccountResponseDTO accountList(AccountRequestDTO requestDTO);

}
