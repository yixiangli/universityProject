package com.shopping.zhang.dao;

import java.util.List;

import com.shopping.li.dao.BaseDao;
import com.shopping.po.Publish;

public interface PublishDao extends BaseDao {
	//��ʾ����
	public List<Publish> getPublish();
	//显示一页公告
	public List<Publish> getPublish(int startIndex,int length);
	//��ӹ���
	public void addPublish(Publish publish);
	//ɾ���
	public void deletePublishById(int id);
	//��ѯ����
	public Publish findPublishById(int id);
	//���¹���
	public void updatePublishById(Publish publish,int id);
}

