--문자열함수
--1.대소문자 변환 함수 lower,upper,initcap
select 'Oracle Mania',
       upper('Oracle Mania'),
       lower('Oracle Mania'),
       initcap('Oracle Mania')
from dual;

select eno, initcap(ename), dno from employee where job = upper('manager');--대문자 비교

select eno, initcap(ename), dno from employee where lower(job) = 'manager';--소문자비교

--2. 문자길이 확인 length(),lenthb()
--length(글자갯수)
select 'Oracle Mania', length('Oracle Mania'), length('오라클 매니아')
   from dual;
--lengthb(글자바이트수)
select 'Oracle Mania',lengthb('Oracle Mania'),lengthb('오라클 매니아') 
   from dual;
   
select * from employee where length(ename)=4;--조회조건 -이름의 길이가 4인 사원   
   
--3.문자결합 함수-concat(문자1,문자2), 문자결합연산자(||)
select 'Oracle','mania', concat('Oracle','mania'), 'Oracle'||'mania'
   from dual;
   
select 'hello ','i am ',' dooly',concat(concat('hello ','i am '),' dooly'),
   concat(concat(concat(concat('hi ','i'),' am'),' a ')' boy'),
   'hello '||'i am '||' dooly'
   from dual;
   
--4. 문자열 추출함수 substr(대상,시작,갯수)
select substr('Oracle Mania',4,3)--오라클 db의 index번호는 1부터 시작,
   from dual;
 select substr('Oracle Mania',-4,3)--오라클 db의 index번호-이면 뒤부터 시작,
   from dual;
   
--이름이 N으로 끝나는 사원
select * from employee where substr(ename,-1,1)='N';--ename의 마지막 단어가
select * from employee where ename like '%N';
--87년도에 입사한 사원
select * from employee where substr(hiredate,1,2)='87';

--문자추출 substr(대상,시작,갯수)
select substr('Oracle mania',4,3),substrb('Oracle mania',4,3)
   from dual;
select substr('오라클매니아',3,4),substrb('오라클매니아',3,4)
   from dual;
   
--대상문자열에서 찾을 문자의 위치 번호 instr(대상,문자,시작,몇 번째)
select instr('Oracle Mania','a'),--대상문자에서 'a'의 첫번째 위치3
       instr('Oracle Mania','a',2),--대상문자에서 2번째 인덱스부터 시작하여 찾은 'a'의 위치
       instr('Oracle Mania','a',5,1),--대상문자에서 인덱스 5번부터 시작하여 찾은 첫번째'a'의 위치
       instr('Oracle Mania','a','f')--대상문자에서 'f'를 찾지 못했을 경우 0 
       from dual;
       
select instrb('Oracle Mania','a'),--대상문자에서 'a'의 첫번째 위치3
       instrb('Oracle Mania','a',2),--대상문자에서 2번째 인덱스부터 시작하여 찾은 'a'의 위치
       instrb('Oracle Mania','a',5,1),--대상문자에서 인덱스 5번부터 시작하여 찾은 첫번째'a'의 위치
       instrb('Oracle Mania','a','f')--대상문자에서 'f'를 찾지 못했을 경우 0 
       from dual;
 
--이름에 'A'가 포함된 조건       
select * from employee where instr(ename,'A')>0;--조건 instr(칼럼,'패터')
--이름에 'A'가 포함되지 않는 조건
select * from employee where instr(ename,'A')=0;--조건 instr(칼럼,'패터')

--LPAD(대상,전체길이,패턴),RPAD(대상,전체길이,패턴)
select eno,ename,lpad(salary,10,'*') from employee order by eno; 
select eno,ename,rpad(salary,10,'*') from employee order by eno;

--TRIM() 공백제거
select ' Oracle Mania ', length(' Oracle Mania '),
       ' Oracle Mania ', length(trim(' Oracle Mania '))
    from dual;

--trim('자를문자' from'문자열')    
select 'Oracle Mania', trim('O' from 'Oracle Mania'),--단어의 왼쪽끝 단어 제거
       trim('a' from 'Oracle Mania'),--오른쪽 끝 단어 제거
       trim('c' from 'Oracle Mania')--문장 중간의 단어 제거 불가
