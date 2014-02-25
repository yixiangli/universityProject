package com.shopping.zhang.dao;

import java.util.List;

import com.shopping.li.dao.BaseDao;
import com.shopping.po.Goods;

public interface GoodsDao extends BaseDao{
	//��Ʒ���У��õ����һ��������ӵ���Ʒ
    public List<Goods> getNewGoods();
    //ͨ���Ƿ��ؼ۲�ѯ�����е��ؼ���Ʒ
    public List<Goods> getGoodsByBargainPrice();
    //ͨ��������������������а�
    public List<Goods> sortGoodsBySalCount();
    //ͨ��id������Ʒ
    public Goods findGoodsById(int id);
    //ͨ�^��Ʒ��͵�ID��ԃ����������Ʒ
    public List<Goods> getGoodsByCategoryId(int categoryId,String keyword);
    //�õ����е���Ʒ
    public List<Goods> getGoods();
    //拿到一个页面的商品
    public List<Goods> getGoods(int startIndex,int length);
    //�����Ʒ
    public void addGoods(Goods good);
    //增加商品数量
    public void addGoodsNum(int gid,int num);
    //�h����Ʒ
    public void deleteGoodsById(int id);
    //�޸���Ʒ
    public void updateGoodsById(Goods good,int id);
}
