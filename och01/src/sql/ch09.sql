--데이터 처리 문(Data Manupulation Language:DML)-데이터 관점
--데이터 입력
--insert into 테이블명(칼럼1,칼럼2,...) vlaues(값1,값2,값3,...);
create table dept_copy
as
select * from department where 1=0;--false조건
select * from dept_copy;

--데이터 입력
insert into dept_copy(dno,dname,loc) 
 values(10,'accounting','New York');
 --칼럼리스트 순서에 따라 값 순서대로 매칭되어 입력
insert into dept_copy(dname,dno,loc)
 values('research',20,'Dallas');
 
--칼럼전체에 맞게 값 입력시는 칼럼리스트 생략가능
insert into dept_copy values(30,'sales','L.A'); 
select * from dept_copy; 
 
--빈 값(null)을 가진 데이터 입력
--ORA-00947: not enough values
insert into dept_copy values(40,'operation'); 
--테이블 저체 칼럼개수보다 적은 값 입력시는 나머지는 null로 채움
insert into dept_copy values(40,'operation',null);
--null이 포함된 값 입력 시 칼럼리스를 표기하고 표기한 갯수만큼만 입력
insert into dept_copy(dno,dname) values(50,'manager');
select * from dept_copy;
 
--날짜데이터 입렵 시 날짜포맷'yy/mm/dd'로 입력하거나 to_date('날짜문자열')
--현재 날짜인 경우 sysdate로 대체
create table emp_copy
as
select * from employee where 1=0;--false조건
--날짜포맷문자열
insert into emp_copy 
values(7000,'candy','manager',7788,'2012/05/01',3000,0,10);
--to_date('날짜문자열')
insert into emp_copy 
values(7001,'choco','clerk',7788,to_date('2012/05/01'),3000,0,10);
--stysdate함수 이용한 값 입력
insert into emp_copy
values(7002,'cookie','sales',7788,sysdate,3000,0,10);
insert into emp_copy
values(7003,'jelly','manager',7788,trunc(sysdate,'dd'),3000,0,10);

--sub쿼리를 이용한 데이터 입력
--insert into 테이블명 subQuery;
insert into emp_copy
select * from employee;

select * from emp_copy;

--테이블 생성 시 칼럼 옵션추가 default값을 선언
drop table bb;
create table bb( 
seq number(2) primary key,   --기본키 설정
title varchar2(100) not null,--null방지 설정
content varchar2(4000),      --옵션없음
readcnt number(2) default 0, --값 미입력시 0으로 입력
regdate date default sysdate --값 미입력시 현재 날짜로 입력
);

select * from bb;
insert into bb(seq,title,content) values(1,'제목1','내용1');
insert into bb(seq,title,content,readcnt) values(2,'제목2','내용2',3);
insert into bb(seq,title,content,regdate) values(3,'제목2','내용2','2012/05/05');
insert into bb values(4,'제목2','내용2',5,'2012/05/07');

--테이블내에서 최대순번+1을 새로운 순번으로 추출
select nvl(max(seq),0)+1 seq from bb;

select * from bb order by seq;

--입력된 데이터 수정
--update 테이블명 set 칼럼1=값1,칼럼2=값2,...where 조건
select * from bb;
update bb set title='타이틀2'where seq=2;--seq는 수정 불가능
--4^4 16가지,title,content,readcnt,regdate,title-content,title-readcnt,title-regdate,title-content-readcnt,title-content-regdate,content-readcnt-regdate,content-regdate,readcnt-regdate
update bb set title = '타이틀3',content='content3' where seq=3;
update bb set title = '타이틀4',readcnt=5,regdate=sysdate where seq=3;
update bb set title = '타이틀5',readcnt=(select nvl(readcnt,0)+1 from bb where seq=5) ,regdate=sysdate where seq=5;
update bb set title='타이틀5',
  readcnt=readcnt+1,--칼럼의 현재 값 +1 한 결과를 다시 readcnt칼럼에 저장
  regdate=sysdate where seq=5;

select * from bb;

--테이블 칼럼 추가
alter table bb add good number default 0;
alter table bb add bad number default 0;

--숫자칼럼의 값 증가 처리 칼럼=칼럼+증가치
update bb set good = good+1 where seq=1;
update bb set bad = bad+1 where seq=3;