from dual;

select eno, initcap(ename), initcap(job)
    from employee
  where job =UPPER(trim(' Manager '));--조회조건 값 양쪽에 공백이 있을때 제거

--replace(대상문자,'구문자','변환문자')
select 'Oracle mania', replace('Oracle mania','a','i') from dual;
--숫자함수
--round(숫자,자리수)
select 98.7654, 
       round(98.7654),  --반올림 
       round(98.7654,2),--소수 2번째자리까지 반올림
       round(98.7654,-1)--1의 자리 반올림
  from dual;
  
select 98.7654,
       trunc(98.7654),  --버림
       trunc(98.7654,2),--소수점 2자리까지 버림
       trunc(98.7654,-1)--1의자리 버림
    from dual;
    
select 98.7654,
       ceil(98.4544)  --올림
       --ceil(98.7654,2),--소수점 2자리까지 올림
       --ceil(98.7654,-1)--1의자리 올림
    from dual;

--나머지 구하는 함수 mod(피제수,제수)    
select mod(10,2),10/2
   from dual;
select '10을 2로 나누면 몫이'||(10/2)||'이고, 나머지가'||mod(10,2)||'이다.'
   from dual;
   
select concat(concat(concat('10을 2로 나누면 몫이',(10/2)),
       concat('이고, 나머지가',mod(10,2))),'이다.')
   from dual;
  
--sign은 부호함수(-1,0,1), abs()절대값 함수
select sign(-5), sign(5), sign(0),abs(-5)
    from dual;

--floor(실수) - 가장 가까운 정수, power(밑수,승수) = 밑수^승수
select floor(12.345), floor(12.765),
       power(3,2),power(2,4) from dual;
       
--날짜함수
--현재날짜 함수 sysdate
select sysdate from dual;
--날짜 연산
select sysdate-1 어제,--sysdate +|-숫자(날짜기준)
       sysdate 오늘,
       sysdate+1 내일,
       sysdate+2 모레
    from dual;
    
--두 날짜 사이의 개월 수 months_between(날짜1,날짜2)
select sysdate, round(months_between(sysdate,sysdate-100)),sysdate-100 from dual;

select eno, initcap(ename),hiredate, 
       round(months_between(sysdate,hiredate)), 
       round(months_between(sysdate,hiredate)/12) 
       from employee;
       
--특정 날짜에 개월 수 더하기 add_months()
select sysdate, add_months(sysdate,2),
       add_months(sysdate,-2) from dual;
       
--특정월의 마지막 날짜 last_day(날짜)
select sysdate,last_day('20/05/23'),
       last_day(add_months(sysdate,-3)) from dual;
       
--특정날짜에서 최초로 도래하는 인자로 받은 요일의 날짜 next_day()
select sysdate, 
       next_day(sysdate,'월요일'),--요일이 지났으면 다음주의 해당요일 날짜
       next_day(sysdate,'토요일') --요일이 아직 안지났으면 이번주의 해당요일날짜
       from dual;   

--날짜 반올림 round() 사용 포맷   
select round(sysdate), sysdate from dual; 

select round(sysdate,'CC'),   --세기
       round(sysdate,'yyyy'), --년도
       round(sysdate,'d'),    --주시작
       round(sysdate,'dd'),   --날짜 
       round(sysdate,'hh'),   --시간
       round(sysdate,'q'),    --분기(해당분기 둘째달의 16일 이후 반올림)-다음분기
       round(sysdate,'month'),--월(해당월 16일 이후 반올림)
       round(sysdate,'day'),  --주시작
       round(sysdate,'mi')    --분 기준(31초 이후 반올림)
 from dual;      
       
select trunc(sysdate,'CC'),   --세기
       trunc(sysdate,'yyyy'), --년도
       trunc(sysdate,'d'),    --주시작
       trunc(sysdate,'dd'),   --날짜 
       trunc(sysdate,'hh'),   --시간
       trunc(sysdate,'q'),    --분기(달버림)-해당분기 시작일
       trunc(sysdate,'month'),--월(해당월 1일)
       trunc(sysdate,'day'),  --주시작
       trunc(sysdate,'mi')    --분 기준
 from dual; 
 
