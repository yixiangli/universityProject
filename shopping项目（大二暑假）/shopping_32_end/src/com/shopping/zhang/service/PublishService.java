package com.shopping.zhang.service;

import java.util.List;

import com.shopping.po.Publish;

public interface PublishService {
    public List<Publish> showPublish();
    
    public List<Publish> showPublish(int nowpage);
    
    public void savePublish(Publish publish);
    
    public void deletePublishById(int id);
    
    public Publish showPublishById(int id);
    
    public void updatePublishById(Publish publish,int id);
}
