package com.shopping.song.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.song.service.OrderGoodService;
import com.shopping.song.service.OrderService;
import com.shopping.song.service.impl.OrderGoodServiceImpl;
import com.shopping.song.service.impl.OrderServiceImpl;

public class DeleteManageOrderServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrderService orderService = OrderServiceImpl.getInstance();
		OrderGoodService orderGoodService = OrderGoodServiceImpl.getInstance();

		PrintWriter out = response.getWriter();

		String orderId = request.getParameter("orderid");
		System.out.println(orderId);
		int re = orderGoodService.deleteOrderGoodsByOrderId(orderId);
		int result = orderService.deleteOrderById(orderId);
		if(result == 1){
			out.print("订单删除成功");
		}else{
			out.print("订单删除失败");
		}
		
		out.flush();
		out.close();
	}

}
