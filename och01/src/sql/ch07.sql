--
select salary from employee where ename='SCOTT';
select ename, salary from employee where salary>3000;
select * from employee order by salary;

--sub-query:다른 쿼리안에 속한 쿼리문
select ename, salary 
       from employee 
       where salary>(select salary  --한(행)건 추출
       from employee 
       where ename='SCOTT');

select dname
   from department
   where dno=(select dno --한(행)건 추출
   from employee 
   where ename='SCOTT');--조회조건 먼저 실행되어 조회값 추출
   
   select dno from employee where ename='SCOTT';

--sub-query: 다중행 서브쿼리
--ORA-01427: single-row subquery returns more than one row
-- in (값1,값2,값3,...) in()내의 값 중 하나에 해당하면 조건 만족
select eno,ename,dno
   from employee
   where dno in (select dno from department where dno<>10);--in이 아닌 =이 올 경우 오류
 
select dno from department where dno<>10;

select *
  from employee 
  where job in ('MANAGER','SALESMAN');

--SUB QUERY
select * 
  from employee
  where job in (select job from employee
                where job in('MANAGER','SALESMAN'));

select * from department;
select distinct job from employee where dno=20;
--'DALLAS'지역에 있는 부서에서 근무하는 사원들의 직책(job)과 같은 직책을
--가진 사원들의 이름, 직책, 부서번호를 출력
select eno,job,salary,dno from employee
   where job in (select distinct job -- in('CLERK','MANAGER','ANALYST')
   from employee 
   where dno=(select dno from department where loc='DALLAS'));

select dno, min(salary) from employee group by dno; 

--부서별 최저급여를 받는 사원들 번호, 이름   
-- in (값1,값2,값3,..) 나열된 값 중에 만족하는 경우 추출
select eno,ename
    from employee
    where salary in (select min(salary) from employee group by dno);
--where salary in(950,800,1300)  

--
select salary from employee where job=upper('salesman');

--값들의 논리 합, 나열된 기준에 하나라도 만족하면 추출
select eno,ename,job,salary
  from employee
  where salary < some(select salary from employee where job=upper('salesman'));

select eno,ename,job,salary
  from employee
  where salary < any(1250,1250,1500,1600);--any대신 some이 와도 같은 결과 추출됨.
  
select eno,ename,job,salary
  from employee
  where (salary<1250) or (salary<1250) or (salary<1500) or (salary<1600);

--직책이 'SALESMAN'인 사원들 중 가장 낮은 급여를 받는 사원보다 적은 급여를 받는 사원들
select eno,ename,job,salary
  from employee
  where salary < all(select salary from employee where job='SALESMAN');
  
--all(값1,값2,값3,...) -나열된 값 모두를 만족해야 추출  
select eno,ename,job,salary
  from employee
  where salary < all(1250,1500,1600);
--논리곱  
select eno,ename,job,salary
  from employee
  where (salary <1250) AND (salary <1500) AND (salary <1600) ;  
  
  
  
  
  