package com.shopping.zhang.dao;

import java.util.List;

import com.shopping.li.dao.BaseDao;
import com.shopping.po.Category;

public interface CategoryDao extends BaseDao{
  public Category findCategoryById(int id);
  public List<Category> getCategory();
  public List<Category> getChildrenCategoryById(int id);
  public List<Category> getBigCategory();
  
  public void addCategory(String name,int pid,String info);
  
  public void deleteCategory(int id);
}
