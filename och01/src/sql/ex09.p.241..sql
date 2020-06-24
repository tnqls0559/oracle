--p.241ex01.emp테이블의 구조만 복사 emp_insert 테이블 생성
create table emp_insert
as
select * from emp where 1<>1;

--ex02.본인을 emp_insert테이블에 추가 sysdate로 입사일자 입력
alter table emp_insert add hiredate date;
select * from emp_insert;
insert into emp_insert values(7788,'홍길동',1500,10,sysdate);

--ex03.emp_insert 테이블 옆사람 추가 to_date();
insert into emp_insert values(7788,'일지매',1500,10,to_date(sysdate-1));
select * from emp_insert;

--ex04.employee 테이블구조 복사 emp_copy;
create table emp_copy2
as
select * from employee;

--ex05.update dno->10
select * from emp_copy2 where eno=7788;
update emp_copy2 set dno=10 where eno=7788;

--ex06. 7788의 담당업무 및 급여 7499의 담당업무, 급여
select job from emp_copy where eno=7499;
select salary from emp_copy where eno=7499;

update emp_copy set job=(select job from emp_copy where eno=7499),
       salary=(select salary from emp_copy where eno=7499)
   where eno=7788;

update emp_copy set(job,salary)=
      (select job,salary from emp_copy where eno=7499)
   where eno=7788;
   
--ex07.7369와 업무가 동일한 모든 사원의 부서번호를 7369현재 부서번호로 갱신
select dno from emp_copy where job=(select job from emp_copy where eno=7369);   
select dno from emp_copy where eno=7369;   
   
update emp_copy set dno=(select dno from emp_copy where eno=7369)   
   where job=(select job from emp_copy where eno=7369);
   
--ex08. department 테이블 구조와 내용 복사 dept_copy
select * from dept_copy2;   
create table dept_copy2
as
select * from department;

--ex09. dept_copy 부서명이 research인 부서 삭제
select * from dept_copy2;
delete from dept_copy2
  where dno=(select dno from dept_copy2 where lower(dname)='research');
   
 --ex10. dept_copy 테이블에서 부서번호가 10이거나 40인 부서 제거
select * from dept_copy2 where dno in(10,40); 
delete from dept_copy2 where dno in (10,40);
commit
  
  
  
  
  
  
  
  
   
