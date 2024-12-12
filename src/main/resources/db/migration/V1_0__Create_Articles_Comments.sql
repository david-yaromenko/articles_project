create table Articles(
id serial not null primary key,
title varchar(30),
text_article text,
add_date date not null,
add_time time not null
);

insert into Articles(title, text_article, add_date, add_time) values ('Traning', 'About legs', '2024-10-25', '20:20:00');
insert into Articles(title, text_article, add_date, add_time) values ('Chest day', 'Pull this shit', '2024-08-10', '11:20:23');
insert into Articles(title, text_article, add_date, add_time) values ('Eat', 'Proteins', '2024-02-15', '08:10:01');
insert into Articles(title, text_article, add_date, add_time) values ('Day whthout trainings', 'Day off', '2024-02-15', '11:20:23');

create table Comments(
id serial not null primary key,
article_id int not null,
text_comment text,
add_date date not null,
add_time time not null
);

insert into Comments(article_id ,text_comment, add_date, add_time) values (1 ,'Klasno', '2024-10-25', '11:20:23');
insert into Comments(article_id, text_comment, add_date, add_time) values (2,'Duje kruto', '2024-02-15', '20:20:00');
insert into Comments(article_id, text_comment, add_date, add_time) values (3,'Ta ni, v tebe krawe', '2024-02-15', '15:30:50');
insert into Comments(article_id, text_comment, add_date, add_time) values (4,'Ludi bez trenirovok', '2024-02-15', '08:10:01');
