package com.shopping.zhang.service.impl;

import java.util.List;

import com.shopping.po.Goods;
import com.shopping.zhang.dao.FavoriteDao;
import com.shopping.zhang.service.FavoriteService;
import com.shopping.util.DaoFactory;

public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteServiceImpl(){}
	private static FavoriteService favoriteServiceImpl = new FavoriteServiceImpl();
	public static FavoriteService getInstance(){
		return favoriteServiceImpl;
	}
	
	private static FavoriteDao favoriteDao = (FavoriteDao)DaoFactory.getInstance("favoriteDao");
	
	public List<Goods> showFavoriteGoods(int uid) {
		return favoriteDao.findFavoriteGoods(uid);
	}

	
	public void saveFavorite(int uid, int gid) {
		favoriteDao.addFavorite(uid, gid);
	}

}
