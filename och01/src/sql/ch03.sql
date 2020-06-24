--create table 테이블명(칼럼 속성);
create table board(
bno number primary key,--테이블의 주 키 선언
title varchar2(50),    --제목
content varchar2(1000),--내용
regdate date default sysdate --등록일자 default 값을 미입력시 기본값
);

-- data 입력
-- 값 입력 insert into 테이블 values(값1,값2,값3,...);
insert into board values(1,'타이틀1','자유게시판 글 등록1',sysdate);
insert into board values(2,'타이틀2','자유게시판 글 등록2',sysdate);

-- 값 입력 insert into테이블(칼럼1,칼럼2,칼럼3) values(값1,값2,값3,...);
insert into board(bno,title,content) values(3,'타이틀3','자유게시판 글 등록3');

--select
select * from board;
-- where 칼럼 like '%값%';
select * from board where title like '%틀%';
select * from board where content like '%판%';
select * from board where title like '%타이틀%';

--order by 절, 정렬
select * from employee order by eno asc;--정렬 오름차순 기준,eno,asc기준
select * from employee order by eno desc;--정렬 내림차순, 기준 eno,
select * from employee order by salary asc;--정렬 오름차순 기준 salary;
select * from employee order by salary desc;--정렬 내림차순 기준 salsry;
--문자 - 사전순
select * from employee order by ename asc;--정렬 오름차순 기준ename;
select * from employee order by ename desc;--정렬 내림차순 기준 ename;
--날짜 -날짜순
select * from employee order by hiredate asc;--정렬 오늘차순 기준 hiredate;
select * from employee order by hiredate desc;--정렬 내림차순 기준 hiredate;

--정렬 조건이 2개 이상, 큰조건 먼저, 다음 조건순으로 ,로 표시 
select * from employee order by dno asc, salary asc;--부서번호 오름차순, 급여 오름차순
select * from employee order by dno asc, salary desc;--부서번호 오름차순, 급여 내림차순
--칼럼에 값이 null이 포함되어있는 경우는 asc(오름차순)-마지막, desc(내림차순)-먼저나옴
select * from employee order by commission desc;
