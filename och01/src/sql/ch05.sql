select * from DEPARTMENT;
--두 테이블의 행수끼리 곱한 행, employee:14행, department:4, 14*4=56;
--카티션곱
select * from employee,department order by employee.dno,eno;

--join,
--두 테이블의 칼럼이 같은 것끼리 추출
select * from employee,department
where employee.dno=department.dno
order by employee.dno,eno;

--ORA-00918: column ambiguously defined
select eno,ename, employee.dno,dname--병합된 행중에서 필요한 칼러만 추출
       from employee,department
       where employee.dno=department.dno--칼럼이 맞는 것끼리 병합,추출
       order by employee.dno,eno;
       
--테이블에 별칭: 테이블명 별칭
select eno "사번", ename "이름", e.dno "부서", dname "부서명"
     from employee e, department d--별칭 임의의 이름
   where e.dno=d.dno
   order by e.dno, eno;
   
--where 조건
select eno, ename, e.dno, dname
       from employee e, department d
       where e.dno=d.dno--조인조건
       and e.eno=7788   --개별데이터 추출 조건
       order by e.dno, eno;
   
--natural join --dbms가 동일한 칼럼을 찾아서 equi-join을 함.
select eno, ename, dno, dname
       from employee e natural join department d
       where e.eno=7788;

-- from 테이블1 join 테이블2 using(공통칼럼)
select eno,ename,dno,dname
       from employee e join department d using(dno)
       where e.eno=7788;
       
-- from 테이릅
select eno,ename,e.dno,dname  --테이블면.공통칼럼
       from employee e join department d on e.dno=d.dno
       where e.eno=7788;
       
--non-equi-join
select * from salgrade;

select eno, case when salary>=700 and salary<=1200 then '1'
                 when salary>=102 and salary<=1400 then '2'
                 when salary>=1401 and salary<=2000 then '3'
                 when salary>=2001 and salary<=3000 then '4'
                 when salary>=3001 and salary<=9999 then '5'
                end as grade
           from employee
           order by eno;

-- 하나의 칼럼에 두 개의 조건(범위)로 조인 - non-equi-join
select eno, salary, grade
   from employee e, salgrade s
  where salary between losal and hisal;
  
select eno, salary, grade
   from employee e, salgrade s
  where salary >=losal and salary<=hisal--범위
;

create table sg(
grade varchar2(10),
low   number(3),
hi    number(3)
);
create table st(
sno number primary key,
name varchar2(50),
score number(3)
);

insert into sg values('A',90,100); 
insert into sg values('B',80,89);
insert into sg values('C',70,79);
insert into sg values('F',0,69);
--점수
insert into st values(1,'홍길동',87);
insert into st values(2,'일지매',95);
insert into st values(3,'임꺽정',59);
   
select * from sg;
select * from st;

--비 동등 조인
select sno,name,score,grade
   from st,sg
   where score between low and hi;
   
select * from locations;--주소테이블
select * from REGIONS;--지역테이블
select * from countries;--국가테이블
select * from employees;--사원테이블
select * from departments;--부서테이블

--A->B , B->C :A->C
select employee_id, first_name,last_name,salary,
    e.department_id,
    d.department_name,
    d.location_id,
    l.street_address,
    l.city,
    l.country_id,
    c.country_name,
    c.region_id,
    r.region_name
    from departments d,employees e, countries c, locations l, regions r
    where e.department_id=d.department_id
    and d.location_id=l.location_id
    and l.country_id=c.country_id
    and c.region_id=r.region_id
    order by c.region_id,l.country_id, e.department_id, employee_id
    ;
    
 select e.ename,d.dname,salary,grade
    from employee e, department d,salgrade s
    where e.dno=d.dno
    and salary between losal and hisal;
    
--self-join: 하나의 테이블을 별칭을 다르게 부여하여 join하는 방식
--계층구조로 만들어진 테이블에 적용.
select a.eno "사번",a.ename "이름",a.manager "관리자",b.ename "관리자명"
     from employee a, employee b
     where a.manager=b.eno;

drop table stud;
create table stud(
sno number primary key,
name varchar2(50),
year number,
mento number
);
select * from stud;
insert into stud values(1,'홍길동',1,3);
insert into stud values(2,'일지매',1,4);
insert into stud values(3,'임꺽정',2,5);
insert into stud values(4,'이순신',3,5);
insert into stud values(5,'김길동',4,null);
     
select a.sno, a.name, a.year, a.mento, b.name
    from stud a, stud b
 where a.mento = b.sno;

--outer-join null 값이 있는 칼럼도 보여주는 경우 (+) 기호로 표시
select * from stud a, stud b where a.mento=b.sno(+);

select * 
   from employee a, employee b
   where a.manager=b.eno(+);--비어있는 칼럼이 있는 겨우 조회시

select * from department;
select *
   from employee a, department b
   where a.dno(+) = b.dno;

--ansi join : left outer join on 조건
select *
   from employee a left outer join employee b
   on a.manager=b.manager
   ;
   
   
   