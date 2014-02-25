package com.shopping.song.dao;

import java.util.List;

import com.shopping.li.dao.BaseDao;
import com.shopping.po.Goods;
import com.shopping.po.OrderGoods;


public interface OrderGoodsDao extends BaseDao{
   //通过订单id查订单项
   public List<OrderGoods> getOrderGoodsByOrderId(String orderId);
   
   //通过订单号拿到当前订单下的所有商品
   public List<Goods> getGoodsByOrderId(String orderId);
   //保存一条订单-商品记录
   public int saveRecordOfOrderGoods(String oid,int gid,float unitprice,int pcount);
   //通过订单号拿到当前所有商品的id
   public List<Integer> getGIDByOrderId(String orderId);
   //通过orderId删除订单-商品中的一条记录
   public int delOrderGoodsByOrderId(String orderId);
}
