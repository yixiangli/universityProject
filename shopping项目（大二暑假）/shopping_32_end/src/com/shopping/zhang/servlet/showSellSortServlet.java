package com.shopping.zhang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.po.Goods;
import com.shopping.zhang.service.impl.GoodsServiceImpl;

public class showSellSortServlet extends HttpServlet {
	private static final long serialVersionUID = -4641645421140020922L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control","no-cache"); 
		response.setHeader("Cache-Control","no-store"); 
		response.setDateHeader("Expires",0); 
		response.setHeader("Pragma","no-cache"); 
		
		List<Goods> sellGoods = GoodsServiceImpl.getInstance().showSortGoodsBySalCount();
		
		StringBuffer str = new StringBuffer("[");
		Iterator<Goods> goods = sellGoods.iterator();
		while(goods.hasNext()){
			Goods good = goods.next();
			str.append("{id:").append(good.getId()).append(",").append("gname:").append("\"").append(good.getGname()).append("\"").append("},");
		}
		str.deleteCharAt(str.length()-1);
		str.append("]");
		PrintWriter out = response.getWriter();
  		out.print(str);
	    out.flush();
	    out.close();
	}

}
