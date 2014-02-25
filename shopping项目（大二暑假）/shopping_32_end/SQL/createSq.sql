----------------------------------------创建用户表：-----------------------------------------
create table t_user(
	  id int auto_increment primary key,
	  username varchar(30),
	  password varchar(12),
	  email varchar(45),
	  realname varchar(15),
	  address varchar(90),
	  area varchar(30),
	  postcode varchar(6),
	  tel varchar(11),
	  type int,
	  pdate date,
	  state int,
	  spend decimal(7,1)
);
 ------------------------------------创建类别表：----------------------------------------------
create table t_category(
	  id int auto_increment primary key,
	  name varchar(30),
	  pid int,
	  info varchar(60),
	  foreign key(pid) references t_category(id)
);
-----------------------------------创建商品表：------------------------------------------------
create table t_goods(
  id int auto_increment primary key,
  gname varchar(45),
  gdiscount decimal(3,2),
  marketPrice decimal(5,1),
  salPrice decimal(5,1),
  info text,
  photo varchar(50),
  bargainPrice int,
  pdate date,
  number int,
  sortId int,
  salCount int,
  foreign key(sortId) references t_category(id)
);
 --------------------------------------------- 创建订单表：--------------------------------------
create table t_order(
  orderId varchar(12) primary key,
  orderTime date,
  uid int,
  recieveName varchar(20),
  timeDemand int,
  postcode int,
  phone char(11),
  orderType int,
  orderSal decimal(6,1),
  orderAddress varchar(45),
  receiveWay int,
  payWay int,
  remark text,
  foreign key(uid) references t_user(id)
);

--------------------------------------创建订单商品表：---------------------------------------
create table t_order_goods(
  id int auto_increment,
  oid varchar(12),
  gid int,
  unitprice decimal(5,1),
  pcount int,
  primary key(id),
  foreign key(oid) references t_order(orderId),
  foreign key(gid) references t_goods(id) 
); 
-------------------------------------------创建用户商品表：----------------------------------
create table t_user_goods(
  uid int,
  gid int,
  comment text,
  commentTime Date,
  foreign key(uid) references t_user(id),
  foreign key(gid) references t_goods(id)
);
-------------------------------------创建收藏夹表：-------------------------------------------
create table t_favorite(
  uid int,
  gid int,
  primary key(uid,gid),
  foreign key(uid) references t_user(id),
  foreign key(gid) references t_goods(id)
);
 ---------------------------------------创建公告表：----------------------------------------------
create table t_publish(
  id int auto_increment primary key,
  title varchar(60),
  content text,
  publishTime date,
  outTime date
);
-----------------------------------------创建管理员表：------------------------------------------
create table t_admin(
  id int auto_increment primary key,
  username varchar(15),
  password varchar(12)
);