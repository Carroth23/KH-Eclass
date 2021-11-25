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
------------------------ DDL : Data Definition Language ------------------------
-- ex) table, user, view, sequence, index, trigger, package, procedure, function
-- create : 객체의 생성 create + 만들고자 하는 캑체 타입 + 테이블 이름)
create table contact(
    id number,
    name varchar2(20), -- varchar2 대신 char을 쓸수도 있다 varchar2는 가변적으로 데이터를 사용 char은 고정된 데이터 그대로 사용 가변로직이 빠지므로 처리속도는 빠름
    contact varchar2(20)
);
-- 제약조건 있는 table 생성
create table contact(
    id number not null, -- not null은 제약조건. null값을 넣을 수 없다. 즉, 비워둘 수 없다.
-- 컬럼명 자료형 제약조건
    name varchar2(20) not null,
    contact varchar2(20) not null
);
-- 기본키를 갖는 table 생성
create table contact(
    id number primary key, -- 식별자. id값을 기본키로 하겠다. 이후에는 동일한 번호의 id값을 삽입할수 없음(not null 자동설정) 한 테이블당 한개만 가능
    name varchar2(20) not null,
    contact varchar2(20) not null
);
-- constraint name을 사용하기 편하게 바꿔서 생성(제약조건 확인)
create table contact(
    id number constraint id_pk primary key,
    name varchar2(20) constraint name_nn not null,
    contact varchar2(20) constraint contact_nn not null
);
-- primary key : 주 키 설정 + 중복방지 + not null
-- not null    : 빈 값 입력 방지, 중복허용, 여러컬럼에 설정가능
-- unique      : 중복방지 , null값 허용, 여러 컬럼에 설정가능
create table contact(
    id number constraint id_pk primary key,
    name varchar2(20) constraint name_nn not null,
    contact varchar2(20) constraint contact_uk unique not null -- unique + not null 동시부여 가능(근데 이러면 primary키랑 비슷)
);
-- check : 들어가는 내용을 체크(설정한 값 이외의 값은 허용하지 않겠다. 여기서는 '남','여'만 허용.null값도 허용)
create table contact(
    id number constraint id_pk primary key,
    name varchar2(20) constraint name_nn not null,
    contact varchar2(20) constraint contact_uk unique not null,
    gender varchar2(10) check (gender in ('남', '여'))
);
-- 테이블 생성
-- primary key : 주 키 설정 + 중복 방지 + not null -> 한군데만 설정 가능
-- not null : 빈 값 입력 방지
-- unique : 중복 방지 --> 여러곳에 설정 가능
-- 제약조건 별명을 붙이는 건 습관을 들일 필요는 없는데, 적어두면 나중에 편하긴하다
-- check : 칼럼에 들어갈 값을 제한
-- default 0 : 값은 안넣을때 자동으로 0 세팅

-- DML : insert - 테이블 또는 view에 데이터를 저장
insert into contact values(1001,'Jack','01012341234','남'); -- 모든 컬럼에 하나의 값을 넣겠다.
insert into contact (id, name) values(1002, 'Tom'); -- 컬럼을 정해서 값 입력 가능
select * from contact;
desc contact;
-------------------------------------
-- Foregin Key (외래키) : 데이터 무결성을 유지(primary key나 unique만 외래키로 사용가능)
create table product(
    pid varchar2(20) primary key,
    pname varchar2(100) not null,
    price number default 0 not null -- default 0 : 값을 안넣을때 자동으로 0값이 세팅
);
-- 값 삽입
insert into product values('p1001', 'LG-TV', 1000000);
insert into product values('p1002', 'ipad', 600000);

-- 컬럼 지정삽입
insert into member(id, pw, name, signup_date) values('joetheblack', '1234', 'joe', sysdate);

delete from product where pid = 'p1001';
drop table product; -- 테이블 삭제

-- 외래키를 갖는 purchase_details 테이블 생성
create table purchase_details(
    id number primary key,
    pid references product(pid), -- references : product의 pid키를 외래키로 한다(외래키 설정이 들어가면 parent, child 관계가 됨)
    pdate date default sysdate not null
);
-- on delete cascade : parent키가 지워졌을 때 연쇄적으로 같이 지워지는 컬럼
create table purchase_details(
    id number primary key,
    pid references product(pid) on delete cascade, -- on delete cascade : parent 테이블의 데이터가 지워질때 외래키의 데이터도 같이 지워지게함.
    pdate date default sysdate not null
);
-- set null : 지워진 값만 null로 바뀜
create table purchase_details(
    id number primary key,
    pid references product(pid) on delete set null,
    pdate date default sysdate not null
);

insert into purchase_details values(1001, 'p1001', default);
insert into purchase_details values(1002, 'p1002', default);
SELECT * FROM purchase_details;
drop table purchase_details;

-- 외래키가 생성되면 테이블 삭제가 까다로워짐
-- on delete cascade가 추가되면 항목 하나를 선택해서 지우는건 가능해짐
delete from purchase_details where pid = 'p1001';
-- drop : 테이블을 지우는 명령(데이블 안의 데이터 다날아감)
drop table contact;