--칼럼 update 다른 테이블이 값으로 update
select * from dept_copy;
update dept_copy
     set dname=(select dname from department where dno=40),--서브쿼리(인라인뷰)
          loc=(select loc from department where dno=40)--서브쿼리(인라인뷰)
      where dno=50;
      
select * from dept_copy;

--데이터 삭제
--delete from 테이블명 where 조건
delete from dept_copy where dno=30;
commit;
select * from dept_copy;

select dno from department where dname='RESEARCH';
select * from department ;

--단일행 서브쿼리
delete from dept_copy where dno=(select dno from department where dname='RESEARCH');

--다중행 서브쿼리
delete from dept_copy where dno in (select dno from department);

select * from dept_copy;
--이전 상태로 되돌리기
rollback

--commit:테이블에 저장된 데이터 변화가 발생한 정보를 db에 저장하는 명령어
--rollback:commit이후 rollback명령어 실행시점까지의  변화된 정보를 commit시점까지 되돌림

create table stock(
item varchar2(30) primary key,
qty number default 0
);

create table bucket(
item varchar2(30) primary key,
qty number default 0
);

create table sale(
seq number primary key,
id varchar2(30), 
item varchar2(30),
qty number default 0,
sdate date default sysdate
);

select * from stock;
select * from bucket;
select * from sale;

delete from stock where item='mango';
delete from bucket ;
commit 
--재고등록
insert into stock values('apple',10);
commit
--장바구니 등록
insert into bucket values('apple',3);
select * from bucket;
--장바구나 수량변경
update bucket set qty=4 where item='apple';
select * from bucket;
--구매처리
insert into sale values(2,'hong','apple',(select qty from bucket where item='apple'),
                        sysdate);
select * from sale;
--장바구니 비우기
delete from bucket;
select * from bucket;
--재고처리                        
update stock set qty=qty-(select qty from bucket where item='apple')
       where item='apple';
select * from stock;
rollback
commit

select nvl(max(seq),0)+1) from sale;

--commit;  -insert,update,delete같은 일련의 작업 내용을 DB에 영구 저장명령어
--rollback;-insert,update,delete 같은 일련의 작업 내용을 이전 commit상태로 모두 되돌리는 명령어

commit
select * from bucket;--select는 트랜잭션 작업이 아님
select * from stock;
insert into bucket values('apple',5);
insert into stock values('banana',10);
commit--db에 저장
select * from bucket;--select는 트랜잭션이 아님
select * from stock; --select는 트랜잭션이 아님
commit--db에 저장된 시점
update bucket set qty=3 where item='apple';
update stock set qty=qty-(select qty from bucket where item='apple')
   where item='apple';
select * from bucket;
select * from stock;
rollback--이전상태(바로 앞의 commit 상태로 되돌리기)
select * from bucket;
select * from stock;

select * from bucket;
select * from sale;
delete bucket;
commit
select count(*) from stock where item='mango';

--savepoint: 트랜잭션 작업 기간을 세분화해서 처리
drop table dept;--commit명령어 없이 바로 db에 반영
create table dept as select * from department;--commit명령어 없이 바로 db에 반영
select * from dept;
delete from dept where dno=40;
commit--db에 반영
select * from dept;
delete from dept where dno=30;
savepoint s1;--savepoint지정 savepoint 세이브포인트명
delete from dept where dno=20;
select * from dept;
savepoint s2;--savepoint 세이브포인트명
delete from dept where dno=10;
select * from dept;
rollback to s2;--commit한 지점으로 데이터 되돌려지지만 to s2로 지정해주면 s2까지 되돌림
select * from dept;
rollback to s1;--save point s1까지 되돌리기
select * from dept;
rollback--전체되돌리기
select * from dept;--savepoint s1까지 되돌렸으므로 그 전으로는 돌아가지 못함.


--commit /rollback /savepoint
select * from dept;
delete from dept where dno=40;
select * from dept;
rollback
commit
--savepoint
alter table emp_copy disable constraint emp_copy_dno_fk;
alter table emp_sample disable constraint my_emp_dept_fk;
delete from dept where dno=40;
savepoint s1;
delete from dept where dno=30;
savepoint s2;
delete from dept where dno=20;
select * from dept;
rollback to s1;

create table test_save(
dno number primary key,
dname varchar2(20),
loc varchar2(20)
);
select * from test_save;
insert into test_save select * from department;
commit
select * from test_save;


