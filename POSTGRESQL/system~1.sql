create table department(
	d_id varchar2(50) primary key,
	d_name varchar(150)
)

drop table department;

create table employee(
e_id varchar2(50) primary key,
	e_name varchar(150),
	e_location varchar(150),
	d_id varchar2(50) references department(d_id)
)

create or replace procedure sp_emp_dtls(
e_name varchar,
e_location varchar,
dp_name varchar
)
as
dept_id VARCHAR2(30);
begin 
select d_id into dept_id from department where d_name=dp_name;

if(dept_id is null) then
insert into department(d_name) values (dp_name) returning d_id into dept_id;

insert into employee(e_name,e_location,d_id) values (e_name,e_location,dept_id);

else
insert into employee(e_name,e_location,d_id) values (e_name,e_location,dept_id);
end if;

end;

/

CREATE SEQUENCE employee_sequence start with 1 increment by 1 maxvalue 9999 nocache;


create or replace trigger trg_serial_employee 
before insert on employee
for each row
begin
select 'EMP'||to_char(employee_sequence.nextval,'FM0000')
into :NEW.e_id from dual;
end;
/

CREATE SEQUENCE department_sequence start with 1 increment by 1 maxvalue 20 nocache;


create or replace trigger trg_serial_department
before insert on department
for each row
begin
select 'DEPT'||to_char(department_sequence.nextval,'FM00')
into :NEW.d_id from dual;
end;
/


begin sp_emp_dtls('kamal','vellore','developer'); end;

select * from department;

insert into department(d_name) values ('FINANCE');

alter table department modify (d_id varchar(50));
/


create or replace procedure sp_emp_dtls(
e_name varchar2,
e_location varchar2,
dp_name varchar2
)
as
dept_id int;
begin 

select d_id into dept_id from department where d_name=dp_name;

EXCEPTION
when NO_DATA_FOUND then
insert into department(d_name) values (dp_name) returning d_id into dept_id;
END;

insert into employee(e_name,e_location,d_id) values (e_name,e_location,dept_id);

end;
/

declare
e_n varchar(50) := 'kamal';
e_l varchar(50) := 'vellore';
d_n varchar(50) := 'HR';
begin
sp_emp_dtls(e_n,e_l,d_n);
end;