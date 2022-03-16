-- ������ SQL : Structured Query Language
    -- DDL(Data Definition Language) : ����Ŭ ���ο��� ���Ǵ� "��ü"�� ����/����/�����ϴ� ���.
        -- 1) Create
        -- 2) Alter
        -- 3) Drop
    -- DML(Data Manipulation Language) : ����Ŭ�� ������ "������"�� ����/����/�����ϴ� ���.
        -- 1) Insert
        -- 2) Delete
        -- DQL (Data Query Language): �����ͺ��̽��� ����� �͵��� ��ȸ.
        --      select ���� ���� ex) from, select, where, group by, having, order by
        -- 3) Select
        -- 4) Update
    -- DCL(Data Control Language) : �ý��� ������ �ο��ϰų� ȸ���ϴ� ���.
        -- 1) Grant
        -- 2) Revoke
    -- TCL(Transaction Control Language) : �۾��� ���� Commit�Ǵ� Rollback�� �����ϴ� ���. ���ڼ��� ��Ű�� ���� ���.
        -- 1) Commit
        -- 2) Rollback
-- select������ ���� ���� from -> where -> group by -> having -> select -> order by
--------------------------------------------------------------------------------
------------------------ DDL : Data Definition Language ------------------------
-- ex) table, user, view, sequence, index, trigger, package, procedure, function
-- create : ��ü�� ���� create + ������� �ϴ� Ĵü Ÿ�� + ���̺� �̸�)
create table contact(
    id number,
    name varchar2(20), -- varchar2 ��� char�� ������ �ִ� varchar2�� ���������� �����͸� ��� char�� ������ ������ �״�� ��� ���������� �����Ƿ� ó���ӵ��� ����
    contact varchar2(20)
);
-- �������� �ִ� table ����
create table contact(
    id number not null, -- not null�� ��������. null���� ���� �� ����. ��, ����� �� ����.
-- �÷��� �ڷ��� ��������
    name varchar2(20) not null,
    contact varchar2(20) not null
);
-- �⺻Ű�� ���� table ����
create table contact(
    id number primary key, -- �ĺ���. id���� �⺻Ű�� �ϰڴ�. ���Ŀ��� ������ ��ȣ�� id���� �����Ҽ� ����(not null �ڵ�����) �� ���̺�� �Ѱ��� ����
    name varchar2(20) not null,
    contact varchar2(20) not null
);
-- constraint name�� ����ϱ� ���ϰ� �ٲ㼭 ����(�������� Ȯ��)
create table contact(
    id number constraint id_pk primary key,
    name varchar2(20) constraint name_nn not null,
    contact varchar2(20) constraint contact_nn not null
);
-- primary key : �� Ű ���� + �ߺ����� + not null
-- not null    : �� �� �Է� ����, �ߺ����, �����÷��� ��������
-- unique      : �ߺ����� , null�� ���, ���� �÷��� ��������
create table contact(
    id number constraint id_pk primary key,
    name varchar2(20) constraint name_nn not null,
    contact varchar2(20) constraint contact_uk unique not null -- unique + not null ���úο� ����(�ٵ� �̷��� primaryŰ�� ���)
);
-- check : ���� ������ üũ(������ �� �̿��� ���� ������� �ʰڴ�. ���⼭�� '��','��'�� ���.null���� ���)
create table contact(
    id number constraint id_pk primary key,
    name varchar2(20) constraint name_nn not null,
    contact varchar2(20) constraint contact_uk unique not null,
    gender varchar2(10) check (gender in ('��', '��'))
);
-- ���̺� ����
-- primary key : �� Ű ���� + �ߺ� ���� + not null -> �ѱ����� ���� ����
-- not null : �� �� �Է� ����
-- unique : �ߺ� ���� --> �������� ���� ����
-- �������� ������ ���̴� �� ������ ���� �ʿ�� ���µ�, ����θ� ���߿� ���ϱ��ϴ�
-- check : Į���� �� ���� ����
-- default 0 : ���� �ȳ����� �ڵ����� 0 ����

-- DML : insert - ���̺� �Ǵ� view�� �����͸� ����
insert into contact values(1001,'Jack','01012341234','��'); -- ��� �÷��� �ϳ��� ���� �ְڴ�.
insert into contact (id, name) values(1002, 'Tom'); -- �÷��� ���ؼ� �� �Է� ����
select * from contact;
desc contact;
-------------------------------------
-- Foregin Key (�ܷ�Ű) : ������ ���Ἲ�� ����(primary key�� unique�� �ܷ�Ű�� ��밡��)
create table product(
    pid varchar2(20) primary key,
    pname varchar2(100) not null,
    price number default 0 not null -- default 0 : ���� �ȳ����� �ڵ����� 0���� ����
);
-- �� ����
insert into product values('p1001', 'LG-TV', 1000000);
insert into product values('p1002', 'ipad', 600000);

-- �÷� ��������
insert into member(id, pw, name, signup_date) values('joetheblack', '1234', 'joe', sysdate);

delete from product where pid = 'p1001';
drop table product; -- ���̺� ����

