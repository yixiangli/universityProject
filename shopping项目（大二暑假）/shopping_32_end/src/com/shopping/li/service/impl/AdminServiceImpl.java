/**
* @package_name   com.shopping.li.service.impl
* @file_name AdminServiceImpl.java
* @author Administrator
* @date 2013-7-23
*/
package com.shopping.li.service.impl;

import java.util.List;

import com.shopping.li.dao.AdminDao;
import com.shopping.li.dao.UserDao;
import com.shopping.li.dao.impl.AdminDao4MySqlImpl;
import com.shopping.li.exception.PasswordErrorException;
import com.shopping.li.exception.UserNotFoundException;
import com.shopping.li.service.AdminService;
import com.shopping.li.service.UserService;
import com.shopping.li.vo.UserVo;
import com.shopping.po.Admin;
import com.shopping.po.User;
import com.shopping.util.DaoFactory;
import com.shopping.li.vo.UserVo;

/** 
 * @ClassName: AdminServiceImpl
 * @Description: TODO
 */
public class AdminServiceImpl implements AdminService {

	/* (non-Javadoc)
	 * @see com.shopping.li.service.AdminService#login(java.lang.String, java.lang.String)
	 */
	private AdminDao adminDao = (AdminDao)DaoFactory.getInstance("AdminDao");
	private static AdminService adminService = new AdminServiceImpl();
    private AdminServiceImpl(){}
    
    public static AdminService getInstance(){
    	return adminService;
    }
	
	@Override
	public Admin login(String username, String password) {
		// TODO Auto-generated method stub
		Admin admin = adminDao.findAdminByUsername(username);
		
		if(admin==null){
			
			throw new UserNotFoundException();
		}
		
		if(!password.equals(admin.getPassword())){
			throw new PasswordErrorException();
		}
		
		return admin;
	}

	/* (non-Javadoc)
	 * @see com.shopping.li.service.AdminService#showUsers()
	 */
	@Override
	public List<User> showUsers() {
		// TODO Auto-generated method stub
		List<User> list = adminDao.findUser();	
		return list;
	}
	
	public User showUserByUsername(String username){
		User user = adminDao.findUserByUsername(username);
		return user;
	}

	/* (non-Javadoc)
	 * @see com.shopping.li.service.AdminService#showUsers(int)
	 */
	@Override
	public List<User> showUsers(int nowpage) {
		// TODO Auto-generated method stub
		UserVo userVo = new UserVo();
		userVo.setPagesize(3);
		int startIndex = nowpage*3;
		int length = userVo.getPagesize();
		
        return adminDao.findUser(startIndex,length);

	}

}
