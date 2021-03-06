package com.shopping.song.dao;

import java.util.List;

import com.shopping.li.dao.BaseDao;
import com.shopping.po.Order;

public interface OrderDao extends BaseDao{
   //生成订单
   public int generateOrder(String orderId,int uid,String receiveName,int timeDemand,int postcode,String phone,int orderType,float orderSal,String orderAddress,int receiveWay,int payWay,String remark);
   //取消一个订单
   public int delOrderById(String orderId);
   //得到当前用户的订单
   public List<Order> getOrders(int uid);
   //通过订单号查找一个订单
   public Order findOrderById(String orderId);
  //修改订单总价格
   public int alterOrderSale(String orderId,float orderSal);
 //查询出所有的订单
   public List<Order> getAllOrders();
 //修改订单的状态
   public int alterOrderStatus(String orderId,int orderType);
 //通过订单状态查找
   public List<Order> getOrdersByOrderType(int orderType);
 //拿到所有订单数目
   public int getAllOrdersCount4Admin();
 //拿到相应订单状态的订单的总数目
   public int getSearchOrderCount4Admin(int orderType);
 //查询出所有的订单
   public List<Order> getAllOrders(int startIndex,int length);
   //通过订单状态查找
   public List<Order> getOrdersByOrderType(int orderType,int startIndex,int length);
 //拿到用户的订单总数
 	public int getOrdersCount4User(int uid);
  //通过uid查订单列表<分页式样>
 	public List<Order> getOrdersByUid(int uid,int startIndex,int length);
}
