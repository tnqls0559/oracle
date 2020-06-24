select * from department;
insert into department values(60,'SALES','L.A');
select eno,ename,a.dno,dname
   from employee a, department b
  where a.dno=b.dno
   and a.job = 'CLERK'
   and a.dno = 20;
   
select * from employee where dno=20;

select * from user_objects 
  where object_type='PROCEDURE'
 order by object_name;
 
 select text from user_source where name='PR_EMP_UPSAL';
 
create or replace  procedure pr_emp_upSal  
 (tot out number)--출력용 매개변수 선언  
 as  
 begin  
 --급여인상 처리  
 update employee  
   set salary = salary + salary*0.05;--전사원  
   commit;
   
     select sum(salary)  
       into tot  
       from employee;  
 end;
 
 select * from user_objects where object_type='FUNCTION';
 select text from user_source where name='FN_SALARY_ENAME';
 
 create or replace function fn_salary_ename(  
 v_ename in employee.ename%type
 )  
 return number--리턴타입 선언  
 is  
 v_salary number(7,2);--소수점2, 정수4자리  
 begin  
 select salary into v_salary from employee where ename=v_ename;  
 return v_salary;--결과값 리턴  
 end;

 --실행
SQL> variable v_sal number;--variable타입
-- exec :변수 :=함수명(값)
SQL> exec :v_sal :=fn_salary_ename('SMITH');

--결과 출력 print 변수명;
SQL> print v_sal

     V_SAL
----------
    972.41
    
select * from employee;
 
select * from user_objects 
  where object_type='PROCEDURE'
 order by object_name;

select * from user_objects where object_type='FUNCTION';
select text from user_source where name='SP_SALARY_ENAME2';
--매개변수 모드가 in모드,out모드 같이 있는 경우
 create or replace procedure sp_salary_ename2(  
 v_ename in employee.ename%type,  
 v_salary out employee.salary%type  
 )  
 as  
 begin  
 	select salary into v_salary from employee where ename=v_ename;  
 end; 
 --실행
SQL> variable v_sal number;
SQL> execute sp_salary_ename2('SMITH',:v_sal);

PL/SQL procedure successfully completed.

SQL> print v_sal;

     V_SAL
----------
    972.41
    
select * from user_objects where object_name='FN_HIRE_ENO';
select text from user_source where name='FN_HIRE_ENO';

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
 return to_char(v_date);  
 end;
 
--실행
SQL> variable v_date varchar2(20);
SQL> exec :v_date :=fn_hire_eno(7788);
PL/SQL procedure successfully completed.
SQL> print v_date;
V_DATE
--------------------------------------------------------------------------------
87/07/13

select * from department where dno=60;
select eno,ename, salary from employee where dno=10;
