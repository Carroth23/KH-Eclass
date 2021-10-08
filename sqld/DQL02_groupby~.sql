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
-----------------------------------Basic 2--------------------------------------
---------------그룹화 ( Group By + Having ) : 특정 컬럼을 기준으로 그룹화시켜서 데이터를 만들어내는 기법 -----------
SELECT emp_name, salary FROM employee;  -- 직원별 급여목록
SELECT SUM(salary) FROM employee;       -- 전직원의 급여합계
select sum(salary) from employee where dept_code = 'D1'; -- 특정 부서의 급여 합계

-- GROUP BY
SELECT dept_code FROM employee GROUP BY dept_code ORDER BY 1; -- 그룹화된 데이터는 출력 가능 중복이 제거된 효과도 얻을 수 있다.
-- 부서별 급여평균
SELECT dept_code, floor(AVG(salary)) FROM employee GROUP BY dept_code ORDER BY 1; -- dept_code를 그룹화
-- select dept_code, emp_name from employee group by dept_code; -- 에러발생 dept그룹으로 모았기 때문에 개인의 데이터를 불러올수 없음

SELECT
    dept_code,
    TO_CHAR(SUM(salary),'L999,999,999') "부서별 급여합계",
    TO_CHAR(AVG(salary),'L999,999,999') "부서별 급여평균",
    COUNT(*)||'명' "부서별 인원수",
    MIN(salary), MAX(salary)
FROM
    employee
GROUP BY
    dept_code
ORDER BY SUM(salary)desc; -- 부서별 급여 합계

-- 부서코드별 보너스를 받는 사람의 인원수
SELECT dept_code, COUNT(bonus) FROM employee GROUP BY dept_code ORDER BY 1; -- 0도 출력
SELECT dept_code, COUNT(*) FROM employee WHERE bonus IS NOT NULL GROUP BY dept_code ORDER BY 1; -- 0은 제외

-- employee 테이블에서 직급이 j1인 사람을 제외하고, 직급, 직급별 사원수 및 평균 급여
SELECT job_code, COUNT(*), floor(AVG(salary)) FROM employee WHERE job_code != 'J1' GROUP BY job_code ORDER BY 1;
-- employee 테이블내에 성별별 인원수를 출력해보세요.
SELECT decode(substr(emp_no, 8, 1),1,'남',2,'여') 성별, count(*)||'명' 인원수 FROM employee
    GROUP BY decode(substr(emp_no, 8, 1),1,'남',2,'여'); -- 만약 decode 지정값 외에 값이 있다면 null처리가 된다.(주민번호 1, 2외엔 null)
-- J1 직급을 제외하고, 입사년도별 인원수를 조회해서 입사년도별 오름차순으로 출력해보세요.
SELECT
    extract(year from hire_date) 입사년도,
    count(*) 인원수
FROM
    employee
WHERE
    job_code != 'J1'
GROUP BY
    extract(year from hire_date)
ORDER BY 1;

-- employee 테이블내에 연령대별 인원수를 출력해보세요.
SELECT
    substr(emp_no, 1,1)||'0년대생'연령대,
    count(*)인원수
FROM
    employee
GROUP BY
    substr(emp_no, 1, 1)
ORDER BY 1;

----------- group by 심화 ------------
-- 이중 group by
SELECT
    dept_code,
    job_code,
    sum(salary) "부서 내 직급별 급여합계",
    count(*) 인원
FROM
    employee
GROUP BY
    dept_code, job_code
ORDER BY 1;

-- 각 직급내 성별별 인원수(각 부서내 성별별 인원수도 비슷)
SELECT
    job_code 직급,
    decode(substr(emp_no, 8, 1), 1, '남', '여') 성별,
    count(*) 인원수
FROM
    employee
GROUP BY
    job_code, substr(emp_no, 8, 1)
ORDER BY 1;

--------- Having --------
-- Having : 그룹화 데이터에 대한 조건을 부여하는 구문
-- select쿼리의 실행 순서 from -> where -> group by -> having -> select -> order by

SELECT -- where가 먼저 실행되므로 전체 직원중 2500000이하인 직원들에 대한 평균을 그룹별로 나타냄
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
-- select쿼리의 실행 순서 from -> where -> group by -> having -> select -> order by
-- having
SELECT -- 평균 급여가 2500000이하인 그룹
    dept_code,
    floor(avg(salary))
FROM
    employee
GROUP BY
    dept_code
HAVING
    avg(salary) < 2500000
ORDER BY 1;

