package com.shopping.zhang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.po.Category;
import com.shopping.po.Favorite;
import com.shopping.po.Goods;
import com.shopping.zhang.dao.FavoriteDao;
import com.shopping.zhang.dao.GoodsDao;
import com.shopping.li.dao.UserDao;
import com.shopping.util.DBUtil;
import com.shopping.util.DaoFactory;

public class FavoriteDao4MySqlImpl implements FavoriteDao {

	public void addFavorite(int uid, int gid) {

		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"insert into t_favorite values(?,?)");
		try {
			pstmt.setInt(1, uid);
			pstmt.setInt(2, gid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	public List<Goods> findFavoriteGoods(int uid) {
		List<Goods> goods = new ArrayList<Goods>();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil
				.getPstmt(conn,
						"select * from t_favorite f,t_goods g where f.gid=g.id and f.uid=?");
		ResultSet rs = null;
		try {
			pstmt.setInt(1, uid);
			rs = DBUtil.getRs(pstmt);
			while (rs.next()) {
				Goods good = new Goods();
				getGoods(rs, good);
				goods.add(good);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return goods;
	}

	public Goods getGoods(ResultSet rs, Goods good) {
		try {
			good.setId(rs.getInt("id"));
			good.setGname(rs.getString("gname"));
			good.setGdiscount(rs.getFloat("gdiscount"));
			good.setMarketPrice(rs.getFloat("marketPrice"));
			good.setSalPrice(rs.getFloat("salPrice"));
			good.setInfo(rs.getString("info"));
			good.setPhoto(rs.getString("photo"));
			good.setBargainPrice(rs.getInt("bargainPrice"));
			good.setPdate(rs.getTimestamp("pdate"));
			good.setNumber(rs.getInt("number"));
			good.setSort(new Category());
			good.setSalCount(rs.getInt("salCount"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return good;
	}

	public List<Favorite> findFavorite(int uid) {
		List<Favorite> favorites = new ArrayList<Favorite>();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select * from t_favorite where uid=?");
		ResultSet rs = null;
		try {
			pstmt.setInt(1, uid);
			rs = DBUtil.getRs(pstmt);
			while (rs.next()) {
				Favorite favorite = new Favorite();
				GoodsDao good = (GoodsDao) DaoFactory.getInstance("goodsDao");
				favorite.setGood(good.findGoodsById(rs.getInt("gid")));
				UserDao user = (UserDao) DaoFactory.getInstance("userDao");
				favorite.setUser(user.findUserById(rs.getInt("uid")));
				favorites.add(favorite);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return favorites;
	}
}
