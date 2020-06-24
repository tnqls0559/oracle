--권한(privilege),


SQL*Plus: Release 11.2.0.2.0 Production on 화 6월 2 12:28:52 2020

Copyright (c) 1982, 2014, Oracle.  All rights reserved.

SQL> connect sys as sysdba
Enter password:
Connected.
SQL> create user usertest01
  2  identified by pass1
  3  default tablespace users
  4  temporary tablespace temp
  5  quota unlimited on users
  6  ;

User created.

SQL> connect usertest01/pass1
ERROR:
ORA-01045: user USERTEST01 lacks CREATE SESSION privilege; logon denied


Warning: You are no longer connected to ORACLE.
SQL> grant create session to usertest01;
SP2-0640: Not connected
SQL> show user
USER is ""
SQL> connect sys as sysdba
Enter password:
Connected.
SQL> grant create session to usertest01;

Grant succeeded.

SQL> connect usertest01/pass1
Connected.
SQL> select * from hr.employee
  2  ;
select * from hr.employee
                 *
ERROR at line 1:
ORA-00942: table or view does not exist


SQL> connect hr/hr
Connected.
--객체 소유자가 객체 권한을 다른 유저에게 부여
SQL> grant select on employee to usertest01;

Grant succeeded.

SQL> select eno,ename,hiredate from hr.employee where eno=7788;

       ENO ENAME                HIREDATE
---------- -------------------- --------
      7788 SCOTT                87/07/13

SQL> connect usertest01/pass1
Connected.
SQL> select eno,ename,hiredate from hr.employee where eno=7788;

       ENO ENAME                HIREDATE
---------- -------------------- --------
      7788 SCOTT                87/07/13
--권한회수
SQL> connect sys as sysdba
Enter password:
Connected.
SQL> show user
USER is "SYS"
SQL> revoke create session from usertest01;

Revoke succeeded.

SQL> connect usertest01/pass1
ERROR:
ORA-01045: user USERTEST01 lacks CREATE SESSION privilege; logon denied


Warning: You are no longer connected to ORACLE.
SQL> create user usertest02
  2  identified by pass2
  3  default tablespace users
  4  temporary tablespace temp
  5  quota unlimited on users;
SP2-0640: Not connected
SQL> connect sys as sysdba
Enter password:
Connected.
SQL> create user usertest02
  2  identified by pass2
  3   default tablespace users
  4  temporary tablespace temp
  5   quota unlimited on users;

User created.

SQL> grant create session, create table, create view to usertest02;

Grant succeeded.

SQL> connect usertest02/pass2;
Connected.
SQL> select eno,ename,hiredate from hr.employee where eno=7788;
select eno,ename,hiredate from hr.employee where eno=7788
                                  *
ERROR at line 1:
ORA-00942: table or view does not exist


SQL> select eno,ename,hiredate from hr.employee where eno=7788;
select eno,ename,hiredate from hr.employee where eno=7788
                                  *
ERROR at line 1:
ORA-00942: table or view does not exist


SQL> grant select on hr.employee to usertest01;
grant select on hr.employee to usertest01
                   *
ERROR at line 1:
ORA-00942: table or view does not exist


SQL> connect usertest01/pass1;
ERROR:
ORA-01045: user USERTEST01 lacks CREATE SESSION privilege; logon denied


Warning: You are no longer connected to ORACLE.
SQL> connect sys as sysdba
Enter password:
Connected.
SQL> grant create session to usertest01;

Grant succeeded.

SQL> connect usertest01/pass1;
Connected.
SQL> select eno,ename,hiredate from hr.employee where eno=7788;

       ENO ENAME                HIREDATE
---------- -------------------- --------
      7788 SCOTT                87/07/13

SQL> connect sys as sysdba
Enter password:
Connected.
SQL> create role roletest01;

Role created.

SQL> grant roletest01 to usertest01;

Grant succeeded.

SQL>

--롤 정보 조회
select * from role_sys_privs;  --롤에 부여된 시스템 권한
select * from role_tab_privs;  --롤에 부여된 테이블 관연 권한
select * from user_role_privs; --접근 가능 권한
select * from user_tab_privs_made; --해당 사용자가 부여한 권한(table)
select * from user_tab_privs_recd; --사용자에게 부여된 권한(table)
select * from user_col_privs_made; --해당 사용자가 부여한 권한(colum)
select * from user_col_privs_recd; --사용자에게 부여된 권한(colum)

--롤 삭제
--drop role 롤명
SQL> drop role roletest01;

--synonym(동의어) - 객체 별칭 붙이기
create synonym hremp for employee;
select * from hremp;
select * from employee;

--dba롤로 접속
SQL> show user;
USER is "USERTEST01"
--hr유저의 employee
SQL> connect sys as sysdba;
Enter password:
Connected.
SQL> grant dba to hr;

Grant succeeded.

SQL> grant dba to usertest01;

Grant succeeded.

SQL> connect usertest01/pass1;
Connected.
SQL> create synonym syn_hr_emp for hr.employee;

Synonym created.

SQL> select count(*) from syn_hr_emp;

  COUNT(*)
----------
        14
--개인 synonym 생성
--create synonym 시노님명 for유저.오브젝트

SQL> connect usertest01/pass1
Connected.
SQL> show user;
USER is "USERTEST01"
SQL> create public synonym hr_syn_emp for hr.employee;

Synonym created.

SQL> select count(*) from hr_syn_emp;

  COUNT(*)
----------
        14
--공용 시노님명으로 조회
SQL> connect scott/tiger;
Connected.

  COUNT(*)
----------
        14
select * from dba_synonym where owner='USERTEST01'
--시노님 삭제
--drop synonym 시노님명;
SQL> drop synonym syn_hr_emp;

Synonym dropped.


