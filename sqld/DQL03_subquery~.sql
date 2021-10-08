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
------------------------- SubQuery -----------------------
-- SubQuery : 하나의 SQL문 안에 포함되어 있는 또 다른 SQL문 ()안에 작성한다.
-- 단일행 서브쿼리
-- 다중행 서브쿼리
-- 다중열 서브쿼리
-- 단일행 다중열 서브쿼리
-- main 쿼리 : 바깥쪽 쿼리
-- 서브쿼리랑 조인이랑 겹치는 경우가 많음(일부 대체가능하나 완전한 대체는 불가능)
-- 전지연의 매니저가 누구인지 출력
SELECT emp_name, manager_id FROM employee WHERE emp_name = '전지연';
SELECT emp_id, emp_name FROM employee WHERE emp_id = 214;
SELECT emp_name FROM employee WHERE emp_id = (SELECT manager_id FROM employee WHERE emp_name = '전지연'); -- ()안의 실행 결과는 결국 214
select * from employee;
-- 전 직원의 평균 급여보다 더 많은 급여를 받고 있는 직원의 사번, 이름, 직급코드, 급여를 출력하세요.
SELECT emp_id, emp_name, job_code, salary FROM employee WHERE (select avg(salary) from employee) < salary; -- 그룹함수는 where절에 사용 불가능
-- 하나의 값만 만들어내는 서브쿼리를 단일행 서브쿼리라고 한다.(여러줄은 다중행, 한줄이지만 여러 열은 다중열 서브쿼리)

-------------- 단일행 서브쿼리 --------------
-- 윤은해 직원의 급여와 같은 급여를 받는 사원들의 사번, 이름, 급여를 출력해보세요.
SELECT emp_id, emp_name, salary FROM employee WHERE (SELECT salary from employee where emp_name = '윤은해') = salary and emp_name != '윤은해';

-- 급여를 가장 적게 받는 직원과 많이받는 직원의 이름과 급여를 출력해보세요.
SELECT emp_name, salary FROM employee WHERE (select min(salary) from employee) = salary or (select max(salary) from employee) = salary;

-- 급여를 가장 적게 받는 직원과 많이받는 직원의 직급과 이름과 급여를 출력해보세요.
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

-- D1, D2 부서에 근무하는 직원들 중에서, D5 부서 직원들의 평균 급여보다 많은 급여를 받는 직원들의 부서명, 사번, 사원명, 급여를 출력
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

-------------------- 다중행 서브쿼리 --------------------
-- 서브쿼리가 두개이상의 행을 반환하면 비교연산자는 = 이 될수없다.
-- 송종기 또는 전지연 직원과 같은 부서에서 일하는 직원들의 이름, 부서, 급여를 출력하세요
SELECT emp_name, dept_code, salary FROM employee
WHERE dept_code in (select dept_code from employee WHERE emp_name /*not*/in ('송종기', '전지연'));

-- 차태연, 전지연 직원의 급여등급과 동일한 급여등급을 가진 직원의 직급명과 이름을 출력해보세요.
SELECT
    job_name,
    emp_name
FROM
    employee join job using (job_code)
WHERE
    sal_level in (select sal_level from employee where emp_name in ('차태연','전지연'));

-- 여러개 비교(비등가 조건검색)
-- 서브쿼리에서 여러 행이 나오는데, 대소비교를 어떻게 할까?
-- any : 아무거나 (즉 서브쿼리에서 나온 행 중에 아무거나)
-- J3직급을 가진 직원들의 모든 급여중에 하나보다만 크면 출력하라.(결국 min보다 크면 출력하라)
SELECT emp_name, salary FROM employee WHERE salary > any (select salary from employee where job_code = 'J3');
-- J3직급을 가진 직원들의 모든 급여보다 크면 출력하다.(결국 max보다 크면 출력하라)
SELECT emp_name, salary FROM employee WHERE salary > all (select salary from employee where job_code = 'J3');
/*
> any ~중에 아무거나보다 크다.
< any ~중에 아무거나보다 작다.
> all ~의 모든 요소중 가장 큰것보다 크다
< all ~의 모든 요소중 가장 작은것보다 작다.
*/
--------------------연습문제
-- D1 또는 D5부서 코드를 가지고 있는 사원들의 급여보다(any) 작은 모든 사원들의 이름, 급여, 부서코드를 출력해보세요.
SELECT
    emp_name,
    salary,
    dept_code
FROM
    employee
WHERE
    salary < any (select salary from employee where dept_code in ('D1','D5'));
-- 부서별 평균 급여를 조사했을때, 가장 낮은 부서의 급여보다 높거나 같은 사원들의 이름, 급여, 부서명을 출력하세요.
SELECT
    emp_name,
    salary,
    dept_title
FROM
    employee e join department d on (e.dept_code = d.dept_id)
WHERE
    salary >= any (select avg(salary) from employee group by dept_code);

----------------------다중 열 서브쿼리----------------------
--이태림과 같은 직급에 같은 부서인 사람들
select dept_code, job_code from employee where emp_name = '이태림';
-- 다중열이면 where 비교할 대상도 같은 다중열로 비교해주면 된다.(양쪽의 값만 맞춰주면 =,in 둘다 사용 가능)
select dept_code, job_code, emp_name from employee -- 여러개의 열과 행을 반환하기 때문에 in으로 비교
    where (dept_code, job_code) in (select dept_code, job_code from employee where emp_name in ('이태림', '대북혼')) and emp_name not in ('이태림','대북혼');
