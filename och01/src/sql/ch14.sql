--pl/sql
--절차적 프로그래밍 기능의 sql문
--선언문, 실행부, 예외부로 구성
set serveroutput on
begin
	dbms_output.put_line('Welcome to Oracle');
end ;

SQL> show user;
USER is "USERTEST01"
SQL> connect hr/hr
Connected.
SQL> begin
  2  dbms_output.put_line('welcome to oracle');
  3  end;
  4  /

PL/SQL procedure successfully completed.

SQL> set serveroutput off
SQL> /

PL/SQL procedure successfully completed.

SQL> show user;
USER is "HR"
SQL> set serveroutput on
SQL> declare  --선언부
  2  v_eno number(4);--스칼라타입
  3  v_ename varchar2(20);
  4  begin  --실행부
  5  v_eno :=7788;--변수:=값;
  6  v_ename :='scott';
  7  dbms_output.put_line('사원번호 사원이름');
  8  dbms_output.put_line('-----------------');
  9  dbms_output.put_line(v_eno||'    '||v_ename);
 10  end;
 11  /
사원번호 사원이름
-----------------
7788    scott

SQL> ed--위에 잘못적었을때 
Wrote file afiedt.buf

--참조변수 선언
set serveroutput on
  1  declare
  2  v_eno employee.eno%type;--employee테이블의 eno타입 참조
  3  v_ename employee.ename%type;--employee테이블의 ename타입 참조
  4  begin
  5  v_eno:=7788;
  6  v_ename:='scott';
  7  dbms_output.put_line('사원번호  사원명');
  8  dbms_output.put('----------------');--put()한 줄 출력 후 해당라인에 멈춤
  9  dbms_output.put_line(' ');--출력 후 다음라인
 10  dbms_output.put_line(v_eno||'  '||v_ename);
 11* end;
 /

set serveroutput on
declare
v_eno employee.eno%type;
v_ename employee.ename%type;
begin
	dbms_output.put_line('사원번호 사원명');
	dbms_output.put_line('-----------');
	
	select eno,ename
	into v_eno, v_ename --select한 결과를 변수에 저장
	from employee
	where ename=upper('scott');
	
	dbms_output.put_line(v_eno||'  '||v_ename);
end;

--사번이 7788인 사원의 사원명, job,salary,hiredate를 출력하는 pl/sql문 작성
--선언부
declare
v_ename varchar2(20);
v_job employee.job%type;
v_salary employee.salary%type;
v_hiredate date;
--실행부
begin
	--dbms_output.put_line('사원명 직업 급여 날짜');
	dbms_output.put_line('------------------------');
	
	select ename,job,salary,hiredate
	into v_ename, v_job, v_salary, v_hiredate
	from employee
	where eno=7788;
	
	dbms_output.put_line('이름:'||v_ename);
	dbms_output.put_line('직책:'||v_job);
	dbms_output.put_line('급여:'||v_salary);
	dbms_output.put_line('입사일:'||v_hiredate);
    --dbms_output.put_line(v_ename||' '||v_job||' '||v_salary||' '||v_hiredate);
end ;	

--structure|recored타입 변수
declare
v_empinfo employee%rowtype;
--실행부
begin	
	select *
	into v_empinfo
	from employee
	where eno=7788;
	
	dbms_output.put_line('이름:'||v_empinfo.ename);
	dbms_output.put_line('직책:'||v_empinfo.job);
	dbms_output.put_line('급여:'||v_empinfo.salary);
	dbms_output.put_line('입사일:'||v_empinfo.hiredate);
    --dbms_output.put_line(v_ename||' '||v_job||' '||v_salary||' '||v_hiredate);
end ;

select * from employee where eno=7788;

--제어문 if-elseif-else  -end if;
declare --선언부
v_employee employee%rowtype;
temp number(4):=1;
annsal number(7,2);--전체 자리수가 7자리, 소수점 자리수 2자리, 정수자리 4자리
begin--실행부
	select *
	  into v_employee
	  from employee
	  where ename=upper('scott');
	  
	  --if 조건 than 실행문; end if;
	  if(v_employee.commission is null) then
	     v_employee.commission :=0;
	     end if;
	     
	     annsal := v_employee.salary*12 + v_employee.commission;
	     dbms_output.put_line('사원번호 사원이름   연봉');
	     dbms_output.put_line('-------------------------');
	     dbms_output.put_line(v_employee.eno||'      '||v_employee.ename||'     '||annsal);
end; 
/

