package com.shopping.zhang.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.shopping.po.Category;
import com.shopping.zhang.dao.CategoryDao;
import com.shopping.zhang.service.CategoryService;
import com.shopping.util.DaoFactory;

public class CategoryServiceImpl implements CategoryService {
	public CategoryServiceImpl() {
	}

	private static CategoryService categoryServiceImpl = new CategoryServiceImpl();

	public static CategoryService getInstance() {
		return categoryServiceImpl;
	}

	private static CategoryDao categoryDao = (CategoryDao) DaoFactory
			.getInstance("categoryDao");

	public Category showCategoryById(int id) {
		return categoryDao.findCategoryById(id);
	}

	public List<Category> showCategory() {
		return categoryDao.getCategory();
	}

	public List<Category> showBigCategory() {
		return categoryDao.getBigCategory();
	}

	public void saveCategory(String name, int pid, String info) {
		categoryDao.addCategory(name, pid, info);
	}

	public List<Category> showChilerenCategory(int id) {
		return categoryDao.getChildrenCategoryById(id);
	}

	public void deleteCategory(int id) {
		categoryDao.deleteCategory(id);
	}

}
