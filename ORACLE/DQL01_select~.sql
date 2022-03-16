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
-------------------------------------select-------------------------------------
-- select ����� �����͸� Ȯ���ϴ� ����
select * from cafe_menu; -- *(������ ����ũ)�� ��� �÷� ���
-- ������� �÷��� ��� �ۼ��� ����
select emp_id, emp_name, emp_no from employee;
-- select������ ���굵 ����
select salary * 12 from employee;

-- Header�� as ū����ǥ""(���������̼�)�� ���.
select emp_id as "���", emp_name, emp_no, salary*12 from employee;
-- ū����ǥ""(���������̼�)�� ��������. but ������Ⱑ ���� ���� �ʼ�.
select emp_id as ���, emp_name, emp_no, salary*12 from employee;
-- as ������ ����.
select emp_id ���, emp_name, emp_no, salary*12 from employee;
-- ���ο� �÷��� ���� �� �ְ� as��ɵ� ���డ��.
select emp_id ���, emp_name ������, emp_no �ֹι�ȣ, salary*12 ����, '��' ���� from employee;
-- ����Ŭ���� ���ڿ����� ||�� �Ἥ ����.
select emp_id ���, emp_name ������, emp_no �ֹι�ȣ, salary*12 ||'��' ���� from employee;

----------- where ������ �� ------------
-- emp_id�� ���� 200�� ����� ���
select * from employee where emp_id = 200;
-- �ε�ȣ�� ����� �����ϴ�
select * from employee where emp_id < 203;
-- or, and �Ǵ�, �̸鼭
select * from employee where emp_id = 200 or emp_id = 201; -- 200 �̰ų� 201��
select * from employee where emp_id = 200 and emp_id = 201; -- 200 �̸鼭 201��
-- between A��B������ ��
select * from employee where salary between 3000000 and 4000000; --salary�� 3000000���� 4000000������ ��

select * from dual; -- dual���̺��� �������̺�, �ӽ� ���� ����ϱ� ���� �������� ����.

-- sysdate : ���� ��¥�� ��ȯ (�ð���{��,��,��}�� ���ԵǾ� �ִ�)
select sysdate from dual;
select sysdate + 5 from dual; -- ���� ��¥�κ��� 5�� ��.
select sysdate - 5 from dual; -- ���� ��¥�κ��� 5�� ��.

select (sysdate+5) - sysdate from dual; -- ��¥���� ������ ������ ����

select emp_name, sysdate - hire_date �ٹ��ϼ� from employee; -- �ٹ��ϼ� ��갡��.
select emp_name, floor(sysdate - hire_date) �ٹ��ϼ� from employee; -- floor�� �Ҽ��� ����.

-- employee ���̺��� �ټӳ���� 20�� �̻� �� ������ �̸�, �޿�, �ټӳ�� ���
select emp_name, salary, floor((sysdate-hire_date)/365)||'��' from employee
    where floor((sysdate-hire_date)/365) > 20;

select * from employee where hire_date='90/02/06'; --��¥�� ����� ������ ���߾�� �Ѵ�
select * from employee where hire_date>'90/01/01' and hire_date<'00/01/01'; -- ��¥ ��Һ� ����
select * from employee where hire_date between '90/01/01' and '00/01/01'; -- between���� Ȱ�밡��.

select * from employee where bonus is null; -- null ���� ǥ���� is null or is not null
select * from employee where bonus is not null; -- null ���� ǥ���� is null or is not null

-- emp_id �� 200 �̰ų� 201�̰ų� 202�̰ų� 203�� ������ ������ ����ϼ���.
select * from employee where emp_id=200 or emp_id=201 or emp_id=202;
select * from employee where emp_id in (200,201,202,203); -- �� ������ ª��
select * from employee where emp_id not in (200,201,202,203); -- 200,201,202,203�� �ƴ� ���̵� ���

