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
-------------------------------------select-------------------------------------
-- select 저장된 데이터를 확인하는 쿼리
select * from cafe_menu; -- *(에스터 리스크)는 모든 컬럼 출력
-- 보고싶은 컬럼만 골라서 작성도 가능
select emp_id, emp_name, emp_no from employee;
-- select절에서 연산도 가능
select salary * 12 from employee;

-- Header는 as 큰따옴표""(더블쿼테이션)를 사용.
select emp_id as "사번", emp_name, emp_no, salary*12 from employee;
-- 큰따옴표""(더블쿼테이션)를 생략가능. but 띄워쓰기가 있을 경우는 필수.
select emp_id as 사번, emp_name, emp_no, salary*12 from employee;
-- as 생략도 가능.
select emp_id 사번, emp_name, emp_no, salary*12 from employee;
-- 새로운 컬럼을 만들 수 있고 as기능도 수행가능.
select emp_id 사번, emp_name 직원명, emp_no 주민번호, salary*12 연봉, '원' 단위 from employee;
-- 오라클에서 문자연결은 ||를 써서 연결.
select emp_id 사번, emp_name 직원명, emp_no 주민번호, salary*12 ||'원' 연봉 from employee;

----------- where 조건을 줌 ------------
-- emp_id의 값이 200인 사람만 출력
select * from employee where emp_id = 200;
-- 부등호도 사용이 가능하다
select * from employee where emp_id < 203;
-- or, and 또는, 이면서
select * from employee where emp_id = 200 or emp_id = 201; -- 200 이거나 201인
select * from employee where emp_id = 200 and emp_id = 201; -- 200 이면서 201인
-- between A와B사이의 값
select * from employee where salary between 3000000 and 4000000; --salary가 3000000에서 4000000사이의 값

select * from dual; -- dual테이블은 더미테이블, 임시 값을 출력하기 위한 목적으로 쓰임.

-- sysdate : 현재 날짜를 반환 (시간값{시,분,초}도 포함되어 있다)
select sysdate from dual;
select sysdate + 5 from dual; -- 현재 날짜로부터 5일 후.
select sysdate - 5 from dual; -- 현재 날짜로부터 5일 전.

select (sysdate+5) - sysdate from dual; -- 날짜간의 연산은 뺄셈만 가능

select emp_name, sysdate - hire_date 근무일수 from employee; -- 근무일수 계산가능.
select emp_name, floor(sysdate - hire_date) 근무일수 from employee; -- floor는 소수점 절삭.

-- employee 테이블에서 근속년수가 20년 이상 된 직원의 이름, 급여, 근속년수 출력
select emp_name, salary, floor((sysdate-hire_date)/365)||'년' from employee
    where floor((sysdate-hire_date)/365) > 20;

select * from employee where hire_date='90/02/06'; --날짜는 년월일 형식을 갖추어야 한다
select * from employee where hire_date>'90/01/01' and hire_date<'00/01/01'; -- 날짜 대소비교 가능
select * from employee where hire_date between '90/01/01' and '00/01/01'; -- between문도 활용가능.

select * from employee where bonus is null; -- null 값의 표현은 is null or is not null
select * from employee where bonus is not null; -- null 값의 표현은 is null or is not null

-- emp_id 가 200 이거나 201이거나 202이거나 203인 직원의 모든것을 출력하세요.
select * from employee where emp_id=200 or emp_id=201 or emp_id=202;
select * from employee where emp_id in (200,201,202,203); -- 위 구문을 짧게
select * from employee where emp_id not in (200,201,202,203); -- 200,201,202,203이 아닌 아이디만 출력

-- like : 찾고자 하는 데이터가 포괄적일 때
-- 이름을 %로 검색하는 상황.
select * from employee where emp_name ='유재식';
select * from employee where emp_name like '유%'; -- like '유%'기호는 '유'로시작하고 ,%는 아무글자나 0글자 이상.
select * from employee where emp_name like '%하%'; -- %는 0글자 이상. '하'라는 글자가 포함된 사람.
select * from employee where emp_name like '%진'; -- 진뒤에는 글자가 있어선 안된다.
-- 이름을 _로 검색하는 상황.
select * from employee where emp_name like '유_'; -- '유'로시작해서 뒤에 아무거나 한글자만 있는 사람.
select * from employee where emp_name like '유__'; -- '유'로시작해서 뒤에 아무거나 두글자만 있는 사람.
select * from employee where emp_name like '_유_'; -- 가운데에 '유'가 들어있는 사람.