-- 직급별 최소 급여를 받는 직원의 직급코드, 이름, 급여를 출력하세요.
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
-- 여기서 job_code 가 빠지면 그냥 다중행만 되어서, min(salary)목록에 들어가기만 하면 출력됨

--------------------------------- SubQuery 심화
-- Inline View = FROM절에서 서브쿼리를 사용한것
select * from (select emp_id, emp_name, salary from employee); -- 서브쿼리로 만든 가상 테이블
SELECT emp_name FROM (select emp_id, emp_name, salary from employee);

----- 상관(상호연관) 서브쿼리 (main쿼리를 서브쿼리에 이용)
-- "자신이 속한 직급" 직원들의 평균급여보다 더 많이 받는 사람?
select emp_name, job_code, salary from employee e
    where salary >= (select avg(salary) from employee e2 where e2.job_code = e.job_code);
-- join 없이 이름과 부서 출력
SELECT emp_name 사원명,
    dept_code,
    (select dept_title from department where dept_id = e.dept_code) 부서
FROM 
    employee e 
ORDER BY 2; -- 2는 두번째 칼럼 기준으로 정렬
----------------------------------------------
-- Ranking 
SELECT emp_name, salary, rank() over(order by salary desc) 급여순위 FROM employee; -- 공동순위 후 점프
SELECT emp_name, salary, dense_rank() over(order by salary desc) 급여순위 FROM employee; -- 공동순위 후 이어서
SELECT emp_name, salary, row_number() over(order by salary desc) 급여순위 FROM employee; -- 공동순위 없이(행번호를 붙이는 개념)

-- employee 테이블 내에서 급여순위 (내림차순)로 정렬했을 때, 5 ~ 10위까지만 출력해보세요.
SELECT * FROM (select emp_name, salary, rank() over(order by salary desc) as rk from employee) WHERE rk between 5 and 10;
--------------------------------SubQuery 실습------------------------------------
--문제1
--기술지원부에 속한 사람들의 사람의 이름,부서코드,급여를 출력하세요
SELECT
    emp_name,
    dept_code,
    salary
FROM
    employee e join department d on (e.dept_code = d.dept_id)
WHERE
    dept_title = '기술지원부';
-- 정답
SELECT
    emp_name,
    dept_code,
    salary
FROM
    employee
WHERE
    dept_code = (SELECT dept_id FROM department WHERE dept_title = '기술지원부');

--문제2
--기술지원부에 속한 사람들 중 가장 연봉이 높은 사람의 이름,부서코드,급여를 출력하세요
SELECT
    emp_name,
    dept_code,
    salary
FROM 
    employee e join department d on (e.dept_code = d.dept_id)
WHERE
    salary = (select max(salary) from employee e join department d on (e.dept_code = d.dept_id) where dept_title = '기술지원부');
-- 정답
SELECT
    *
FROM
    (SELECT emp_name, dept_code, salary FROM employee WHERE dept_code = (SELECT dept_id FROM department WHERE dept_title = '기술지원부') ORDER BY salary DESC)
WHERE
    ROWNUM = 1;
    
--문제3
--매니저가 있는 사원중에 월급이 전체사원 평균을 넘고 
--사번,이름,매니저 이름,월급(만원단위부터)을 구하세요
-- * 단, JOIN을 이용하세요
SELECT
    e1.emp_id ID,
    e1.emp_name 사원명,
    e2.emp_name 매니저,
    to_char(e1.salary / 10000, '9,999')||'만원' 월급 
FROM
    employee e1 full join employee e2 on (e1.manager_id = e2.emp_id)
WHERE
    e1.manager_id is not null and e1.salary > (select avg(salary) from employee)
ORDER BY 1;
-- 정답
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

--문제4
--각 직급마다 급여 등급이 가장 높은 직원의 이름, 직급코드, 급여, 급여등급을 조회하세요
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
--정답
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

--문제5
-- 부서별 평균 급여가 2200000 이상인 부서명, 평균 급여를 조회하세요.
SELECT
    (SELECT dept_title FROM department d WHERE e.dept_code = d.dept_id ) AS "부서명",
    floor(AVG(salary)) AS "평균 급여"
FROM
    employee e
GROUP BY
    dept_code
HAVING
    AVG(salary) >= 2200000
ORDER BY
    1;
-- 2번째 정답
SELECT
    (SELECT dept_title FROM department WHERE dept_code = dept_id),
    trunc(AVG(salary), 0)
FROM
    employee
GROUP BY
    dept_code
HAVING
    trunc(AVG(salary), 0) >= 2200000;

/*문제6
직급의 연봉 평균보다 적게 받는 여자사원의
사원명,직급코드,부서코드,연봉을 이름 오름차순으로 조회하시오
연봉 계산 => (급여+(급여*보너스))*12*/
-- 사원명,직급명,부서명,연봉은 EMPLOYEE 테이블을 통해 출력이 가능함
-- 우선 직급별 평균 연봉 뽑아내기 코드
SELECT
    job_code,
    AVG((salary +(salary * nvl(bonus, 0))) * 12)
FROM
    employee
GROUP BY
    job_code;
-- 여자 사원들 및 여자사원들의 연봉 코드
SELECT
    emp_name,
    emp_no,
    job_code,
    ( salary + ( salary * nvl(bonus, 0) ) ) * 12
FROM
    employee
WHERE
    substr(emp_no, 8, 1) = 2;
-- 최종 정답
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

------------------------------------------------------------ DQL 끝 ------------