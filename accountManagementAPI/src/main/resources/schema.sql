create table "T_USER"
(
 USER_ID bigint generated by default as identity,
 "NAME" varchar(255),
 "AGE" int,
 "CREATED_AT" DATETIME,
 primary key (USER_ID)
) AS SELECT * FROM CSVREAD('사용자.csv');


create table "T_ACCOUNT"
(
 "USER_ID" bigint,
 "ACCOUNT_NUMBER" varchar(255)
)  AS SELECT * FROM CSVREAD('계좌.csv');

create table "T_ACCOUNT_DETAIL"
(
 "ACCOUNT_NUMBER" varchar(255),
 "IS_DEPOSIT" varchar(1),
 "DEPOSIT_AMOUNT" bigint,
 "CREATED_AT" DATETIME
)  AS SELECT * FROM CSVREAD('계좌내역.csv');

commit;