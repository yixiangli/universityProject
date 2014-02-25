package com.shopping.song.service.impl;

import java.util.List;

import com.shopping.po.Goods;
import com.shopping.po.OrderGoods;
import com.shopping.song.dao.OrderGoodsDao;
import com.shopping.util.DaoFactory;
import com.shopping.song.service.OrderGoodService;

public class OrderGoodServiceImpl implements OrderGoodService {
    private OrderGoodServiceImpl(){}
    private static OrderGoodService orderGoodService = new OrderGoodServiceImpl();
    public static OrderGoodService getInstance(){
    	return orderGoodService;
    }
    private static OrderGoodsDao orderGoodsDao = (OrderGoodsDao)DaoFactory.getInstance("orderGoodsDao");
	@Override
	public List<Goods> showGoodsByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return orderGoodsDao.getGoodsByOrderId(orderId);
	}

	@Override
	public int saveRecords(String oid,int gid,float unitprice,int pcount) {
		// TODO Auto-generated method stub
        return orderGoodsDao.saveRecordOfOrderGoods(oid, gid,unitprice,pcount);
	}

	@Override
	public List<Integer> showGIDByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return orderGoodsDao.getGIDByOrderId(orderId);
	}

	@Override
	public int deleteOrderGoodsByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return orderGoodsDao.delOrderGoodsByOrderId(orderId);
	}

	@Override
	public List<OrderGoods> showOrderGoodsByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return orderGoodsDao.getOrderGoodsByOrderId(orderId);
	}

}
