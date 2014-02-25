package com.shopping.song.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.li.dao.impl.UserDao4MySqlImpl;
import com.shopping.po.Order;
import com.shopping.song.dao.OrderDao;
import com.shopping.util.DBUtil;
import com.shopping.util.OrderNumberUtil;

public class OrderDao4MysqlImpl implements OrderDao {

	public int generateOrder(String orderId,int uid,String receiveName,int timeDemand,int postcode,String phone,int orderType,float orderSal,String orderAddress,int receiveWay,int payWay,String remark) {
		// TODO Auto-generated method stub
		int result = -1;
		Connection conn = DBUtil.getConn();
    	PreparedStatement pstmt = DBUtil.getPstmt(conn,"insert into t_order values(?,now(),?,?,?,?,?,?,?,?,?,?,?)");
        try {
        	pstmt.setString(1,orderId);
			pstmt.setInt(2,uid);
			pstmt.setString(3,receiveName);
			pstmt.setInt(4,timeDemand);
			pstmt.setInt(5,postcode);
			pstmt.setString(6,phone);
			pstmt.setInt(7,orderType);
			pstmt.setFloat(8,orderSal);
			pstmt.setString(9,orderAddress);
            pstmt.setInt(10,receiveWay);
			pstmt.setInt(11,payWay);
			pstmt.setString(12,remark);
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
	public int delOrderById(String orderId) {
		// TODO Auto-generated method stub
		int result = -1;
        Connection conn = DBUtil.getConn();
       
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"delete from t_order where orderId=?");
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
	public List<Order> getOrders(int uid) {
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<Order>();
		
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from t_order where uid=?");
	    ResultSet rs = null;
	    try {
			pstmt.setInt(1,uid);
			rs = DBUtil.getRs(pstmt);
			while(rs.next()){
				Order order = new Order();
				order.setOrderId(rs.getString(1));
				order.setOrderTime(rs.getTimestamp(2));
				order.setUser(new UserDao4MySqlImpl().findUserById(uid));
				order.setReceiveName(rs.getString(4));
				order.setTimeDemand(rs.getInt(5));
				order.setPostcode(rs.getInt(6));
				order.setPhone(rs.getString(7));

				order.setOrderType(rs.getInt(8));
				order.setOrderSale(rs.getFloat(9));
				order.setOrderAddress(rs.getString(10));
				order.setReceiveWay(rs.getString(11));
				order.setPayWay(rs.getString(12));
				order.setRemark(rs.getString(13));
				orders.add(order);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	    return orders;
		
	}

	@Override
	public Order findOrderById(String orderId) {
		// TODO Auto-generated method stub
		Order order = new Order();
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from t_order where orderId=?");
		ResultSet rs = null;
		try {
			pstmt.setString(1,orderId);
			rs = DBUtil.getRs(pstmt);
			while(rs.next()){
				order.setOrderId(orderId);
				order.setOrderTime(rs.getTimestamp(2));
				order.setUser(new UserDao4MySqlImpl().findUserById(rs.getInt(3)));
				order.setReceiveName(rs.getString(4));
				order.setTimeDemand(rs.getInt(5));
				order.setPostcode(rs.getInt(6));
				order.setPhone(rs.getString(7));

				order.setOrderType(rs.getInt(8));
				order.setOrderSale(rs.getFloat(9));
				order.setOrderAddress(rs.getString(10));
				order.setReceiveWay(rs.getString(11));
				order.setPayWay(rs.getString(12));
				order.setRemark(rs.getString(13));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return order;
	}

	@Override
	public int alterOrderSale(String orderId, float orderSal) {
		// TODO Auto-generated method stub
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;		
		try {
			conn = DBUtil.getConn();
			pstmt = DBUtil.getPstmt(conn, "update t_order set orderSal=? where orderId=?");
			pstmt.setDouble(1, orderSal);
			pstmt.setString(2, orderId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
				List<Order> orders = new ArrayList<Order>();
				
				Connection conn = DBUtil.getConn();
				PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from t_order ORDER BY orderTime DESC");
			    ResultSet rs = null;
			    try {
					rs = DBUtil.getRs(pstmt);
					while(rs.next()){
						Order order = new Order();
						order.setOrderId(rs.getString(1));
						order.setOrderTime(rs.getTimestamp(2));
						order.setUser(new UserDao4MySqlImpl().findUserById(rs.getInt(3)));
						order.setReceiveName(rs.getString(4));
						order.setTimeDemand(rs.getInt(5));
						order.setPostcode(rs.getInt(6));
						order.setPhone(rs.getString(7));

						order.setOrderType(rs.getInt(8));
						order.setOrderSale(rs.getFloat(9));
						order.setOrderAddress(rs.getString(10));
						order.setReceiveWay(rs.getString(11));
						order.setPayWay(rs.getString(12));
						order.setRemark(rs.getString(13));
						orders.add(order);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					DBUtil.close(rs);
					DBUtil.close(pstmt);
					DBUtil.close(conn);
				}
			    return orders;
	}

	@Override
	public int alterOrderStatus(String orderId,int orderType) {
		// TODO Auto-generated method stub
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;		
		try {
			conn = DBUtil.getConn();
			pstmt = DBUtil.getPstmt(conn, "update t_order set orderType=? where orderId=?");
			pstmt.setInt(1, orderType);
			pstmt.setString(2, orderId);
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
	public List<Order> getOrdersByOrderType(int orderType) {
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<Order>();
		
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from t_order where orderType = ? ORDER BY orderTime DESC");
	    ResultSet rs = null;
	    try {
	    	pstmt.setInt(1,orderType);
			rs = DBUtil.getRs(pstmt);
			while(rs.next()){
				Order order = new Order();
				order.setOrderId(rs.getString(1));
				order.setOrderTime(rs.getTimestamp(2));
				order.setUser(new UserDao4MySqlImpl().findUserById(rs.getInt(3)));
				order.setReceiveName(rs.getString(4));
				order.setTimeDemand(rs.getInt(5));
				order.setPostcode(rs.getInt(6));
				order.setPhone(rs.getString(7));

				order.setOrderType(rs.getInt(8));
				order.setOrderSale(rs.getFloat(9));
				order.setOrderAddress(rs.getString(10));
				order.setReceiveWay(rs.getString(11));
				order.setPayWay(rs.getString(12));
				order.setRemark(rs.getString(13));
				orders.add(order);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	    return orders;
	}

	@Override
	public int getAllOrdersCount4Admin() {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConn();
			pstmt = DBUtil.getPstmt(conn, "select count(*) from t_order");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return result;
	}

	@Override
	public int getSearchOrderCount4Admin(int orderType) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConn();
			pstmt = DBUtil.getPstmt(conn, "select count(*) from t_order where orderType = ?");
			pstmt.setInt(1,orderType);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return result;
	}

	@Override
	public List<Order> getAllOrders(int startIndex, int length) {
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<Order>();
		
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from t_order ORDER BY orderTime DESC limit ?,?");
	    ResultSet rs = null;
	    try {
	    	pstmt.setInt(1, startIndex);
	    	pstmt.setInt(2, length);

			rs = DBUtil.getRs(pstmt);
			while(rs.next()){
				Order order = new Order();
				order.setOrderId(rs.getString(1));
				order.setOrderTime(rs.getTimestamp(2));
				order.setUser(new UserDao4MySqlImpl().findUserById(rs.getInt(3)));
				order.setReceiveName(rs.getString(4));
				order.setTimeDemand(rs.getInt(5));
				order.setPostcode(rs.getInt(6));
				order.setPhone(rs.getString(7));

				order.setOrderType(rs.getInt(8));
				order.setOrderSale(rs.getFloat(9));
				order.setOrderAddress(rs.getString(10));
				order.setReceiveWay(rs.getString(11));
				order.setPayWay(rs.getString(12));
				order.setRemark(rs.getString(13));
				orders.add(order);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	    return orders;
	}

	@Override
	public List<Order> getOrdersByOrderType(int orderType, int startIndex,
			int length) {
		// TODO Auto-generated method stub
        List<Order> orders = new ArrayList<Order>();
		
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from t_order where orderType = ? ORDER BY orderTime DESC limit ?,?");
	    ResultSet rs = null;
	    try {
	    	pstmt.setInt(1,orderType);
	    	pstmt.setInt(2,startIndex);
	    	pstmt.setInt(3,length);

			rs = DBUtil.getRs(pstmt);
			while(rs.next()){
				Order order = new Order();
				order.setOrderId(rs.getString(1));
				order.setOrderTime(rs.getTimestamp(2));
				order.setUser(new UserDao4MySqlImpl().findUserById(rs.getInt(3)));
				order.setReceiveName(rs.getString(4));
				order.setTimeDemand(rs.getInt(5));
				order.setPostcode(rs.getInt(6));
				order.setPhone(rs.getString(7));

				order.setOrderType(rs.getInt(8));
				order.setOrderSale(rs.getFloat(9));
				order.setOrderAddress(rs.getString(10));
				order.setReceiveWay(rs.getString(11));
				order.setPayWay(rs.getString(12));
				order.setRemark(rs.getString(13));
				orders.add(order);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	    return orders;
	}

	@Override
	public int getOrdersCount4User(int uid) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConn();
			pstmt = DBUtil.getPstmt(conn, "select count(*) from t_order where uid = ?");
			pstmt.setInt(1,uid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return result;	
		}

	@Override
	public List<Order> getOrdersByUid(int uid, int startIndex, int length) {
		// TODO Auto-generated method stub
		 List<Order> orders = new ArrayList<Order>();
			
			Connection conn = DBUtil.getConn();
			PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from t_order where uid = ? ORDER BY orderTime DESC limit ?,?");
		    ResultSet rs = null;
		    try {
		    	pstmt.setInt(1,uid);
		    	pstmt.setInt(2,startIndex);
		    	pstmt.setInt(3,length);

				rs = DBUtil.getRs(pstmt);
				while(rs.next()){
					Order order = new Order();
					order.setOrderId(rs.getString(1));
					order.setOrderTime(rs.getTimestamp(2));
					order.setUser(new UserDao4MySqlImpl().findUserById(rs.getInt(3)));
					order.setReceiveName(rs.getString(4));
					order.setTimeDemand(rs.getInt(5));
					order.setPostcode(rs.getInt(6));
					order.setPhone(rs.getString(7));

					order.setOrderType(rs.getInt(8));
					order.setOrderSale(rs.getFloat(9));
					order.setOrderAddress(rs.getString(10));
					order.setReceiveWay(rs.getString(11));
					order.setPayWay(rs.getString(12));
					order.setRemark(rs.getString(13));
					orders.add(order);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.close(rs);
				DBUtil.close(pstmt);
				DBUtil.close(conn);
			}
		    return orders;
	}

}
