package com.shopping.zhang.service;

import java.util.List;

import com.shopping.po.Goods;

public interface FavoriteService {
   public List<Goods> showFavoriteGoods(int uid);
   
   public void saveFavorite(int uid,int gid);
}
