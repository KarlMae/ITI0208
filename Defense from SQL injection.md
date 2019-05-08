# Not getting injected with mybatis

In mybatis, to use variables in SQL, there are 2 possible syntaxes.

For example: 
if the variable name is 'test', one could use
  1. INSERT INTO table(field) VALUES (#{test});
or
  2. INSERT INTO table(field) VALUES ('${test}');
  
The second example inserts an unescaped string into the SQL statement, which is bad.

To demo it:

* Make an endpoint, that uses user input inside it's SQL;
* Inside the mybatis SQL, that the endpoint uses, use '${variableName}';
* Create a table in the DB (for example 'demo_db');
* Use postman to make a request with body: {"variable": "attack incoming"); DROP TABLE demo_db; --"}
  (We use view, so demo_db should be prefixed with 'training.');
* The table is deleted. SQL injection has been executed.

**To fix the endpoint, simply change '${variableName}' with #{variableName}.**

Going through the same demo doesn't delete the demo_db table.

**Yay.**

Spring security is planned in the third sprint, so we can't demo any session stealing etc. 
Also we don't have any user inputs implemented yet.
