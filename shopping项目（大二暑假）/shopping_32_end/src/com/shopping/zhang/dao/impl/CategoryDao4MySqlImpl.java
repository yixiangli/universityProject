package com.shopping.zhang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.po.Category;
import com.shopping.zhang.dao.CategoryDao;
import com.shopping.util.DBUtil;

public class CategoryDao4MySqlImpl implements CategoryDao {

	
	public Category findCategoryById(int id) {
		Category category = null;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select * from t_category where id=?");
		ResultSet rs = null;
		try {
			pstmt.setInt(1, id);
			rs = DBUtil.getRs(pstmt);
			if (rs.next()) {
				category = new Category();
				initCategory(rs, category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return category;
	}

	private void initCategory(ResultSet rs, Category category) {
		try {
			category.setId(rs.getInt("id"));
			category.setName(rs.getString("name"));
			category.setPid(rs.getInt("pid"));
			List<Category> c = getChildrenCategoryById(rs.getInt("id"));
			category.setInfo(rs.getString("info"));
			category.setChildren(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Category> getCategory() {
		List<Category> categories = new ArrayList<Category>();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select * from t_category where id>1");
		ResultSet rs = null;
		try {
			rs = DBUtil.getRs(pstmt);
			while(rs.next()) {
				Category category = new Category();
				initCategory(rs, category);
				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return categories;
	}
	
	public List<Category> getChildrenCategoryById(int id) {
		List<Category> categories = new ArrayList<Category>();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select * from t_category where pid=?");
		ResultSet rs = null;
		
		try {
			pstmt.setInt(1, id);
			rs = DBUtil.getRs(pstmt);
			
			while(rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setPid(rs.getInt("pid"));
				if(id == 1){
					List<Category> c = getChildrenCategoryById(rs.getInt("id"));
				    category.setChildren(c);
				}else{
					category.setChildren(null);
				}
				category.setInfo(rs.getString("info"));
				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return categories;
	}
	
	public List<Category> getBigCategory() {
		List<Category> categories = new ArrayList<Category>();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select * from t_category where pid=1 and id>1");
		ResultSet rs = null;
		try {
			rs = DBUtil.getRs(pstmt);
			while(rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setPid(1);
				category.setInfo(rs.getString("info"));
				category.setChildren(null);
				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		return categories;
	}

	public void addCategory(String name,int pid,String info) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"insert into t_category values(null,?,?,?)");
		try {
			pstmt.setString(1, name);
			pstmt.setInt(2,pid);
			pstmt.setString(3, info);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
	}
    //ɾ�����������С������ɾ��С����ɾ�����
	public void deleteCategory(int id) {
		List<Category> categories = getChildrenCategoryById(id);
		if(categories.size() == 0){
			Connection conn = DBUtil.getConn();
			PreparedStatement pstmt = DBUtil.getPstmt(conn,
					"delete from t_category where id=?");
			try {
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(pstmt);
				DBUtil.close(conn);
			}
		}else{
			Connection conn = DBUtil.getConn();
			PreparedStatement pstmt = DBUtil.getPstmt(conn,
					"delete from t_category where pid=?");
			try {
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(pstmt);
				DBUtil.close(conn);
			}
			deleteCategory(id);
		}
		
	}
}
