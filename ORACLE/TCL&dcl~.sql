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
delete from cafe_menu where price = 4000;
desc cafe_menu;
select * from user_constraints where table_name='CAFE_MENU';

alter table cafe_menu add constraint cafe_menu_id_pk primary key(id);
-- name�� not null �ɼ� �߰�
alter table cafe_menu modify (name constraint cafe_menu_name_nn/*�̰� �̸��� �ֱ����� �뵵*/ not null);
alter table cafe_menu drop constraint CAFE_MENU_NAME_NN;

insert into cafe_menu values(1001, 'Americano', 2000);
insert into cafe_menu values(1002, 'Cafe_Latte', 2500);
insert into cafe_menu values(1003, 'Cafe_Mocha', 3000);
insert into cafe_menu values(cafe_menu_seq.nextval, 'Orange Juice', 4000); -- �������� �ִ� ����.(������ ��ɾ�� ����)
-- Sequence : Ư�� ���۰����� ���� ������ �� �������� ���������� ����(����) �ϴ� ���� ������ִ� ��ü
--               ������ �̸�                                   maxvalue 2000
create sequence cafe_menu_seq start with 1004 increment by 1 nomaxvalue nocache;
-- nomaxvalue ����ȣ�� ������ ���� maxvalue 2000�� ����ȣ ���Ҽ� �ִ�.
-- nocache�� ĳ�̱���� ������� �ʴ´ٴ� ��.
-- start with 1004 increment by 1 1004������ 1�� ������Ű�ڴٴ� ��

-- ������ ����
DROP SEQUENCE cafe_menu_seq;
--------------------------------------------------------------------------------
-- TCL : Transection Control Language
-- Ʈ����� : ����Ŭ ������ ����ϴ� ���� �۾��� ���� (������ �߰� �����?) / 
--           ������ �������� �۾��� ���ڼ��� Ȯ���Ѵ�. (������, �Ǽ�����, ���ڼ�) ���ڼ��̶� �۾��� ���� �����ϰ� �ϰų� ���� �����ϰ� �ϰų�
-- commit : Ʈ������̶�� �ӽ�����ҿ� �ִ� ������ DB�� ������.
commit;
-- rollback : Ʈ����ǿ� �ִ� ��ɵ��� ���
rollback;

select * from cafe_menu;

delete from cafe_menu;

----------------------------------system ����------------------------------------
-- DCL : Data Control Language
-- Grant (���Ѻο�)
create user test identified by test; -- ������ test ��й�ȣ test
grant connect to test; -- ���� ����
grant resource to test; -- ���̺� ���� ���� ���� ���� ����
grant select on kh.employee to test; -- kh������ �ִ� employee���̺��� select������ test�������� �ο���.

select * from kh.employee;
update kh.employee set emp_name = '������' where emp_id = 200;
select * from employee;
commit; -- ������Ʈ �Ŀ� Ŀ���� �ؾ� �ٲ�

--------------------------------------------------------------------------------
-- Object : view - (���������� ������������ �������̺� ���� ��ũ���̺�)�������̺�
select * from employee;

-- ������ �÷��� ������ �����ؼ� �� ���̺��� ����.(���纻. ���������� �ΰ��� ���̺��� �ǹǷ� employee�� �����ص� dev�� ��ȭ�� ����)
create table employee_dev as select emp_id,emp_name,emp_no,email from employee;

select * from employee_dev;
update employee_dev set emp_name='������' where emp_id=200;
commit;

-- �̰��� view
create view employee_dev_view as select emp_id,emp_name,emp_no,email from employee;
-- view ���� ������ ��� ��������� �ʴ´�.
-- grant create view to kh; �� ������ �־����
select * from employee_dev_view;

-- view�� �����ؼ� ������� �ִ�.
create view employee2 as select emp_id, emp_name,
(select dept_title from department where dept_code = dept_id) �μ��� from employee;

-- �������� �ֹι�ȣ ����
update employee set emp_no = '621231-1985634' where emp_id = 200;
select * from employee_dev_view;

-- view���� �ٲٸ� ���� employee�� ����Ǿ��ֱ⿡ ���������͵� ���� �����.
update employee_dev_view set emp_name = '������' where emp_id=200;

-- test������ kh.employee�� select ������ ��.
grant select on kh.employee_dev_view to test;
--------------------------------------------------------------------------------

/* ����
DB != DBMS (DBMS�� �����Ͱ��� �ý���)

SQL-Developer (DBMS�� ���ϰ� ����ϱ����� ��)
- SQL
    > DDL : create / alter / drop 
    > DCL : grant / revoke (�ڿ��� �����̳� system�������� ������ �ټ� �ִ�.)
    > TCL : rollback / commit (Ʈ����ǰ���)
    > DML : insert / update / delete
        > DQL : select > from, where, function, order by, group by, having, subquery, join
                select������ ���� ���� from -> where -> group by -> having -> select -> order by

*/