-- Data Dictionary : 사용자의 쿼리 또는 명령문에 의해 생성되는 정보들을 저장하는 오라클 내장 테이블
SELECT table_name FROM user_tables;
SELECT * FROM user_constraints WHERE table_name = 'EMPLOYEE';

-------------- 테이블 만들기 실습 -----------------
-- Member 테이블 구성
-- ID / PW / Name
-- jackid / 1234 / jack
-- tomid / 4321 / tom
create table member(
    id varchar2(20) primary key,
    pw number not null,
    name varchar2(10)
);
insert into Member values('jackid', 1234, 'jack');
insert into Member values('tomid', 4321, 'tom');
SELECT * FROM Member;

drop table Member;
delete from member where id = 'jackid'; 
-- delete from member; 이것만 하면 데이터가 다 사라짐
-- delete 에는 *을 찍지 않는다.

-- Board 테이블 구성
-- id / message / writer (member 테이블의 id를 참조)
-- 1001 HelloTom jackid
-- 1002 Byjack tomid
create table Board(
    id number primary key,
    message varchar2(20) not null,
    writer references member(id) on delete cascade
    -- writer references Member(id) on delete set null
    -- writer references Member(id) 
);
insert into Board values(1001, 'HelloTom', 'jackid');
insert into Board values(1002, 'Byjack', 'tomid');
SELECT * FROM Board;

delete from Member where id = 'jackid';
delete from Board where ID = 1002;
drop table Board;

--------------------------------------------------------------------------------
/*
DDL
create : 객체 생성 - 제약조건 : not null, primary key, unique, check, foreign key
drop : 객체 삭제
alter : 객체 수정

DML
insert / delete / select / update(데이터 수정)
update는 데이터 수정 / alter는 객체 수정
*/
select * from contact;
drop table contact;
update contact set gender = '남' where id = 1001; -- delete처럼 where 절을 잘 명시해야함
update contact set name = 'tom', contact = '01012344321' where id = 1001; -- 여러개를 변경할땐 ,로 구분

------------------실습---------------------
create table khacademy(
    no number primary key,
    id varchar2(20) unique,
    pass varchar2(20) not null,
    name varchar2(20) not null,
    nickname varchar2(20)unique,
    gender char,
    tel varchar2(20) default '010-0000-0000',
    address varchar2(90)
);
select * from khacademy;
select * from user_constraints where table_name='KHACADEMY';
select column_name, data_type, nullable,data_default,column_id from all_tab_columns where table_name='KHACADEMY';
-- 데이터 삽입
insert into khacademy values (1, 'hong11', '1234', '홍길동', '동해번쩍', 'M', '010-4958-2333', '경기도');
insert into khacademy values (2, 'gogo11', '4444', '고길똥', '둘리세퀴', 'M', default, '경상도');
insert into khacademy values (3, 'kimDDong', '6658', '김말똥', '내눈은말똥', 'F', '010-6674-8986', '전라도');
insert into khacademy values (4, 'sin', '5356', '신구', '니들이게맛을', 'M', '010-8997-1122', '울릉도');
insert into khacademy values (5, 'mslove', '5555', '김민수', '영원한ms', 'F', default, '서울시');
-- 데이터 수정(내눈은말똥이란 사람의 pass 를 9999로 변경 nickname를 검색조건으로 사용.)
update khacademy set pass = '9999' where nickname = '내눈은말똥';
update khacademy set tel = '없음' where tel = '010-0000-0000'; -- default로 된 모든 사람을 '없음'으로 변경
-- 데이터 삭제
delete from khacademy where id = 'sin';
-- 테이블 삭제
drop table khacademy;

------------------------------------ alter -------------------------------------
-- alter : 객체의 정보 또는 설정을 수정하는 기능(테이블의 구조를 바꿈)
select * from contact;
desc contact;
-- add : 새로운 컬럼 추가
alter table contact add(address varchar(100));
-- alter table contact add(address varchar(100) not null); 이건 안됨 컬럼이 생성되자마자값이 없으니 not null이 성립안됨.
alter table contact add(address varchar(100) default '없음' not null);

-- drop column : 컬럼 삭제
alter table contact drop column address;

-- modify : 컬럼 자료형 변경하기
alter table contact modify(address varchar2(200));

-- rename column : 컬럼명 변경하기
alter table contact rename column address to address1;

-- rename to : 테이블명 변경하기
alter table contact rename to members;
alter table members rename to contact;

-- drop constraint : 컬럼 제약조건 삭제하기
alter table contact drop constraint SYS_C007785;

-- 컬럼에 not null 제약조건 추가하기(modify 로 변경, 추가 가능)
alter table contact modify (address varchar2(20) not null);

-- 컬럼에 제약조건 추가하기 다른방법
alter table contact modify (name varchar2(20) unique); -- name에 unique 옵션을 준다.
alter table contact modify (name varchar2(20) constraint name_nn unique); -- 이름도 부여 가능
alter table contact add constraint name_uk unique(name); -- name에 unique옵션을 준다.(not null 은 add로 불가)

-- 컬럼 제약조건 확인
select * from user_constraints where table_name='CONTACT';
