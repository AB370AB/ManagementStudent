CREATE TABLE if not exists STUDENTS
(
    `id` bigint primary key not null AUTO_INCREMENT,
    `first_name` varchar2(30) not null,
    `last_name` varchar2(30) not null,
    `email` varchar2(20) unique not null
);


insert into students("FIRST_NAME", "LAST_NAME", "EMAIL") values ( 'Alina', 'Popa','allpopa@yahoo.com' );
insert into students("FIRST_NAME", "LAST_NAME", "EMAIL") values ( 'George', 'Popa','georgepopa@yahoo.com' );
insert into students("FIRST_NAME", "LAST_NAME", "EMAIL") values ( 'Elena', 'Vlan','vladelena@yahoo.com' );
insert into students("FIRST_NAME", "LAST_NAME", "EMAIL") values ( 'Paul', 'Ionita','pauionita@yahoo.com' );

