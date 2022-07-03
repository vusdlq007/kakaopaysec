package com.kakaopaysec.accountmanagementapi.api.repo;

import com.kakaopaysec.accountmanagementapi.api.dto.DepositAvgDTO;
import com.kakaopaysec.accountmanagementapi.api.dto.MostDepositDTO;
import com.kakaopaysec.accountmanagementapi.api.dto.UserDepositDTO;
import com.kakaopaysec.accountmanagementapi.api.vo.AccountDetailVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AccountDetailsRepository extends JpaRepository<AccountDetailVo, Integer> {     // <Entity, 기본키 타입>

    public List<AccountDetailVo> findAll();

    public Optional<AccountDetailVo> findByAccountNumber(String accountNum);
    
    /**
     * 2번 연령별 평균 예치금.
     * @param
     * @return
     */
    @Query(nativeQuery = true,
            value = "WITH TMP1 AS(" +
                    "SELECT B.USER_ID, B.ACCOUNT_NUMBER, SUM(A.DEPOSIT_AMOUNT) DEPOSIT_AMOUNT " +
                    "FROM T_ACCOUNT_DETAIL A " +
                    "INNER JOIN T_ACCOUNT B " +
                    "ON A.ACCOUNT_NUMBER = B.ACCOUNT_NUMBER " +
                    "WHERE A.IS_DEPOSIT = 'Y'" +
                    "GROUP BY  B.ACCOUNT_NUMBER" +
                    "), TMP2 AS(" +
                    "SELECT B.USER_ID, B.ACCOUNT_NUMBER, SUM(A.DEPOSIT_AMOUNT) DEPOSIT_AMOUNT " +
                    "FROM T_ACCOUNT_DETAIL A " +
                    "INNER JOIN T_ACCOUNT B " +
                    "ON A.ACCOUNT_NUMBER = B.ACCOUNT_NUMBER " +
                    "WHERE A.IS_DEPOSIT = 'N'" +
                    "GROUP BY  B.ACCOUNT_NUMBER" +
                    ")" +
                    "SELECT AGES, AVG(SUM_AMT) AVGDEPOSIT " +
                    "FROM (" +
                    "SELECT U.USER_ID, U.AGES, SUM(A.AMT) SUM_AMT " +
                    "FROM (" +
                    "  SELECT TMP1.USER_ID, TMP1.ACCOUNT_NUMBER, TMP1.DEPOSIT_AMOUNT-TMP2.DEPOSIT_AMOUNT AMT" +
                    "  FROM TMP1" +
                    "  LEFT JOIN TMP2" +
                    "  ON TMP1.ACCOUNT_NUMBER = TMP2.ACCOUNT_NUMBER" +
                    ") A " +
                    "LEFT JOIN (" +
                    "  SELECT USER_ID, AGE, CASE WHEN AGE < 20 THEN 10" +
                    "                WHEN AGE <  30 THEN 20" +
                    "                WHEN AGE <  40 THEN 30" +
                    "                WHEN AGE <  50 THEN 40" +
                    "                WHEN AGE <  60 THEN 50" +
                    "                WHEN AGE <  70 THEN 60" +
                    "                WHEN AGE <  80 THEN 70" +
                    "                WHEN AGE <  90 THEN 80" +
                    "                WHEN AGE <  100 THEN 90 " +
                    "ELSE NULL " +
                    "END as AGES " +
                    "FROM T_USER " +
                    ")  U " +
                    "ON A.USER_ID = U.USER_ID " +
                    "GROUP BY U.USER_ID, U.AGES " +
                    ")" +
                    "GROUP BY AGES ")
    public List<DepositAvgDTO> findByAgesTotalAvg();


    /**
     * 1. 사용자의 계좌별 예치금 조회.
     * @param userId
     * @return
     */
    @Query(nativeQuery = true, value = "WITH TMP1 AS(" +
            "SELECT B.ACCOUNT_NUMBER, SUM(A.DEPOSIT_AMOUNT) DEPOSIT_AMOUNT " +
            "FROM T_ACCOUNT_DETAIL A " +
            "INNER JOIN(" +
            "  SELECT ACCOUNT_NUMBER " +
            "  FROM (" +
            "      SELECT ACCOUNT_NUMBER " +
            "      FROM  T_ACCOUNT " +
            "      WHERE USER_ID = ?1 " +
            "  )" +
            ") B " +
            "ON A.ACCOUNT_NUMBER = B.ACCOUNT_NUMBER " +
            "WHERE A.IS_DEPOSIT = 'Y' " +
            "GROUP BY  B.ACCOUNT_NUMBER " +
            "), TMP2 AS(" +
            "SELECT B.ACCOUNT_NUMBER, SUM(A.DEPOSIT_AMOUNT) DEPOSIT_AMOUNT " +
            "FROM T_ACCOUNT_DETAIL A " +
            "INNER JOIN(" +
            "  SELECT ACCOUNT_NUMBER " +
            "  FROM (" +
            "      SELECT ACCOUNT_NUMBER " +
            "      FROM  T_ACCOUNT " +
            "      WHERE USER_ID = ?1" +
            "  )" +
            ") B " +
            "ON A.ACCOUNT_NUMBER = B.ACCOUNT_NUMBER " +
            "WHERE A.IS_DEPOSIT = 'N' " +
            "GROUP BY  B.ACCOUNT_NUMBER " +
            ") " +
            "SELECT TMP1.ACCOUNT_NUMBER as ACCOUNTNUMBER, TMP1.DEPOSIT_AMOUNT-TMP2.DEPOSIT_AMOUNT as DEPOSITCOUNT " +
            "FROM TMP1 " +
            "LEFT JOIN TMP2 " +
            "ON TMP1.ACCOUNT_NUMBER = TMP2.ACCOUNT_NUMBER ")
    public List<UserDepositDTO> findAllByUserAccountEachDeposit(String userId);


    /**
     * 해당기간안에 가장 많이 예치한 사용자 순 조회.
     * @param startTime
     * @param endTime
     * @return
     */
    @Query(nativeQuery = true, value = "WITH TMP1 AS(" +
            "SELECT B.USER_ID, B.ACCOUNT_NUMBER, SUM(A.DEPOSIT_AMOUNT) DEPOSIT_AMOUNT " +
            "FROM T_ACCOUNT_DETAIL A " +
            "INNER JOIN T_ACCOUNT B " +
            "ON A.ACCOUNT_NUMBER = B.ACCOUNT_NUMBER " +
            "WHERE A.IS_DEPOSIT = 'Y' " +
            "GROUP BY  B.ACCOUNT_NUMBER " +
            "), TMP2 AS(" +
            "SELECT B.USER_ID, B.ACCOUNT_NUMBER, SUM(A.DEPOSIT_AMOUNT) DEPOSIT_AMOUNT " +
            "FROM T_ACCOUNT_DETAIL A " +
            "INNER JOIN T_ACCOUNT B " +
            "ON A.ACCOUNT_NUMBER = B.ACCOUNT_NUMBER " +
            "WHERE A.IS_DEPOSIT = 'N'" +
            "GROUP BY  B.ACCOUNT_NUMBER " +
            ")" +
            "SELECT A.USER_ID, U.NAME, SUM(A.AMT) DEPOSIT_AMOUNT " +
            "FROM (" +
            "  SELECT TMP1.USER_ID, TMP1.ACCOUNT_NUMBER, TMP1.DEPOSIT_AMOUNT-TMP2.DEPOSIT_AMOUNT AMT " +
            "  FROM TMP1" +
            "  LEFT JOIN TMP2" +
            "  ON TMP1.ACCOUNT_NUMBER = TMP2.ACCOUNT_NUMBER " +
            ") A " +
            "LEFT JOIN (" +
            "  SELECT USER_ID, NAME " +
            "  FROM T_USER " +
            ")  U " +
            "ON A.USER_ID = U.USER_ID " +
            "GROUP BY A.USER_ID " +
            "ORDER BY 3 DESC ")
    public List<MostDepositDTO> findAllByMostDepositEarnUserBetween(LocalDateTime startTime, LocalDateTime endTime);

}