-- SELECT salary 급여 from employee WHERE 급여; < 2000000; --불가능 이유는 쿼리 순서상 where절이 먼저오기때문
SELECT salary 급여 from employee ORDER BY 급여; --가능 이유는 select에서 먼저 급여별명이 붙기때문

---------------------- Join ------------------------
-- join : 여러 테이블의 레코드를 조합해서 의미있는 ResultSet을 만들어내는 문법
SELECT * FROM employee, department; -- 테이블이 두개 이상이 되면 join이 됨 (이중for문 느낌)
SELECT * FROM job, department; -- Cross Join : Cartesian Product - 카티션곱
SELECT * FROM employee, department WHERE dept_code = dept_id; -- Inner Join : 특정 조건을 이용해 의미있는 데이터를 만들어내는것
SELECT emp_name, dept_code, dept_title FROM employee, department WHERE dept_code = dept_id;

SELECT emp_name, job_name FROM employee, job where employee.job_code = job.job_code; -- 명칭이 겹칠때 점찍어서 사용가능(추천 안함)
SELECT emp_name, job_name FROM employee e, job j WHERE e.job_code = j.job_code; -- as를 붙여서 사용도 가능

SELECT emp_name, dept_title FROM employee, department WHERE dept_code = dept_id; -- 오라클 전용 쿼리문법
SELECT emp_name, dept_title FROM employee inner join department on (employee.dept_code = department.dept_id); -- ANSI 표준 쿼리문법
SELECT emp_name, job_name FROM employee inner join job on (employee.job_code = job.job_code); -- ANSI 표준 쿼리문법
SELECT emp_name, job_name FROM employee join job using (job_code); -- ANSI 표준 쿼리문법 Join사용 이름이 같으면 using사용 가능
SELECT * FROM employee e join job j on e.job_code = j.job_code;
select * from employee join job using (job_code); -- using는 job_code컬럼이 한개이다.
-- inner join
SELECT emp_name, dept_title FROM employee inner/*inner생략가능*/ join department on (employee.dept_code = department.dept_id);

-- outer join
SELECT emp_name, dept_title FROM employee e, department d WHERE e.dept_code = d.dept_id(+); -- 오라클 문법 오른쪽에 값이NULL인 애들을 +시켜줘라
SELECT emp_name, dept_title FROM employee e left outer join department d on (e.dept_code = d.dept_id); -- ansi 왼쪽 테이블(employee)에 있는 모든 값이 나오게 해줘
SELECT emp_name, dept_title FROM employee e right outer join department d on (e.dept_code = d.dept_id); -- ansi
SELECT emp_name, dept_title FROM employee e full outer join department d on (e.dept_code = d.dept_id); -- ANSI 문법 (오라클엔 없는 full outer)

-- self join : 같은 테이블을 join하여 사용하는 문법
-- e1테이블과 e2테이블이라는 같은 테이블을 일일히 비교하면서 e1의 manager_id와 e2의 emp_id 가 같아질때
-- e2.emp_name(e1.manager_id = e2.emp_id) 이라는 것을 "매니저 이름" 으로 해서 e2.emp_name 을 출력한다
SELECT e1.emp_id, e1.emp_name 직원명, nvl(e2.emp_name, '관리자 없음') "매니저 이름" FROM employee e1, employee e2 WHERE e1.manager_id = e2.emp_id(+); -- 오라클
SELECT e1.emp_name 직원명, e1.manager_id 직속상사ID, e2.emp_name 상사명 FROM employee e1 right join employee e2 on(e1.manager_id = e2.emp_id); -- ANSI NULL 출력
--------- 다중 join ---------
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

-- employee 내의 각 직원들의 이름, 부서명, 직책명을 출력하세요.
SELECT
    emp_name 사원,
    nvl(dept_title, '인턴') 부서,
    job_name 직책
FROM
    employee e left join department d on (e.dept_code = d.dept_id)
    join job j on(e.job_code = j.job_code)
ORDER BY e.job_code;

-- 부서별 급여 합계와 평균
SELECT
    d.dept_title 부서명,
    to_char(sum(salary), 'L999,999,999') 급여합계,
    to_char(floor(avg(salary)), 'L999,999,999') 급여평균
FROM
    employee e join department d on (e.dept_code = d.dept_id)
GROUP BY d.dept_title
ORDER BY 급여합계 desc;

-------------------------

