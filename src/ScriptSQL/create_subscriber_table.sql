create table if not exists subscriber ( id int primary key, name varchar(255), sex varchar(255) check(sex='M' or sex='F'));

INSERT INTO Subscriber (id, name, sex) VALUES  (1, 'Alice', 'F'), (2, 'Bob', 'M'), (3, 'Charlie', 'M');