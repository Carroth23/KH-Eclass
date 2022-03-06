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
-----------------------------------Basic 2--------------------------------------
---------------�׷�ȭ ( Group By + Having ) : Ư�� �÷��� �������� �׷�ȭ���Ѽ� �����͸� ������ ��� -----------
SELECT emp_name, salary FROM employee;  -- ������ �޿����
SELECT SUM(salary) FROM employee;       -- �������� �޿��հ�
select sum(salary) from employee where dept_code = 'D1'; -- Ư�� �μ��� �޿� �հ�

-- GROUP BY
SELECT dept_code FROM employee GROUP BY dept_code ORDER BY 1; -- �׷�ȭ�� �����ʹ� ��� ���� �ߺ��� ���ŵ� ȿ���� ���� �� �ִ�.
-- �μ��� �޿����
SELECT dept_code, floor(AVG(salary)) FROM employee GROUP BY dept_code ORDER BY 1; -- dept_code�� �׷�ȭ
-- select dept_code, emp_name from employee group by dept_code; -- �����߻� dept�׷����� ��ұ� ������ ������ �����͸� �ҷ��ü� ����

SELECT
    dept_code,
    TO_CHAR(SUM(salary),'L999,999,999') "�μ��� �޿��հ�",
    TO_CHAR(AVG(salary),'L999,999,999') "�μ��� �޿����",
    COUNT(*)||'��' "�μ��� �ο���",
    MIN(salary), MAX(salary)
FROM
    employee
GROUP BY
    dept_code
ORDER BY SUM(salary)desc; -- �μ��� �޿� �հ�

-- �μ��ڵ庰 ���ʽ��� �޴� ����� �ο���
SELECT dept_code, COUNT(bonus) FROM employee GROUP BY dept_code ORDER BY 1; -- 0�� ���
SELECT dept_code, COUNT(*) FROM employee WHERE bonus IS NOT NULL GROUP BY dept_code ORDER BY 1; -- 0�� ����

-- employee ���̺��� ������ j1�� ����� �����ϰ�, ����, ���޺� ����� �� ��� �޿�
SELECT job_code, COUNT(*), floor(AVG(salary)) FROM employee WHERE job_code != 'J1' GROUP BY job_code ORDER BY 1;
-- employee ���̺��� ������ �ο����� ����غ�����.
SELECT decode(substr(emp_no, 8, 1),1,'��',2,'��') ����, count(*)||'��' �ο��� FROM employee
    GROUP BY decode(substr(emp_no, 8, 1),1,'��',2,'��'); -- ���� decode ������ �ܿ� ���� �ִٸ� nulló���� �ȴ�.(�ֹι�ȣ 1, 2�ܿ� null)
-- J1 ������ �����ϰ�, �Ի�⵵�� �ο����� ��ȸ�ؼ� �Ի�⵵�� ������������ ����غ�����.
SELECT
    extract(year from hire_date) �Ի�⵵,
    count(*) �ο���
FROM
    employee
WHERE
    job_code != 'J1'
GROUP BY
    extract(year from hire_date)
ORDER BY 1;

-- employee ���̺��� ���ɴ뺰 �ο����� ����غ�����.
SELECT
    substr(emp_no, 1,1)||'0����'���ɴ�,
    count(*)�ο���
FROM
    employee
GROUP BY
    substr(emp_no, 1, 1)
ORDER BY 1;

----------- group by ��ȭ ------------
-- ���� group by
SELECT
    dept_code,
    job_code,
    sum(salary) "�μ� �� ���޺� �޿��հ�",
    count(*) �ο�
FROM
    employee
GROUP BY
    dept_code, job_code
ORDER BY 1;

-- �� ���޳� ������ �ο���(�� �μ��� ������ �ο����� ���)
SELECT
    job_code ����,
    decode(substr(emp_no, 8, 1), 1, '��', '��') ����,
    count(*) �ο���
FROM
    employee
GROUP BY
    job_code, substr(emp_no, 8, 1)
