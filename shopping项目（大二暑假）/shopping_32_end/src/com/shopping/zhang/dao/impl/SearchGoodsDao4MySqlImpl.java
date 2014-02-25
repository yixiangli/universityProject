package com.shopping.zhang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.po.Goods;
import com.shopping.zhang.dao.SearchGoodsDao;
import com.shopping.util.DBUtil;

public class SearchGoodsDao4MySqlImpl implements SearchGoodsDao {

	public List<Goods> searchGoods(int categoryId, String goodsName) {
		List<Goods> goods = new ArrayList<Goods>();

		goodsName = "%" + goodsName + "%";
		String sql = null;
		if (categoryId == 1) {
			sql = "select id,gname,gdiscount,marketPrice,salPrice,info,photo,number from t_goods where gname like ?";
		} else {
			sql = "select id,gname,gdiscount,marketPrice,salPrice,info,photo,number from t_goods where sortId in(select id from t_category where pid=?) and gname like ?";
		}
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn, sql);
		ResultSet rs = null;
		try {
			if (categoryId == 1) {
				pstmt.setString(1, goodsName);
			} else {
				pstmt.setInt(1, categoryId);
				pstmt.setString(2, goodsName);
			}

			rs = DBUtil.getRs(pstmt);
			while (rs.next()) {
				Goods good = new Goods();
				initGoods(rs, good);
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

	public void initGoods(ResultSet rs, Goods good) {
		try {
			good.setId(rs.getInt("id"));
			good.setGname(rs.getString("gname"));
			good.setGdiscount(rs.getFloat("gdiscount"));
			good.setMarketPrice(rs.getFloat("marketPrice"));
			good.setSalPrice(rs.getFloat("salPrice"));
			good.setInfo(rs.getString("info"));
			good.setPhoto(rs.getString("photo"));
			good.setNumber(rs.getInt("number"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
