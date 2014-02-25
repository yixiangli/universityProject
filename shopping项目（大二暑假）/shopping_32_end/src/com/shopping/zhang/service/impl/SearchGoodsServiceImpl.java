package com.shopping.zhang.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.shopping.po.Goods;
import com.shopping.zhang.dao.SearchGoodsDao;
import com.shopping.zhang.service.SearchGoodsService;
import com.shopping.util.DaoFactory;

public class SearchGoodsServiceImpl implements SearchGoodsService {
	private SearchGoodsServiceImpl(){}
	private static SearchGoodsService searchGoodsServiceImpl = new SearchGoodsServiceImpl();
	public static SearchGoodsService getInstance(){
		return searchGoodsServiceImpl;
	}
	
	private static SearchGoodsDao searchGoodsDao = (SearchGoodsDao)DaoFactory.getInstance("searchGoodsDao");
	public List<Goods> showSearchGoods(int categoryId, String goodsName) {
		//�����ж��Ƿ�����ؼ��֣����ؼ���Ϊ����ֱ�ӷ���һ���յ�list
		List<Goods> searchGoods = null;
		if(goodsName.equals("")){
		}else{
		    searchGoods = searchGoodsDao.searchGoods(categoryId, goodsName);
		}
		return searchGoods;
	}

}