ORDER BY 1;

--------- Having --------
-- Having : �׷�ȭ �����Ϳ� ���� ������ �ο��ϴ� ����
-- select������ ���� ���� from -> where -> group by -> having -> select -> order by

SELECT -- where�� ���� ����ǹǷ� ��ü ������ 2500000������ �����鿡 ���� ����� �׷캰�� ��Ÿ��
    dept_code,
    floor(avg(salary)),
    count(*)
FROM
    employee
WHERE
    salary < 2500000
GROUP BY
    dept_code
ORDER BY 1;
-- select������ ���� ���� from -> where -> group by -> having -> select -> order by
-- having
SELECT -- ��� �޿��� 2500000������ �׷�
    dept_code,
    floor(avg(salary))
FROM
    employee
GROUP BY
    dept_code
HAVING
    avg(salary) < 2500000
ORDER BY 1;

-- SELECT salary �޿� from employee WHERE �޿�; < 2000000; --�Ұ��� ������ ���� ������ where���� �������⶧��
SELECT salary �޿� from employee ORDER BY �޿�; --���� ������ select���� ���� �޿������� �ٱ⶧��

---------------------- Join ------------------------
-- join : ���� ���̺��� ���ڵ带 �����ؼ� �ǹ��ִ� ResultSet�� ������ ����
SELECT * FROM employee, department; -- ���̺��� �ΰ� �̻��� �Ǹ� join�� �� (����for�� ����)
SELECT * FROM job, department; -- Cross Join : Cartesian Product - īƼ�ǰ�
SELECT * FROM employee, department WHERE dept_code = dept_id; -- Inner Join : Ư�� ������ �̿��� �ǹ��ִ� �����͸� �����°�
SELECT emp_name, dept_code, dept_title FROM employee, department WHERE dept_code = dept_id;

SELECT emp_name, job_name FROM employee, job where employee.job_code = job.job_code; -- ��Ī�� ��ĥ�� ���� ��밡��(��õ ����)
SELECT emp_name, job_name FROM employee e, job j WHERE e.job_code = j.job_code; -- as�� �ٿ��� ��뵵 ����
select * from employee left outer join department on (employee.dept_code = department.dept_id);
SELECT emp_name, dept_title FROM employee, department WHERE dept_code = dept_id; -- ����Ŭ ���� ��������
SELECT emp_name, dept_title FROM employee inner join department on (employee.dept_code = department.dept_id); -- ANSI ǥ�� ��������
SELECT emp_name, job_name FROM employee inner join job on (employee.job_code = job.job_code); -- ANSI ǥ�� ��������
SELECT emp_name, job_name FROM employee join job using (job_code); -- ANSI ǥ�� �������� Join��� �̸��� ������ using��� ����
SELECT * FROM employee e join job j on e.job_code = j.job_code;
select * from employee join job using (job_code); -- using�� job_code�÷��� �Ѱ��̴�.
-- inner join
SELECT emp_name, dept_title FROM employee inner/*inner��������*/ join department on (employee.dept_code = department.dept_id);

-- outer join
SELECT emp_name, dept_title FROM employee e, department d WHERE e.dept_code = d.dept_id(+); -- ����Ŭ ���� �����ʿ� ����NULL�� �ֵ��� +�������
SELECT emp_name, dept_title FROM employee e left outer join department d on (e.dept_code = d.dept_id); -- ansi ���� ���̺�(employee)�� �ִ� ��� ���� ������ ����
SELECT emp_name, dept_title FROM employee e right outer join department d on (e.dept_code = d.dept_id); -- ansi
SELECT emp_name, dept_title FROM employee e full outer join department d on (e.dept_code = d.dept_id); -- ANSI ���� (����Ŭ�� ���� full outer)

