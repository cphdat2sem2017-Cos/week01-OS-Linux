# Useful SQL (prompt) commands;
This is a condensed version of the two tutorials:

* [a-basic-mysql-tutorial](https://www.digitalocean.com/community/tutorials/a-basic-mysql-tutorial)
* [how-to-create-a-new-user-and-grant-permissions-in-mysql](https://www.digitalocean.com/community/tutorials/how-to-create-a-new-user-and-grant-permissions-in-mysql)

## General commands 


command | comment
---|---
SHOW DATABASES; | Shows which databases are available on the server
USE mydatabase; | Selects mydatabase as the current one (so you can refer to tables by name)
SHOW TABLES; | Show which tables are in the selected database.
DESCRIBE myTable; | Show the definition of the columns in myTable (to get the names and type of the rows)
SELECT * FROM myTable; | list all rows in myTable. This is often not very usefull in  a shell window. 
other | All SQL query and manipulations commands can be used from the promt

---
## Creating and deleting users
The command to create a new database user is:

`CREATE USER 'newuser'@'localhost' IDENTIFIED BY 'password';`

The `newuser` is only allowed to log in from localhost. This is often OK, but if the database server can be accessed from the outside the syntax is:

`CREATE USER 'newuser' IDENTIFIED BY 'password';`

And yes - you do give the password directly here.

To delete a user: 
`DROP USER ‘someuser’;`

## Granting permissions to users
By default a new user is not allowed to do anything, not even log in.

`GRANT <SomePrivilege> ON datatabase.table TO 'newuser'[@'localhost'];`

Here is a short list of other common possible permissions that users can enjoy.

Privilege | Comment
---+---
ALL PRIVILEGES |  as we saw previously, this would allow a MySQL user all access to a designated database (or if no database is selected, across the system)
CREATE |  allows them to create new tables or databases
DROP |  allows them to them to delete tables or databases
DELETE |  allows them to delete rows from tables
INSERT |  allows them to insert rows into tables
SELECT |  allows them to use the Select command to read through databases
UPDATE |  allow them to update table rows
GRANT OPTION |  allows them to grant or remove other users' privileges

To the the user `peeper` access to execute select queries on the `customer` table in the database `classicmodels` from the machine `188.233.45.77`, you can for example do:

`GRANT SELECT ON classicmodels.customer TO peeper@188.233.45.77;`
