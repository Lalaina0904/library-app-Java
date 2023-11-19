create table  if not exists book ( id int primary key, bookName varchar(255), pageNumbers varchar(255), topic varchar(255), releaseDate varchar(255) , authorId int references author(id));
INSERT INTO Book (id, bookName, pageNumbers, topic, releaseDate, authorId) VALUES
(1, 'The Great Gatsby', 300, 'ROMANCE', '2022-01-01', 1),
(2, 'Pride and Prejudice', 250, 'ROMANCE', '2021-12-15', 2),
(3, '1984', 280, 'OTHER', '2022-02-10', 3);