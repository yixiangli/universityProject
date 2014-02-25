create database shopping;
drop database shopping;
drop table t_order_goods;
drop table t_order;

select * from t_goods;
select * from t_admin;
select * from t_user;
select * from t_favorite;
select * from t_user where username="ccc";
select * from t_user_goods;
select * from t_order;
select * from t_category;
select * from t_publish;

update t_goods set sortId=13 where id=5;
delete from t_user_goods where uid=1;

update t_user set state=0;

update t_goods set photo="images/goods/fdg0005.jpg" where id=4;
drop table t_user_goods;