-- like : ã���� �ϴ� �����Ͱ� �������� ��
-- �̸��� %�� �˻��ϴ� ��Ȳ.
select * from employee where emp_name ='�����';
select * from employee where emp_name like '��%'; -- like '��%'��ȣ�� '��'�ν����ϰ� ,%�� �ƹ����ڳ� 0���� �̻�.
select * from employee where emp_name like '%��%'; -- %�� 0���� �̻�. '��'��� ���ڰ� ���Ե� ���.
select * from employee where emp_name like '%��'; -- ���ڿ��� ���ڰ� �־ �ȵȴ�.
-- �̸��� _�� �˻��ϴ� ��Ȳ.
select * from employee where emp_name like '��_'; -- '��'�ν����ؼ� �ڿ� �ƹ��ų� �ѱ��ڸ� �ִ� ���.
select * from employee where emp_name like '��__'; -- '��'�ν����ؼ� �ڿ� �ƹ��ų� �α��ڸ� �ִ� ���.
select * from employee where emp_name like '_��_'; -- ����� '��'�� ����ִ� ���.

-- ��������
-- Employee ���̺��� �̸��� ������ ������ ����� �̸� ���
select emp_name from employee where emp_name like '%��';
-- �̸����ּ��� ����� �ձ��ڰ� 3���� �̻��� ����� ���.
-- �ձ��ڰ� 3�����̰� escape���ڷ� '#'�� ���ڴ�. %�� 0�����̻�. like�� not like�� ����.
select * from employee where email like '___#_%' escape '#';
-- employee ���̺��� ��ȭ��ȣ ó�� 3�ڸ��� 010�� �ƴ� ����� �̸�, ��ȭ��ȣ�� ���
select emp_name, phone from employee where phone not like '010%';
-- employee ���̺��� �����ּҿ� 's' �� ���鼭, dept_code�� d9 �Ǵ� d6�̰�,
--            ������� 1990�� 1�� 1�Ϻ��� 2000�� 12�� 1�� �����̸�
--            �޿��� 270���� �̻��� ������ ��ü ����
select * from employee
where 
    email like '%s%' 
    and dept_code in ('D9','D6')
    and hire_date between '90/01/01' and '00/12/01' 
    and salary >= 2700000;
-- �μ� ��ġ�� ���� �ʾ����� ���ʽ��� ���޹޴� ������ ��� �� �̸�, ���ʽ�, �μ��� ����ϼ���
select emp_id, emp_name, bonus, dept_code from employee 
    where dept_code is null and bonus is not null;
-- ���� ��, �����ڵ尡 J7 �Ǵ� J2�̰�, �޿��� 200���� �ʰ��� ����� �̸� �޿� �����ڵ带 ����ϼ���.
select emp_name, salary, job_code from employee
    where job_code='J7' or job_code = 'J2' and salary > 2000000;
-- ���� �ڵ�� and������ �켱�Ǳ� ������ j2�̸鼭 2000000�̻��̰ų� j7�λ�� ���� �ؼ���. ()��ȣ�� �ذ�
-----------------------------------

-- order by : ������ ���Ŀ� ���.(���������̳� ��������, ����Ʈ�� ��������.)
select * from employee order by emp_name; -- �̸� ��������(�⺻ ��������).
select * from employee order by salary asc; -- �޿� ��������.
select * from employee order by hire_date desc; -- ��볯¥�� �ֽų�¥���� ������ ��¥���� ��������.
select * from employee order by 12 desc; -- �÷��� ������ ��ȣ�� ����.
select * from employee order by dept_code, job_code; -- dept_code�� �����ϰ� job_code�� ����.
select * from employee order by 6 desc, 7 asc; -- dept_code�� �������� �����ϰ� job_code�� �������� ����.

--nvl() : �޼��忡 ���� ���� �Ǿ�����, ���޵� ���� null�̸� �츮�� ������ ������ ��ȯ�ǰ�,
--        null�� �ƴϸ� ���޵� �� �״�� ��ȯ�Ѵ�.
select emp_name, nvl(dept_code, '����') from employee; -- dept_code�� �޾��� �� null���� �ִٸ� �������� ����.

