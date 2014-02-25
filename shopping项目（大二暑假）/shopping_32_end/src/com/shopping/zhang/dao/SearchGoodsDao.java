package com.shopping.zhang.dao;

import java.util.List;

import com.shopping.li.dao.BaseDao;
import com.shopping.po.Goods;

public interface SearchGoodsDao extends BaseDao{
  public List<Goods> searchGoods(int categoryId,String goodsName);
}
