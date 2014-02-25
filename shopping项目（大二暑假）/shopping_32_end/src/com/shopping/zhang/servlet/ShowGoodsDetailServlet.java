package com.shopping.zhang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.po.Goods;
import com.shopping.zhang.service.impl.GoodsServiceImpl;

@SuppressWarnings("serial")
public class ShowGoodsDetailServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int gid = Integer.parseInt(request.getParameter("id"));
		Goods good = GoodsServiceImpl.getInstance().showGoodsById(gid);
		request.setAttribute("good", good);
		request.getRequestDispatcher("goods_detail.jsp").forward(request, response);
	}
}