-- ��������
-- ����1. 
-- �Ի����� 5�� �̻�, 10�� ������ ������ �̸�,�ֹι�ȣ,�޿�,�Ի����� �˻��ϼ���
select emp_name, emp_no, salary, hire_date from employee where (sysdate - hire_date)/365 between 5 and 10;
-- ����2.
-- �������� �ƴ� ������ �̸�,�μ��ڵ带 �˻��ϼ��� (��� ���� : ENT_YN)
select emp_name, dept_code from employee where ent_yn = 'Y';
-- ����3.
-- �ټӳ���� 10�� �̻��� �������� �˻��Ͽ� ����ϼ���.
-- ��� ����� �̸�,�޿�,�ټӳ��(�Ҽ���X)�� �ټӳ���� ������������ �����Ͽ� ����ϼ���.
-- ��, �޿��� 50% �λ�� �޿��� ��µǵ��� �մϴ�.
select emp_name, salary * 1.5, floor((sysdate-hire_date) / 365) from employee where (sysdate-hire_date) / 365 >= 10 order by ((sysdate-hire_date) / 365);
-- ����4.
-- �Ի����� 99/01/01 ~ 10/01/01 �� ��� �߿��� �޿��� 2000000 �� ������ �����
-- �̸�,�ֹι�ȣ,�̸���,����ȣ,�޿��� �˻��ϼ���.
select emp_name, emp_no, email, phone, salary from employee where (hire_date between'99/01/01' and '10/01/01') and salary <= 2000000;
-- ����5.
-- �޿��� 2000000�� ~ 3000000�� �� ������ �߿��� 4�� �����ڸ� �˻��Ͽ� 
-- �̸�,�ֹι�ȣ,�޿�,�μ��ڵ带 �ֹι�ȣ ������(��������) ����ϼ���.
-- ��, �μ��ڵ尡 null�� ����� �μ��ڵ尡 '����' ���� ��� �ϼ���.
select emp_name, emp_no, salary, nvl(dept_code, '����') from employee where salary between 2000000 and 3000000 and emp_no like '___4___2%' order by emp_no desc;
-- ����6.
-- ���� ��� �� ���ʽ��� ���� ����� ���ñ��� �ٹ����� �����Ͽ� 
-- 1000�� ����(�Ҽ��� ����) 
-- �޿��� 10% ���ʽ��� ����Ͽ� �̸�,Ư�� ���ʽ� (��� �ݾ�) ����� ����ϼ���.
-- ��, �̸� ������ ���� ���� �����Ͽ� ����ϼ���.
select emp_name, floor(((sysdate - hire_date)/100) * (salary * 0.01))Ư�����ʽ�
from employee where emp_no like '%-1%' and bonus is null order by 2 desc;
---------------------------------�Լ� (Function)---------------------------------

---------------------------------���� �� �Լ�------------------------------------
--���� �� �Լ� : �� �ึ�� ����Ǵ� �Լ�.
--Lower, Upper, Initcap : �빮��,�ҹ���,��ҹ��� ��ȯ
select * from employee where upper(job_code) = upper('j1'); -- ���� �̸��̶�� ��ҹ��ڱ��о��� �˻�����

--length : ���ڰ����� ���޵� ���ڿ��� ���̸� ��ȯ�ϴ� �Լ�
select length('������232hello')���ڼ���ȯ from dual;
select emp_name, length(email) from employee; -- �̸��� ���̸� �޾ƿ�

--lengthb : ���ڰ����� ���޵� ���ڿ��� ������(byte)�� ��ȯ�ϴ� �Լ�
select lengthb('ABCDEFG') from dual; -- �ѱ��ڴ� 1byte
select lengthb('������') from dual; -- �ѱ��ڴ� 3byte

