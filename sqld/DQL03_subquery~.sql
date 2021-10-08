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
------------------------- SubQuery -----------------------
-- SubQuery : �ϳ��� SQL�� �ȿ� ���ԵǾ� �ִ� �� �ٸ� SQL�� ()�ȿ� �ۼ��Ѵ�.
-- ������ ��������
-- ������ ��������
-- ���߿� ��������
-- ������ ���߿� ��������
-- main ���� : �ٱ��� ����
-- ���������� �����̶� ��ġ�� ��찡 ����(�Ϻ� ��ü�����ϳ� ������ ��ü�� �Ұ���)
-- �������� �Ŵ����� �������� ���
SELECT emp_name, manager_id FROM employee WHERE emp_name = '������';
SELECT emp_id, emp_name FROM employee WHERE emp_id = 214;
SELECT emp_name FROM employee WHERE emp_id = (SELECT manager_id FROM employee WHERE emp_name = '������'); -- ()���� ���� ����� �ᱹ 214
select * from employee;
-- �� ������ ��� �޿����� �� ���� �޿��� �ް� �ִ� ������ ���, �̸�, �����ڵ�, �޿��� ����ϼ���.
SELECT emp_id, emp_name, job_code, salary FROM employee WHERE (select avg(salary) from employee) < salary; -- �׷��Լ��� where���� ��� �Ұ���
-- �ϳ��� ���� ������ ���������� ������ ����������� �Ѵ�.(�������� ������, ���������� ���� ���� ���߿� ��������)

-------------- ������ �������� --------------
-- ������ ������ �޿��� ���� �޿��� �޴� ������� ���, �̸�, �޿��� ����غ�����.
SELECT emp_id, emp_name, salary FROM employee WHERE (SELECT salary from employee where emp_name = '������') = salary and emp_name != '������';

-- �޿��� ���� ���� �޴� ������ ���̹޴� ������ �̸��� �޿��� ����غ�����.
SELECT emp_name, salary FROM employee WHERE (select min(salary) from employee) = salary or (select max(salary) from employee) = salary;

-- �޿��� ���� ���� �޴� ������ ���̹޴� ������ ���ް� �̸��� �޿��� ����غ�����.
SELECT
    job_name,
    emp_name,
    salary 
FROM 
    employee e join job j using (job_code)
WHERE
    (select min(salary) from employee) = salary
    or
    (select max(salary) from employee) = salary;

-- D1, D2 �μ��� �ٹ��ϴ� ������ �߿���, D5 �μ� �������� ��� �޿����� ���� �޿��� �޴� �������� �μ���, ���, �����, �޿��� ���
SELECT
    dept_code,
    dept_title,
    emp_id,
    emp_name,
    salary
FROM
    employee join department on (employee.dept_code = department.dept_id)
WHERE
    dept_code in ('D1', 'D2') and salary > (SELECT avg(salary) FROM employee WHERE dept_code = 'D5')
ORDER BY 1;

-------------------- ������ �������� --------------------
-- ���������� �ΰ��̻��� ���� ��ȯ�ϸ� �񱳿����ڴ� = �� �ɼ�����.
-- ������ �Ǵ� ������ ������ ���� �μ����� ���ϴ� �������� �̸�, �μ�, �޿��� ����ϼ���
SELECT emp_name, dept_code, salary FROM employee
WHERE dept_code in (select dept_code from employee WHERE emp_name /*not*/in ('������', '������'));

-- ���¿�, ������ ������ �޿���ް� ������ �޿������ ���� ������ ���޸�� �̸��� ����غ�����.
SELECT
    job_name,
    emp_name
FROM
    employee join job using (job_code)
WHERE
    sal_level in (select sal_level from employee where emp_name in ('���¿�','������'));

-- ������ ��(�� ���ǰ˻�)
-- ������������ ���� ���� �����µ�, ��Һ񱳸� ��� �ұ�?
-- any : �ƹ��ų� (�� ������������ ���� �� �߿� �ƹ��ų�)
-- J3������ ���� �������� ��� �޿��߿� �ϳ����ٸ� ũ�� ����϶�.(�ᱹ min���� ũ�� ����϶�)
SELECT emp_name, salary FROM employee WHERE salary > any (select salary from employee where job_code = 'J3');
-- J3������ ���� �������� ��� �޿����� ũ�� ����ϴ�.(�ᱹ max���� ũ�� ����϶�)
SELECT emp_name, salary FROM employee WHERE salary > all (select salary from employee where job_code = 'J3');
/*
> any ~�߿� �ƹ��ų����� ũ��.
< any ~�߿� �ƹ��ų����� �۴�.
> all ~�� ��� ����� ���� ū�ͺ��� ũ��
< all ~�� ��� ����� ���� �����ͺ��� �۴�.
*/
--------------------��������
-- D1 �Ǵ� D5�μ� �ڵ带 ������ �ִ� ������� �޿�����(any) ���� ��� ������� �̸�, �޿�, �μ��ڵ带 ����غ�����.
SELECT
    emp_name,
    salary,
    dept_code
