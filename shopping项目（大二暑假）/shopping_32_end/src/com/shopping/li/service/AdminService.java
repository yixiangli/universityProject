/**
* @package_name   com.shopping.li.service
* @file_name AdminService.java
* @author Administrator
* @date 2013-7-23
*/
package com.shopping.li.service;

import java.util.List;

import com.shopping.po.Admin;
import com.shopping.po.User;

/** 
 * @ClassName: AdminService
 * @Description: TODO
 */
public interface AdminService {

	public Admin login(String username,String password);
	
	public List<User> showUsers();
	
	public User showUserByUsername(String username);
	
	public List<User> showUsers(int nowpage);
}
