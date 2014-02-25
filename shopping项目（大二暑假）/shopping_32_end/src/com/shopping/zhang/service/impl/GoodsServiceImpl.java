package com.shopping.zhang.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.shopping.li.vo.GoodsManageVo;
import com.shopping.po.Goods;
import com.shopping.zhang.dao.GoodsDao;
import com.shopping.zhang.service.GoodsService;
import com.shopping.util.DaoFactory;

public class GoodsServiceImpl implements GoodsService {
	public static final int NEW_GOODS = 0;
	public static final int BARGAIN_GOODS = 1;
    public GoodsServiceImpl(){}
    private static GoodsService goodsServiceImpl = new GoodsServiceImpl();
    public static GoodsService getInstance(){
    	return goodsServiceImpl;
    }
    private static GoodsDao goodsDao = (GoodsDao)DaoFactory.getInstance("goodsDao");
    
	//��ʾ����Ʒ����ʱ��������ʾǰ�¼�
	public List<Goods> showNewGoods() {
		List<Goods> newGoods = new ArrayList<Goods>();
		List<Goods> goods = goodsDao.getNewGoods();
		if(goods.size()>10){
			for(int i=0;i<10;i++){
				newGoods.add(goods.get(i));
			}
		}else{
			newGoods = goods;
		}
		return newGoods;
	}

	
	public Goods showGoodsById(int id) {
		return goodsDao.findGoodsById(id);
	}

	
	public List<Goods> showSortGoodsBySalCount() {
		List<Goods> sortGoods = new ArrayList<Goods>();
		List<Goods> goods = goodsDao.sortGoodsBySalCount();
		if(goods.size()<9){
			//���������Ʒ�ı��
			for(int i=0;i<goods.size();i++){
				String newGname = goods.get(i).getGname();
				goods.get(i).setGname(newGname);
				sortGoods.add(goods.get(i));
			}
		}else{
			//���������Ʒ�ı�ţ�����ʾ����ǰʮ����Ʒ
			for(int i=0;i<9;i++){
				Goods good = goods.get(i);
				String newGname = good.getGname();
				good.setGname(newGname);
				sortGoods.add(good);
			}
		}
		return sortGoods;
	}

	
	public List<Goods> showGoodsByBargainPrice() {
		return goodsDao.getGoodsByBargainPrice();
	}
    //�õ���ʾ����ҳ�ϵ��ؼۺ���Ʒ��ǰ������Ʒ
	public List<Goods> getBeforeGoods(int type){
		List<Goods> goods = null;
		if(type == GoodsServiceImpl.NEW_GOODS){
			goods = goodsDao.getNewGoods();
		}else if(type == GoodsServiceImpl.BARGAIN_GOODS){
			goods = goodsDao.getGoodsByBargainPrice();
		}
		List<Goods> beforeGoods = new ArrayList<Goods>();
		for(int i=0;i<4;i++){
			beforeGoods.add(goods.get(i));
		}
		return beforeGoods;
	}


	public List<Goods> showGoodsByCategoryId(int categoryId,String keyword) {
		return goodsDao.getGoodsByCategoryId(categoryId,keyword);
	}


	public List<Goods> showGoods() {
		List<Goods> goods = goodsDao.getGoods();
		return goods;
	}


	public void saveGoods(Goods good) {
		goodsDao.addGoods(good);
	}


	public void deleteGoodsById(int id) {
		goodsDao.deleteGoodsById(id);	
	}


	public void updateGoodsById(Goods good, int id) {
		goodsDao.updateGoodsById(good, id);
	}


	public List<Goods> showGoods(int nowpage) {
        GoodsManageVo goodsManageVo = new GoodsManageVo();
        goodsManageVo.setPagesize(6);
        int startIndex = nowpage*6;
        int length = goodsManageVo.getPagesize();
		return goodsDao.getGoods(startIndex, length);
	}


	public void saveGoods(int gid,int num) {
		goodsDao.addGoodsNum(gid,num);
	}
}
