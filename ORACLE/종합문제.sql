--------------------------------- Basic Select ---------------------------------
-- 01.
SELECT
    department_name AS "�а� ��",
    category AS �迭
FROM
    tb_department
ORDER BY '��';

-- 02.
SELECT
    department_name||'�� ������ '||capacity||'�� �Դϴ�.' AS "�а��� ����"
FROM
    tb_department ;

-- 03.
SELECT s.student_name
FROM
    tb_department d full join
    tb_student s on (d.department_no = s.department_no)
WHERE
    d.department_name = '������а�'
    and student_ssn like '%-2%'
    and s.absence_yn = 'Y';

-- 04.
SELECT
    student_name
FROM
    tb_student
WHERE
    student_no in ('A513079', 'A513090', 'A513091', 'A513110', 'A513119')
ORDER BY 1 desc;

-- 05.
SELECT
    department_name,
    category
FROM
    tb_department
WHERE
    capacity between 20 and 30;
    
-- 06.
SELECT
    professor_name
FROM
    tb_professor
WHERE
    department_no is null;

-- 07.
SELECT
    *
FROM
    tb_student
WHERE
    department_no is null
;

-- 08.
SELECT
    class_no
FROM
    tb_class
WHERE
    preattending_class_no is not null;
    
-- 09.
SELECT
    distinct category
FROM
    tb_department;
    
-- 10.
SELECT
    student_no,
    student_name,
    student_ssn
FROM
    tb_student
WHERE
    entrance_date like '02%'
    and student_address like '����%'
    and absence_yn = 'N'
ORDER BY 2;

------------------------------ Additional Select -------------------------------
-- 01.
SELECT
    student_no AS �й�,
    student_name AS �̸�,
    to_char(entrance_date, 'YYYY-MM-DD') AS ���г⵵
FROM
    tb_student
WHERE
    department_no = 002;
    
-- 02.
SELECT
    professor_name,
    professor_ssn
FROM
    tb_professor
WHERE
    professor_name not like '___';

-- 03.
SELECT
    professor_name AS �����̸�,
    extract(year from sysdate) - (substr(professor_ssn, 1, 2)+1900) AS ����
FROM
    tb_professor
WHERE
    professor_ssn like '%-1%'
ORDER BY 2;

-- 04.
SELECT
    substr(professor_name, 2) AS �̸�
FROM
    tb_professor;

-- 05.
SELECT
    student_no,
    student_name
FROM
    tb_student
WHERE
    substr(student_ssn, 1, 2) between '82' and '84';

-- 06.
SELECT
    to_char(to_date(20201225), 'YYYY-MM-DD day') AS ũ��������
FROM
    dual;

-- 07.
SELECT
    to_char(to_date('99/10/11','YY/MM/DD'), 'YYYY/MM/DD') AS YY1,
    to_char(to_date('49/10/11','YY/MM/DD'), 'YYYY/MM/DD') AS YY2,
    to_char(to_date('99/10/11','RR/MM/DD'), 'RRRR/MM/DD') AS RR1, 
    to_char(to_date('49/10/11','RR/MM/DD'), 'RRRR/MM/DD') AS RR2
FROM
    dual;

-- 08.
SELECT
    student_no,
    student_name
FROM
    tb_student
WHERE
    student_no not like 'A%';

-- 09.
SELECT
    round(avg(point), 1) AS ����
FROM
    tb_grade
WHERE
    student_no = 'A517178';
    
-- 10.
SELECT
    department_no,
    count(*)
FROM
    tb_student
GROUP BY
    department_no
ORDER BY 1;

-- 11.
SELECT
    count(*)
FROM
    tb_student
WHERE
    coach_professor_no is null;

-- 12.
SELECT
    substr(term_no, 1,4) AS �⵵,
    round(avg(point), 1) AS "�⵵ �� ����"
FROM
    tb_grade
WHERE
    student_no = 'A112113'
GROUP BY
    substr(term_no, 1,4)
ORDER BY 1;

-- 13. �ٽ�Ǯ��----------------------------------�ٽ�Ǯ�� 13 ----
SELECT
    department_no, nvl(count(*), 0)
FROM
    tb_student
GROUP BY
    department_no, absence_yn
HAVING
    absence_yn = 'Y'
ORDER BY 1;

-- 14.
SELECT
    student_name AS �����̸�,
    count(*) AS "������ ��"
FROM
    tb_student
GROUP BY
    student_name
HAVING
    count(*) != 1
ORDER BY 1;

-- 15. ----------------- ������ ����
SELECT
    decode(GROUPING(substr(term_no, 1, 4)), 0, substr(term_no, 1, 4), 1, ' ') AS �⵵,
    decode(GROUPING(substr(term_no, 5, 2)), 0, substr(term_no, 5, 2), 1, ' ') AS �б�,
    round(AVG(point), 1) AS  ���
