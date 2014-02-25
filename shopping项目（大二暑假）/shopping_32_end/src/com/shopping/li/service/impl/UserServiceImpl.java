package com.shopping.li.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.shopping.li.dao.UserDao;
import com.shopping.li.dao.impl.UserDao4MySqlImpl;
import com.shopping.li.exception.DongJieException;
import com.shopping.li.exception.PasswordDifferentException;
import com.shopping.li.exception.PasswordErrorException;
import com.shopping.li.exception.UserNotFoundException;
import com.shopping.li.service.UserService;
import com.shopping.po.User;
import com.shopping.po.UserGoods;
import com.shopping.util.DaoFactory;


public class UserServiceImpl implements UserService{
	private UserDao userDao = (UserDao)DaoFactory.getInstance("UserDao");
	private static UserService userService = new UserServiceImpl();
    private UserServiceImpl(){}
    
    public static UserService getInstance(){
    	return userService;
    }
    	
	@Override
	//��½
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		User user = null;
		user = userDao.findUserByUsername(username);
		
		if(user == null){
			throw new UserNotFoundException();
		}
		
		if(user.getState()==1){
			throw new DongJieException();
		}
		
		if(!user.getPassword().equals(password)){
			throw new PasswordErrorException();
		}
		return user;
	}

	@Override
	//ע��
	public void register(User user) {
		// TODO Auto-generated method stub
		//日志处理
		Logger logger = Logger.getLogger(UserServiceImpl.class);
		logger.warn("用户"+user.getUsername()+"被保存");
		userDao.saveUser(user);
	}

	@Override
	//�����޸�
	public void updatePassword(String username, String oldPwd,String newPwd) {
		// TODO Auto-generated method stub
			String oldPwd4MySql = userDao.findPasswordByUsername(username);
			//���ԭʼ��������ݿ��ѯ������һ��
			if(oldPwd.equals(oldPwd4MySql)){
				
					userDao.updatePasswordByUsername(username, newPwd);
			}else{
				throw new PasswordDifferentException();
			}
			
	}

	@Override
	public void updateInfo(String username, String realname, String address,
			String area, String postcode, String tel) {
		// TODO Auto-generated method stub
			userDao.updateTrafficByUsername(username, realname, address, area, postcode, tel);
	}

	/* (non-Javadoc)
	 * @see com.shopping.li.service.UserService#comment(com.shopping.po.UserGoods)
	 */
	@Override
	public void commentGoods(int uid,int gid,String comment) {
		// TODO Auto-generated method stub
		userDao.saveComment(uid,gid,comment);
	}

	/* (non-Javadoc)
	 * @see com.shopping.li.service.UserService#showComment(int, int)
	 */
	@Override
	public String showComment(int uid, int gid) {
		// TODO Auto-generated method stub
		String comment = userDao.findCommentById(uid, gid);
		return comment;
	}

	/* (non-Javadoc)
	 * @see com.shopping.li.service.UserService#showAllComment(int)
	 */
	@Override
	public List<UserGoods> showAllComment(int gid) {
		// TODO Auto-generated method stub
		List<UserGoods> list = userDao.findCommentByGid(gid);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.shopping.li.service.UserService#getUserByUsername(java.lang.String)
	 */
	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findUserByUsername(username);
	}

	/* (non-Javadoc)
	 * @see com.shopping.li.service.UserService#freezeUserById(int, int)
	 */
	@Override
	public void freezeUserById(int id, int state) {
		// TODO Auto-generated method stub
		userDao.freezeUserById(id, state);
	}

	/* (non-Javadoc)
	 * @see com.shopping.li.service.UserService#getUserById(int)
	 */
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.findUserById(id);
	}
}
