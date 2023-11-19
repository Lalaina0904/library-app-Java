create table if not exists author ( id int primary key, name varchar(255), sex varchar(255) check(sex='M' or sex='F'));

INSERT INTO Author (id, name, sex) VALUES (1, 'Daniel Cruz', 'M'), (2, 'Jane Smith', 'F'), (3, 'Alex Johnson', 'M');