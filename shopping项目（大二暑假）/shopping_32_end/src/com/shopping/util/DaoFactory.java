package com.shopping.util;

import com.shopping.li.dao.BaseDao;

public class DaoFactory {

	public static BaseDao getInstance(String daoName) {
		BaseDao dao = null;
		String className = PropUtil.getValue("daoConfig.properties", daoName);
		try {
			dao = (BaseDao) Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dao;
	}
}