-- 연습문제
-- Employee 테이블에서 이름이 연으로 끝나는 사람의 이름 출력
select emp_name from employee where emp_name like '%연';
-- 이메일주소의 언더바 앞글자가 3글자 이상인 사람만 출력.
-- 앞글자가 3글자이고 escape문자로 '#'을 쓰겠다. %는 0글자이상. like는 not like도 가능.
select * from employee where email like '___#_%' escape '#';
-- employee 테이블에서 전화번호 처음 3자리가 010이 아닌 사람의 이름, 전화번호를 출력
select emp_name, phone from employee where phone not like '010%';
-- employee 테이블에서 메일주소에 's' 가 들어가면서, dept_code가 d9 또는 d6이고,
--            고용일이 1990년 1월 1일부터 2000년 12월 1일 사이이며
--            급여가 270만원 이상인 직원의 전체 정보
select * from employee
where 
    email like '%s%' 
    and dept_code in ('D9','D6')
    and hire_date between '90/01/01' and '00/12/01' 
    and salary >= 2700000;
-- 부서 배치가 되지 않았지만 보너스를 지급받는 직원의 사번 및 이름, 보너스, 부서를 출력하세요
select emp_id, emp_name, bonus, dept_code from employee 
    where dept_code is null and bonus is not null;
-- 직원 중, 직급코드가 J7 또는 J2이고, 급여가 200만원 초과인 사람의 이름 급여 직급코드를 출력하세요.
select emp_name, salary, job_code from employee
    where job_code='J7' or job_code = 'J2' and salary > 2000000;
-- 위의 코드는 and연산이 우선되기 때문에 j2이면서 2000000이상이거나 j7인사람 으로 해석됨. ()괄호로 해결
-----------------------------------

-- order by : 데이터 정렬에 사용.(오름차순이나 내림차순, 디폴트는 오름차순.)
select * from employee order by emp_name; -- 이름 오름차순(기본 오름차순).
select * from employee order by salary asc; -- 급여 오름차순.
select * from employee order by hire_date desc; -- 고용날짜의 최신날짜부터 오래된 날짜까지 내림차순.
select * from employee order by 12 desc; -- 컬럼의 순서를 번호로 쓰임.
select * from employee order by dept_code, job_code; -- dept_code로 정렬하고 job_code를 정렬.
select * from employee order by 6 desc, 7 asc; -- dept_code를 내림차순 정렬하고 job_code를 오름차순 정렬.

--nvl() : 메서드에 값이 전달 되었을때, 전달된 값이 null이면 우리가 지정한 값으로 반환되고,
--        null이 아니면 전달된 값 그대로 반환한다.
select emp_name, nvl(dept_code, '인턴') from employee; -- dept_code를 받았을 때 null값이 있다면 인턴으로 리턴.

-- 연습문제
-- 문제1. 
-- 입사일이 5년 이상, 10년 이하인 직원의 이름,주민번호,급여,입사일을 검색하세요
select emp_name, emp_no, salary, hire_date from employee where (sysdate - hire_date)/365 between 5 and 10;
-- 문제2.
-- 재직중이 아닌 직원의 이름,부서코드를 검색하세요 (퇴사 여부 : ENT_YN)
select emp_name, dept_code from employee where ent_yn = 'Y';
-- 문제3.
-- 근속년수가 10년 이상인 직원들을 검색하여 출력하세요.
-- 출력 결과는 이름,급여,근속년수(소수점X)를 근속년수가 오름차순으로 정렬하여 출력하세요.
-- 단, 급여는 50% 인상된 급여로 출력되도록 합니다.
select emp_name, salary * 1.5, floor((sysdate-hire_date) / 365) from employee where (sysdate-hire_date) / 365 >= 10 order by ((sysdate-hire_date) / 365);
-- 문제4.
-- 입사일이 99/01/01 ~ 10/01/01 인 사람 중에서 급여가 2000000 원 이하인 사람의
-- 이름,주민번호,이메일,폰번호,급여를 검색하세요.
select emp_name, emp_no, email, phone, salary from employee where (hire_date between'99/01/01' and '10/01/01') and salary <= 2000000;
-- 문제5.
-- 급여가 2000000원 ~ 3000000원 인 여직원 중에서 4월 생일자를 검색하여 
-- 이름,주민번호,급여,부서코드를 주민번호 순으로(내림차순) 출력하세요.
-- 단, 부서코드가 null인 사람은 부서코드가 '없음' 으로 출력 하세요.
select emp_name, emp_no, salary, nvl(dept_code, '없음') from employee where salary between 2000000 and 3000000 and emp_no like '___4___2%' order by emp_no desc;
-- 문제6.
-- 남자 사원 중 보너스가 없는 사원의 오늘까지 근무일을 측정하여 
-- 1000일 마다(소수점 제외) 
-- 급여의 10% 보너스를 계산하여 이름,특별 보너스 (계산 금액) 결과를 출력하세요.
-- 단, 이름 순으로 오름 차순 정렬하여 출력하세요.
select emp_name, floor(((sysdate - hire_date)/100) * (salary * 0.01))특별보너스
from employee where emp_no like '%-1%' and bonus is null order by 2 desc;
---------------------------------함수 (Function)---------------------------------

