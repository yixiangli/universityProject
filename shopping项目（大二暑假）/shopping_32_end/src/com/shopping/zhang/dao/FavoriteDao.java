package com.shopping.zhang.dao;

import java.util.List;

import com.shopping.li.dao.BaseDao;
import com.shopping.po.Favorite;
import com.shopping.po.Goods;

public interface FavoriteDao extends BaseDao{
	public void addFavorite(int uid, int gid);

	public List<Goods> findFavoriteGoods(int uid);
	//��ѯ��һ���û���favorite�����жϸ��û��Ƿ����ղع�ĳ��Ʒ
	public List<Favorite> findFavorite(int uid);
}
