package com.shopping.zhang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.po.Goods;
import com.shopping.zhang.service.impl.GoodsServiceImpl;

public class ShowSellGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 142178407592822750L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Goods> sellGoods = GoodsServiceImpl.getInstance().showSortGoodsBySalCount();
		request.setAttribute("sellGoods", sellGoods); 

		request.getRequestDispatcher("SellSort.jsp").forward(request, response);
	}

}
