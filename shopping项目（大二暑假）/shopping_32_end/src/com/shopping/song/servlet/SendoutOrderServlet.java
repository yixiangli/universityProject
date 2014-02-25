package com.shopping.song.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.song.service.OrderService;
import com.shopping.song.service.impl.OrderServiceImpl;

public class SendoutOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrderService orderService = OrderServiceImpl.getInstance();

		PrintWriter out = response.getWriter();

		String id = request.getParameter("orderid");
		int status = 2;
		int result = orderService.alterOrderStatus(id, status);
		
		if(result == 1) {
			out.print("发货成功");
		} else {
			out.print("发货失败");
		}
		
		out.flush();
		out.close();
	}
	}