---------------------------------단일 행 함수------------------------------------
--단일 행 함수 : 한 행마다 적용되는 함수.
--Lower, Upper, Initcap : 대문자,소문자,대소문자 변환
select * from employee where upper(job_code) = upper('j1'); -- 만약 이름이라면 대소문자구분없이 검색가능

--length : 인자값으로 전달된 문자열의 길이를 반환하는 함수
select length('가나다232hello')글자수반환 from dual;
select emp_name, length(email) from employee; -- 이메일 길이를 받아옴

--lengthb : 인자값으로 전달된 문자열의 사이즈(byte)를 반환하는 함수
select lengthb('ABCDEFG') from dual; -- 한글자당 1byte
select lengthb('가나다') from dual; -- 한글자당 3byte

-- instr : 찾는 문자(열)이 지정한 위치부터 지정한 번째만큼 나타난 시작 위치를 반환.
-- instr(원본 문자열, 찾을 문자(열), 몇번째 자리에서부터, 몇번째로 만나는); -반환값은 검색 성공한 문자의 처음부터 해당 위치까지의 인덱스값
select instr('Hello World Hi High', 'H', 3, 1) from dual;-- 3은 1번 인자의 몇번째 글자로부터 찾을지 1은 몇번째로 만나는 H인지
select instr('Hello World Hi High', 'H', 1, 2) from dual;-- 공백 포함
select instr('Hello World Hi High', 'H', 2, 1) from dual;-- 13이 나오는 이유는 시작위치부터 찾으니까.
select instr('Hello World Hi High', 'H', 2, 2) from dual;

--employee 테이블 내에서 email과 email의 @ 위치값을 출력하세요.
select email, instr(email, '@', 1) from employee;

-- substr : 문자열 내에서 시작 인덱스부터 지정한 글자만큼 문자열을 추출
-- substr(타겟 문자열, 잘라내고 싶은 문자열의 시작 인덱스, 지정한 글자수)
-- 지정한 글자수를 명시하지 않으면 시작 인덱스부터 끝까지 출력
select substr('A wise man will make more opportunities than he finds.',3,4) from dual;
select substr('A wise man will make more opportunities than he finds.',12,4) from dual;
select substr('A wise man will make more opportunities than he finds.',5) from dual; -- 뒤에껄 다 출력

-- distinct : 중복을 제거
-- distinct는 다른 칼럼이 나오고 나서 쓸 수 없다. 
-- select emp_name 이름, distinct substr(emp_name, 1,1) 성 from employee order by 1; (x)
-- employee 테이블에서 직원들의 이름과 성만 출력해보세요
select distinct substr(emp_name,1,1) "성" from employee order by 1; -- 중복을 제거하고 ㄱㄴㄷ정렬(distinct는 select 바로뒤에 사용)
select distinct substr(emp_name,1,1) "성", emp_name from employee order by 1; -- 중복제거가 취소됨(name도 나와야 하니까)
select substr(emp_name,2) "이름" from employee;

