/**
* @package_name   com.shopping.li.dao.impl
* @file_name AdminDao4MySqlImpl.java
* @author Administrator
* @date 2013-7-23
*/
package com.shopping.li.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.li.dao.AdminDao;
import com.shopping.po.Admin;
import com.shopping.po.User;
import com.shopping.util.DBUtil;
import com.sun.java_cup.internal.runtime.virtual_parse_stack;

/** 
 * @ClassName: AdminDao4MySqlImpl
 * @Description: TODO
 */
public class AdminDao4MySqlImpl implements AdminDao {

	/* (non-Javadoc)
	 * @see com.shopping.li.dao.AdminDao#findAdminByUsername(java.lang.String)
	 */
	@Override
	public Admin findAdminByUsername(String username) {
		// TODO Auto-generated method stub
		
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "select password from t_admin where username=?");
		ResultSet rs = null;
		Admin admin = new Admin();

		try {
			pstmt.setString(1, username);			
			rs = DBUtil.getRs(pstmt);
			
			while (rs.next()) {
				admin.setPassword(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
				
		return admin;
	}

	/* (non-Javadoc)
	 * @see com.shopping.li.dao.AdminDao#findUser()
	 */
	@Override
	public List<User> findUser() {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "select * from t_user");
		ResultSet rs = DBUtil.getRs(pstmt);
		List<User> list = new ArrayList<User>();

		try {
			while (rs.next()) {
				User user = new User();
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
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		return list;
	}

	/* (non-Javadoc)
	 * @see com.shopping.li.dao.AdminDao#findUserByUsername(java.lang.String)
	 */
	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "select * from t_user where username=?");
		ResultSet rs = null;	
		User user = null;
		
		try {
			
			pstmt.setString(1, username);			
			rs = DBUtil.getRs(pstmt);
			
			while (rs.next()) {
				user = new User();
				
				user.setId(rs.getInt(1));
				user.setUsername(username);
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

	/* (non-Javadoc)
	 * @see com.shopping.li.dao.AdminDao#findUser(int, int)
	 */
	@Override
	public List<User> findUser(int startIndex, int length) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, "select * from t_user limit ?,?");
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();

		try {
			
			pstmt.setInt(1,startIndex);
			pstmt.setInt(2,length);
			rs = DBUtil.getRs(pstmt);
			
			while (rs.next()) {
				User user = new User();
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
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		return list;
	}

}
