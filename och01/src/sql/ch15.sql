--프로시져 - 명령문을 모아서 하나의 그룹으로 처리하기 위한 객체
--create or replace procedure 프로시져명 is 변수 begin~end;
create or replace procedure sp_salary
is
v_salary employee.ename%type;
begin
	select salary into v_salary from employee where ename='SCOTT';
	dbms_output.put_line('SCOTT의 급여는 '||v_salary);
end; 

--user_source에 객체로 저장
select name, text from user_source where name='SP_SALARY';

--실행--command|sqlplus에서 실행
execute sp_salary;

--삭제
--drop procedure 프로시져명
drop procedure sp_salary;

--매개변수를 받는 프로시져
create or replace procedure sp_salary_ename(
v_ename in employee.ename%type--아규먼트 선언 값을 읽어들이는 모드
)
is
v_salary employee.salary%type;--변수선언
begin
	select salary into v_salary from employee where ename=v__ename;
	dbms_output.put_line(v_ename||'의 급여는'||v_salary);
end; 

--프로시져 소스 확인
select name, text from user_source where name='SP_SALARY_ENAME';
--프로시져 상태 확인 status-valid
select object_name,object_type,status from user_objects 
       where object_name='SP_SALARY_ENAME';

--out 매개변수
create or replace procedure sp_salary_ename2(
v_ename in employee.ename%type,
v_salary out employee.salary%type
)
as
begin
	select salary into v_salary from employee where ename=v_ename;
end; 

--실행
--out모드의 변수 값 받기 위한 변수 선언
--variable 변수명 타입;
 variable v_salary varchar2(14);
 --실행
 --execute 프로시명(입력값, :출력변수)
SQL> execute sp_salary_ename2('SCOTT',:v_salary);
--변수값 console에 출력
--print변수
SQL> print v_salary; 

--프로시져
--전사원의 급여 5%인상 후 전체 인상 후 급여액 출력
create or replace procedure pr_emp_upSal
(tot out number)--출력용 매개변수 선언
as
begin
	--급여인상 처리
	update employee 
	  set salary = salary + salary*0.05;--전사원
	   commit;--트랜잭션 처리 후 db반응처리
    select sum(salary)
      into tot
      from employee;
end; 

--출력용 매개변수 값을 받는 변수 선언 variable 변수명 타입;
veriable v_tot number(14);
--실행 execute 프로시져명 (:변수명);
execute pr_emp_upSal(:v_tot);
--결과 출력 print 변수명;
print v_tot;

select * from employee;

--함수
--function 실행문을 처리 후 결과를 리턴하는 형식의 객체
create or replace function fn_salary_ename(
v_ename in employee.ename%type;
)
return number;--리턴타입 선언
is
v_salary number(7,2);--소수점2, 정수4자리
begin
	select salary into v_salary from employee where ename=v_ename;
	return v_salary;--결과값 리턴
end;

--FUNCTION 정보 조회
select object_name, status from user_objects
where object_type='FUNCTION';

--실행
--출력용 변수 선언
variable v_salary number;
--실행
--execute :변수 :=함수명
execute :v_salary : fn_salary_ename('SCOTT');
--결과 출력
--PRINT 변수명
PRINT V_SALARY;

--select 문에서 실행
select ename,fn_salary_ename(ename) salary
  from employee order by eno;

--특정 사원의 입사일자를 구하는 함수
--createor replace function 함수명(매개변수 타입)return 리턴타입
--as begin ~~ return 결과;end
create or replace function fn_hire_eno
(v_eno number)
return date
as
v_date date;
begin
	select hiredate into v_date from employee where eno=v_eno;
	return v_date;
end; 


--실행
--변수 선언
 variable v_hiredate varchar2;
 --실행 및 결과 얻기
execute :v_hiredate :=to_char(fn_hire_eno(7788));
--결과 출력
print v_hiredate;
--쿼리문에서 결과 출력
select eno,fn_hire_eno(eno) from employee where eno=7788;

create or replace function fn_hire_eno
(v_eno number)  --매개변수 선언
return varchar2--결과 처리 리턴타입 지정 선언
as
v_date date;
begin
	select hiredate 
	into v_date 
	from employee 
	where eno=v_eno;
	return to_char(v_date); --결과 리턴 문;
end; 

--트리거
--테이블의 데이터에 트랜잭션 발생 시 자동 처리해주는 객체 trigger
create or replace trigger trigger_sample1--트리거명
after insert --입력직후 자동 실행되는 트리거
on dept --등록될 테이블
for each row--행단위 실행
begin
	if inserting then --updating,deleting
	dbms_output.put_line('inserting Trigger 발생');
	insert into dept_history
	values(:new.dno,:new.dname,:new.loc,sysdate);--:new.칼럼,;old.칼럼
	-- 입력 전 :new.dno의 값은 null, :old.dno의 값 null
	-- 입력 후 :new.dno의 값은 입력값   :old.dno의 값 null,
	end if;
end ;

--테이블 생성
create table dept_history
as
select dno,dname,loc,sysdate regdate from department where 1<>1;
select * from dept_history;
select * from user_trigger;
select object_name, status from user_objects where object_type='TRIGGER';

