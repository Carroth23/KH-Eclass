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
delete from cafe_menu where price = 4000;
desc cafe_menu;
select * from user_constraints where table_name='CAFE_MENU';

alter table cafe_menu add constraint cafe_menu_id_pk primary key(id);
-- name에 not null 옵션 추가
alter table cafe_menu modify (name constraint cafe_menu_name_nn/*이건 이름을 주기위한 용도*/ not null);
alter table cafe_menu drop constraint CAFE_MENU_NAME_NN;

insert into cafe_menu values(1001, 'Americano', 2000);
insert into cafe_menu values(1002, 'Cafe_Latte', 2500);
insert into cafe_menu values(1003, 'Cafe_Mocha', 3000);
insert into cafe_menu values(cafe_menu_seq.nextval, 'Orange Juice', 4000); -- 시퀀스를 주는 쿼리.(시퀀스 명령어는 고정)
-- Sequence : 특정 시작값으로 부터 지정된 값 간격으로 지속적으로 증가(감소) 하는 값을 기억해주는 객체
--               시퀀스 이름                                   maxvalue 2000
create sequence cafe_menu_seq start with 1004 increment by 1 nomaxvalue nocache;
-- nomaxvalue 끝번호에 제한이 없음 maxvalue 2000로 끝번호 정할수 있다.
-- nocache는 캐싱기능을 사용하지 않는다는 뜻.
-- start with 1004 increment by 1 1004번부터 1씩 증가시키겠다는 뜻

-- 시퀀스 삭제
DROP SEQUENCE cafe_menu_seq;
--------------------------------------------------------------------------------
-- TCL : Transection Control Language
-- 트랜잭션 : 오라클 내에서 사용하는 논리적 작업의 단위 (쿼리의 중간 저장소?) / 
--           개발자 관점에서 작업의 원자성을 확보한다. (안정성, 실수방지, 원자성) 원자성이란 작업을 전부 실패하게 하거나 전부 성공하게 하거나
-- commit : 트랜잭션이라는 임시저장소에 있는 내용을 DB로 보낸다.
commit;
-- rollback : 트랜잭션에 있는 명령들을 취소
rollback;

select * from cafe_menu;

delete from cafe_menu;

----------------------------------system 계정------------------------------------
-- DCL : Data Control Language
-- Grant (권한부여)
create user test identified by test; -- 계정명 test 비밀번호 test
grant connect to test; -- 접속 권한
grant resource to test; -- 테이블 생성 수정 삭제 삽입 권한
grant select on kh.employee to test; -- kh계정에 있는 employee테이블의 select권한을 test계정에게 부여함.

select * from kh.employee;
update kh.employee set emp_name = '선동이' where emp_id = 200;
select * from employee;
commit; -- 업데이트 후에 커밋을 해야 바뀜

--------------------------------------------------------------------------------
-- Object : view - (물리적으로 독립되지않은 원본테이블에 대한 링크테이블)가상테이블
select * from employee;

-- 선택한 컬럼의 내용을 복사해서 새 테이블을 만듬.(복사본. 물리적으로 두개의 테이블이 되므로 employee를 수정해도 dev는 변화가 없음)
create table employee_dev as select emp_id,emp_name,emp_no,email from employee;

select * from employee_dev;
update employee_dev set emp_name='선동삼' where emp_id=200;
commit;

-- 이것이 view
create view employee_dev_view as select emp_id,emp_name,emp_no,email from employee;
-- view 만들 권한이 없어서 만들어지지 않는다.
-- grant create view to kh; 로 권한을 주어야함
select * from employee_dev_view;

-- view를 조인해서 만들수도 있다.
create view employee2 as select emp_id, emp_name,
(select dept_title from department where dept_code = dept_id) 부서명 from employee;

-- 선동일의 주민번호 변경
update employee set emp_no = '621231-1985634' where emp_id = 200;
select * from employee_dev_view;

-- view에서 바꾸면 원본 employee와 연결되어있기에 원본데이터도 같이 변경됨.
update employee_dev_view set emp_name = '선동구' where emp_id=200;

-- test계정에 kh.employee의 select 권한을 줌.
grant select on kh.employee_dev_view to test;
--------------------------------------------------------------------------------

/* 정리
DB != DBMS (DBMS는 데이터관리 시스템)

SQL-Developer (DBMS를 편하게 사용하기위한 툴)
- SQL
    > DDL : create / alter / drop 
    > DCL : grant / revoke (자원의 주인이나 system계정만이 권한을 줄수 있다.)
    > TCL : rollback / commit (트랜잭션관련)
    > DML : insert / update / delete
        > DQL : select > from, where, function, order by, group by, having, subquery, join
                select쿼리의 실행 순서 from -> where -> group by -> having -> select -> order by

*/