-- employee 테이블에서 남자직원만 사원번호, 사원명, 주민번호, 연봉을 나타내세요.
-- 주민번호의 뒷6자리는 *처리하세요.
select emp_id, emp_name, substr(emp_no,1,7)||'*******' 주민번호, salary*12 연봉 from employee where emp_no like '%-1%';
-- 강사풀이
select
    emp_id,
    emp_name,
    substr(emp_no,1,8)||'*******' as 주민번호,
    salary*12 연봉 
from employee 
    where substr(emp_no,8,1)=1;

-- replace : 문자열 내에서 특정 문자열을 다른 문자열로 교체 (대체)
select replace('Oracle is not fun','not','very') from dual; -- 1번째 문자열에서 2번째 단어를 만났을때 3번째 문자로 바꿈

-- employee 테이블에서 직원의 이름과 이메일을 출력하되, 이메일은 kh.or.kr 에서 iei.or.kr로 변경해서 출력하세요.
select emp_name, replace(email,'kh','iei') from employee;

-- lpad, rpad : 빈공간을 특정 문자로 채우는 함수(14자리중 7자리를 표시하고 왼쪽,오른쪽을 지정한 문자 또는 빈공간으로 채움)
select rpad(substr(emp_no,1,7), 14, '*') from employee;

-- trim : 공백제거

----------------소수점 관련 함수---------------
-- round : 반올림 함수
select 126.456 from dual;
select round(126.456, 3) from dual; -- 소수점 네번째 자리에서 반올림하여 세번째 자리까지 출력인데 세번째까지밖에 없으므로 그대로 출력됨
select round(126.455, 2) from dual; -- 소수점 세번째 자리에서 반올림하여 2번째 자리까지 출력
select round(126.426, 1) from dual; -- 소수점 두번째 자리가 2이기 때문에 반올림되지않고 126.4만 출력
select round(126.656, 0) from dual; -- 소수점을 없앨수도 있다(반올림)
select round(126.456, -1) from dual; -- 소수점 위쪽으로 반올림도 가능
select round(126.456, -2) from dual; -- 쌉가능

-- floor : 소수점을 버리는 함수
select floor(126.456) from dual; -- 소수점을 그냥 버림(반올림하지않음)

-- trunc : 원하는 소수점 자리까지 출력하며 나머지를 버리는 함수
select trunc(123.456,1) from dual;
select trunc(123.456,2) from dual;
select trunc(123.456,0) from dual;
select trunc(123.456,-1) from dual;

-- ceil : 올림 함수
select ceil(123.001) from dual; -- 소수점을 바로 올려버림

-- abs : 절대값
select abs(-1) from dual;

------------------날짜 관련 함수-----------------
-- sysdate : 현재 날짜를 반환 (시간값{시,분,초}도 포함되어 있다),(초 이하의 ms는 갖지 못함)
select sysdate from dual;

-- localtimestamp : 정밀한 시간 반환 ms까지 출력
select localtimestamp from dual;

-- months_between : 인자로 전달되는 두개의 날짜사이의 개월수를 리턴하는 함수
select emp_name, hire_date, months_between(sysdate,hire_date) from employee;
select months_between(sysdate,'19/06/01') / 12 from dual;
select emp_name, hire_date, floor(months_between(sysdate,hire_date)/12)||'년' from employee;

-- add_months : 인자로 전달받은 날짜에, 인자로 전달된 숫자만큼의 개월을 더하여 리턴하는 함수
select sysdate + 1 from dual; -- 하루 추가
select add_months(sysdate, 1) from dual; -- 1개월 추가

-- next_day : 인자로 전달받은 날짜로부터 가장 가까운 두번째 인자에 해당하는 요일의 날짜를 리턴
select sysdate, next_day(sysdate, '월요일') from dual; -- sysdate 날짜 기준으로 가장 가까운 월요일 출력
select emp_name, hire_date, next_day(hire_date, '일요일') from employee; -- 입사 후 처음 맞는 일요일
-- alter session set nls_language=AMERICAN; -- 오라클 설정을 영어로 변경

-- last_day : 인자로 전달받은 날짜가 속한 달의 마지막 날짜를 리턴
select last_day(sysdate) from dual;
-- 다음달 마지막 날짜는 몇일일까요?
select last_day(add_months(sysdate,1)) from dual;

-- extract : 인자로 전달된 날짜로부터 년/월/일 값을 추출해서 리턴
select extract(year from sysdate) from dual; -- sysdate로 부터 year을 추출하겠다
select extract(month from sysdate)||'월'||extract(day from sysdate)||'일' from dual; -- 같이도 됨
select extract(day from sysdate) from dual;

