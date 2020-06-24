--데이터 정의의(Data Definition Language:DDL)-테이블 ,칼럼 처리문
--테이블 생성
--create table테이블명(칼럼 타입, 제약조건);
create table temp3(
seq number primary key,--제약 조건 primary key
name varchar2(30) not null--제약조건 not null(해당칼럼에 빈값 저장불가 조건)
);

--생성된 테이블 수정(칼럼추가, 칼럼조정, 칼럼삭제, 칼럼명 변경)
--alter table 테이블명 칼럼식
--칼럼 추가: alter table 테이블명 add 칼럼명 데이타 타입
alter table temp3 add dno number(2);
select * from temp3;

--칼럼 변경: alter table 테이블명 modify 칼럼 변경 조건
--char타임: 고정길이 타입(정해진 길이 유지), varchar2:가변길이 타입(입력된 데이터 길이로 가변)
alter table temp3 modify name char null(50);--타입 제약조건 옵션추가

--칼럼 제거: alter table 테이블명 drop 칼럼
alter table temp3 drop column dno;

--칼럼 이름 변경: alter table 테이블명 rename column 이전 칼럼 명 to 변경 칼럼명
alter table temp3 rename column name to sname;

--칼럼 접근불가 처리 : alter table 테이블명 set unused(칼럼명)
alter table temp3 set unused(dno);--칼럼 접근 불가 처리
--접근불가 처리 칼럼 삭제: alter table 테이블명 drop unused columns;
alter table temp3 drop unused columns;--접근불가 칼럼 삭제

--테이블 변경
--테이블 이름 변경, 테이블 삭제
--rename 이전 테이블 명 to 바꿀 테이블 명
rename temp3 to temp33;

--drop table테이블명
drop table temp33;

--테이블 데이터 자르기truncate table 테이블명
insert into temp3(seq,name) values(1,'홍길동');
insert into temp3(seq,name) values(2,'일지매');
insert into temp3(seq,name) values(3,'임꺽정');

--테이블구조 그대로, 데이터만 삭제DB에 바로 반영
truncate table temp3;

--두 테이블, 서로 참조 관계 테이블: 참조관계에서는 참조되는 테이블 삭제 불가
--참조관계를 제거 후 삭제해야됨
create table pa(
dno number, 
dname varchar2(20)
);

create table ch(
seq number primary key,
name varchar2(20),
dno number
);

insert into pa values(10,'연구');
insert into pa values(20,'회계');
insert into pa values(30,'영업');

insert into ch values(1,'홍길동',10);
insert into ch values(2,'일지매',20);
insert into ch values(3,'임꺽정',30);


--drop table pa;
--자식테이블 외부키 제약조건 추가
--참조되는 부모키가 primary key여야 함.
--부모키에 primary key 제약조건 추가 후에 처리
--alter table 테이블명 add contraint 제약조건명 primary key(칼럼);
alter table pa add constraint pa_pk primary key(dno); 
--alter table 테이블명 add contraint 제약조건명 primary key(칼럼);
--references 참조테이블 (칼럼);
alter table ch add constraint ch_fk foreign key(dno) references pa(dno);
--참조제약조건 조회
select * from user_constraints where table_name in ('PA','CH');

--제약조건 제거후 삭제
--alter table  테이블명 drop constraint 제약 조건 명
alter table ch drop constraint ch_fk; 
--참조 관계가 아니므로 삭제 가능
drop table pa;

--데이터 딕셔너리
--user_,all_,dba_
select * from user_tables;--현재 접속한 유저가 생성한 테이블 리스트
select * from user_tab_cols;--현재 접속한 유저가 생성한 테이블 칼럼 리스트
select * from user_constraints;--현재 접속한 유저가 생성한 제약조건 리스트
select * from user_indexes;--현재 접속한 유저가 생성한 인덱스 리스트
select * from user_tab_comments;--현재 접속한 유저가 생성한 테이블 commit리스트
select * from user_col_comments;--현재 접속한 유저가 생성한 칼럼 commmit리스트
select * from user_objects;--현재 접속한 유저가 생성한 객체(테이블,인덱스,뷰,시퀀스,트리거)등
select * from user_procedures;--현재 접속한 유저가 생성한 procedure정보
select * from user_dependencies;--현재 접속한 유저가 생성한 객체한 참조정보
select * from user_source;--현재 접속한 유저가 생성한 프로그램으; 소스 정보
select text from user_source where name='UPDATE_JOB_HISTORY';

select count(*) tabcnt from user_tables where table_name=upper('dt');



