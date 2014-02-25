package com.shopping.li.dao;

import java.util.List;

import com.shopping.po.Admin;
import com.shopping.po.User;

public interface AdminDao extends BaseDao {
	
	//查询密码
	public Admin findAdminByUsername(String username);
	
	//查找用户
	public  List<User> findUser();
	
	//查找单个
	public User findUserByUsername(String username);
	
	//查找用户分页
	public  List<User> findUser(int startIndex,int length);
}