-- 연습문제
-- employee 테이블에서 사원의 이름, 입사일, 년차를 출력하세요. 단, 입사일은 YYYY년 M월 D일 형태로 출력하세요.
-- 년차는 올림해서 출력하세요, 정렬은 입사일 기준으로 오름차순 적용하세요.
select
    emp_name,
    extract(year from hire_date)||'년'||extract(month from hire_date)||'월'||extract(day from hire_date)||'일' 입사일,
    ceil((sysdate-hire_date)/365) "년차"
from employee order by hire_date;

------------------형변환 함수------------------
-- to_char : 숫자타입이나 날짜타입을 문자열로 변경하여 리턴하는 함수
-- to_char(어떤 숫자나 날짜를, 어떤 문자열 모양으로 출력)
select to_char(sysdate, 'YYYY-MM-DD') from dual;
select to_char(sysdate, 'YYYY/MM/DD') from dual;
select to_char(sysdate, 'YYYY/MM/DD day') from dual; -- 요일도 출력함
select to_char(sysdate, 'YYYY/MM/DD(dy)') from dual; -- 요일을 한글자로 출력
select to_char(sysdate, 'YYYY#MM$DD_ dy HH:MI:SS') from dual; -- 시간값까지 출력
select to_char(sysdate, 'YYYY"년"MM"월"DD"일" dy HH:MI:SS') from dual; -- date포맷 안에 원하는 문자는 ""로 묶는다.

-- 이번달 마지막 요일 구하기
select to_char(last_day(sysdate), 'day') from dual;
-- 6개월 후의 마지막날 요일
select to_char(last_day(add_months(sysdate, 6)), 'YYYY/MM/DD day') from dual;

-- 숫자를 문자열로 표기
select emp_name, to_char(salary, '999,999,999') from employee; -- 999로 채우면 000처럼 자리수를 0으로 채우지않는다.
select emp_name, to_char(salary, 'L999,999,999') from employee; --L은 로컬통화 표기법

-- to_date : 문자 또는 숫자를 날짜로 형변환시켜 리턴하는 함수
select to_date(20200905, 'YYYYMMDD') from dual; -- YYYY MM DD 형식으로 분석을 하는것이지 출력을 하는것이 아님.
select to_date('09052020', 'MMDDYYYY') from dual; -- 년 월 일 인식을 다르게 하는것.
-- 2030년 12월 25일은 무슨 요일일까요?
select to_char(to_date(20301225), 'YYYY/MM/DD day') from dual;

