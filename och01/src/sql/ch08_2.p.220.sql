--DDL데이터 정의   drop table dept7;
-- create table 테이블명(칼럼타입 option);
create table deta(
dno number(2),
dname varchar(14),
loc varchar2(14)
);
select * from dept;

--서브쿼리를 이용한 테이블 생성
-- create table 테이블명 as 서브쿼리문;
create table dept3
as 
select * from department;

select * from dept3;

--서브쿼리 결과로 테이블 생성
create table dept4
as
select eno,ename,salary*12 annsal
  from employee
  where dno=20;
  
select * from dept5;

--ORA-00998: must name this expression with a column alias
create table dept5
as
select eno,ename,salary*12
  from employee
  where dno=20;  
  
--테이블 구조복사
create table dept_third
as 
select dno,dname
  from department
  where 1!=1; --false조건
select * from dept_third;  
  
--employee 테이블 사원번호,사원명,매니저명을 저장하는 테이블 emanager테이블 생성
create table emanager
as
select a.eno eno,a.ename ename,b.ename mname
  from employee a, employee b
  where a.manager=b.eno(+)
  ;
 select * from emanager; 
  
--테이블 구조변경
--alter table 테이블명[add|modify|drop]
create table dept7
as 
select dno,dname from department;
 
select * from dept7; 

--칼럼 loc칼럼추가
alter table dept7 add (loc varchar2(14));
truncate table dept7;
insert into dept7 select * from department;
 
--칼럼변경
--alter table modify 칼럼(변경할 내용)
alter table dept7 modify loc varchar2(20); 
select length(loc) from dept7; 
--ORA-01441: cannot decrease column length because some value is too big-- 8이하로는 불가능
alter table dept7 modify loc varchar2(8);  
 
--칼럼제거
--alter table 테이블명 drop 칼럼
alter table dept7 drop column loc; 
select * from dept7;

--칼럼 사용불가 처리
--alter table 테이블명 set unused (칼럼)
alter table dept7 set unuesd (loc);--loc칼럼 접근 불가 처리
alter table dept7 drop unused columns;--접근불가 처리된 칼럼 제거

--칼럼명 변경
--alter table 테이블명 rename column 칼럼명 to 바꿀 칼럼명
alter table dept7 rename column loc to location;
select * from dept7;

--테이블 이름 변경
rename dept7 to dept77;
select * from dept77;
select * from dept7;

--테이블 삭제 drop table 테이블명
drop table dept77;

create table parent
as 
select * from department;

create table child
as
select eno,ename,dno from employee;
select * from child;

--foreign key: 부모테이블의 primary 키가 자식테이블의 속성으로 참조되는 키;
--parent,child 관계맺기
--ORA-02270: no matching unique or primary key for this column-list
alter table child add constraint child_fk foreign key(dno) references parent(dno);
--parent 테이블에 기본키 제약조건 추가
--add constraint 제약조건명 primary key(대상칼럼)
alter table parent add constraint parent_pk primary key(dno);
select * from parent;
select * from user_constraints where table_name='PARENT';
select * from user_constraints where table_name='CHILD';
select * from user_constraints where table_name in('PARENT','CHILD');
--부모 테이블 삭제
--ORA-02449: unique/primary keys in table referenced by foreign keys--child인 자식 테이블이 참조중이므로 삭제 불가능
drop table parent;-- parent는 부모 테이블이므로 참조받는 입장으로 삭제 불가능
drop table child;--참조를 하고 있는 child테이블은 삭제 가능

--foreign key 관계 제거
--alter table 테이블명 drop constraint 제약조건명(child_fk)
alter table child drop constraint child_fk;

--foreign key 제약조건 삭제 후 부모테이블 삭제 가능
drop table parent;

--테이블 생성 시 제약조건 추가
create table temp1(
dno number primary key,
dname varchar2(14)
);

create table temp2(
eno number primary key,
ename varchar2(20),
dno number,--칼럼선언
foreign key(dno) references temp1(dno)--제약조건 추가
--foreign key(대상칼럼) references 부모테이블(참조칼럼)
);

select * from user_constraints 
  where table_name in ('TEMP1','TEMP2','PARENT','CHILD');

--데이터 자르기 truncate table 테이블명;
--truncate는  db에 바로 반영되는 삭제 작업
--delete는 메모리에서 작업 후 commit;명령에 의해 db에 반영, rollback;으로 되돌릴 수 있음.
select * from dept4;
truncate table dept4;
insert into dept4 select eno,ename,salary*12 annsal from employee;

--데이터 사전
--user_데이터 사전: 접속한 user가 접근가능한 정보
select table_name from user_tables;--hr유저가 만든 테이블리스트
select * from user_indexes; --hr유저의 생성된 index정보
select * from user_constraints;--hr유저의 제약조건 정보
select * from user_objects;--hr유저의 생성된 객체 정보

--all_데이터 사전: 모든 유저가 접근가능한 정보
select owner, table_name from all_tables order by owner,table_name;

--dba_데이터 사전: dba권한을 가진 유저 접근가능한 정보(sys)
--sys as sysdba로 접속
--grant dba to 유저(hr);로 권한 부여.
--회수: revoke dba from 유저; 권한회수
select owner, table_name from dba_tables;

--ex1.p.220 dept테이블 생성
create table dept(
dno number(2),
dname varchar2(14),
loc varchar2(13)
);
--ex2. emp테이블 
create table emp_t(
eno number(4),
ename varchar2(10),
dno number(2)
);
--ex3. 칼럼변경
alter table emp_t modify ename varchar2(25);

--ex4.
create table employee2
as
select eno emp_id, ename name, salary sal, dno dept_id 
       from employee;
select * from employee2;

--ex5. emp테이블 삭제
select * from emp;
drop table emp;

--ex6. employee2 -> emp
rename employee2 to emp;
select * from emp;

--ex7.dept dname제거
select * from dept;
alter table dept drop column dname;--삭제 후 다시 원래대로 복구는 불가 뒤에 추가는 가능

--ex8. loc칼럼 unused로 표시
alter table dept set unused (loc);alter

--ex9.
alter table dept drop unused columns; 




  