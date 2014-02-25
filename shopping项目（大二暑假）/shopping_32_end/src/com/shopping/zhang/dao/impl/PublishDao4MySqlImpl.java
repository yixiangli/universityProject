package com.shopping.zhang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shopping.po.Publish;
import com.shopping.zhang.dao.PublishDao;
import com.shopping.util.DBUtil;

public class PublishDao4MySqlImpl implements PublishDao {

	public List<Publish> getPublish() {
		List<Publish> publishs = new ArrayList<Publish>();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select * from t_publish");
		ResultSet rs = null;
		try {
			rs = DBUtil.getRs(pstmt);
			while (rs.next()) {
				Publish publish = new Publish();
				publish.setId(rs.getInt("id"));
				publish.setTitle(rs.getString("title"));
				publish.setContent(rs.getString("content"));
				publish.setPublishTime(rs.getTimestamp("publishTime"));
				publish.setOutTime(rs.getTimestamp("outTime"));
				publishs.add(publish);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return publishs;
	}

	public void addPublish(Publish publish) {
		String title = publish.getTitle();
		String content = publish.getContent();
		Date publishTime = publish.getPublishTime();
		Date outTime = publish.getOutTime();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"insert into t_publish values(null,?,?,?,?)");
		try {
			pstmt.setString(1,title);
			pstmt.setString(2, content);
			pstmt.setTimestamp(3, (Timestamp) publishTime);
			pstmt.setTimestamp(4, (Timestamp) outTime);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	public void deletePublishById(int id) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"delete from t_publish where id=?");
		try {
			pstmt.setInt(1,id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	public Publish findPublishById(int id) {
		Publish publish = null;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select * from t_publish where id=?");
		ResultSet rs = null;
		try {
			pstmt.setInt(1, id);
			rs = DBUtil.getRs(pstmt);
			while (rs.next()) {
				publish = new Publish();
				publish.setId(rs.getInt("id"));
				publish.setTitle(rs.getString("title"));
				publish.setContent(rs.getString("content"));
				publish.setPublishTime(rs.getTimestamp("publishTime"));
				publish.setOutTime(rs.getTimestamp("outTime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return publish;
	}

	public void updatePublishById(Publish publish,int id) {
		String title = publish.getTitle();
		String content = publish.getContent();
		Date publishTime = publish.getPublishTime();
		Date outTime = publish.getOutTime();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"update t_publish set title=?,content=?,publishTime=?,outTime=? where id=?");
		try {
			pstmt.setString(1,title);
			pstmt.setString(2, content);
			pstmt.setTimestamp(3, (Timestamp) publishTime);
			pstmt.setTimestamp(4, (Timestamp) outTime);
			pstmt.setInt(5, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	public List<Publish> getPublish(int startIndex, int length) {
		List<Publish> publishs = new ArrayList<Publish>();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select * from t_publish limit ?,?");
		ResultSet rs = null;
		try {
			pstmt.setInt(1,startIndex);
			pstmt.setInt(2,length);
			rs = DBUtil.getRs(pstmt);
			while (rs.next()) {
				Publish publish = new Publish();
				publish.setId(rs.getInt("id"));
				publish.setTitle(rs.getString("title"));
				publish.setContent(rs.getString("content"));
				publish.setPublishTime(rs.getTimestamp("publishTime"));
				publish.setOutTime(rs.getTimestamp("outTime"));
				publishs.add(publish);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return publishs;
	}

}
