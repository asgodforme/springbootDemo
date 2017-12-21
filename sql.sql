select * from user;
select * from address;

select a.city as address, a.user_name as userName, b.email as email from  address a, user b where a.user_name = b.user_name

select user0_.id as id1_0_, user0_.email as email2_0_, user0_.nick_name as nick_nam3_0_, user0_.password as password4_0_, user0_.reg_time as reg_time5_0_, user0_.user_name as user_nam6_0_ 
from user user0_ where user0_.user_name like '%姜杰%' order by user0_.id desc limit 1, 10