--변환 함수
--to_char(), to_date(), to_number()
--to_char(날짜,'출력형식')
select sysdate, 
       to_char(sysdate,'yyyy'), to_char(sysdate,'yy'), --년도
       to_char(sysdate,'mm'), to_char(sysdate,'mon'),  --월
       to_char(sysdate,'day'), to_char(sysdate,'dy'), --요일
       to_char(sysdate,'d'), to_char(sysdate,'dd'), --일
       to_char(sysdate,'yyyy-mm-dd day'),
       to_char(1234,'99999'),  --숫자
       to_char(1234,'09999'),  --빈 공간 채우기
       to_char(1234,'$9999'),  --$로 시작
       to_char(1234,'9999,99'),--,로 구분
       to_char(1234,'9999.99') --소수점 표시
   from dual;
   
select eno,ename,hiredate from employee 
       where to_char(hiredate,'yy')=87;--substr(hiredate,1,2)='87'

--문자열로 주어진 값을 날짜타입으로 변경 to_date(문자열,포맷)      
select to_date('20200526','yyyymmdd'),--to_date('문자열',포맷)
       to_date('20200526','yyyy-mm-dd'),
       to_date('2020-05-26','yyyy-mm-dd'),
       to_date('20200526'),--to_date('문자열')
       to_date('20-05-26')--to_date('문자열')
       --to_date('2020-05-26','yyyymmdd')--날짜 포맷 오류
    from dual;
     
select eno, ename, hiredate from Employee where hiredate>=to_date('19870101');--날짜로 변환해 비교

--숫자로 변환 함수 to_number()
--to_number('문자열','포맷')
select --'10,000'-'5,000' to_number('10,000')-to_number('5,000') 
       to_number('10000') -to_number('5000'),
       to_number('100,000','999,999')-to_number('50,000','999,999'),
       to_number(to_char(last_day(sysdate),'dd')),--숫자
       -to_number(to_char(last_day(sysdate),'dd'))
       from dual;

--NULL값 처리함수
--NVL(),NVL2(),NULLIF(), COALESCE()
--nvl(값,대체값)
select commission, nvl(commission,0) from employee;

--nvl(값, null이 아닌경우, null인 경우)
select ename, salary,commission, 
      nvl2(commission,salary*12+commission, salary*12),
      salary*12+commission
      from employee;

select ename, nullif(dno,10),dno from employee;

--nullif(첫번째값,두번째값) 첫 번째 값과 두 번째 값이 같으면 null, 다르면 첫 번째 값 출력
select nullif('A','A'), nullif('B','A') from dual;

--coalesce(값1,값2,값3,...) 첫 번째로 null이 아닌 값
select coalesce(null,1,2), coalesce(null,null,1,2),
       coalesce(null,null,1,2,null) from dual;
       
--  decode(값,case1,case1값, case2,case2값,..,defaut값)
select dno, decode(dno,10,'회계부서',20,'연구부서',30,'영업부서',40,'관리부서')
   as dname from department;
--decode
select salary, round(salary/1000)
       decode(round(salary/1000),1,'C',2,'B',3,'A',5,'S','K') from employee order by salary;
   
select 'private '|| decode(data_type,'VARCHAR2','String','NUMBER','int','DATE','Date',data_type)
       ||' '||lower(column_name) from cols where table_name='BOARD'; 
       
select * from cols;--접속한 계정(hr)의 테이블 칼럼 정보를 저장하는 레이블

--case when 조건 then 값
select dno,dname,case dno when 10 then '회계' --칼럼 when값 then결과
                          when 10 then '연구' 
                          when 30 then '영업' 
                          when 40 then '관리' 
                          else '기타'  
                          end as dname
   from department;
   
select dno,dname,case    when dno=10 then '회계' --when식 then결과
                         when dno=10 then '연구' 
                         when dno=30 then '영업' 
                         when dno=40 then '관리' 
                         else '기타'  
                         end as dname
   from department;

-- if~else  if~ else   
select case when 76>=90 then 'A'
            when 76>=80 then 'B'
            when 76>=70 then 'C'
            else 'F'
            end as score
        from dual;