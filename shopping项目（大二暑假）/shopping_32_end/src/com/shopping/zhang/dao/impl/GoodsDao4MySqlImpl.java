package com.shopping.zhang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.po.Goods;
import com.shopping.zhang.dao.GoodsDao;
import com.shopping.util.DBUtil;

public class GoodsDao4MySqlImpl implements GoodsDao {

	public List<Goods> getNewGoods() {
		List<Goods> goods = new ArrayList<Goods>();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select * from t_goods order by pdate desc");
		ResultSet rs = null;
		try {
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

	public List<Goods> getGoodsByBargainPrice() {
		List<Goods> goods = new ArrayList<Goods>();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select * from t_goods where bargainPrice=1");
		ResultSet rs = null;
		try {
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

	public List<Goods> sortGoodsBySalCount() {
		List<Goods> goods = new ArrayList<Goods>();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select * from t_goods order by salCount desc");
		ResultSet rs = null;
		try {
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
			good.setBargainPrice(rs.getInt("bargainPrice"));
			good.setPdate(rs.getTimestamp("pdate"));
			good.setNumber(rs.getInt("number"));
			good.setSort(new CategoryDao4MySqlImpl().findCategoryById(rs.getInt("sortId")));
			good.setSalCount(rs.getInt("salCount"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Goods findGoodsById(int id) {
		Goods good = null;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select * from t_goods where id=?");
		ResultSet rs = null;
		try {
			pstmt.setInt(1, id);
			rs = DBUtil.getRs(pstmt);
			if (rs.next()) {
				good = new Goods();
				initGoods(rs, good);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return good;
	}

	public List<Goods> getGoodsByCategoryId(int categoryId,String keyword) {
		List<Goods> goods = new ArrayList<Goods>();
		keyword = "%"+keyword+"%";
		String sql = "select * from t_goods where sortId=? and gname like ?";
//		//û������ؼ��֣����ѯ��������µ�������Ʒ
//		if("%%".equals(keyword)){
//			sql = "select * from t_goods";
//		}
		//�����˹ؼ��֣�����û��ѡ��С�࣬�������е���Ʒ��ƥ����Ӧ�Ĺؼ���
		if(categoryId == 1){
			sql = "select * from t_goods where gname like ?";
		}
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,sql);
		ResultSet rs = null;
		try {
			
			if(categoryId == 1){
			    pstmt.setString(1,keyword);
			}else if(categoryId > 1){
				pstmt.setInt(1,categoryId);
				pstmt.setString(2,keyword);
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

	public List<Goods> getGoods() {
		List<Goods> goods = new ArrayList<Goods>();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select * from t_goods");
		ResultSet rs = null;
		try {
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

	public void addGoods(Goods good) {
		
		String gname = good.getGname();
		float gdiscount = good.getGdiscount();
		float marketPrice = good.getMarketPrice();
		float salPrice = good.getSalPrice();
		String info = good.getInfo();
		String photo = good.getPhoto();
		int bargainPrice  = good.getBargainPrice();
		int sortId = good.getSort().getId();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"insert into t_goods values(null,?,?,?,?,?,?,?,now(),0,?,0)");
		try {
			pstmt.setString(1, gname);
			pstmt.setFloat(2, gdiscount);
			pstmt.setFloat(3, marketPrice);
			pstmt.setFloat(4, salPrice);
			pstmt.setString(5, info);
			pstmt.setString(6, photo);
			pstmt.setInt(7, bargainPrice);
			pstmt.setInt(8, sortId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	public void deleteGoodsById(int id) {
		deleteFavoriteGoodsById(id);
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"delete from t_goods where id=?");
		try {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}
	
	public void deleteFavoriteGoodsById(int id) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"delete from t_favorite where gid=?");
		try {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	public void updateGoodsById(Goods good, int id) {
		String gname = good.getGname();
		float gdiscount = good.getGdiscount();
		float marketPrice = good.getMarketPrice();
		float salPrice = good.getSalPrice();
		String info = good.getInfo();
		String photo = good.getPhoto();
		int bargainPrice  = good.getBargainPrice();
		int sortId = good.getSort().getId();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"update t_goods set gname=?,gdiscount=?,marketPrice=?,salPrice=?,info=?,photo=?,bargainPrice=?,sortId=? where id=?");
		try {
			pstmt.setString(1, gname);
			pstmt.setFloat(2, gdiscount);
			pstmt.setFloat(3, marketPrice);
			pstmt.setFloat(4, salPrice);
			pstmt.setString(5, info);
			pstmt.setString(6, photo);
			pstmt.setInt(7, bargainPrice);
			pstmt.setInt(8, sortId);
			pstmt.setInt(9, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}
	public List<Goods> getGoods(int startIndex, int length) {
		List<Goods> goods = new ArrayList<Goods>();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select * from t_goods limit ?,?");
		ResultSet rs = null;
		try {
			pstmt.setInt(1,startIndex);
			pstmt.setInt(2,length);
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

	public void addGoodsNum(int gid,int num) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"update t_goods set number=? where id=?");
		try {
			if(num == 0){
				pstmt.setInt(1,getGoodsNum(gid));
			}else if(num > 0){
				pstmt.setInt(1,num);
			}
			pstmt.setInt(2,gid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}
	public int getGoodsNum(int gid){
		int goodsNum = 0;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,
				"select number from t_goods where id=?");
		ResultSet rs = null;
		try {
			pstmt.setInt(1,gid);
			rs = DBUtil.getRs(pstmt);
			while (rs.next()) {
				goodsNum = rs.getInt("number")+1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return goodsNum;
	}
}
