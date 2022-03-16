-- 쿼리문 SQL : Structured Query Language
    -- DDL(Data Definition Language) : 오라클 내부에서 사용되는 "객체"를 생성/수정/삭제하는 명령.
        -- 1) Create
        -- 2) Alter
        -- 3) Drop
    -- DML(Data Manipulation Language) : 오라클에 저장할 "데이터"를 생성/수정/삭제하는 명령.
        -- 1) Insert
        -- 2) Delete
        -- DQL (Data Query Language): 데이터베이스에 저장된 것들을 조회.
        --      select 관련 쿼리 ex) from, select, where, group by, having, order by
        -- 3) Select
        -- 4) Update
    -- DCL(Data Control Language) : 시스템 권한을 부여하거나 회수하는 명령.
        -- 1) Grant
        -- 2) Revoke
    -- TCL(Transaction Control Language) : 작업에 대한 Commit또는 Rollback을 관리하는 명령. 원자성을 지키기 위한 명령.
        -- 1) Commit
        -- 2) Rollback
-- select쿼리의 실행 순서 from -> where -> group by -> having -> select -> order by
--------------------------------------------------------------------------------
alter session set "_ORACLE_SCRIPT"=true; -- C##안붙이고 계성생성하게 바꾸는것.
-- 계정생성 계정명 test 비밀번호 test
create user 계정명 identified by 비밀번호;
-- 접속 권한
grant connect to 계정명;
-- 테이블 생성 수정 삭제 삽입 권한
grant resource to 계정명;

/* 요런식으로 계정 생성하면 됨
create user practice identified by practice;
grant connect, resource to practice;
grant unlimited tablespace to practice;
*/

grant unlimited tablespace to 계정명; -- 테이블스페이스권한 줌 밑에랑 같은거인듯
ALTER USER 계정명 DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS; -- 데이터 삽입 가능
grant create table, dba TO 계정명; -- dba권한은 사용자계정한테 함부로 주면안됨. 거의 모든권한이 들어가있기때문
drop user 계정명 cascade; -- 유저 삭제 cascade를 붙여야 깔끔하게 지워짐

-- kh계정에 있는 employee테이블의 select권한을 test계정에게 부여함.
grant select on kh.employee to test;
-- test계정의 kh.employye 테이블에 대한 select 권한 회수
revoke select on kh.employee from test;
------------------

-- test2 계정을 만들고, kh.employee 테이블에 select 및 update 권한을 부여한다.
-- test2 계정으로 접속해서 선동일의 이름을 선동이로 변경해본다.
-- test2 계정이 할당 받은 권한을 모두 revoke 로 회수해본다.
create user test2 identified by test2;
grant connect to test2;
grant select, update on kh.employee to test2;

select * from kh.employee;
update kh.employee set emp_name = '선동이' where emp_id = 200;
select * from employee;
commit; -- 업데이트 후에 커밋을 해야 바뀜
-------------------------------------

-- testConnection
create table temp(
    data varchar(20)
);

select * from kh.employee; -- select 권한을 부여받아 test에서도 select 가능.
delete from kh.employee; -- delete 권한은 없으므로 삭제불가.
