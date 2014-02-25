package com.shopping.zhang.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.shopping.li.vo.GoodsManageVo;
import com.shopping.po.Publish;
import com.shopping.zhang.dao.PublishDao;
import com.shopping.zhang.service.PublishService;
import com.shopping.util.DaoFactory;

public class PublishServiceImpl implements PublishService {

	private PublishServiceImpl(){}
	private static PublishService publishServiceImpl = new PublishServiceImpl();
	public static PublishService getInstance(){
		return publishServiceImpl;
	}
	
	private static PublishDao publishDao = (PublishDao)DaoFactory.getInstance("publishDao");
	public List<Publish> showPublish() {
		return publishDao.getPublish();
	}

	public void savePublish(Publish publish) {
		publishDao.addPublish(publish);
	}

	public void deletePublishById(int id) {
		publishDao.deletePublishById(id);
	}

	public Publish showPublishById(int id) {
		return publishDao.findPublishById(id);
	}

	public void updatePublishById(Publish publish, int id) {
		publishDao.updatePublishById(publish, id);
	}

	public List<Publish> showPublish(int nowpage) {
		GoodsManageVo goodsManageVo = new GoodsManageVo();
        goodsManageVo.setPagesize(6);
        int startIndex = nowpage*6;
        int length = goodsManageVo.getPagesize();
		return publishDao.getPublish(startIndex, length);
	}

}
