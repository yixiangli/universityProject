package com.shopping.song.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.po.Order;
import com.shopping.po.OrderGoods;
import com.shopping.song.service.OrderGoodService;
import com.shopping.song.service.OrderService;
import com.shopping.song.service.impl.OrderGoodServiceImpl;
import com.shopping.song.service.impl.OrderServiceImpl;

public class ShowOrderDetailServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    OrderService orderService = OrderServiceImpl.getInstance();
	    OrderGoodService orderGoodService = OrderGoodServiceImpl.getInstance();

		String orderId = request.getParameter("orderid");
		String flag = request.getParameter("flag");
		String items = request.getParameter("items");
		
		String[] itemsString = items.split("<br>");	
		String path = null;
		List<OrderGoods> orderGoodsList = orderGoodService.showOrderGoodsByOrderId(orderId);
		Order order = orderService.showOrderById(orderId);
		request.setAttribute("order", order);
		request.setAttribute("items", itemsString);
		request.setAttribute("orderGoodsList", orderGoodsList);
		
		if (flag.equals("admin")) {
			path = "./manage/order_detail.jsp";
		} else {
			path = "order_detail.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
		
	}
		
	}