-- self join : ���� ���̺��� join�Ͽ� ����ϴ� ����
-- e1���̺�� e2���̺��̶�� ���� ���̺��� ������ ���ϸ鼭 e1�� manager_id�� e2�� emp_id �� ��������
-- e2.emp_name(e1.manager_id = e2.emp_id) �̶�� ���� "�Ŵ��� �̸�" ���� �ؼ� e2.emp_name �� ����Ѵ�
SELECT e1.emp_id, e1.emp_name ������, nvl(e2.emp_name, '������ ����') "�Ŵ��� �̸�" FROM employee e1, employee e2 WHERE e1.manager_id = e2.emp_id(+); -- ����Ŭ
SELECT e1.emp_name ������, e1.manager_id ���ӻ��ID, e2.emp_name ���� FROM employee e1 right join employee e2 on(e1.manager_id = e2.emp_id); -- ANSI NULL ���
--------- ���� join ---------
SELECT
    e.emp_name,
    d.dept_title,
    d.location_id,
    l.national_code,
    n.national_name
FROM
    employee e join department d on (e.dept_code = d.dept_id)
    join location l on (d.location_id = l.local_code)
    join national n on (l.national_code = n.national_code);

-- employee ���� �� �������� �̸�, �μ���, ��å���� ����ϼ���.
SELECT
    emp_name ���,
    nvl(dept_title, '����') �μ�,
    job_name ��å
FROM
    employee e left join department d on (e.dept_code = d.dept_id)
    join job j on(e.job_code = j.job_code)
ORDER BY e.job_code;

-- �μ��� �޿� �հ�� ���
SELECT
    d.dept_title �μ���,
    to_char(sum(salary), 'L999,999,999') �޿��հ�,
    to_char(floor(avg(salary)), 'L999,999,999') �޿����
FROM
    employee e join department d on (e.dept_code = d.dept_id)
GROUP BY d.dept_title
ORDER BY �޿��հ� desc;

-------------------------

-- select������ ���� ���� from -> where -> group by -> having -> select -> order by
/*
����Ŭ DBMS
- SQL
    - DDL : ��ü ����
    - DML : ������ ����
        - ���� DQL : FROM, SELECT, WHERE, GROUP BY, HAVING, ORDER BY
                    function(), JOIN
    - DCL : ��������
    - TCL : Ʈ����� ����
*/
----------------------------------�ǽ� ����--------------------------------------
--1. 2020�� 12�� 25���� ���� �������� ��ȸ�ϼ���.
SELECT
    to_char(to_date(20201225), 'YYYY MM DD day') ũ��������
FROM
    dual;
--2. �ֹι�ȣ�� 1970��� ���̸鼭 ������ �����̰�, ���� ������ �������� �����, �ֹι�ȣ, �μ���, ���޸��� ��ȸ�ϼ���.
SELECT
    emp_name  �����,
    emp_no    �ֹι�ȣ,
    dept_title �μ�,
    job_name  ���޸�
FROM
    employee e join department d on (e.dept_code = d.dept_id)
    join job j on (e.job_code = j.job_code)
WHERE
    emp_no like '7%-2%' and substr(emp_name,1,1) = '��';
--3. �̸��� '��'�ڰ� ���� �������� ���, �����, �μ����� ��ȸ�ϼ���.
SELECT
    emp_id ���,
    emp_name �����,
    dept_title �μ�
FROM
    employee e join department d on (e.dept_code = d.dept_id)
WHERE
    emp_name like '%��%';
--4. �ؿܿ����ο� �ٹ��ϴ� �����, ���޸�, �μ��ڵ�, �μ����� ��ȸ�ϼ���.
SELECT
    emp_name �����,
    job_code ����,
    dept_code �μ��ڵ�,
    dept_title �μ���
FROM
    employee e join department d on (e.dept_code = d.dept_id)
WHERE
    dept_code in ('D5','D6')
ORDER BY dept_code, job_code;
--5. ���ʽ�����Ʈ�� �޴� �������� �����, ���ʽ�����Ʈ, �μ���, �ٹ��������� ��ȸ�ϼ���.
SELECT
    emp_name �����,
    bonus ���ʽ�����Ʈ,
    nvl(dept_title, '����') �μ�,
    nvl(local_name, '����') �ٹ���
