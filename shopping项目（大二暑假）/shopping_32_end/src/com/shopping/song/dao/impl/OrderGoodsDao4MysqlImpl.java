package com.shopping.song.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.po.Goods;
import com.shopping.po.OrderGoods;
import com.shopping.song.dao.OrderGoodsDao;
import com.shopping.util.DBUtil;
import com.shopping.util.DBUtil;
import com.shopping.zhang.dao.impl.GoodsDao4MySqlImpl;

public class OrderGoodsDao4MysqlImpl implements OrderGoodsDao {

	@Override
	public List<Goods> getGoodsByOrderId(String orderId) {
		// TODO Auto-generated method stub
		List<Goods> goodsList = new ArrayList<Goods>();
		
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,"select gid from t_order_goods where oid=?");
		ResultSet rs = null;
		try {
			pstmt.setString(1,orderId);
			rs = DBUtil.getRs(pstmt);
			
			while(rs.next()){
				Goods goods = new Goods();
				goods = new GoodsDao4MySqlImpl().findGoodsById(rs.getInt(1));
				System.out.println(goods.getGname());
				goodsList.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return goodsList;
	}

	@Override
	public int saveRecordOfOrderGoods(String oid,int gid,float unitprice,int pcount) {
		// TODO Auto-generated method stub
		int result = -1;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,"insert into t_order_goods values(null,?,?,?,?)");
		try {
			pstmt.setString(1,oid);
			pstmt.setInt(2,gid);
			pstmt.setFloat(3,unitprice);
			pstmt.setInt(4,pcount);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return result;
	}

	@Override
	public List<Integer> getGIDByOrderId(String orderId) {
		// TODO Auto-generated method stub
		List<Integer> gidList = new ArrayList<Integer>();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,"select gid from t_order_goods where oid=?");
		ResultSet rs = null;
		try {
			pstmt.setString(1,orderId);
			rs = DBUtil.getRs(pstmt);
			while(rs.next()){
				gidList.add(rs.getInt("gid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return gidList;
	}

	@Override
	public int delOrderGoodsByOrderId(String orderId) {
		// TODO Auto-generated method stub
		int result = -1;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,"delete from t_order_goods where oid=?");
		try {
			pstmt.setString(1,orderId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return result;
	}

	@Override
	public List<OrderGoods> getOrderGoodsByOrderId(String orderId) {
		// TODO Auto-generated method stub
        List<OrderGoods> orderGoodsList = new ArrayList<OrderGoods>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConn();
			pstmt = DBUtil.getPstmt(conn, "select * from t_order_goods where oid=?");
			pstmt.setString(1, orderId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderGoods orderGoods = new OrderGoods();
				orderGoods.setId(rs.getInt(1));
				orderGoods.setOrderId(rs.getString(2));

				orderGoods.setGoodsId(rs.getInt(3));
				orderGoods.setUnitPrice(rs.getFloat(4));
				orderGoods.setPcount(rs.getInt(5));
				
				orderGoodsList.add(orderGoods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return orderGoodsList;
	}

}
