--ex1. 커미션이 null이 아닌 상태의 사원번호, 이름, 급여 이름이 긴 순으로 오름차순 정렬결과
--저장하는 프로시져
create table emp_sal
as
select eno,ename,salary from employee where 1<>1;
select * from emp_sal;

--ex2. 프로시져 생성
create or replace procedure sp_commission
is
cursor c1 is select * from employee where commission is not null;
begin
	dbms_output.put_line('사번  이름   급여');
	dbms_output.put_line('-------------');
	for v_emp in c1 loop
	exit when c1%notfound;
	dbms_output.put_line(v_emp.eno||' '||v_emp.ename||' '||v_emp.salary);
	insert into emp_sal values(v_emp.eno,v_emp.ename,v_emp.salary);
	end loop;
end; 
select * from emp_sal;

--ex3. 사번 이름 급여 커미션
alter table emp_sal add commission number;

create or replace procedure sp_comm2
is
cursor c1 is select * from employee where commission is not null;
begin
	dbms_output.put_line('사번  이름   급여  커미션');
	dbms_output.put_line('-------------');
	for v_emp in c1 loop
	exit when c1%notfound;
	dbms_output.put_line(v_emp.eno||' '||v_emp.ename||' '||v_emp.commission);
	insert into emp_sal values(v_emp.eno,v_emp.ename,v_emp.commission);
	end loop;
	commit;
end; 

delete from emp_sal;
commit
select * from emp_sal;
alter table emp_sal add constraint emp_sal_pk primary key(eno);