-- to_number : 문자를 숫자로 바꾸는 함수(오라클에선 문법 맥락을 분석하여 자동 형변환을 지원하기때문에 별필요없음.
select to_number('10') + '5' from dual;
select '10' + '5' from dual;

-- mod : 숫자를 나눈 나머지값을 반환
select mod(15, 6) from dual;

------------------선택 함수-----------------
-- decode : 자바의 switch와 같은 역할. == 비교를 통한 분기점 생성
select
    emp_name,
    decode(substr(emp_no,8,1), 1, '남', 2, '여', 3, '남', 4, '여') -- 가변 인자값
    -- decode(여기값이, 이거면, 이걸출력, 이거면, 이걸출력 ...)
    -- decode(substr(emp_no,8,1), 1, '남', '없음') '없음' 디폴트 적용
from
    employee;

-- case: 자바의 if와 같은 역할. <= >= > < == 비교를 통한 분기점을 생성
select
    emp_name,
    case
        when substr(emp_no, 8, 1) = 1 then '남'
        when substr(emp_no, 8, 1) = 2 then '여'
        else '없음' -- 디폴트
    end 성별
from employee;

-- 60년대생 직원중에, 65년 이전 직원은 '60년대생 초반', 이후는 '60년대생 후반' 이름과 주민번호, 년생정보를 출력하세요
select
    emp_name,
    emp_no,
    case
        when substr(emp_no, 2, 1) < 5 then '60년대 초반생'
        when substr(emp_no, 2, 1) >= 5 then '60년대 후반생'
    end 년생정보
from
    employee
where emp_no like '6%';

------------------------------------그룹 함수------------------------------------
-- 그룹 함수 : 모든 행에 대해서 딱 한 번 실행되는 것.
-- 그룹함수옆엔 단일행 함수가 올수 없다.

-- 합계함수 (sum)
select sum(salary) from employee;
-- employee 테이블 내에 여직원들의 급여 합계
select to_char(sum(salary), 'L99,999,999') "여직원 급여합계" from employee
    where emp_no like '%-2%';

-- 평균함수 (AVG)
select to_char(avg(salary), 'L9,999,999') "여직원 급여평균" from employee
where substr(emp_no, 8, 1) = 2;

-- 개수측정 (COUNT)
-- NULL 값은 카운팅 하지 않음
-- 따라서 NULL 여부 상관 없이 행 갯수 자체를 원한다면 count(*)을 쓰면 된다. 
select count(emp_name) from employee; -- 23
select count(dept_code) from employee; -- 21 (count함수는 null값을 계산하지 않는다.)
select count(*) from employee; -- *모든 행의 갯수를 계산
-- 남직원의 수를 출력해보세요.
select '남직원은 '||count(*)||'명' 인원 from employee where emp_no like '%-1%';

-- 최소값 / 최대값 (min / max)
select min(salary), max(salary) from employee; -- 그룹함수들은 같이쓸수있다.
-- D5부서에서 급여가 가장 높은 직원의 salary 값을 출력해보세요.
select max(salary) from employee where dept_code = 'D5';

-----------------------실습 문제------------------------
-- 직원명과 이메일 이메일의 길이를 출력
select emp_name 직원명, email 이메일, length(email) 메일길이 from employee;
-- 직원명과 @전까지의 이메일을 출력
select emp_name 직원명, substr(email, 1, instr(email, '@')-1) 메일아이디 from employee;
-- 60년생의 직원명과 년생, 보너스율을 출력 단, 보너스율이 null이면 0%로 출력
select emp_name 직원명, substr(emp_no, 1, 2)||'년생' 년생, nvl(bonus*100, '0')||'%' 보너스 from employee where emp_no like '6%';
-- 010 핸드폰번호를 쓰지 않는 직원의 수
select count(*)||'명' "010을 사용하지않는 직원" from employee where phone not like '010%';
-- 직원명과 입사년월 조회 입사년원 2012년 12월 형식
select emp_name 직원명, to_char(hire_date, 'YYYY"년"MM"월"') 입사년월 from employee;
-- 직원명과 주민번호 조회 단, 주민번호는 771120-1****** 으로 표시
select emp_name 직원명, substr(emp_no, 1, 8)||'******' 주민번호 from employee;
-- 직원명, 직급코드, 연봉(원) 조회 단, 연봉은 현지통화57,000,000으로 표시 연봉은 보너스포인트가 적용된 1년치 급여임
select emp_name 직원명, job_code 직급코드, to_char(salary*12+(salary*12*nvl(bonus, 0)), 'L999,999,999') 연봉 from employee;
-- 부서코드가 D5,D9인 직원중 2004년도에 입사한 직원의 사번 사원명 부서코드 입사일
select emp_id 사번, emp_name 직원명, dept_code 부서코드, hire_date 입사일 from employee where dept_code in ('D5', 'D9') and (hire_date like '04%');
-- 직원명, 입사일, 오늘까지의 근무일수 조회
select emp_name 직원명, hire_date 입사일, ceil(sysdate-hire_date) 총근무일수 from employee;
-- 모든 직원의 나이 중 가장 많은 나이와 가장 적은 나이를 출력하세요.
select max(to_char(sysdate, 'YYYY') - (substr(emp_no,1,2)+1900))+1||'세' "가장 많은나이", min(to_char(sysdate, 'YYYY') - (substr(emp_no,1,2)+1900))+1||'세' "가장 적은나이" from employee;
select min(2021-(1900+substr(emp_no,1,2))+1) "가장 적은 나이", max(2021-(1900+substr(emp_no,1,2))+1) "가장 많은 나이" from employee;
select
    emp_name 이름,
    dept_code 부서코드,
    case
        when dept_code in ('D5','D6','D9') then '야근'
        else '야근없음'
    end 야근유무
from employee order by dept_code;

select * from employee;

select d.emp_name, d.dept_code, d1.dept_title from (select * from employee where dept_code = 'D9') d, (select * from department) d1 where d.dept_code = d1.dept_id;