-- select쿼리의 실행 순서 from -> where -> group by -> having -> select -> order by
/*
오라클 DBMS
- SQL
    - DDL : 객체 통제
    - DML : 데이터 통제
        - 현재 DQL : FROM, SELECT, WHERE, GROUP BY, HAVING, ORDER BY
                    function(), JOIN
    - DCL : 권한통제
    - TCL : 트랜잭션 통제
*/
----------------------------------실습 문제--------------------------------------
--1. 2020년 12월 25일이 무슨 요일인지 조회하세요.
SELECT
    to_char(to_date(20201225), 'YYYY MM DD day') 크리스마스
FROM
    dual;
--2. 주민번호가 1970년대 생이면서 성별이 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하세요.
SELECT
    emp_name  사원명,
    emp_no    주민번호,
    dept_title 부서,
    job_name  직급명
FROM
    employee e join department d on (e.dept_code = d.dept_id)
    join job j on (e.job_code = j.job_code)
WHERE
    emp_no like '7%-2%' and substr(emp_name,1,1) = '전';
--3. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하세요.
SELECT
    emp_id 사번,
    emp_name 사원명,
    dept_title 부서
FROM
    employee e join department d on (e.dept_code = d.dept_id)
WHERE
    emp_name like '%형%';
--4. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하세요.
SELECT
    emp_name 사원명,
    job_code 직급,
    dept_code 부서코드,
    dept_title 부서명
FROM
    employee e join department d on (e.dept_code = d.dept_id)
WHERE
    dept_code in ('D5','D6')
ORDER BY dept_code, job_code;
--5. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하세요.
SELECT
    emp_name 사원명,
    bonus 보너스포인트,
    nvl(dept_title, '인턴') 부서,
    nvl(local_name, '인턴') 근무지
FROM
    employee e full join job j on (e.job_code = j.job_code)
    full join department d on (e.dept_code = d.dept_id)
    full join location l on (d.location_id = l.local_code)
WHERE
    bonus is not null
ORDER BY local_code;
--6. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하세요.
SELECT
    emp_name 사원명,
    j.job_name 직급,
    dept_title 부서,
    local_name 근무지
FROM
    employee e join job j on (e.job_code = j.job_code)
    join department d on (e.dept_code = d.dept_id)
    join location l on (d.location_id = l.local_code)
WHERE
    dept_code = 'D2';
--7. 급여등급테이블의 최대급여(MIN_SAL)의 -20만원보다 많이 받는 직원들의 사원명, 직급명, 급여, 최대급여를 조회하세요.
-- (사원테이블과 급여등급테이블을 SAL_LEVEL컬럼기준으로 조인할 것)

--8. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 지역명, 국가명을 조회하세요.
SELECT
    emp_name 사원명,
    dept_title 부서,
    local_name 근무지,
    n.national_name 근무국가
FROM
    employee e left join department d on (e.dept_code = d.dept_id)
    left join location l on (d.location_id = l.local_code)
    left join national n on (l.national_code = n.national_code)
WHERE
    n.national_code in ('KO', 'JP');
--9. 같은 부서에 근무하는 직원들의 사원명, 부서명, 동료이름을 조회하세요. (self join 사용)
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
--10. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하세요. 단, join과 IN 사용할 것
SELECT
    emp_name 사원명,
    j.job_name 직급,
    salary 급여
FROM
    employee e left join job j on (e.job_code = j.job_code)
    left join department d on (e.dept_code = d.dept_id)
WHERE
    bonus is null and j.job_name in ('차장', '사원')
ORDER BY salary desc;
--11. 재직중인 직원과 퇴사한 직원의 수를 조회하세요.
SELECT
    decode(ent_yn, 'N','재직중','Y','퇴사') 퇴사여부,
    count(*)||'명' 인원수
FROM
    employee
GROUP BY decode(ent_yn, 'N','재직중','Y','퇴사');

--------------------------------------------------------------------------------
-- Set Operator
-- union(중복을 제거하는 합집합) / union all(중복을 허용하는 합집합) / intersect(교집합) / minus(차집합)
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

-- union(중복을 제거하는 합집합)
SELECT * FROM temp1
UNION
SELECT * FROM temp2;

-- union all(중복을 허용하는 합집합)
SELECT * FROM temp1
UNION ALL
SELECT * FROM temp2;

-- intersect(교집합)
SELECT * FROM temp1
intersect
SELECT * FROM temp2;

-- minus(차집합)
select * from temp1
minus
select * from temp2;

/* 데이터 컬럼의 수가 다르므로 에러(컬럼의 데이터타입도 같아야 한다)
SELECT * FROM employee
union
SELECT * FROM department;
*/