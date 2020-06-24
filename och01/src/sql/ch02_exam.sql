--1.덧셈 연산자를 이용한 급여인상 $300, 인상 후의 사원이름, 급여, 인상된 급여출력
select ename as 이름, salary as 급여, salary+300 as "인상 후 급여"
   from employee
   order by ename;
   
--2. 사원이름, 급여, 연간 총수입 많은 것부터 출력 급여*12 + $100더한 결과
--order by 절에 연산결과도 올 수 있음.
   select ename, salary, salary*12+100
     from employee
    order by salary*12+10 desc;
    
--3.급여가 2000을 넘는 사원의 이름과 급여, 급여가 많은 것 부터 적은 순 desc
select ename, salary from employee order by salary desc;

--4. 사원 번호가 7788인 사원의 이름과 부서번호
select ename, dno from employee where eno=7788;

--5.급여가 2000에서 3000사이에 포함되지 않는 사원의 이름과 급여,
--where 칼럼 between A and B 범위 내, not between A and B범위 밖
select ename, salary from employee where salary not between 2000 and 3000;

--6.1981년 2월 20일 부터 1981년 5월 1일 사이 입사, 이름, 담당업무, 입사일
select ename, job, hiredate from employee where hiredate between '1981/02/20' and '1981/05/01';

--7.부서번호가 20 및 30에 속한 사원의 이름과 부서번호, 이름 내림차순
select ename, dno from employee where dno=20 or dno=30 order by ename desc;
select ename, dno from employee where dno in (20,30) order by ename desc;

--8. 2000~3000사이, 부서번호가 20 또는 30인 사원, 이름, 급여, 부서번호 이름순(오름차순)
--논리연산 And, between, in
select ename, salary, dno from employee where (salary between 2000 and 3000) 
      and (dno in(20,30)) order by ename;
      
--9. 1981년도에 입사한 사원의 이름과 입사일 like와 와일드 카드 사용
-- 날짜데이터 -> 문자데이터로 변환해서 연산가능
select ename, hiredate from employee where hiredate like '81%';
select ename, hiredate from employee where hiredate between '1981/01/01' and '1981/12/31';

--10. 관리자가 없는 사원의 이름과 담당업무
select * from employee where manager is null order by eno;
--계층쿼리
select 1pad(' ',4*(level-1))||ename, eno, manager,level from employee 
           start with manager is null--루트노드를 지정
           connect by prior eno=manager;--부모와 자식노드간의 관계 연결 
           
--11. 커미션
select ename, salary, commission from employee where commission is not null
    order by salary desc, commission desc;
    
--12. 이름의 세번째 문자가 R인 사원
select * from employee where ename like '__R%';    

--13.이름에 A와 E를 모두 포함하는 사원
select * from employee where (ename like '%A%' or ename like '%E%');

--14.담당업무가 clerk or salesman, $1600,$950,$1300이 아닌 사원
select ename, job, salary from employee where job in('CLERK','SALESMAN')
      and salary not in (1600,950,1300);
      
--15. 커미션 $500 이상인 사원
select ename, salary, commission from employee where commission >=500;      

    