select * from dept;
select * from dept_history;

--삭제트리거
create or replace trigger trigger_del
after delete --삭제직후 실행되는 트리거
on dept_org
for each row--행 단위 처리
begin
	dbms_output.put_line('deleting trigger 발생');
	delete from dept_copy where dept_copy.dno=:old.dno;--삭제직후 이전값으로 조회하여 삭제
	insert into dept_history
	values(:old.dno,:old.dname,:old.loc,sysdate);--삭제직후 이전값으로 입력처리
	--삭제전 :old.dno값 40, :new.dno값 null;
	--삭제후 :old.dno값 40, :new.dno값 null;
end; 

--dept_org테이블 생성
create table dept_org as select * from dept;
create table dept_copy as select * from dept_org;
--dept_copy 테이블 생성
select * from dept_org;
select * from dept_copy;
select * from dept_history;

--update 트리거
create or replace trigger trig_update
after update
on dept
for each row
begin
	dbms_output.put_line('update 트리거 발생');
	insert into dept_up_history
	values(:old.dno,:old.dname,:old.loc,
	       :new.dno,:new.dname,:new.loc,sysdate);
	--update이전 :old.dno 40, :new.dno는 null;
	--update이후 :old.dno 40, :new.dno는 수정된 값;
end;

create table dept_up_history;
as
select dno olddno,dname olddname,loc oldloc,
       dno newdno,dname newdname,loc newloc,sysdate updatedate from department where 1<>1;

select * from dept_up_history;

select * from dept;

--프로시져
create or replace procedure ps_commission_up
is
begin
	update employee
	set commission=salary*0.05
	where salary > 3000;
	commit;
end;

--프로시져 생성 상태 확인 status가 vaild이면 정상
select object_name,object_type,status from user_objects
       where object_name='PS_COMMISSION_UP'; 

--프로시져 실행
SQL> execute ps_commission_up;

select * from employee where salary>3000;

--매개변수가 있는 프로시져--7788사원이 근무하는 부서의 총 급여액 출력
create or replace procedure ps_dept_tot
(
  v_eno in employee.eno%type, --값을 받는 매개변수 in모드
  v_tot out number  --값을 출력하는 매개변수 타입 out모드
)
is
begin
	select sum(salary)
	into v_tot
	  from employee
	where dno=(select dno from employee where eno=7788);
end; 

--상태확인
select object_name, status from user_objects 
        where object_name='PS_DEPT_TOT';
--실행
--변수선언
--variable 변수명 타입;
SQL> variable v_saltot number;
--실행
--execute 프로시져명(in모드값, :out모드변수)
SQL> execute ps_dept_tot(7788,:v_saltot);

PL/SQL procedure successfully completed.
--print out 모드변수;
SQL> print v_saltot;

  V_SALTOT
----------
  11418.75

--함수 return문을 가진 객체
create or replace function fn_jobname
(v_eno number) --매개변수
return varchar2--return타입
is
v_job employee.job%type;--출력용 변수 선언
begin
	select job
	into v_job
	  from employee
	 where eno=7788;
	return v_job;--결과 리턴문
end; 

--프로시져 상태 확인
select object_name, object_type, status 
   from user_objects where object_type='FUNCTION';
--실행
--변수 선언
SQL> variable v_jobname varchar2(20);
--실행 후 결과
SQL> execute :v_jobname :=fn_jobname(7788);

PL/SQL procedure successfully completed.
--결과 출력
SQL> print v_jobname;

V_JOBNAME
---------------------------------------------------
ANALYST

--트리거
create table emp_history
as
select eno oldeno,ename oldename,job oldjob,dno olddno,
       eno neweno,ename newename,job newjob,dno newdno,
       sysdate chgdate
  from employee
 where 1<>1;
 
select * from emp_history;

--트리거 생성
create or replace trigger tr_empchg
after update --타이밍 직 후, 이벤트 update
on employee  --트리거가 작동되는 테이블 employee
for each row --행 단위 처리
begin
	dbms_output.put_line('update trigger 실행');
	insert into emp_history 
	values(:old.eno,:old.ename,:old.job,:old.dno, --칼럼의 이전값이 :old속성
	       :new.eno,:new.ename,:new.job,:new.dno,--칼럼의 이후값이 :new속성
	       sysdate);
end; 

--트리거 활성화/비활성화 여부 확인
select trigger_name,triggering_event,status
    from user_triggers
   where trigger_name=UPPER('tr_empchg');

--트리거 상태 확인
select object_name,object_type,status
   from user_objects
  where object_type='TRIGGER';

select * from employee where eno=7788; --job:MANAGER ->job을 manager로, dno:30 ->dno(20)을 30으로

update employee
 set job='MANAGER',
     dno=30
  where eno=7788;
commit

select * from employee where eno=7788,
select * from emp_history;

--SQL> set serveroutput on
SQL> update employee
  2   set ename='Scotttt',
  3  job='Analyst',
  4  dno=20
  5  where eno=7788;
commit;














