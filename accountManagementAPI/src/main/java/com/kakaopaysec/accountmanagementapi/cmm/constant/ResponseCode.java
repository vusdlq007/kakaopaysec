package com.kakaopaysec.accountmanagementapi.cmm.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum ResponseCode {
    NOT_FOUND("PAGE NOT FOUND",404,"COMMON-ERR-404"),
    NOT_ALLOW("COMMON-ERR-403",403,"NOT ALLOW"),
    INTER_SERVER_ERROR("INTER SERVER ERROR",500,"COMMON-ERR-500"),
    SUCCESS("SUCCESS",200,"COMMON-SUCC-200"),
    USER_REGIST_SUCCESS("SUCCESS",200,"사용자 생성에 성공하였습니다."),
    USER_REGIST_FAIL("INTER SERVER ERROR",500,"사용자 생성에 실패하였습니다."),
    USER_SEARCH_SUCCESS("SUCCESS",200,"사용자 목록 조회에 성공하였습니다."),
    USER_SEARCH_FAIL("INTER SERVER ERROR",400,"사용자 목록 조회에 실패하였습니다."),
    ACCOUNT_SEARCH_FAIL("INTER SERVER ERROR",400,"계좌 조회에 실패하였습니다. 계좌 정보가 존재하지 않습니다."),
    ACCOUNT_SEARCH_SUCCESS("SUCCESS",200,"계좌 조회 성공하였습니다."),
    ACCOUNT_DETAIL_SERACH_FAIL("INTER SERVER ERROR",500,"계좌내역 조회에 실패하였습니다. 계좌 내역 정보가 존재하지 않습니다."),
    ACCOUNT_REGIST_SUCCESS("SUCCESS",200,"계좌 등록에 성공하였습니다."),
    ACCOUNT_REGIST_FAIL("INTER SERVER ERROR",500,"계좌 등록에 실패하였습니다."),
    ACCOUNT_REGIST_EXIST_FAIL("INTER SERVER ERROR",400,"계좌 등록에 실패하였습니다. 계좌번호가 해당 이미 존재합니다. 다시 시도해주세요.");



    @Getter
    private String status;
    @Getter
    private int errorCode;
    @Getter
    private String message;

}