-- �ܷ�Ű�� ���� purchase_details ���̺� ����
create table purchase_details(
    id number primary key,
    pid references product(pid), -- references : product�� pidŰ�� �ܷ�Ű�� �Ѵ�(�ܷ�Ű ������ ���� parent, child ���谡 ��)
    pdate date default sysdate not null
);
-- on delete cascade : parentŰ�� �������� �� ���������� ���� �������� �÷�
create table purchase_details(
    id number primary key,
    pid references product(pid) on delete cascade, -- on delete cascade : parent ���̺��� �����Ͱ� �������� �ܷ�Ű�� �����͵� ���� ����������.
    pdate date default sysdate not null
);
-- set null : ������ ���� null�� �ٲ�
create table purchase_details(
    id number primary key,
    pid references product(pid) on delete set null,
    pdate date default sysdate not null
);

insert into purchase_details values(1001, 'p1001', default);
insert into purchase_details values(1002, 'p1002', default);
SELECT * FROM purchase_details;
drop table purchase_details;

-- �ܷ�Ű�� �����Ǹ� ���̺� ������ ��ٷο���
-- on delete cascade�� �߰��Ǹ� �׸� �ϳ��� �����ؼ� ����°� ��������
delete from purchase_details where pid = 'p1001';
-- drop : ���̺��� ����� ���(���̺� ���� ������ �ٳ��ư�)
drop table contact;

-- Data Dictionary : ������� ���� �Ǵ� ��ɹ��� ���� �����Ǵ� �������� �����ϴ� ����Ŭ ���� ���̺�
SELECT table_name FROM user_tables;
SELECT * FROM user_constraints WHERE table_name = 'EMPLOYEE';

-------------- ���̺� ����� �ǽ� -----------------
-- Member ���̺� ����
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
-- delete from member; �̰͸� �ϸ� �����Ͱ� �� �����
-- delete ���� *�� ���� �ʴ´�.

-- Board ���̺� ����
-- id / message / writer (member ���̺��� id�� ����)
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
create : ��ü ���� - �������� : not null, primary key, unique, check, foreign key
drop : ��ü ����
alter : ��ü ����

DML
insert / delete / select / update(������ ����)
update�� ������ ���� / alter�� ��ü ����
*/
select * from contact;
drop table contact;
update contact set gender = '��' where id = 1001; -- deleteó�� where ���� �� ����ؾ���
update contact set name = 'tom', contact = '01012344321' where id = 1001; -- �������� �����Ҷ� ,�� ����

------------------�ǽ�---------------------
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
-- ������ ����
insert into khacademy values (1, 'hong11', '1234', 'ȫ�浿', '���ع�½', 'M', '010-4958-2333', '��⵵');
insert into khacademy values (2, 'gogo11', '4444', '����', '�Ѹ�����', 'M', default, '���');
insert into khacademy values (3, 'kimDDong', '6658', '�踻��', '����������', 'F', '010-6674-8986', '����');
insert into khacademy values (4, 'sin', '5356', '�ű�', '�ϵ��̰Ը���', 'M', '010-8997-1122', '�︪��');
insert into khacademy values (5, 'mslove', '5555', '��μ�', '������ms', 'F', default, '�����');
-- ������ ����(�����������̶� ����� pass �� 9999�� ���� nickname�� �˻��������� ���.)
update khacademy set pass = '9999' where nickname = '����������';
update khacademy set tel = '����' where tel = '010-0000-0000'; -- default�� �� ��� ����� '����'���� ����
-- ������ ����
delete from khacademy where id = 'sin';
-- ���̺� ����
drop table khacademy;

------------------------------------ alter -------------------------------------
-- alter : ��ü�� ���� �Ǵ� ������ �����ϴ� ���(���̺��� ������ �ٲ�)
select * from contact;
desc contact;
-- add : ���ο� �÷� �߰�
alter table contact add(address varchar(100));
-- alter table contact add(address varchar(100) not null); �̰� �ȵ� �÷��� �������ڸ��ڰ��� ������ not null�� �����ȵ�.
alter table contact add(address varchar(100) default '����' not null);

-- drop column : �÷� ����
alter table contact drop column address;

-- modify : �÷� �ڷ��� �����ϱ�
alter table contact modify(address varchar2(200));

-- rename column : �÷��� �����ϱ�
alter table contact rename column address to address1;

-- rename to : ���̺�� �����ϱ�
alter table contact rename to members;
alter table members rename to contact;

-- drop constraint : �÷� �������� �����ϱ�
alter table contact drop constraint SYS_C007785;

-- �÷��� not null �������� �߰��ϱ�(modify �� ����, �߰� ����)
alter table contact modify (address varchar2(20) not null);

-- �÷��� �������� �߰��ϱ� �ٸ����
alter table contact modify (name varchar2(20) unique); -- name�� unique �ɼ��� �ش�.
alter table contact modify (name varchar2(20) constraint name_nn unique); -- �̸��� �ο� ����
alter table contact add constraint name_uk unique(name); -- name�� unique�ɼ��� �ش�.(not null �� add�� �Ұ�)

-- �÷� �������� Ȯ��
select * from user_constraints where table_name='CONTACT';