FROM
    tb_grade
WHERE
    student_no = 'A112113'
GROUP BY
    ROLLUP(substr(term_no, 1, 4),
           substr(term_no, 5, 2));

-------------------------- Additional SELECT - Option --------------------------
-- 01.
SELECT
    student_name AS "�л� �̸�",
    student_address AS �ּ���
FROM
    tb_student
ORDER BY 1;

-- 02.
SELECT
    student_name,
    student_ssn
FROM
    tb_student
WHERE
    absence_yn = 'Y'
ORDER BY 2 desc;

-- 03.
SELECT
    student_name AS �л��̸�,
    student_no AS �й�,
    student_address AS "������ �ּ�"
FROM
    tb_student
WHERE
    (student_address like '%���%' or student_address like '%����%')
    and extract(year from entrance_date) between '1900' and '1999'
ORDER BY 1;

-- 04.
SELECT
    professor_name,
    professor_ssn
FROM
    tb_professor
WHERE
    department_no = '005'
ORDER BY 2;

-- 05.
SELECT
    student_no,
    point
FROM
    tb_grade
WHERE
    term_no = 200402
    and class_no = 'C3118100'
ORDER BY 2 desc, 1;

-- 06.
SELECT
    s.student_no,
    s.student_name,
    d.department_name
FROM
    tb_student s join tb_department d
    on (s.department_no = d.department_no)
ORDER BY 2;

-- 07.
SELECT
    c.class_name,
    d.department_name
FROM
    tb_class c join tb_department d
    on (c.department_no = d.department_no);

-- 08.
SELECT
    c.class_name,
    p.professor_name
FROM
    tb_class c join tb_class_professor cp using (class_no)
    join tb_professor p using (professor_no);

-- 09.
SELECT
    c.class_name,
    p.professor_name
FROM
    tb_class c join tb_class_professor cp using (class_no)
    join tb_professor p using (professor_no)
    join tb_department d on (d.department_no = p.department_no)
WHERE
    d.category = '�ι���ȸ';

-- 10.
SELECT
    s.student_no,
    s.student_name,
    round(avg(g.point), 1)
FROM
    tb_department d join tb_student s on (d.department_no = s.department_no)
    join tb_grade g on (s.student_no = g.student_no)
WHERE
    d.department_name = '�����а�'
group by
    s.student_no, s.student_name
ORDER BY 1;

-- 11.
SELECT
    department_name AS �а��̸�,
    student_name AS �л��̸�,
    professor_name AS ���������̸�
FROM
    tb_department join tb_student using(department_no)
    join tb_professor on (coach_professor_no = professor_no)
WHERE
    student_no = 'A313047';

-- 12.
SELECT
    student_name,
    term_no
FROM
    tb_student join tb_grade using ( student_no )
    join tb_class using ( class_no )
WHERE
        class_name = '�ΰ������'
    AND substr(term_no, 1, 4) = 2007
ORDER BY 1;

-- 13.
SELECT
    class_name,
    department_name
FROM
    tb_class left join tb_class_professor using(class_no)
    join tb_department using (department_no)
WHERE
    category = '��ü��' and professor_no is null
ORDER BY 2;

-- 14.
------- Ǯ��ߴ�








------------------------------------- DDL --------------------------------------
-- 01.
create table tb_category(
    name varchar2(10),
    use_yn char(1) default 'Y'
);

desc tb_category;
drop table tb_category;
select * from user_constraints where table_name='TB_CATEGORY';

-- 02.
create table tb_class_type(
    no varchar2(5),
    name varchar2(10)
);
desc tb_class_type;
drop table tb_class_type;

-- 03.
alter table tb_category add primary key (name);

-- 04.
alter table tb_class_type modify (name not null);

-- 05.
alter table tb_category modify(name varchar2(20));
alter table tb_class_type modify (no varchar2(10));
alter table tb_class_type modify (name varchar2(20));

-- 06.
alter table tb_category rename column name to category_name;
alter table tb_class_type rename column name to class_type_name;
alter table tb_class_type rename column no to class_type_no;

-- 07.
select * from user_constraints where table_name='TB_CATEGORY';
alter table tb_category drop constraint SYS_C008028;
alter table tb_category add constraint pk_category_name primary key(category_name);

-- 08.
insert into tb_category values ('����', 'Y');
insert into tb_category values ('�ڿ�����','Y');
insert into tb_category values ('����','Y');
insert into tb_category values ('��ü��','Y');
insert into tb_category values ('�ι���ȸ','Y');
commit;

-- 09.









    
    