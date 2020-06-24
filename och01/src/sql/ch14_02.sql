--ex1. if문을 사용하여 king사원의 부서번호를 얻어와서 부서명 출력
declare--선언부
v_dname department.dname%type;
v_dno department.dno%type;
begin--실행부
	select dno
	into v_dno
	from employee
	where ename=upper('king');
	if v_dno=10 then
	  v_dname:='ACCOUNT';
	elsif v_dno=20 then
	  v_dname:='RESEARCH';
	elsif v_dno=30 then
	  v_dname:='SALES';
	elsif v_dno=40 then
	  v_dname:='OPERATION';
	end if;
	dbms_output.put_line('king의 부서번호는 '||v_dno||' '||'부서명은'||v_dname);
end; 
/

--ex2.basic loop 1~10사이의 자연수 합 구하기
declare--선언부
tot number :=0;
n number :=1;
begin--실행부
	loop--basic loop
	tot :=tot+n;
	n:=n+1;
	if n>10 then--loop 빠져나가는 조건
      exit;--loop 빠져나가는 명령문
	end if;
	end loop;
	dbms_output.put_line('총합:'||tot);
end; 
/

--ex3. for loop 1..10 합
declare--선언부
tot number :=0;
begin--실행부
	for i in 1..10 loop --for 변수 in 하한..상한 loop
      tot := tot+i;
	end loop;
	
	dbms_output.put_line('총합:'||tot);
end; 
/
--ex4. while loop 1 ~ 10까지 자연수 합
declare
n number:=1;
tot number:=0;
begin
	while n<=10 loop
	   tot :=tot+n;
	   n:=n+1;
	end loop;
	
	dbms_output.put_line('총합'||tot);
end; 
--10까지의 자연수 중 짝수의 합
declare
n number:=1;
tot number:=0;
begin
	while n<=10 loop
	  if mod(n,2)=0 then--mod(피젯수,제수) 나머지 
	   tot :=tot+n;
	  end if;
	   n:=n+1;
	end loop;
	
	dbms_output.put_line('총합'||tot);
end; 

--ex5. 사원 테이블에서 커미션이 null이 아닌 상태의 사원번호,이름,급여를 기준 오름차순 정렬결과
select eno,ename,salary from employee order by eno;
declare
v_emp employee%rowtype;
--1.커서 생성
cursor c1 is select * from employee where commission is not null;
begin
	dbms_output.put_line('사번    이름   급여');
	dbms_output.put_line('--------------------');
	open c1;--2.커서 오픈
	loop
	fetch c1 into v_emp;--3.fetch
	exit when c1%notfound;
	dbms_output.put_line(v_emp.eno||' '||v_emp.ename||' '||v_emp.salary);
	end loop;
	close c1;--4.커서 닫기
end; 

































