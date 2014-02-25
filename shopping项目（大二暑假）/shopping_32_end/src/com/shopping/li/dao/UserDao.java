package com.shopping.li.dao;

import java.util.Date;
import java.util.List;
import com.shopping.po.User;
import com.shopping.po.UserGoods;
import com.sun.xml.internal.ws.message.StringHeader;

public interface UserDao extends BaseDao{
	
	//保存用户
	public void saveUser(User user);
	
	//通过用户名修改地址
	public void updateTrafficByUsername(String username,String realname,String address,String area,String postcode,String tel);
	
	//通过用户名修改密码
	public void updatePasswordByUsername(String username,String oldPassword);
	
	//通过id得到User
	public User findUserById(int id);
	
	//通过用户名得到User
	public User findUserByUsername(String username);
	
	//通过用户名查找密码
	public String findPasswordByUsername(String username);
	
	//用户评论
	public void saveComment(int uid,int gid,String comment);
	
	//显示某用户评论
	public String findCommentById(int uid,int gid);
	
	//显示某商品评论
	public List<UserGoods> findCommentByGid(int gid);
	
	//冻结帐号
	public void freezeUserById(int id,int state);
}
