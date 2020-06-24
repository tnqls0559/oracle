--정규표현식 -10g
select * from t_reg;
select * from t_reg where regexp_like(text,'[a-z]');--소문자포함행
select * from t_reg where regexp_like(text,'[A-Z]');--대문자포함행
select * from t_reg where regexp_like(text,'[a-zA-Z]');--대/소문자 포함행
select * from t_reg where regexp_like(text,'[a-z] ');--소문자로 시작하고 뒤에 공백
select * from t_reg where regexp_like(text,'[a-z] [0-9]');--소문자로 시작하고 중간에 공백 다음 숫자
select * from t_reg where regexp_like(text,'[[:space:]]');--공백이 있는 모든행
select * from t_reg where regexp_like(text,'[A-Z]{2}');--대문자 2개 이상 연속
select * from t_reg where regexp_like(text,'[A-Z]{3}');--대문자 3개 이상 연속
select * from t_reg where regexp_like(text,'[A-Z]{4}');--대문자 4개 이상 연속
select * from t_reg where regexp_like(text,'[0-9]{3}');--숫자 3개 이상 연속
select * from t_reg where regexp_like(text,'[A-Z][0-9]{3}');--대문자 3개 이상이고 숫자 3개 이상 연속
select * from t_reg where regexp_like(text,'[A-Z]');--대문자 포함
select * from t_reg where regexp_like(text,'[[:upper:]]');--대문자 포함
select * from t_reg where regexp_like(text,'^[A-Za-z]');--대/소문자로 시작
select * from t_reg where regexp_like(text,'^[0-9A-Z]');--숫자/대문자로 시작
select * from t_reg where regexp_like(text,'^[a-z]|^[0-9]');--소문자나 숫자로 시작
select * from student where regexp_like(id,'^M(a|o)');--M으로 시작하는 주 번째 글자는 'a'나 'o'인 id
select * from t_reg where regexp_like(text,'[a-zA-Z]$');--대/소문자로 끝
select * from t_reg where regexp_like(text,'[[:alpha:]]$');--대/소문자로 끝
select * from t_reg where regexp_like(text,'^[^a-z]');--소문자가 제외단어로 시작
select * from t_reg where regexp_like(text,'^[^0-9]');--숫자 제외 단어로 시작
select * from t_reg where regexp_like(text,'^[^0-9a-z]');--숫자/소문자 제외
select * from t_reg where not regexp_like(text,'[a-z]');--소문자 포함행 제거

select * from student where regexp_like(tel,'^[0-9]{2}\)[0-9]{4}');--숫자2개)숫자4개
select * from student where regexp_like(id,'...r.');--4번째 이상 r포함 
select * from t_reg2 where regexp_like(ip,'^[10]{2}\.[10]{2}\.[10]{2}');--ip주소가 10.10.10.1인 행
select * from t_reg2 where regexp_like(ip,'[172]{3}\.[16]{2}\.[168]{3}');--ip주소가 172.16.168.xxx 

select * from t_reg where regexp_like(text,'!');--특수문자
select * from t_reg where regexp_like(text,'?');--와일드카드문자
select * from t_reg where regexp_like(text,'*');--와일드카드문자
select * from t_reg where regexp_like(text,'\?');--\?-'?'가 포함된 행
select * from t_reg where regexp_like(text,'\*');--'*'가 포함된 행
select * from t_reg where not regexp_like(text,'\?');--\?-'?'가 제외된 행

-- regexp_replace(대상,패턴)
select text, regexp_replace(text,'[[:digit:]]','*')--숫자->'*'
  from t_reg;
select text, regexp_replace(text,'([0-9])','\1-*')--숫자뒤에 -*추가
  from t_reg;
select regexp_replace('aaa bbb','( ){1,}','') 
  from dual;
select regexp_replace('aaa bbb','( ){2,}','')"one",
       regexp_replace('aaa  bbb','( ){2,}','')"two"
  from dual;
select regexp_replace('aaa bbb','( ){2,}','*')"one",
       regexp_replace('aaa  bbb','( ){2,}','*')"two",--공백을 '*'로 치환
       regexp_replace('aaa   bbb','( ){2,}','*')"three"  --공백을 '*'로 치환
  from dual;

select regexp_replace('20141023','([[:digit:]]{4})([[:digit:]]{2})([[:digit:]]{2})','\1-\2-\3')
  from dual;

--문자추출 함수 regexp_substr()
select regexp_substr('ABC* *DEF $GHI%KJL','[^ ]+[DEF]')
  from dual;
  
select name, ltrim(regexp_substr(hpage,'/([[:alnum:]]+\.?){3,4}?'),'/') url 
  from professor
where hpage is not null;

-- 문자 포함갯수 함수 regexp_count --11g
select text, regexp_count(text,'c',3) from t_reg;--3번째 문자 이후 'c'가 포함된 갯수
select text, regexp_count(text,'A') from t_reg;--'A'가 포함 갯수
