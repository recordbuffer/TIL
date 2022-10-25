/*create table person
(
   id integer not null,
   name varchar(255) not null,
   location varchar(255),
   birth_date timestamp,
   primary key(id)
);
*/
/*INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10001,  'Ranga', 'Hyderabad',CURRENT_DATE());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10002,  'James', 'New York',CURRENT_DATE());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10003,  'Pieter', 'Amsterdam',CURRENT_DATE());
*/
/*insert into COURSE (ID, AUTHOR, NAME)
values (100001, 'in28minutes', 'Learn Microservices');
insert into COURSE (ID, AUTHOR, NAME)
values (100002, 'in28minutes', 'Learn FullStack with React and Angular');
insert into COURSE (ID, AUTHOR, NAME)
values (100003, 'in28minutes', 'Learn AWS, GCP and Azure');*/

insert into course(id, name, author, creation_timestamp, update_timestamp)
values(10001,'JPA in 50 Steps', '허균', CURRENT_DATE(), CURRENT_DATE());
insert into course(id, name, author, creation_timestamp, update_timestamp)
values(10002,'Spring in 50 Steps', '홍길동', CURRENT_DATE(), CURRENT_DATE());
insert into course(id, name, author, creation_timestamp, update_timestamp)
values(10003,'Spring Boot in 100 Steps', '허난설헌', CURRENT_DATE(), CURRENT_DATE());

insert into passport(id,number)
values(40001,'E123456');
insert into passport(id,number)
values(40002,'N123457');
insert into passport(id,number)
values(40003,'L123890');

insert into student(id,name, passport_id)
values(20001,'한소희', 40001);
insert into student(id,name, passport_id)
values(20002,'아이유', 40002);
insert into student(id,name, passport_id)
values(20003,'김태리', 40003);

insert into review(id,rating,description, course_id)
values(50001,'FIVE', 'Great Course', 10002);
insert into review(id,rating,description, course_id)
values(50002,'FOUR', 'Wonderful Course', 10003);
insert into review(id,rating,description, course_id)
values(50003,'FIVE', 'Awesome Course', 10003);

insert into student_and_course(student_id, course_id)
values(20001, 10001);
insert into student_and_course(student_id, course_id)
values(20002, 10001);
insert into student_and_course(student_id, course_id)
values(20003, 10001);
insert into student_and_course(student_id, course_id)
values(20001, 10003);