select job,salary,hiredate from employee where ename='SMITH';
select ename,job,salary,hiredate from employee where dno=10;
select * from dept;
insert into dept values(60,'SALES','NEW YORK');
update dept set loc = 'DALLAS' where dno=60;
select * from user_triggers where table_name='DEPT';
alter trigger trigger_sample1 disable;
delete from dept where dno=60;

select dno,dname,loc from dept;
select * from employee where eno=7788;

select * from dept where dno=10;
select * from dept where dno=20;
select dname from dept where dno=10;

select * from dept where dno=?;--10,20,30
select * from dept;

select * from employee;
insert into employee values(7999,'홍길동','CLERK',7788,sysdate,1500,null,20);
select eno,ename,job,salary,dname
  from employee a, department b
 where a.dno=b.dno
 and hiredate > '87/05/05'
 and a.dno=20
 and a.job like 'CLERK';
 
