package com.shopping.song.service.impl;

import java.util.List;

import com.shopping.li.vo.OrderManageVo;
import com.shopping.po.Order;
import com.shopping.song.dao.OrderDao;
import com.shopping.song.service.OrderService;
import com.shopping.util.DaoFactory;

public class OrderServiceImpl implements OrderService {
	//单例设计模式,service的构造方法私有化
    private OrderServiceImpl(){}
    //提供一个自己类型的成员变量
    private static OrderService orderService = new OrderServiceImpl();
   //提供一个静态方法，用于获得一个当前类型的成员变量
    public static OrderService getInstance(){
    	return orderService;
    }
  //构造dao和service的依赖关系
    private static OrderDao orderDao = (OrderDao)DaoFactory.getInstance("orderDao");
	@Override
	//生成一个新的订单
	public int createOrder(String orderId,int uid,String receiveName,int timeDemand,int postcode,String phone,int orderType,float orderSal,String orderAddress,int receiveWay,int payWay,String remark) {
		// TODO Auto-generated method stub
        return orderDao.generateOrder(orderId,uid,receiveName,timeDemand,postcode,phone,orderType,orderSal,orderAddress,receiveWay,payWay,remark);
	}

	@Override
	//通过订单号删除一条记录
	public int deleteOrderById(String orderId) {
		// TODO Auto-generated method stub
        return orderDao.delOrderById(orderId); 
	}

	@Override
	//拿到当前用户的所有订单
	public List<Order> showOrders(int uid) {
		// TODO Auto-generated method stub
		return orderDao.getOrders(uid);
	}

	@Override
	public Order showOrderById(String orderId) {
		// TODO Auto-generated method stub
		return orderDao.findOrderById(orderId);
	}

	@Override
	public int alterOrderSale(String orderId, float orderSal) {
		// TODO Auto-generated method stub
		return orderDao.alterOrderSale(orderId, orderSal);
	}

	@Override
	public List<Order> showOrders() {
		// TODO Auto-generated method stub
		return orderDao.getAllOrders();
	}

	@Override
	public int alterOrderStatus(String orderId, int orderType) {
		// TODO Auto-generated method stub
		return orderDao.alterOrderStatus(orderId, orderType);
	}

	@Override
	public List<Order> getOrdersByOrderType(int orderType) {
		// TODO Auto-generated method stub
		return orderDao.getOrdersByOrderType(orderType);
	}

	@Override
	public int getAllOrdersCount4Admin() {
		// TODO Auto-generated method stub
		return orderDao.getAllOrdersCount4Admin();
	}

	@Override
	public int getSearchOrderCount4Admin(int orderType) {
		// TODO Auto-generated method stub
		return orderDao.getSearchOrderCount4Admin(orderType);
	}

	@Override
	public List<Order> getAllOrders(int nowpage) {
		// TODO Auto-generated method stub
		OrderManageVo orderVo = new OrderManageVo();
		orderVo.setPagesize(3);
		int startIndex = nowpage*3;
		int length = orderVo.getPagesize();
		
        return orderDao.getAllOrders(startIndex, length);	
        }

	@Override
	public List<Order> getOrdersByOrderType(int orderType, int nowpage) {
		// TODO Auto-generated method stub
		OrderManageVo orderVo = new OrderManageVo();
		orderVo.setPagesize(3);
		int startIndex = nowpage*3;
		int length = orderVo.getPagesize();
		return orderDao.getOrdersByOrderType(orderType, startIndex, length);
	}

	@Override
	public int getOrdersCount4User(int uid) {
		// TODO Auto-generated method stub
		return orderDao.getOrdersCount4User(uid);
	}

	@Override
	public List<Order> getOrdersByUid(int uid, int startIndex, int length) {
		// TODO Auto-generated method stub
		int beginIndex = (startIndex-1)*5;
		return orderDao.getOrdersByUid(uid, beginIndex, length);
	}

}
