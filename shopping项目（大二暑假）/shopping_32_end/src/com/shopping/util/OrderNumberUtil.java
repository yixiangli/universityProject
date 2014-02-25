package com.shopping.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class OrderNumberUtil {
   public static String getOrderNumber(){
	   Connection conn = DBUtil.getConn();
		  PreparedStatement pstmt = DBUtil.getPstmt(conn,"select count(*) from t_order");
		  ResultSet rs = DBUtil.getRs(pstmt);
		  int count = 0;
		  try {
			while(rs.next()){
			  count = rs.getInt(1);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	  String str = ++count + "";
	  StringBuffer s = new StringBuffer("");
	  s.append(getTimeStamp()).append(addZero(str));
	  return s.toString();
   }
   //得到一个当前的系统时间
   private static String getTimeStamp(){
	   String timeStamp = new SimpleDateFormat("yyyyMMdd").format(new Date());
	   return timeStamp;
   }
   //对传入的字符串进行补零处理
   private static String addZero(String str){
	   if(str.length() == 4){
		   return str;
	   }else{
		   return addZero("0"+str);
	   }
   }
}
