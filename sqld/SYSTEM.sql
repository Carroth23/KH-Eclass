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
alter session set "_ORACLE_SCRIPT"=true; -- C##�Ⱥ��̰� �輺�����ϰ� �ٲٴ°�.
-- �������� ������ test ��й�ȣ test
create user ������ identified by ��й�ȣ;
-- ���� ����
grant connect to ������;
-- ���̺� ���� ���� ���� ���� ����
grant resource to ������;

grant unlimited tablespace to ������; -- ���̺����̽����� �� �ؿ��� �������ε�
ALTER USER ������ DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS; -- ������ ���� ����
grant create table, dba TO ������; -- dba������ ����ڰ������� �Ժη� �ָ�ȵ�. ���� �������� ���ֱ⶧��
drop user ������ cascade; -- ���� ���� cascade�� �ٿ��� ����ϰ� ������

-- kh������ �ִ� employee���̺��� select������ test�������� �ο���.
grant select on kh.employee to test;
-- test������ kh.employye ���̺� ���� select ���� ȸ��
revoke select on kh.employee from test;
------------------

-- test2 ������ �����, kh.employee ���̺� select �� update ������ �ο��Ѵ�.
-- test2 �������� �����ؼ� �������� �̸��� �����̷� �����غ���.
-- test2 ������ �Ҵ� ���� ������ ��� revoke �� ȸ���غ���.
create user test2 identified by test2;
grant connect to test2;
grant select, update on kh.employee to test2;

select * from kh.employee;
update kh.employee set emp_name = '������' where emp_id = 200;
select * from employee;
commit; -- ������Ʈ �Ŀ� Ŀ���� �ؾ� �ٲ�
-------------------------------------

-- testConnection
create table temp(
    data varchar(20)
);

select * from kh.employee; -- select ������ �ο��޾� test������ select ����.
delete from kh.employee; -- delete ������ �����Ƿ� �����Ұ�.
