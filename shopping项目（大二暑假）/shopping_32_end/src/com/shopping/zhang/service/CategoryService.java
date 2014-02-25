package com.shopping.zhang.service;

import java.util.List;

import com.shopping.po.Category;

public interface CategoryService {
    public Category showCategoryById(int id);
    public List<Category> showCategory();
    public List<Category> showBigCategory();
    public List<Category> showChilerenCategory(int id);
    //��������Ϣ
    public void saveCategory(String name,int pid,String info);
    
    public void deleteCategory(int id);
    
}
