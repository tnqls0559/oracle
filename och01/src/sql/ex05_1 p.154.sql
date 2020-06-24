--그룹함수(집계함수)
--SUM()--합계
select sum(salary) from employee;

--avg()--평균
select avg(salary) from employee;

--max()--최대
select max(salary) from employee;

--min()--최소
select min(salary) from employee;

--count()--개수
select count(salary) from employee;

--sum(칼럼)-집계함수는 null은 제외하고 집계
select sum(commission) from employee;
--count(칼럼)--null은 제외하고 집계
select count(commission) from employee;

select sum(commission)/count(commission), 
       avg(commission)
from employee;

-- commission있든 없든, 전체 사원의 수 구하기
select count(commission),count(eno),count(*),count(nvl(commission,0)) from employee;

select * from employee;

--중복을 제거한 칼럼값의 집계 count(distinct 칼럼)
select count(job), count(distinct job) from employee;
select count(dno), count(distinct dno) from employee;
select count(manager), count(distinct manager) from employee;

--  ORA-00937: not a single-group group function
select dno,count(distinct job) from employee;

--그룹별 집계 group by 기준칼럼,
select dno,count(distinct job) from employee group by dno;

-- 부서별 기준칼럼,sum() ~~ groip by 기준칼럼;
select dno,sum(salary) from employee group by dno;

-- 부서별 사원 수 count(*) ~~ group by 기준 칼럼;
select dno,count(*) from employee group by dno;

--부서별 최고급여,최소급여 max(),min() ~~ group by 기준 칼럼;
select dno, max(salary), min(salary) from employee group by dno;
select job,max(salary), min(salary) from employee group by job;

-- 집계한 함수결과에 연산 가능
select max(salary) + 1 from employee;

-- 집계기준이 2개이상, 먼저 기술한 칼럼순으로 기준
select dno,job, max(salary),min(salary),sum(salary),avg(salary) 
       from employee  
       group by dno,job --1.
       order by dno,job;--2.
       
-- 집계전의 개별 데이터 추출 조건 where 조건 
select dno,eno, salary from employee where salary>=1000;

-- 집계한 데이터 추출 조건 having조건
--select dno, sum(salary) from, employee group by dno where sum(salary)>=1000;
select dno,sum(salary) from employee
       group by dno --1.그룹별 추출
       having sum(salary)>=10000;--2.필터링

-- 20번 부서의 직급별 급여 구한 후 3000이상인 직급      
select job, sum(salary)
       from employee
       where dno=20 --1.개별데이터 추출
       group by job --2.추출한 개별데이터 그룹핑
       having sum(salary)>=3000;--3.필터링

--20번 부서의 직급별 최고급여를 구하고, 최고급여 중에서 3000이상인 직급명과 급여출력
select job, max(salary) 
       from employee
       where dno=20 --1.개별데이터 조건
       group by job --2.그룹조건
       having max(salary)>=3000;--3.필터링 조건

--20번 부서의 직급별 최고급여를 구하고, 최고급여 중에서 3000이상인 직급명과 급여출력
select job, max(salary) sum_sal--alias
       from employee
       where dno=20 --1.개별데이터 조건
       group by job --2.그룹조건
       having sum_sal>=3000;--3.필터링 조건--집계함수의 alias로 연산불가

--집계함수내 집계함수       --round( ,2)소수점 2자리까지 표시
select round(max(avg(salary)),2)from employee group by dno;

--p.154 ex1.
select max(salary) maximum,min(salary) as minimum,
       sum(salary) as sum,round(avg(salary),2) average
     from employee;

--ex2.
select max(salary) maximum,min(salary) as minimum,
       sum(salary) as sum,round(avg(salary),2) average
     from employee
     group by job;
     
--ex3.
select job, count(*) from employee group by job;

--ex4.
select count(manager) from employee;

--ex5. 집계 후 연산 가능
select max(salary) - min(salary) from employee;

--ex6.
select job, min(salary)
       from employee
       group by job
       having not min(salary)<2000;

--ex7.
select dno, count (*), round(AVG(salary),2)
       from employee
       group by dno;

--ex8.
select decode(dno,10,'acc',20,'rs',30,'sa',40,'op')dname,
       decode(dno,10,'NY',20,'DA',30,'CH',40,'BO')loc,
       count(*),round(avg(salary),2)
       from employee
       group by dno;

--ex9.
select job,dno,
       decode(dno,10,sum(salary))"부서10",
       decode(dno,20,sum(salary))"부서20",
       decode(dno,30,sum(salary))"부서30",
       sum(salary) "총액"
       from employee
       group by job,dno
       order by dno;
       
--집계함수
--rollup(조건1,조건2)--조건1에 대한 소계,조건2에 대한 속계, 총계
select job, dno, sum(salary)
       from employee
       group by rollup(job,dno);
       
--가로합 세로로 -pivot함수
--dno,job별 salary
select * from (select dno, job, salary from employee)
pivot
(sum(salary) for job in ('CLERK' as "CLERK",
                         'MANAGER' as "MANAGER",
                         'PRESIDENT' as "PRESIDENT",
                         'ANALYST' as "ANALYST",
                         'SALESMAN' as "SALESMAN")
 )
 order by dno;      
       
       