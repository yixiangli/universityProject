package com.shopping.li.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shopping.li.dao.UserDao;
import com.shopping.po.User;
import com.shopping.po.UserGoods;
import com.shopping.util.DBUtil;


public class UserDao4MySqlImpl implements UserDao{

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "insert into t_user values(null,?,?,?,?,?,?,?,?,0,now(),0,0)");
		
		try {
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getRealname());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getArea());
			pstmt.setString(7, user.getPostcode());
			pstmt.setString(8, user.getTel());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}				
	}

	@Override
	public void updateTrafficByUsername(String username,String realname,String address,String area,String postcode,String tel) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "update t_user set realname=?,address=?,area=?,postcode=?,tel=? where username=?");
		
		try {
			pstmt.setString(1, realname);
			pstmt.setString(2, address);
			pstmt.setString(3, area);
			pstmt.setString(4, postcode);
			pstmt.setString(5, tel);			
			pstmt.setString(6, username);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}


	@Override
	public void updatePasswordByUsername(String username, String newPassword) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "update t_user set password=? where username=?");
		
		try {
			pstmt.setString(1, newPassword);
			pstmt.setString(2, username);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	//����ƥ�� ����ԭʼ����
	public String findPasswordByUsername(String username) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,"select password from t_user where username=?");
		ResultSet rs = null;
		String oldPassword = null;
		
		try {
			
			pstmt.setString(1, username);
			rs = DBUtil.getRs(pstmt);
			
			while(rs.next()){
				//���ҵ��û�Ա��ԭʼ����
				oldPassword = rs.getString(1);				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		return oldPassword;
		
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from t_user where id=?");
		ResultSet rs = null;
		User user = null;
		
		try {	
				pstmt.setInt(1, id);				
				rs = DBUtil.getRs(pstmt);	
				
				while(rs.next()){
					user = new User();	
					this.findUserProperty(user, rs);		
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		return user;
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from t_user where username=?");
		ResultSet rs = null;
		User user = null;
		
		try {	
				pstmt.setString(1, username);				
				rs = DBUtil.getRs(pstmt);	
				
				while(rs.next()){
					user = new User();	
					this.findUserProperty(user, rs);		
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		return user;
	}
	
	
	private void findUserProperty(User user,ResultSet rs){
		try {
			user.setId(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setRealname(rs.getString(5));
			user.setAddress(rs.getString(6));
			user.setArea(rs.getString(7));
			user.setPostcode(rs.getString(8));
			user.setTel(rs.getString(9));
			user.setType(rs.getInt(10));
			user.setPdate(rs.getTimestamp(11));
			user.setState(rs.getInt(12));
			user.setSpend(rs.getInt(13));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/* (non-Javadoc)
	 * @see com.shopping.li.dao.UserDao#saveComment(com.shopping.po.User_goods)
	 */
	@Override
	public void saveComment(int uid,int gid,String comment) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "insert into t_user_goods values(?,?,?,now())");
			
		try {
			pstmt.setInt(1,uid);
			pstmt.setInt(2, gid);
			pstmt.setString(3,comment);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.shopping.li.dao.UserDao#findCommentById(int, int)
	 */
	@Override
	public String findCommentById(int uid, int gid) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "select comment from t_user_goods where uid=? and gid=?");
		ResultSet rs = null;
		String comment = null;
		
		try {
			pstmt.setInt(1, uid);
			pstmt.setInt(2, gid);
			pstmt.executeUpdate();
			
			rs = DBUtil.getRs(pstmt);
			
			while (rs.next()) {
				
				comment = rs.getString(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return comment;
	}

	/* (non-Javadoc)
	 * @see com.shopping.li.dao.UserDao#findCommentByGid(int)
	 */
	@Override
	public List<UserGoods> findCommentByGid(int gid) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "select * from t_user_goods where gid=?");
		ResultSet rs = null;
		List<UserGoods> list = new ArrayList<UserGoods>();
		
		try {
			pstmt.setInt(1, gid);
			rs = DBUtil.getRs(pstmt);
			
			while (rs.next()) {
				
				UserGoods userGoods = new UserGoods();
				userGoods.setUid(rs.getInt(1));
				userGoods.setGid(gid);
				userGoods.setComment(rs.getString(3));
				userGoods.setCommentTime(rs.getTimestamp(4));
				list.add(userGoods);	
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
		
	}

	/* (non-Javadoc)
	 * @see com.shopping.li.dao.UserDao#freezeUserById(int, int)
	 */
	@Override
	public void freezeUserById(int id, int state) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "update t_user set state = ? where id = ?");
		try {
			
			pstmt.setInt(1, state);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

}
