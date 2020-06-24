--p.178 ex1. equi조인 scott사원의 부서번호, 부서명
select * from employee where ename=upper('scott');
select * from department where dno=20;

--ORA-00918: column ambiguously defined
--dno는 employee,department둘 다 가지고 있으므로 d.dno로 중복되지않게한다.
select eno, ename, d.dno, dname
   from employee e, department d 
   where e.dno=d.dno and ename=upper('scott');
   
--ex2. inner join ~ on 사원이름 소속 부서 이름, 지역명
select ename, dname, loc
   from employee e inner join department d on e.dno=d.dno
  ;
select ename, dname, loc
   from employee e join department d using(dno)
  ;
  
--ex3. inner join ~ using
select eno,ename,job,loc
  from employee e inner join department d using(dno)
  where dno=10;  
 
--ex4. natural join 이름,부서,지역
select ename,dname,loc 
  from employee natural join department
  where commission is not null and commission>0;  

--ex5. equi조인 wildcard like '%', A, 이름, 부서명
select ename,dname
  from employee e, department d
  where e.dno=d.dno
  and e.ename like '%A%';

select ename,dname--??
  from employee e, natural join department d
  where e.ename like '%A%';

--ex6. natural join NEW YORK에 근무하는 사원, 이름, 업무, 부서명
select eno,ename,job,dname
  from department natural join employee
  where loc='NEW YORK';

--ex7. self join 사원명, 관리자명 관리자 번호 별칭
select a.eno "사원번호",a.ename "사원명",a.manager "매니저 번호",b.ename "매니저명"
  from employee a, employee b
  where a.manager=b.eno
;
select a.eno "사원번호",a.ename "사원명",a.manager "매니저 번호",b.ename "매니저명"
  from employee a inner join employee b
 on a.manager=b.eno
 ;
--ex8. outer join, self join 관리자가 없는 사원 포함, 사원번호 기준으로 내림차순 
select * from employee where manager is null;
select * from employee where manager is not null;
 
select a.eno, a.ename, a.manager, b.ename
  from employee a, employee b--self join
  where a.manager = b.eno(+) --outer join
  order by a.eno desc; --내림차순 정렬

select a.eno, a.ename, a.manager, b.ename
  from employee a left outer join employee b--self join
  on a.manager = b.eno --outer join
  order by a.eno desc; --내림차순 정렬
  
--ex9. self join, 지정한 사원('scott')의 이름, 부서번호, 지정한 사원과 동일한 부서에서 
--근무하는 사원
select a.eno "지정사원",a.ename "이름",b.eno "종료사원",b.ename "이름"
  from employee a, employee b
  where a.dno=b.dno
  and a.ename like upper('scott')--like =
  and b.ename !=upper('scott');  -- != 같지않다.
 
--ex10. self join, ward보다 늦게 입사한 사원 이름, 입사일
select * from employee where ename like 'WARD';
select b.eno ,b.ename ,b.hiredate
  from employee a, employee b --a는 ward를 기준, b는 동료들 기준
  where a.ename=upper('ward')
   and a.hiredate <b.hiredate
   order by b.hiredate;

--ex11. self join 관리자보다 먼저 입사한 모든 사원,이름, 입사일자
select * from employee;

select a.eno,a.ename,a.hiredate,a.manager,b.ename,b.hiredate 
  from employee a, employee b
  where a.manager = b.eno
  and a.hiredate <= b.hiredate
;