-- instr : ã�� ����(��)�� ������ ��ġ���� ������ ��°��ŭ ��Ÿ�� ���� ��ġ�� ��ȯ.
-- instr(���� ���ڿ�, ã�� ����(��), ���° �ڸ���������, ���°�� ������); -��ȯ���� �˻� ������ ������ ó������ �ش� ��ġ������ �ε�����
select instr('Hello World Hi High', 'H', 3, 1) from dual;-- 3�� 1�� ������ ���° ���ڷκ��� ã���� 1�� ���°�� ������ H����
select instr('Hello World Hi High', 'H', 1, 2) from dual;-- ���� ����
select instr('Hello World Hi High', 'H', 2, 1) from dual;-- 13�� ������ ������ ������ġ���� ã���ϱ�.
select instr('Hello World Hi High', 'H', 2, 2) from dual;

--employee ���̺� ������ email�� email�� @ ��ġ���� ����ϼ���.
select email, instr(email, '@', 1) from employee;

-- substr : ���ڿ� ������ ���� �ε������� ������ ���ڸ�ŭ ���ڿ��� ����
-- substr(Ÿ�� ���ڿ�, �߶󳻰� ���� ���ڿ��� ���� �ε���, ������ ���ڼ�)
-- ������ ���ڼ��� ������� ������ ���� �ε������� ������ ���
select substr('A wise man will make more opportunities than he finds.',3,4) from dual;
select substr('A wise man will make more opportunities than he finds.',12,4) from dual;
select substr('A wise man will make more opportunities than he finds.',5) from dual; -- �ڿ��� �� ���

-- distinct : �ߺ��� ����
-- distinct�� �ٸ� Į���� ������ ���� �� �� ����. 
-- select emp_name �̸�, distinct substr(emp_name, 1,1) �� from employee order by 1; (x)
-- employee ���̺��� �������� �̸��� ���� ����غ�����
select distinct substr(emp_name,1,1) "��" from employee order by 1; -- �ߺ��� �����ϰ� ����������(distinct�� select �ٷεڿ� ���)
select distinct substr(emp_name,1,1) "��", emp_name from employee order by 1; -- �ߺ����Ű� ��ҵ�(name�� ���;� �ϴϱ�)
select substr(emp_name,2) "�̸�" from employee;

-- employee ���̺��� ���������� �����ȣ, �����, �ֹι�ȣ, ������ ��Ÿ������.
-- �ֹι�ȣ�� ��6�ڸ��� *ó���ϼ���.
select emp_id, emp_name, substr(emp_no,1,7)||'*******' �ֹι�ȣ, salary*12 ���� from employee where emp_no like '%-1%';
-- ����Ǯ��
select
    emp_id,
    emp_name,
    substr(emp_no,1,8)||'*******' as �ֹι�ȣ,
    salary*12 ���� 
from employee 
    where substr(emp_no,8,1)=1;

-- replace : ���ڿ� ������ Ư�� ���ڿ��� �ٸ� ���ڿ��� ��ü (��ü)
select replace('Oracle is not fun','not','very') from dual; -- 1��° ���ڿ����� 2��° �ܾ �������� 3��° ���ڷ� �ٲ�

-- employee ���̺��� ������ �̸��� �̸����� ����ϵ�, �̸����� kh.or.kr ���� iei.or.kr�� �����ؼ� ����ϼ���.
select emp_name, replace(email,'kh','iei') from employee;

-- lpad, rpad : ������� Ư�� ���ڷ� ä��� �Լ�(14�ڸ��� 7�ڸ��� ǥ���ϰ� ����,�������� ������ ���� �Ǵ� ��������� ä��)
select rpad(substr(emp_no,1,7), 14, '*') from employee;

-- trim : ��������

----------------�Ҽ��� ���� �Լ�---------------
-- round : �ݿø� �Լ�
select 126.456 from dual;
select round(126.456, 3) from dual; -- �Ҽ��� �׹�° �ڸ����� �ݿø��Ͽ� ����° �ڸ����� ����ε� ����°�����ۿ� �����Ƿ� �״�� ��µ�
select round(126.455, 2) from dual; -- �Ҽ��� ����° �ڸ����� �ݿø��Ͽ� 2��° �ڸ����� ���
select round(126.426, 1) from dual; -- �Ҽ��� �ι�° �ڸ��� 2�̱� ������ �ݿø������ʰ� 126.4�� ���
select round(126.656, 0) from dual; -- �Ҽ����� ���ټ��� �ִ�(�ݿø�)
select round(126.456, -1) from dual; -- �Ҽ��� �������� �ݿø��� ����
select round(126.456, -2) from dual; -- �԰���

