package com.shopping.zhang.service;

import java.util.List;

import com.shopping.po.Goods;

public interface SearchGoodsService {
  public List<Goods> showSearchGoods(int categoryId, String goodsName);
}
