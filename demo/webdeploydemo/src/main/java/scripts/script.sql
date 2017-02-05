create table myusers(
id int(5) primary key auto_increment,
created datetime default current_timestamp,
username varchar(30),
password varchar(70)
);

