package com.shopping.song.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.po.User;
import com.shopping.song.service.impl.OrderGoodServiceImpl;
import com.shopping.song.service.impl.OrderServiceImpl;
import com.shopping.util.OrderNumberUtil;
import com.shopping.zhang.service.impl.GoodsServiceImpl;

public class SubmitCartServlet extends HttpServlet {

		public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			PrintWriter out = response.getWriter();
			
			String msg = "订单提交失败";
			
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");

			String orderId = OrderNumberUtil.getOrderNumber();
			int uid = user.getId();
			float orderSal = (float) 0.0;
			String receiveName = request.getParameter("recievename");
			String orderAddress = request.getParameter("address");
			int postcode = Integer.parseInt(request.getParameter("postcode"));
			String phone = request.getParameter("phone");
			int payWay = Integer.parseInt(request.getParameter("paymethod"));
			
			int receiveWay = Integer.parseInt(request.getParameter("recievemethod"));
			int timeDemand = Integer.parseInt(request.getParameter("timedemand"));
			int orderType = 1;
			String remark = request.getParameter("remark");
			int result = OrderServiceImpl.getInstance().createOrder(orderId,uid,receiveName,timeDemand,postcode,phone,orderType,orderSal,orderAddress,receiveWay,payWay,remark);
			
			if(result == 1) {
				Cookie[] cookies = request.getCookies();
				if (cookies != null && cookies.length>1) {
					for(int i=1;i<cookies.length;i++) {
						int goodsId = Integer.parseInt(cookies[i].getName());
						//String goodsName = GoodsServiceImpl.getInstance().showGoodsById(goodsId).getGname();
						//得到商品单价
						float unitprice = GoodsServiceImpl.getInstance().showGoodsById(goodsId).getSalPrice();
						int pcount = Integer.parseInt(cookies[i].getValue());
						//计算每样商品的小计，总价累加
						float totalMoney = unitprice * pcount;
						orderSal += totalMoney;
						//添加一个订单项
						OrderGoodServiceImpl.getInstance().saveRecords(orderId,goodsId,unitprice,pcount);
					}
					//更新总价格
					OrderServiceImpl.getInstance().alterOrderSale(orderId, orderSal);
					//修改返回信息
					msg = "订单提交成功";
				}
			}
			out.print(msg);
			out.flush();
			out.close();
		

		
	}

		public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	      
			this.doGet(request, response);

	}

}
