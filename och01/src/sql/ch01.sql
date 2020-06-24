select eno, ename from employee;
--select문의 칼럼(숫자)의 사칙연산
select eno, ename, salary+300, salary-300, salary*300, salary/4 from employee;

--null(빈값)의 처리, nvl(값,대체값)
--칼럼 as 별칭
select eno,ename, salary, commission from employee;
select eno, ename, salary, commission+300 as com1 ,nvl(commission,0)+300 
as com2 from employee;

--select시 중복칼럼 제거 distinct
select distinct dno from employee;
select * from employee;

select 'hello wolrd!' from employee where rownum=1;
select 'hello world!' from dual;
select * from dual;

--메세지 출력, 연산결과 출력용 테이블 dual;
--칼럼 as 별칭, 칼럼[as] 별칭(as 생략가능)
select 1+2 as intsum, 5.5+4.5 as dblsum, 'hello'str , 
   sysdate as"날 짜", 10/5 div, 20*3 mul from dual;
   
select null+10, null*10, nvl(null,0)+10, nvl(null,1)*10 from dual;

