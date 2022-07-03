package com.kakaopaysec.accountmanagementapi.api.svc;


import com.kakaopaysec.accountmanagementapi.api.dto.AccountDetailRequestDTO;
import com.kakaopaysec.accountmanagementapi.api.dto.AccountDetailResponseDTO;
import org.springframework.data.domain.Pageable;


import java.time.LocalDateTime;

public interface AccountDetailService {

    AccountDetailResponseDTO accountDetailRegist(AccountDetailRequestDTO requestDTO);

    AccountDetailResponseDTO accountDetailSearch(AccountDetailRequestDTO requestDTO, Pageable pageable);

    AccountDetailResponseDTO agesAvgDeposit();

    AccountDetailResponseDTO mostDepositUserOfLange(String startTime, String endTime);

    AccountDetailResponseDTO userDepositInfo(String userId);


}
