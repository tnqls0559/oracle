--조건 비교연산 where 칼럼=값
select * from employee where dno=10;--칼럼 dno은의 값은 숫자

--문자열 비교 where 칼럼='문자값
select * from employee where ename='SCOTT';--칼럼 ename의 값은 문자(홀따옴표) '값'

--날짜 비교 where 칼럼 <='날짜'
select * from employee where hiredate <='1981/01/01';

--조회 조건
--같다(=)
select eno, ename, salary from employee where salary=1500;
--보다 크다(>)
select eno, ename, salary from employee where salary>1500;
--보다 작다(<)
select eno, ename, salary from employee where salary<1500;
--보다 크거나 같다
select eno, ename, salary from employee where salary>=1500;
--보다 작거나 같다
select eno, ename, salary from employee where salary<=1500;
--같지않다(!=,<>,^=)
select eno, ename, salary from employee where salary!=1500;
select eno, ename, salary from employee where salary<>1500;
select eno, ename, salary from employee where salary ^=1500;

--비교연산 결과-칼럼 추출안됨.
--select 10>5, 10<5, 10>=5, 10<=5, 10!=5 from dual;

--논리연산 AND,OR, NOT
--and
select * from employee where dno=10 and job='MANAGER';
--or
select * from employee where dno=10 or job='MANAGER';
--not
select * from employee where not dno=10 ;


--범위 연산자 between A and B,   1000<=salary<=1500
select * from employee where salary between 1000 and 1500;
select * from employee where salary>=1000 and salary<=1500;
-- salary <=1000 and 1500<salary
select * from employee where salary<1000 or salary>1500;
select * from employee where salary not between 1000 and 1500;
--날짜 범위
select * from employee where hiredate between '1981/02/03' and '1981/11/17';

--in 연산자- 나열된 값 중 하나에 해당하는 값 추출
select * from employee where commission in (300,500,1400);

--like % | _
select * from employee where ename like '%D%';--문자길이 상관없이 D포함
select * from employee where ename like '%E_';-- _길이가 1인 문자를 포함하는 E
select * from employee;
select * from employee where ename like '_A%';-- 두번째 단어가 A가 포함된 문자열

-- is null | is not null - 해당 칼럼의 값이 null인지 여부확인
select * from employee where commission is null;
select * from employee where commission is not null;