--if ~ elseif ~ end if;
declare
v_eno employee.eno%type;
v_ename employee.ename%type;
v_dno employee.dno%type;
v_dname department.dname%type;
begin--실행부
	select eno,ename,dno
	into v_eno,v_ename,v_dno
	from employee
	where ename=upper('scott');
	
	if(v_dno=10) then  --값 비교 : v_dno = 값
	v_dname := 'Accounting';--값 저장 : v_dname :=값
	elsif v_dno=20 then
	v_dname :='Research';
	elsif v_dno=30 then
	v_dname :='Sales';
	elsif v_dno=40 then
	v_dname :='Operation';
	end if;
	
	dbms_output.put_line('사번   이름   부서명');
	dbms_output.put_line(v_eno||' '||v_ename||' '||v_dname);
end ;
/

--loop문
--반복문
declare--선언부
v_dan number :=2;--변수선언 및 값 초기화
v_i number:=1;
begin
	loop
	dbms_output.put_line(v_dan || '*'||v_i||'='||(v_dan*v_i));--세로
	v_i:= v_i+1;--증가식
	if v_i>9 then
	    exit;
	end if;
	end loop;	
end;


declare--선언부
v_dan number :=2;--변수선언 및 값 초기화
v_i number:=1;
begin
	loop
	dbms_output.put(v_dan || '*'||v_i||'='||(v_dan*v_i)||' , ' );--가로
	v_i:= v_i+1;--증가식
	if v_i>9 then
	    exit;
	end if;
	end loop;	
	dbms_output.put_line('');
end;
/

--for loop
declare
dan number:=2;--변수 선언 및 초기화, 변수:=값;
i number:=1;--변수:=값;
begin--실행부
	for i in 1..9 loop--for 변수 in 하한..상한 loop
	dbms_output.put(dan||'*'||i||'='||(dan*i)||' ');--가로로 출력하고 싶을땐 put_line에서 _line을 뺴준다-한 줄 출력put()
  end loop;
    dbms_output.put_line('');--_line을 뺄 땐 공백을 넣어줘야 출력가능
end;                         -- put()함수의 내용 출력하기 위해 pu_line()추가

--구구단 이준 loop
declare
dan number:=2;
i number:=1;
begin
	for dan in reverse 2..9 loop--for 변수 in 하한..상한 loop
	for i in 1..9 loop  --for 변수 in 하한..상한 loop
	dbms_output.put(dan||'*'||i||'='||(dan*i)||' ');
	end loop;
	dbms_output.put_line('');
	end loop;
end ;

--while 반복문
--while 조건 loop ~~~ end loop
set serveroutput on
declare--선언부
dan number:=2;
i number:=1;--초기값
begin--실행부
	while i<=9 loop
	dbms_output.put(dan||'*'||i||'='||(dan*i)||' ');
	i:=i+1;--증가식 변수:=증가값
	end loop;
	dbms_output.put_line('');
end; 

--이중 while문
declare--선언부
dan number:=2;
i number:=1;--초기값
begin--실행부
    while dan<=9 loop
	while i<=9 loop
	dbms_output.put(dan||'*'||i||'='||(dan*i)||' ');
	i:=i+1;--증가식 변수:=증가값
	end loop;
	dbms_output.put_line('');
	dan:=dan+1;--증가식 변수:=증가값
	end loop;--안쪽 반복문 변수 값 1로 초기화
end; 

--cursor 커서명 is select문;
--여러행의 데이터를 한번에 처리하는 객체
declare--선언부
v_dept department%rowtype;--참조타입 dno,dname,loc 값을 저장
--cursor변수 is 쿼리문;
cursor c1 is select * from department;--커서생성
begin--실행부
    dbms_output.put_line('부서번호    부서명    지역명');
    dbms_output.put_line('----------------------------');
	open c1;--커서 오픈
	if not c1%isopen--오픈이면 true,아니면 false
	open c1;
	dbms_output.put_line('c1열기');
	else
	dbms_output.put_line('c1 오픈됨');
	end if;
	loop
	dbms_output.put_line('실행된 건 수:'||c1%rowcount);--rowcount 실행건수
	fetch c1 into v_dept.dno, v_dept.dname, v_dept.loc;
	exit when c1%notfound;--반복문 빠져나가는 조건
    dbms_output.put_line(v_dept.dno||' '||v_dept.dname||' '||v_dept.loc);
    if c1%found then;--레코드 조회되는지 여부 조회되면 true, 아니면 false
	         dbms_output.put_line('레코드 있음');
	         end if;
    end loop;
	close c1;--커서  닫기
end;

select * from department;

--open문, fetch문 생략->for loop문으로 처리
declare--선언부
v_dept department%rowtype;
cursor c1
is
select * from department order by dno;
begin--실행부
	dbms_output.put_line('부서번호   부서명   지역명');
	dbms_output.put_line('---------------------------');
	--open c1;
	for v_dept in c1 loop--커서 c1 자동 오픈, fetch자동 실행
	exit when c1%notfound;
	dbms_output.put_line(v_dept.dno||' '||v_dept.dname||' '||v_dept.loc);
	end loop;
end; 





