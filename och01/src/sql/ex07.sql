--p.195 ex1. 사원 번호가 7788인 사원의 담당업무가 같은 사원
select job from employee where eno=7788;
select ename,job from employee where job='ANALYST' and eno!=7788;
select ename,job from employee 
       where job=(select job from employee where eno=7788)
       and eno!=7788;
       
--ex2. 7499사원보다 급여가 많은 사원 이름, 담당업무
select ename,job,salary
   from employee 
   where salary > (select salary from employee where eno=7499);
   
--3. 최소급여를 받는 사원 이름, 담당업무, 급여
select min(salary) from employee group by dno; --min대신 max를 넣으면 최대급여   
select ename,job,salary,dno
  from employee
  where salary in (select min(salary) from employee group by dno);
   
--ex4. 직급별 평균급여가 가장 적은 사원의 담당업무를 찾아 직급과 평균급여표시
select min(salary) from employee;  --전체에서  가장 적은 급여
select dno, avg(salary) from employee group by dno;   
select job, avg(salary) from employee group by job;    
select min(avgSal)
       from(select job, avg(salary) avgSal from employee group by job);
       
select job, avg(salary) from employee group by job
  having avg(salary)= (select min(avg(salary))
  from (select job, avg(salary) salary from employee group by job)
  group by job );
   
select job, avg(salary) from employee group by job
  having avg(salary)= (select min(avg(salary))
                        from (select min (avg(salary)) salary from employee group by job );     
 
--ex5. 각 부서의 최소급여 이름, 급여, 부서번호
select ename,salary,dno
  from employee
  where salary in (select min(salary) from employee group by dno);
  
--ex6. 'ANALYST' 보다 급여가 적으면서 'ANALYST'가 아닌 사원 사번, 이름, 업무, 급여
select salary from employee where lower(job)='analyst';  
select eno,ename,job,salary from employee
  where salary < all (select salary from employee where lower(job)='analyst');--기준값이 하나이기 때문에 all대신 any가 와도 가능
  
--ex7. 부하직원이 없는 사원 이름
select distinct manager from employee where manager is not null;  
select * from employee where eno not in (7839,7782,7698,7902,7566,7788)  
;  
select * from employee where eno not in  
        (select distinct manager from employee where manager is not null)    
; 
--ex7-1 상사가 없는 사원
select * from employee where manager is null;

--ex8. 부하직원이 있는 사원  
select * from employee where eno in  
        (select distinct manager from employee where manager is not null)   
;     
--ex9. blake와 동일한 부서에 속한 사원 이름, 입사일(blake제외)
select dno from employee where ename like upper('blake');
select ename,hiredate
  from employee
  where dno=(select dno from employee where ename like upper('blake'))
  and ename!=upper('blake')
;
--ex10. 평균급여봐 많은 사원들
select avg(salary) from employee;
select eno,ename,salary
  from employee
  where salary > (select avg(salary) from employee)
  order by salary;

--ex11. 'K'가 포함된 사원
select * from employee where ename like '%K%';
select dno from employee where ename like '%K%';
select eno, ename
   from employee
   where dno in (select dno from employee where ename like '%K%');

--ex12. 부서 위치가 dallas인 사원의 이름, 부서번호, 담당업무
select dno from department where loc=upper('dallas');
select ename,dno,job
  from employee
  where dno=(select dno from department where loc=upper('dallas'));
   
--ex13. king에게 보고하는 사원의 이름과 급여=상사가 king인 사원
select eno from employee where ename like upper('king');  
select * from employee where manager=7839; --king에게 보고하는 사원들  
select ename,salary
  from employee 
  where manager=(select eno from employee where ename like upper('king')); 
 
--ex14. research부서 부서번호, 사원이름, 담당업무
select * from department where dname=upper('research');
select * from employee where dno=20;  
select dno,ename,job
   from employee
   where dno=(select dno from department where dname=upper('research'))  ;
  
--ex15. 평균 급여보다  많은 급여를 받고 이름에 'M'이 포함된 사원과 같은 부서,사원번호,이름
select avg(salary) from employee; 
select distinct dno from employee where ename like '%M%';  --(10,20,30)
select dno, eno,ename, salary
    from employee
    where salary > (select avg(salary) from employee)
    and dno in (select distinct dno from employee where ename like '%M%');
  
--ex16.
--ex17. 담당업무가 MANAGER인 사원이 소속된 부서와 동일한 부서의 사원
select dno from employee where job='MANAGER';  
select ename
   from employee
   where dno in (select dno from employee where job='MANAGER');
  
  
  
  
  
  
  
  
  
  
