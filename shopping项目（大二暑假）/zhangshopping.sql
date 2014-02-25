create table t_user(
  id int auto_increment primary key,
  username varchar(30),
  password varchar(12),
  email varchar(45),
  realname varchar(15),
  address varchar(90),
  postcode varchar(6),
  tel varchar(11),
  type int,
  pdate date,
  state int,
  spend decimal(7,1),
  area varchar(30)
);

create table t_category(
  id int auto_increment primary key,
  name varchar(30),
  pid int,
  foreign key(pid) references t_category(id)
);
create table t_goods(
  id int auto_increment primary key,
  gname varchar(45),
  gdiscount decimal(3,2),
  market_price decimal(5,1),
  sal_price decimal(5,1),
  info text,
  photo varchar(50),
  bargain_price int,
  pdate date,
  number int,
  sort_id int,
  sal_count int,
  foreign key(sort_id) references t_category(id)
);
create table t_order(
  order_id varchar(12) primary key,
  order_time date,
  uid int,
  order_type int,
  order_sal decimal(6,1),
  order_address varchar(45),
  receive_way varchar(30),
  pay_way varchar(30),
  remark text,
  foreign key(uid) references t_user(id)
);
create table t_order_goods(
  oid varchar(12),
  gid int,
  primary key(oid,gid),
  foreign key(oid) references t_order(order_id),
  foreign key(gid) references t_goods(id) 
); 

create table t_user_goods(
  uid int,
  gid int,
  comment text,
  comment_time date,
  primary key(uid,gid),
  foreign key(uid) references t_user(id),
  foreign key(gid) references t_goods(id)
);
create table t_favorite(
  uid int,
  gid int,
  primary key(uid,gid),
  foreign key(uid) references t_user(id),
  foreign key(gid) references t_goods(id)
);

create table t_publish(
  id int auto_increment primary key,
  title varchar(60),
  content text,
  publish_time date,
  out_time date
);
create table t_admin(
  id int auto_increment primary key,
  username varchar(15),
  password varchar(12)
);