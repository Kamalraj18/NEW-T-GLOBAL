create table actors(
actor_id int primary key,
first_name varchar2(150),
	last_name varchar2(150) not null,
	gender varchar2(10),
	date_of_birth date,
	created_date date,
	modified_date date
);
/

CREATE SEQUENCE actors_sequence start with 1 increment by 1 maxvalue 99999;

create table directos(
director_id int primary key,
first_name varchar(150),
	last_name varchar(150) not null,
	date_of_birth date,
	nationality varchar(10),
	created_date date,
	modified_date date
);
/
create table movies(
movie_id int primary key,
movie_name varchar(150),
	movie_length int,
	movie_lang varchar(155),
	age_certificate varchar(10),
	release_date date,
	director_id int references directors(director_id)
);

alter table directos rename to directors;

create table movies_revenues(
revenue_id int primary key,
movie_id int references movies(movie_id),
	revenue_domestic number(10,2),
	revenue_international number(10,2)
);

SELECT * FROM ACTORS;
/