FROM
    employee
WHERE
    salary < any (select salary from employee where dept_code in ('D1','D5'));
-- �μ��� ��� �޿��� ����������, ���� ���� �μ��� �޿����� ���ų� ���� ������� �̸�, �޿�, �μ����� ����ϼ���.
SELECT
    emp_name,
    salary,
    dept_title
FROM
    employee e join department d on (e.dept_code = d.dept_id)
WHERE
    salary >= any (select avg(salary) from employee group by dept_code);

----------------------���� �� ��������----------------------
--���¸��� ���� ���޿� ���� �μ��� �����
select dept_code, job_code from employee where emp_name = '���¸�';
-- ���߿��̸� where ���� ��� ���� ���߿��� �����ָ� �ȴ�.(������ ���� �����ָ� =,in �Ѵ� ��� ����)
select dept_code, job_code, emp_name from employee -- �������� ���� ���� ��ȯ�ϱ� ������ in���� ��
    where (dept_code, job_code) in (select dept_code, job_code from employee where emp_name in ('���¸�', '���ȥ')) and emp_name not in ('���¸�','���ȥ');
-- ���޺� �ּ� �޿��� �޴� ������ �����ڵ�, �̸�, �޿��� ����ϼ���.
SELECT
    job_code,
    emp_name,
    salary
FROM
    employee
WHERE
    (job_code, salary) in ( SELECT job_code, MIN(salary) FROM employee GROUP BY job_code)
ORDER BY
    job_code;
-- ���⼭ job_code �� ������ �׳� �����ุ �Ǿ, min(salary)��Ͽ� ���⸸ �ϸ� ��µ�

--------------------------------- SubQuery ��ȭ
-- Inline View = FROM������ ���������� ����Ѱ�
select * from (select emp_id, emp_name, salary from employee); -- ���������� ���� ���� ���̺�
SELECT emp_name FROM (select emp_id, emp_name, salary from employee);

----- ���(��ȣ����) �������� (main������ ���������� �̿�)
-- "�ڽ��� ���� ����" �������� ��ձ޿����� �� ���� �޴� ���?
select emp_name, job_code, salary from employee e
    where salary >= (select avg(salary) from employee e2 where e2.job_code = e.job_code);
-- join ���� �̸��� �μ� ���
SELECT emp_name �����,
    dept_code,
    (select dept_title from department where dept_id = e.dept_code) �μ�
FROM 
    employee e 
ORDER BY 2; -- 2�� �ι�° Į�� �������� ����
----------------------------------------------
-- Ranking 
SELECT emp_name, salary, rank() over(order by salary desc) �޿����� FROM employee; -- �������� �� ����
SELECT emp_name, salary, dense_rank() over(order by salary desc) �޿����� FROM employee; -- �������� �� �̾
SELECT emp_name, salary, row_number() over(order by salary desc) �޿����� FROM employee; -- �������� ����(���ȣ�� ���̴� ����)

-- employee ���̺� ������ �޿����� (��������)�� �������� ��, 5 ~ 10�������� ����غ�����.
SELECT * FROM (select emp_name, salary, rank() over(order by salary desc) as rk from employee) WHERE rk between 5 and 10;
--------------------------------SubQuery �ǽ�------------------------------------
--����1
--��������ο� ���� ������� ����� �̸�,�μ��ڵ�,�޿��� ����ϼ���
SELECT
    emp_name,
    dept_code,
    salary
FROM
    employee e join department d on (e.dept_code = d.dept_id)
WHERE
    dept_title = '���������';
-- ����
SELECT
    emp_name,
    dept_code,
    salary
FROM
    employee
WHERE
    dept_code = (SELECT dept_id FROM department WHERE dept_title = '���������');

--����2
--��������ο� ���� ����� �� ���� ������ ���� ����� �̸�,�μ��ڵ�,�޿��� ����ϼ���
SELECT
    emp_name,
    dept_code,
    salary
