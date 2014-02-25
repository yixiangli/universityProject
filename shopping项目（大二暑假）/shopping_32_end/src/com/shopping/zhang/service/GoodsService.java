package com.shopping.zhang.service;

import java.util.List;

import com.shopping.po.Goods;

public interface GoodsService {
  public List<Goods> showNewGoods();
  public Goods showGoodsById(int id);
  public List<Goods> showSortGoodsBySalCount();
  public List<Goods> showGoodsByBargainPrice();
  //�õ���ʾ����ҳ�ϵ��ؼۺ���Ʒ��ǰ������Ʒ
  public List<Goods> getBeforeGoods(int type);
  public List<Goods> showGoodsByCategoryId(int categoryId,String keyword);
  //��ʾ���е���Ʒ
  public List<Goods> showGoods();
  //显示一页商品
  public List<Goods> showGoods(int nowpage);
  //������Ʒ
  public void saveGoods(Goods good);
  //保存商品数量
  public void saveGoods(int gid,int num);
  //ͨ�^id�h����Ʒ
  public void deleteGoodsById(int id);
  //�޸���Ʒ
  public void updateGoodsById(Goods good,int id);
}