-- floor : �Ҽ����� ������ �Լ�
select floor(126.456) from dual; -- �Ҽ����� �׳� ����(�ݿø���������)

-- trunc : ���ϴ� �Ҽ��� �ڸ����� ����ϸ� �������� ������ �Լ�
select trunc(123.456,1) from dual;
select trunc(123.456,2) from dual;
select trunc(123.456,0) from dual;
select trunc(123.456,-1) from dual;

-- ceil : �ø� �Լ�
select ceil(123.001) from dual; -- �Ҽ����� �ٷ� �÷�����

-- abs : ���밪
select abs(-1) from dual;

------------------��¥ ���� �Լ�-----------------
-- sysdate : ���� ��¥�� ��ȯ (�ð���{��,��,��}�� ���ԵǾ� �ִ�),(�� ������ ms�� ���� ����)
select sysdate from dual;

-- localtimestamp : ������ �ð� ��ȯ ms���� ���
select localtimestamp from dual;

-- months_between : ���ڷ� ���޵Ǵ� �ΰ��� ��¥������ �������� �����ϴ� �Լ�
select emp_name, hire_date, months_between(sysdate,hire_date) from employee;
select months_between(sysdate,'19/06/01') / 12 from dual;
select emp_name, hire_date, floor(months_between(sysdate,hire_date)/12)||'��' from employee;

-- add_months : ���ڷ� ���޹��� ��¥��, ���ڷ� ���޵� ���ڸ�ŭ�� ������ ���Ͽ� �����ϴ� �Լ�
select sysdate + 1 from dual; -- �Ϸ� �߰�
select add_months(sysdate, 1) from dual; -- 1���� �߰�

-- next_day : ���ڷ� ���޹��� ��¥�κ��� ���� ����� �ι�° ���ڿ� �ش��ϴ� ������ ��¥�� ����
select sysdate, next_day(sysdate, '������') from dual; -- sysdate ��¥ �������� ���� ����� ������ ���
select emp_name, hire_date, next_day(hire_date, '�Ͽ���') from employee; -- �Ի� �� ó�� �´� �Ͽ���
-- alter session set nls_language=AMERICAN; -- ����Ŭ ������ ����� ����

-- last_day : ���ڷ� ���޹��� ��¥�� ���� ���� ������ ��¥�� ����
select last_day(sysdate) from dual;
-- ������ ������ ��¥�� �����ϱ��?
select last_day(add_months(sysdate,1)) from dual;

-- extract : ���ڷ� ���޵� ��¥�κ��� ��/��/�� ���� �����ؼ� ����
select extract(year from sysdate) from dual; -- sysdate�� ���� year�� �����ϰڴ�
select extract(month from sysdate)||'��'||extract(day from sysdate)||'��' from dual; -- ���̵� ��
select extract(day from sysdate) from dual;

-- ��������
-- employee ���̺��� ����� �̸�, �Ի���, ������ ����ϼ���. ��, �Ի����� YYYY�� M�� D�� ���·� ����ϼ���.
-- ������ �ø��ؼ� ����ϼ���, ������ �Ի��� �������� �������� �����ϼ���.
select
    emp_name,
    extract(year from hire_date)||'��'||extract(month from hire_date)||'��'||extract(day from hire_date)||'��' �Ի���,
    ceil((sysdate-hire_date)/365) "����"
from employee order by hire_date;