FROM 
    employee e join department d on (e.dept_code = d.dept_id)
WHERE
    salary = (select max(salary) from employee e join department d on (e.dept_code = d.dept_id) where dept_title = '���������');
-- ����
SELECT
    *
FROM
    (SELECT emp_name, dept_code, salary FROM employee WHERE dept_code = (SELECT dept_id FROM department WHERE dept_title = '���������') ORDER BY salary DESC)
WHERE
    ROWNUM = 1;
    
--����3
--�Ŵ����� �ִ� ����߿� ������ ��ü��� ����� �Ѱ� 
--���,�̸�,�Ŵ��� �̸�,����(������������)�� ���ϼ���
-- * ��, JOIN�� �̿��ϼ���
SELECT
    e1.emp_id ID,
    e1.emp_name �����,
    e2.emp_name �Ŵ���,
    to_char(e1.salary / 10000, '9,999')||'����' ���� 
FROM
    employee e1 full join employee e2 on (e1.manager_id = e2.emp_id)
WHERE
    e1.manager_id is not null and e1.salary > (select avg(salary) from employee)
ORDER BY 1;
-- ����
SELECT
    e1.emp_id,
    e1.emp_name,
    (SELECT e2.emp_name FROM employee e2 WHERE e1.manager_id = e2.emp_id),
    trunc(e1.salary, - 4)
FROM
    employee e1
WHERE
    manager_id IS NOT NULL
    AND salary > (SELECT AVG(salary) FROM employee);

--����4
--�� ���޸��� �޿� ����� ���� ���� ������ �̸�, �����ڵ�, �޿�, �޿������ ��ȸ�ϼ���
SELECT
    emp_name,
    job_code,
    salary,
    sal_level
FROM
    employee
WHERE 
    (job_code,salary) in (select job_code, max(salary) from employee group by job_code)
ORDER BY 2;
--����
SELECT
    emp_name,
    job_code,
    salary,
    sal_level
FROM
    employee e1
WHERE
    e1.sal_level = (SELECT MIN(e2.sal_level) FROM employee e2 WHERE e1.job_code = e2.job_code)
ORDER BY
    4;

--����5
-- �μ��� ��� �޿��� 2200000 �̻��� �μ���, ��� �޿��� ��ȸ�ϼ���.
SELECT
    (SELECT dept_title FROM department d WHERE e.dept_code = d.dept_id ) AS "�μ���",
    floor(AVG(salary)) AS "��� �޿�"
FROM
    employee e
GROUP BY
    dept_code
HAVING
    AVG(salary) >= 2200000
ORDER BY
    1;
-- 2��° ����
SELECT
    (SELECT dept_title FROM department WHERE dept_code = dept_id),
    trunc(AVG(salary), 0)
FROM
    employee
GROUP BY
    dept_code
HAVING
    trunc(AVG(salary), 0) >= 2200000;

/*����6
������ ���� ��պ��� ���� �޴� ���ڻ����
�����,�����ڵ�,�μ��ڵ�,������ �̸� ������������ ��ȸ�Ͻÿ�
���� ��� => (�޿�+(�޿�*���ʽ�))*12*/
-- �����,���޸�,�μ���,������ EMPLOYEE ���̺��� ���� ����� ������
-- �켱 ���޺� ��� ���� �̾Ƴ��� �ڵ�
SELECT
    job_code,
    AVG((salary +(salary * nvl(bonus, 0))) * 12)
FROM
    employee
GROUP BY
    job_code;
-- ���� ����� �� ���ڻ������ ���� �ڵ�
SELECT
    emp_name,
    emp_no,
    job_code,
    ( salary + ( salary * nvl(bonus, 0) ) ) * 12
FROM
    employee
WHERE
    substr(emp_no, 8, 1) = 2;
-- ���� ����
SELECT
    emp_name,
    job_code,
    dept_code,
    ( salary + ( salary * nvl(bonus, 0) ) ) * 12 AS annual_salary
FROM
    employee e
WHERE
    substr(emp_no, 8, 1) = '2'
    AND ( salary + ( salary * nvl(bonus, 0) ) ) * 12 < (SELECT AVG((salary +(salary * nvl(bonus, 0))) * 12) FROM employee y WHERE e.job_code = y.job_code)
ORDER BY
    emp_name ASC;

------------------------------------------------------------ DQL �� ------------