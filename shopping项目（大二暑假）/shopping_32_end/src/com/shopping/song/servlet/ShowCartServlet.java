package com.shopping.song.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.shopping.po.Goods;

import com.shopping.zhang.service.impl.GoodsServiceImpl;

public class ShowCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
	    //System.out.println("555555555");
		if (cookies != null && cookies.length>1) {
			StringBuffer s = new StringBuffer("[");
			for(int i=1;i<cookies.length;i++){
				//System.out.println(cookies[0].getName());
				   Goods goods = GoodsServiceImpl.getInstance().showGoodsById(Integer.parseInt(cookies[i].getName()));
				   int id = goods.getId();
				   String gname = goods.getGname();
				   float marketPrice = goods.getMarketPrice();
				   float salPrice = goods.getSalPrice();
				   float discount = goods.getGdiscount();
				   int amount = Integer.parseInt(cookies[i].getValue());
				   float totalMprice = marketPrice*amount;
				   float totalSprice = salPrice*amount;
				   //s.append("{\"id\":"+id+",\"gname\":"+gname+",\"marketPrice\":"+marketPrice+",\"salPrice\":"+salPrice+",\"discount\":"+discount+",\"amount\":"+amount+",\"totalMprice\":"+totalMprice+",\"totalSprice\":"+totalSprice+"},");
			       s.append("{id:").append(id).append(",").append("gname:").append("\"").append(gname).append("\"").append(",").append("marketPrice:").append("\"").append(marketPrice).append("\"").append(",").append("salPrice:").append("\"").append(salPrice).append("\"").append(",").append("discount:").append("\"").append(discount).append("\"").append(",").append("amount:").append("\"").append(amount).append("\"").append(",").append("totalMprice:").append("\"").append(totalMprice).append("\"").append(",").append("totalSprice:").append("\"").append(totalSprice).append("\"").append("},");
			   }
			   s.deleteCharAt(s.length()-1);
			   s.append("]");
			   out.print(s);
			   //System.out.println(s);
			  
		}
		else {
			out.print("[]");
		}
		
		out.flush();
		out.close();
	}

}