------------------����ȯ �Լ�------------------
-- to_char : ����Ÿ���̳� ��¥Ÿ���� ���ڿ��� �����Ͽ� �����ϴ� �Լ�
-- to_char(� ���ڳ� ��¥��, � ���ڿ� ������� ���)
select to_char(sysdate, 'YYYY-MM-DD') from dual;
select to_char(sysdate, 'YYYY/MM/DD') from dual;
select to_char(sysdate, 'YYYY/MM/DD day') from dual; -- ���ϵ� �����
select to_char(sysdate, 'YYYY/MM/DD(dy)') from dual; -- ������ �ѱ��ڷ� ���
select to_char(sysdate, 'YYYY#MM$DD_ dy HH:MI:SS') from dual; -- �ð������� ���
select to_char(sysdate, 'YYYY"��"MM"��"DD"��" dy HH:MI:SS') from dual; -- date���� �ȿ� ���ϴ� ���ڴ� ""�� ���´�.

-- �̹��� ������ ���� ���ϱ�
select to_char(last_day(sysdate), 'day') from dual;
-- 6���� ���� �������� ����
select to_char(last_day(add_months(sysdate, 6)), 'YYYY/MM/DD day') from dual;

-- ���ڸ� ���ڿ��� ǥ��
select emp_name, to_char(salary, '999,999,999') from employee; -- 999�� ä��� 000ó�� �ڸ����� 0���� ä�����ʴ´�.
select emp_name, to_char(salary, 'L999,999,999') from employee; --L�� ������ȭ ǥ���

-- to_date : ���� �Ǵ� ���ڸ� ��¥�� ����ȯ���� �����ϴ� �Լ�
select to_date(20200905, 'YYYYMMDD') from dual; -- YYYY MM DD �������� �м��� �ϴ°����� ����� �ϴ°��� �ƴ�.
select to_date('09052020', 'MMDDYYYY') from dual; -- �� �� �� �ν��� �ٸ��� �ϴ°�.
-- 2030�� 12�� 25���� ���� �����ϱ��?
select to_char(to_date(20301225), 'YYYY/MM/DD day') from dual;

