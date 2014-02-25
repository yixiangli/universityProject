user:
insert into t_admin values(null,"admin","12345");
insert into t_user values(null,"jack","12345",www@,"tom",null,null,345000,231,1,now(),1,0);

t_category:
insert into t_category values(null,"商品总类",1,"dasf");
insert into t_category values(null,"食品烟酒",1,"食品烟酒大全");
insert into t_category values(null,"健康美容",1,"健康美容全集");
insert into t_category values(null,"家居用品",1,"家居用品必备");
insert into t_category values(null,"家电通讯",1,"家电通讯大全");
insert into t_category values(null,"服装鞋帽",1,"服装鞋帽大全");
insert into t_category values(null,"IT数码",1,"IT的天下");
insert into t_category values(null,"电视区",5,"dasf");
insert into t_category values(null,"冰箱区",5,"dasf");
insert into t_category values(null,"电话区",5,"dasf");
insert into t_category values(null,"手机区",5,"dasf");

t_goods:
insert into t_goods values(null,"好看的电视",0.94,3980.0,3680.0,"农大电视真好呀","images/goods/fdg0001.jpg",1,now(),30,4,1);
insert into t_goods values(null,"很冷的冰箱",0.92,5470.0,4860.0,"农大冰箱真的好便宜","images/goods/fdg0010.jpg",1,now(),30,4,3);
insert into t_goods values(null,"奋斗电脑",0.98,3980.0,3680.0,"奋斗牌电脑，你值得拥有","images/goods/fdg0013.jpg",1,now(),30,6,2);
insert into t_goods values(null,"好床单",0.75,300.0,225.0,"床单","images/goods/201307250337218729539.jpg",1,now(),30,3,6);
insert into t_goods values(null,"CCTV电视",0.90,2560.0,2166.4,"CCTV电视，无线可达","images/goods/fdg0008.jpg",0,now(),30,4,10);

t_favorite
insert into t_favorite values(1,1);
insert into t_favorite values(1,2);
insert into t_favorite values(2,3);
insert into t_favorite values(2,4);

t_user_goods
insert into t_user_goods values(1,3,"dasd",now());
insert into t_user_goods values(2,3,"dddddd",now());
insert into t_user_goods values(1,3,"dadassad",now());