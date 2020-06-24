--sequence: 순번 자동잘번 객체
drop sequence dno_seq;
create sequence dno_seq
start with 10  --시작번호
increment by 10--증가번호
minvalue 10    --start with 10으로 시작해서 1순환 후 새로 시작될 때는 minvalue10으로 시작 
maxvalue 50    --최대번호
nocache        --cache관리안함.
cycle;         --순환

--select 값 from dual;
select dno_seq.currval, dno_seq.nextval from dual;

--board sequence생성
create sequence board_seq
start with 1
increment by 1
;

create table board2(
seq number primary key,
title varchar2(100),
content varchar2(4000)
);

select * from board2;
insert into board2 values(board_seq.nextval,'제목1','내용1');
insert into board2 values(board_seq.nextval,'제목2','내용2');
insert into board2 values(board_seq.nextval,'제목3','내용3');
insert into board2 values(board_seq.nextval,'제목4','내용4');
select board_seq.currval, board_seq.nextval from dual;

--시퀀스 수정
alter sequence dno_seq
--start with 10  --시작번호
increment by 1--증가번호
minvalue 10    --start with 10으로 시작해서 1순환 후 새로 시작될 때는 minvalue10으로 시작 
maxvalue 50    --최대번호
cache 10       --cache관리안함.--cache갯수 기본20개
nocycle;         --순환

select dno_seq.nextval from dual;

--시퀀스 정보 조회
select * from user_sequences;

--인덱스-대량의 데이터 검색 속도 향상 객체
--데이터의 저장 정보를 인덱스 객체에 저장 후 조회시 인덱스 정보로 검색
select * from user_indexes where table_name='EMPLOYEE';
select * from user_ind_columns where table_name='EMPLOYEE';

create index idx_employee_ename
on employee(ename);

--쿼리 실행계획
--explain plan for 쿼리문;
explain plan for
select eno,ename from employee
;
--쿼리실행계획 조회
--select * from table(dbma_xplan.displan);
select * from table(dbms_xplan.display);

--고유/비고유 인덱스
--create unique index 인덱스명 on 테이블명 (칼럼)
create table dept_second as select * from dept;
select * from dept_second;
create unique index dept_deptsecond_idx on dept_second(dno);
--ORA-00001: unique constraint (HR.DEPT_DEPTSECOND_IDX) violated
insert into dept_second values(30,'SALES','CHICAGO');

--non-unique 인덱스
create index dept_deptsecond_idx2 on dept_second(dname);
insert into dept_second values(40,'SALES','CHICAGO');

--결합인덱스  두 개 이상의 칼럼
create index idx_dept_com on dept_second(dname,loc);
select * from user_ind_columns where table_name='DEPT_SECOND';

--함수기반 인덱스
create table emp_second2
as
select eno,ename,job,hiredate,salary,dno from employee;

create index idx_emp_second_annsal
on emp_second2(salary*12);

select * from emp_second2;





