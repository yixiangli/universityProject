package com.shopping.li.service;

import java.util.List;

import com.shopping.po.User;
import com.shopping.po.UserGoods;

public interface UserService {

	//登陆
	public User login(String username,String password);
	
	//注册
	public void register(User user);
	
	//修改密码
	public void updatePassword(String username,String oldPwd,String newPwd);
	
	//修改信息
	public void updateInfo(String username,String realname,String address,String area,String postcode,String tel);
	
	//保存评论
	public void commentGoods(int uid,int gid,String comment);
	
	//显示评论内容
	public String showComment(int uid,int gid);
	
	//显示某商品全部评论内容
	public List<UserGoods> showAllComment(int gid);
	
	//验证用户名是否存在
	public User getUserByUsername(String username);
	
	//冻结用户
	public void freezeUserById(int id,int state);
	
	//通过id得到User
	public User getUserById(int id);
}
