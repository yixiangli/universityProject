package com.shopping.song.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.po.Order;
import com.shopping.po.OrderGoods;
import com.shopping.po.User;
import com.shopping.song.service.OrderGoodService;
import com.shopping.song.service.OrderService;
import com.shopping.song.service.impl.OrderGoodServiceImpl;
import com.shopping.song.service.impl.OrderServiceImpl;
import com.shopping.zhang.service.GoodsService;
import com.shopping.zhang.service.impl.GoodsServiceImpl;

public class ShowOrderServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//显示用户订单
		  
				OrderService orderService = OrderServiceImpl.getInstance();
				OrderGoodService orderGoodService = OrderGoodServiceImpl.getInstance();

				GoodsService goodsService = GoodsServiceImpl.getInstance();
				
				//int page = Integer.parseInt(request.getParameter("page"));
				//int singlePageCount = Integer.parseInt(request.getParameter("singlePageCount"));
				
				PrintWriter out = response.getWriter();
				StringBuffer jsonString = new StringBuffer("[");
				
				//迭代订单
				int uid = ((User)request.getSession().getAttribute("user")).getId();
				List<Order> orders = orderService.showOrders(uid);
				for(Iterator<Order> i = orders.iterator();i.hasNext();) {
					Order order = i.next();
					String orderId = order.getOrderId();
					String pdate = order.getOrderTime().toString();
					String receiveName = order.getReceiveName();
					
					//拼订单-商品项的字符串
					List<OrderGoods> orderGoodsList = orderGoodService.showOrderGoodsByOrderId(orderId);
					StringBuffer itemsString = new StringBuffer();
					for(Iterator<OrderGoods> j = orderGoodsList.iterator();j.hasNext();) {
						OrderGoods orderGoods = j.next();
						String goodsName = goodsService.showGoodsById(orderGoods.getGoodsId()).getGname();

						int amount = orderGoods.getPcount();

						itemsString.append(goodsName+"("+amount+")<br>");
					}
					String items = itemsString.toString();
					
					int orderType = order.getOrderType();
					
					
					//拼订单字符串
					jsonString.append("{\"orderid\":\""+orderId+"\",\"pdate\":\""+pdate+"\",\"recievename\":\""+receiveName+"\",\"items\":\""+items+"\",\"status\":"+orderType+"},");
				}
				jsonString.deleteCharAt(jsonString.length()-1);
				jsonString.append("]");
				out.print(jsonString);

				out.flush();
				out.close();
			}
	}