-- to_number : ���ڸ� ���ڷ� �ٲٴ� �Լ�(����Ŭ���� ���� �ƶ��� �м��Ͽ� �ڵ� ����ȯ�� �����ϱ⶧���� ���ʿ����.
select to_number('10') + '5' from dual;
select '10' + '5' from dual;

-- mod : ���ڸ� ���� ���������� ��ȯ
select mod(15, 6) from dual;

------------------���� �Լ�-----------------
-- decode : �ڹ��� switch�� ���� ����. == �񱳸� ���� �б��� ����
select
    emp_name,
    decode(substr(emp_no,8,1), 1, '��', 2, '��', 3, '��', 4, '��') -- ���� ���ڰ�
    -- decode(���Ⱚ��, �̰Ÿ�, �̰����, �̰Ÿ�, �̰���� ...)
    -- decode(substr(emp_no,8,1), 1, '��', '����') '����' ����Ʈ ����
from
    employee;

-- case: �ڹ��� if�� ���� ����. <= >= > < == �񱳸� ���� �б����� ����
select
    emp_name,
    case
        when substr(emp_no, 8, 1) = 1 then '��'
        when substr(emp_no, 8, 1) = 2 then '��'
        else '����' -- ����Ʈ
    end ����
from employee;

-- 60���� �����߿�, 65�� ���� ������ '60���� �ʹ�', ���Ĵ� '60���� �Ĺ�' �̸��� �ֹι�ȣ, ��������� ����ϼ���
select
    emp_name,
    emp_no,
    case
        when substr(emp_no, 2, 1) < 5 then '60��� �ʹݻ�'
        when substr(emp_no, 2, 1) >= 5 then '60��� �Ĺݻ�'
    end �������
from
    employee
where emp_no like '6%';

------------------------------------�׷� �Լ�------------------------------------
-- �׷� �Լ� : ��� �࿡ ���ؼ� �� �� �� ����Ǵ� ��.
-- �׷��Լ����� ������ �Լ��� �ü� ����.

-- �հ��Լ� (sum)
select sum(salary) from employee;
-- employee ���̺� ���� ���������� �޿� �հ�
select to_char(sum(salary), 'L99,999,999') "������ �޿��հ�" from employee
    where emp_no like '%-2%';

-- ����Լ� (AVG)
select to_char(avg(salary), 'L9,999,999') "������ �޿����" from employee
where substr(emp_no, 8, 1) = 2;

-- �������� (COUNT)
-- NULL ���� ī���� ���� ����
-- ���� NULL ���� ��� ���� �� ���� ��ü�� ���Ѵٸ� count(*)�� ���� �ȴ�. 
select count(emp_name) from employee; -- 23
select count(dept_code) from employee; -- 21 (count�Լ��� null���� ������� �ʴ´�.)
select count(*) from employee; -- *��� ���� ������ ���
-- �������� ���� ����غ�����.
select '�������� '||count(*)||'��' �ο� from employee where emp_no like '%-1%';

-- �ּҰ� / �ִ밪 (min / max)
select min(salary), max(salary) from employee; -- �׷��Լ����� ���̾����ִ�.
-- D5�μ����� �޿��� ���� ���� ������ salary ���� ����غ�����.
select max(salary) from employee where dept_code = 'D5';

-----------------------�ǽ� ����------------------------
-- ������� �̸��� �̸����� ���̸� ���
select emp_name ������, email �̸���, length(email) ���ϱ��� from employee;
-- ������� @�������� �̸����� ���
select emp_name ������, substr(email, 1, instr(email, '@')-1) ���Ͼ��̵� from employee;
-- 60����� ������� ���, ���ʽ����� ��� ��, ���ʽ����� null�̸� 0%�� ���
select emp_name ������, substr(emp_no, 1, 2)||'���' ���, nvl(bonus*100, '0')||'%' ���ʽ� from employee where emp_no like '6%';
-- 010 �ڵ�����ȣ�� ���� �ʴ� ������ ��
select count(*)||'��' "010�� ��������ʴ� ����" from employee where phone not like '010%';
-- ������� �Ի��� ��ȸ �Ի��� 2012�� 12�� ����
select emp_name ������, to_char(hire_date, 'YYYY"��"MM"��"') �Ի��� from employee;
-- ������� �ֹι�ȣ ��ȸ ��, �ֹι�ȣ�� 771120-1****** ���� ǥ��
select emp_name ������, substr(emp_no, 1, 8)||'******' �ֹι�ȣ from employee;
-- ������, �����ڵ�, ����(��) ��ȸ ��, ������ ������ȭ57,000,000���� ǥ�� ������ ���ʽ�����Ʈ�� ����� 1��ġ �޿���
select emp_name ������, job_code �����ڵ�, to_char(salary*12+(salary*12*nvl(bonus, 0)), 'L999,999,999') ���� from employee;
-- �μ��ڵ尡 D5,D9�� ������ 2004�⵵�� �Ի��� ������ ��� ����� �μ��ڵ� �Ի���
select emp_id ���, emp_name ������, dept_code �μ��ڵ�, hire_date �Ի��� from employee where dept_code in ('D5', 'D9') and (hire_date like '04%');
-- ������, �Ի���, ���ñ����� �ٹ��ϼ� ��ȸ
select emp_name ������, hire_date �Ի���, ceil(sysdate-hire_date) �ѱٹ��ϼ� from employee;
-- ��� ������ ���� �� ���� ���� ���̿� ���� ���� ���̸� ����ϼ���.
select max(to_char(sysdate, 'YYYY') - (substr(emp_no,1,2)+1900))+1||'��' "���� ��������", min(to_char(sysdate, 'YYYY') - (substr(emp_no,1,2)+1900))+1||'��' "���� ��������" from employee;
select min(2021-(1900+substr(emp_no,1,2))+1) "���� ���� ����", max(2021-(1900+substr(emp_no,1,2))+1) "���� ���� ����" from employee;
select
    emp_name �̸�,
    dept_code �μ��ڵ�,
    case
        when dept_code in ('D5','D6','D9') then '�߱�'
        else '�߱پ���'
    end �߱�����
from employee order by dept_code;

select * from employee;

select d.emp_name, d.dept_code, d1.dept_title from (select * from employee where dept_code = 'D9') d, (select * from department) d1 where d.dept_code = d1.dept_id;