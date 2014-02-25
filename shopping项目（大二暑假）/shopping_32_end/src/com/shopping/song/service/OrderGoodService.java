package com.shopping.song.service;

import java.util.List;

import com.shopping.po.Goods;
import com.shopping.po.OrderGoods;

public interface OrderGoodService {
	//通过订单id查订单项
	   public List<OrderGoods> showOrderGoodsByOrderId(String orderId);
	 //通过订单号拿到当前订单下的所有商品
	   public List<Goods> showGoodsByOrderId(String orderId);
	   //保存一条订单-商品记录
	   public int saveRecords(String oid,int gid,float unitprice,int pcount);
	   //通过订单号拿到当前所有商品的id
	   public List<Integer> showGIDByOrderId(String orderId);
	   //通过orderId删除订单-商品中的一条记录
	   public int deleteOrderGoodsByOrderId(String orderId);
}
