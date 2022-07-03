package com.kakaopaysec.accountmanagementapi.api.svc;


import com.kakaopaysec.accountmanagementapi.api.dto.AccountDetailRequestDTO;
import com.kakaopaysec.accountmanagementapi.api.dto.AccountDetailResponseDTO;

public interface AccountDetailService {

    AccountDetailResponseDTO accountDetailRegist(AccountDetailRequestDTO requestDTO);

    AccountDetailResponseDTO accountDetailSearch(AccountDetailRequestDTO requestDTO);


}
