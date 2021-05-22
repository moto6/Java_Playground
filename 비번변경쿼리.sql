USE mysql;
SELECT HOST,user,authentication_string FROM user;
-- UPDATE user set authentication_string=password('password') where user='root';
alter user 'root'@'localhost' identified with mysql_native_password by 'password';
flush privileges;