FROM
    employee e full join job j on (e.job_code = j.job_code)
    full join department d on (e.dept_code = d.dept_id)
    full join location l on (d.location_id = l.local_code)
WHERE
    bonus is not null
ORDER BY local_code;
--6. �μ��ڵ尡 D2�� �������� �����, ���޸�, �μ���, �ٹ��������� ��ȸ�ϼ���.
SELECT
    emp_name �����,
    j.job_name ����,
    dept_title �μ�,
    local_name �ٹ���
FROM
    employee e join job j on (e.job_code = j.job_code)
    join department d on (e.dept_code = d.dept_id)
    join location l on (d.location_id = l.local_code)
WHERE
    dept_code = 'D2';
--7. �޿�������̺��� �ִ�޿�(MIN_SAL)�� -20�������� ���� �޴� �������� �����, ���޸�, �޿�, �ִ�޿��� ��ȸ�ϼ���.
-- (������̺�� �޿�������̺��� SAL_LEVEL�÷��������� ������ ��)

--8. �ѱ�(KO)�� �Ϻ�(JP)�� �ٹ��ϴ� �������� �����, �μ���, ������, �������� ��ȸ�ϼ���.
SELECT
    emp_name �����,
    dept_title �μ�,
    local_name �ٹ���,
    n.national_name �ٹ�����
FROM
    employee e left join department d on (e.dept_code = d.dept_id)
    left join location l on (d.location_id = l.local_code)
    left join national n on (l.national_code = n.national_code)
WHERE
    n.national_code in ('KO', 'JP');
--9. ���� �μ��� �ٹ��ϴ� �������� �����, �μ���, �����̸��� ��ȸ�ϼ���. (self join ���)
SELECT
    e1.emp_name,
    d.dept_title,
    e2.emp_name
FROM
    employee e1 join employee e2 on (e1.dept_code = e2.dept_code)
    join department d on (e1.dept_code = d.dept_id)
WHERE
    e1.emp_name != e2.emp_name
ORDER BY e1.emp_name;
--10. ���ʽ�����Ʈ�� ���� ������ �߿��� ������ ����� ����� �������� �����, ���޸�, �޿��� ��ȸ�ϼ���. ��, join�� IN ����� ��
SELECT
    emp_name �����,
    j.job_name ����,
    salary �޿�
FROM
    employee e left join job j on (e.job_code = j.job_code)
    left join department d on (e.dept_code = d.dept_id)
WHERE
    bonus is null and j.job_name in ('����', '���')
ORDER BY salary desc;
--11. �������� ������ ����� ������ ���� ��ȸ�ϼ���.
SELECT
    decode(ent_yn, 'N','������','Y','���') ��翩��,
    count(*)||'��' �ο���
FROM
    employee
GROUP BY decode(ent_yn, 'N','������','Y','���');

--------------------------------------------------------------------------------
-- Set Operator
-- union(�ߺ��� �����ϴ� ������) / union all(�ߺ��� ����ϴ� ������) / intersect(������) / minus(������)
create table temp1(
    str varchar(10)
);
insert into temp1 values('A');
insert into temp1 values('B');
select * from temp1;

create table temp2(
    str varchar(10)
);
insert into temp2 values('B');
insert into temp2 values('C');
select * from temp2;

-- union(�ߺ��� �����ϴ� ������)
SELECT * FROM temp1
UNION
SELECT * FROM temp2;

-- union all(�ߺ��� ����ϴ� ������)
SELECT * FROM temp1
UNION ALL
SELECT * FROM temp2;

-- intersect(������)
SELECT * FROM temp1
intersect
SELECT * FROM temp2;

-- minus(������)
select * from temp1
minus
select * from temp2;

/* ������ �÷��� ���� �ٸ��Ƿ� ����(�÷��� ������Ÿ�Ե� ���ƾ� �Ѵ�)
SELECT * FROM employee
union
SELECT * FROM department;
*/